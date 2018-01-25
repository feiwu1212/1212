package com.crfchina.recon.jobhandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.crfchina.cdg.basedb.dao.LmTransferReckonLogMapper;
import com.crfchina.cdg.basedb.dao.SystemConfigMapper;
import com.crfchina.cdg.basedb.entity.LmTransferReckonLog;
import com.crfchina.cdg.basedb.entity.LmTransferReckonLogExample;
import com.crfchina.cdg.basedb.entity.SystemConfig;
import com.crfchina.cdg.basedb.entity.SystemConfigExample;
import com.crfchina.cdg.common.exception.CdgException;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.common.utils.LmHttpUtils;
import com.crfchina.recon.service.ICdgReconService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;



/**
 * 
 * 
 * @ProjectName：cdg-recon-task
 * @ClassName：LmReckonFileDownLoadJobHandler 
 * @Description: 懒猫对账文件下载
 * @author: ghf
 * @date：2018年1月24日 上午10:19:45
 * @updateBy：ghf
 * @updateDate：2018年1月24日 上午10:19:45
 * @remarks：
 */
@JobHander(value="lmReckonFileDownLoadJobHandler")
@Service
public class LmReckonFileDownLoadJobHandler extends IJobHandler {

	private static final Logger logger = LoggerFactory.getLogger(LmReckonFileDownLoadJobHandler.class);

	@Value("${lm.reckon.file.path}")  
	String reckFileDownloadPath;
	
	@Autowired
	SystemConfigMapper sysConfigMapper;
	
	@Autowired
	LmTransferReckonLogMapper reckLogMapper;
	
	@Autowired
	ICdgReconService iCdgReconService;
	
	LmTransferReckonLogExample reckLogExp = new LmTransferReckonLogExample();
		
	private String reckonType = "00";
	
	private Integer STATUS_0 = 0;//初始化状态
	
	private Integer STATUS_1 = 1;//对账文件下载中
	
	private Integer STATUS_2 = 2;//对账文件下载完成
	
	private String lm_reck_api = "DOWNLOAD_CHECKFILE";
	
	@Override
	public ReturnT<String> execute(String... params) throws Exception {
		Date now = new Date();
		//获取对账文件下载日期
		SystemConfigExample configExp = new SystemConfigExample();
		configExp.createCriteria().andParamKeyEqualTo("reckFileDate");
		List<SystemConfig> configList = sysConfigMapper.selectByExample(configExp);
		String reckFileDt = configList.get(0).getParamValue();
		logger.info("懒猫对账文件下载任务开始！Reckon File Date="+reckFileDt);
		
		//生成今日的对账文件下载批次名
		String reckonId = "lm_reckonFile_"+reckFileDt+".zip";
		LmTransferReckonLog reckLog = new LmTransferReckonLog();

		//查看当日对账文件是否有下载
		reckLogExp.createCriteria().andReckonDateEqualTo(reckFileDt).andReckonTypeEqualTo(reckonType);
		List<LmTransferReckonLog> isExist = reckLogMapper.selectByExample(reckLogExp);
		reckLogExp.clear();
		if(isExist.size()==1){
			reckLog=isExist.get(0);
		}else{
			//初始化一条记录
			reckLog.setCreateTime(now);
			reckLog.setReckonDate(reckFileDt);
			reckLog.setReckonId(reckonId);//获取对账批次
			reckLog.setLmReckonFile(reckonId);
			reckLog.setReckonType(reckonType);
			reckLog.setStatue(STATUS_0);
			reckLog.setUpdateTime(now);
			reckLogMapper.insert(reckLog);
		}
		
		//判断流水状态：0可以下载，1和2跳出无需下载
		if(!reckLog.getStatue().equals(STATUS_0)){
			return new ReturnT<String>(999,"懒猫对账文件已下载或下载中");
		}
		
		//发起下载文件请求
		//封装懒猫接口
				Map<String, Object> reqDataMap = new LinkedHashMap<>();
				reqDataMap.put("fileDate", new Date(Integer.valueOf(reckFileDt)));
				List<BasicNameValuePair> postParam = null;
				String result = "";
				//更新流水状态为下载中
				reckLog.setStatue(STATUS_1);
				reckLogMapper.updateByPrimaryKey(reckLog);
				try { 
					postParam = AppUtil.createServicePostParam(lm_reck_api, reqDataMap);
					result = LmHttpUtils.postServiceReckFile(postParam, reckFileDownloadPath + reckonId);
				} catch (CdgException e) {
					//下载失败，更新状态为初始化
					reckLog.setStatue(STATUS_0);
					reckLogMapper.updateByPrimaryKey(reckLog);
					return new ReturnT<String>(999,"对账文件下载异常");
				}
				//更新流水信息为下载成功
				reckLog.setStatue(STATUS_2);
				reckLogMapper.updateByPrimaryKey(reckLog);
				return ReturnT.SUCCESS;
	}

}
