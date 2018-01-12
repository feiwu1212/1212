/**
 * @Title：
 * @Package com.crfchina.cdg.api.core.service.dubbo
 * @date 2018/1/10 16:30
 * @version V1.0
 */
package com.crfchina.cdg.api.core.service.dubbo.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmProjectFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmProjectListMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferBatchMapper;
import com.crfchina.cdg.basedb.entity.LmProjectAuthList;
import com.crfchina.cdg.basedb.entity.LmProjectFlowinfo;
import com.crfchina.cdg.basedb.entity.LmProjectList;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetail;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.business.ProjectStatus;
import com.crfchina.cdg.common.enums.business.WithdrawalType;
import com.crfchina.cdg.common.enums.common.EnumsDBMap;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.LmHttpUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.dto.param.LmCreateProjectParamDTO;
import com.crfchina.cdg.dto.result.LmAutoWithdrawResultDTO;
import com.crfchina.cdg.dto.result.LmCreateProjectResultDTO;
import com.crfchina.cdg.service.LmProjectDubboService;

/**
 * 
 * 
 * @ProjectName：cdg-api-core
 * @ClassName：LmProjectDubboServiceImpl 
 * @Description:
 * @author: ghf
 * @date：2018年1月12日 下午2:40:21
 * @updateBy：ghf
 * @updateDate：2018年1月12日 下午2:40:21
 * @remarks：
 */
@Service("lmProjectDubboService")
public class LmProjectDubboServiceImpl implements LmProjectDubboService {

	public static final Logger logger = LoggerFactory
			.getLogger(LmProjectDubboServiceImpl.class);

	@Autowired
	LmProjectFlowinfoMapper projectFlowInfoMapper;
	
	@Autowired
	LmProjectListMapper projectListMapper;
	
	/**
	 * 标的创建
	 */
	public LmCreateProjectResultDTO establishProject(
			LmCreateProjectParamDTO paramDTO) {
		//获取交易流水号
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.CREATE_PROJECT);
		Date now = new Date();
        int partitionDt=Integer.valueOf(DateUtils.dateToString(now, "yyyyMM"));

		//返回结果预封装
		LmCreateProjectResultDTO rsp = new LmCreateProjectResultDTO();
				rsp.setRequestRefNo(paramDTO.getRequestRefNo());
				rsp.setFcpTrxNo(fcpTrxNo);
				rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		
		//新增标的流水信息
	   LmProjectFlowinfo flow = new LmProjectFlowinfo();
	   BeanUtils.copyProperties(flow, paramDTO);//对象赋值
	   flow.setCreateTime(now);
	   flow.setFcpTrxNo(fcpTrxNo);
	   flow.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
	   flow.setProjectDesc(paramDTO.getProjectDescription());
	   flow.setProjectType(EnumsDBMap.PROJECT_TYPE_MAP.get(paramDTO.getProjectType().getCode())); 
	   flow.setInterestRate(paramDTO.getAnnnualInterestRate());
	   flow.setRepaymentWay(EnumsDBMap.REPAYMENT_WAY.get(paramDTO.getRepaymentWay().getCode()));
	   flow.setProjectStatus(EnumsDBMap.PROJECT_STATUS.get(ProjectStatus.COLLECTING));		 //需要转码
	   flow.setUpdateTime(now);
	   flow.setResult(ResultCode.ACCEPTED.getCode()); //受理成功
	   flow.setPartitionDate(partitionDt);

	   //数据库操作
	   projectFlowInfoMapper.insert(flow);
	   
	   //调用懒猫交易接口
	    Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("projectNo", paramDTO.getProjectNo());
		reqDataMap.put("projectAmount", MoneyUtils.toDollar(paramDTO.getProjectAmount()));
		reqDataMap.put("projectName", paramDTO.getProjectName());
		if(!StringUtils.isEmpty(paramDTO.getProjectDescription()))
		reqDataMap.put("projectDescription", paramDTO.getProjectDescription());
		reqDataMap.put("projectType", paramDTO.getProjectType().getCode());
		if(!StringUtils.isEmpty(paramDTO.getProjectPeriod()))
		reqDataMap.put("projectPeriod", paramDTO.getProjectType().getCode());
		reqDataMap.put("annnualInterestRate", paramDTO.getAnnnualInterestRate());
		reqDataMap.put("repaymentWay", paramDTO.getRepaymentWay().getCode());
		if(!StringUtils.isEmpty(paramDTO.getExtend()))
		reqDataMap.put("extend", paramDTO.getExtend());

		
		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.ESTABLISH_PROJECT.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (Exception e) {
			logger.error("调用懒猫接口异常", e);
			 flow.setResult(ResultCode.UNKNOWN.getCode());
			 projectFlowInfoMapper.updateByPrimaryKey(flow);
			 rsp.setResult(ResultCode.FAIL);
			 return rsp;
		}
		String code = result.getString("code");
		String status = result.getString("status");

		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			//更新流水表和信息表
			  flow.setResult(ResultCode.SUCCESS.getCode());
			  projectFlowInfoMapper.updateByPrimaryKey(flow);
			  
			   //新增标的信息表
			   LmProjectList proInfo = new LmProjectList();
			   BeanUtils.copyProperties(proInfo, flow);//对象赋值
			   proInfo.setId(null);//主键重置
			   projectListMapper.insert(proInfo);
			   
			//返回成功结果
			  rsp.setResult(ResultCode.SUCCESS);
		} else {
			String failCode = result.getString("errorCode");
			String failReason = result.getString("errorMessage");
			//更新流水表和信息表
			 flow.setResult(ResultCode.FAIL.getCode());
			 flow.setFailCode(failCode);
			 flow.setFailReason(failReason);
			 projectFlowInfoMapper.updateByPrimaryKey(flow);
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(failReason);
			 rsp.setFailCode(failCode);
		}
		return rsp;
	}



	
}
