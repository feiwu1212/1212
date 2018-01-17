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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.api.cache.SysCodeService;
import com.crfchina.cdg.basedb.dao.LmProjectAuthListMapper;
import com.crfchina.cdg.basedb.dao.LmProjectFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmProjectListMapper;
import com.crfchina.cdg.basedb.entity.LmProjectAuthList;
import com.crfchina.cdg.basedb.entity.LmProjectAuthListExample;
import com.crfchina.cdg.basedb.entity.LmProjectFlowinfo;
import com.crfchina.cdg.basedb.entity.LmProjectFlowinfoExample;
import com.crfchina.cdg.basedb.entity.LmProjectList;
import com.crfchina.cdg.basedb.entity.LmProjectListExample;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.business.AuthorizeStatusType;
import com.crfchina.cdg.common.enums.business.ProjectStatus;
import com.crfchina.cdg.common.enums.common.EnumsDBMap;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.exception.CdgException;
import com.crfchina.cdg.common.exception.CdgExceptionCode;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.LmHttpUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.dto.param.LmAuthorizationEntrustPayParamDTO;
import com.crfchina.cdg.dto.param.LmCreateProjectParamDTO;
import com.crfchina.cdg.dto.param.LmUpdateProjectParamDTO;
import com.crfchina.cdg.dto.result.LmAuthorizationEntrustPayResultDTO;
import com.crfchina.cdg.dto.result.LmCreateProjectResultDTO;
import com.crfchina.cdg.dto.result.LmUpdateProjectResultDTO;
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
	
	@Autowired
	SysCodeService sysCodeSrv;
	
	@Autowired
	 LmProjectAuthListMapper projectAuthListMapper;
	
	/**
	 * 标的创建
	 */
	public LmCreateProjectResultDTO establishProject(
			LmCreateProjectParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		//获取交易流水号
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.CREATE_PROJECT);
		Date now = new Date();
        int partitionDt=Integer.valueOf(DateUtils.dateToString(now, "yyyyMM"));

		//返回结果预封装
		LmCreateProjectResultDTO rsp = new LmCreateProjectResultDTO();
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());

		//判断是否重复上送报文
		LmProjectFlowinfoExample flowExample = new LmProjectFlowinfoExample();
		flowExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		List<LmProjectFlowinfo> infoList = projectFlowInfoMapper.selectByExample(flowExample);
		if(infoList.size()>0){
				rsp.setResult(ResultCode.FAIL);
				rsp.setFailCode("CDG10013");
				rsp.setFailReason(sysCodeSrv.getExplain("CDG10013"));
				return rsp;
		}
		
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
		} catch (CdgException e) {
			//异常流程处理
			 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
				 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 flow.setResult(ResultCode.FAIL.getCode());
				 flow.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 flow.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
			 }
			 else{
				 rsp.setFailCode(e.getCode());
				 rsp.setFailReason(e.getMsg());
				 flow.setResult(ResultCode.UNKNOWN.getCode());
			 }
			 //更新异常流水信息
			 projectFlowInfoMapper.updateByPrimaryKey(flow);
			 return rsp;
		}
		String code = result.getString("code");
		String status = result.getString("status");

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
			//更新流水表和信息表
			 flow.setResult(ResultCode.FAIL.getCode());
			 flow.setFailCode(sysCodeSrv.getResCodeByLm(failCode));
			 flow.setFailReason(sysCodeSrv.getExplainByLm(failCode));
			 projectFlowInfoMapper.updateByPrimaryKey(flow);
			 //封装返回报文
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(sysCodeSrv.getExplainByLm(failCode));
			 rsp.setFailCode(sysCodeSrv.getResCodeByLm(failCode));
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}

	/**
	 * 标的变更
	 */
	public LmUpdateProjectResultDTO modifyProject(
			LmUpdateProjectParamDTO paramDTO) {
			logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
				//获取交易流水号
				String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.MODIFY_PROJECT);
				Date now = new Date();
		        int partitionDt=Integer.valueOf(DateUtils.dateToString(now, "yyyyMM"));

				//返回结果预封装
		        LmUpdateProjectResultDTO rsp = new LmUpdateProjectResultDTO();
			    rsp.setRequestRefNo(paramDTO.getRequestRefNo());
				rsp.setFcpTrxNo(fcpTrxNo);
				rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
				
				//判断是否重复上送报文
				LmProjectFlowinfoExample flowExample = new LmProjectFlowinfoExample();
				flowExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
				List<LmProjectFlowinfo> infoList = projectFlowInfoMapper.selectByExample(flowExample);
				if(infoList.size()>0){
						rsp.setResult(ResultCode.FAIL);
						rsp.setFailCode("CDG10013");
						rsp.setFailReason(sysCodeSrv.getExplain("CDG10013"));
						return rsp;
				}
				
				//通过标的号查抄标的信息
				LmProjectListExample example = new LmProjectListExample();
				example.createCriteria().andProjectNoEqualTo(paramDTO.getProjectNo());
				 List<LmProjectList> proInfoList = projectListMapper.selectByExample(example);
				if(proInfoList.size()==0){
					logger.info("未找到标的号["+paramDTO.getProjectNo()+"]信息");
					rsp.setResult(ResultCode.FAIL);
					return rsp;
				}
				LmProjectList proInfo = proInfoList.get(0);
				//新增标的流水信息
			   LmProjectFlowinfo flow = new LmProjectFlowinfo();
			   BeanUtils.copyProperties(flow, proInfo);//对象赋值
			   flow.setCreateTime(now);
			   flow.setFcpTrxNo(fcpTrxNo);
			   flow.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
			   flow.setProjectStatus(EnumsDBMap.PROJECT_STATUS.get(paramDTO.getStatus().getCode()));		 //需要转码
			   flow.setUpdateTime(now);
			   flow.setResult(ResultCode.UNKNOWN.getCode()); //受理成功
			   flow.setPartitionDate(partitionDt);
			   flow.setRequestRefNo(paramDTO.getRequestRefNo());
			   
			   //数据库操作
			   projectFlowInfoMapper.insert(flow);
			   
			   //调用懒猫交易接口
			    Map<String, Object> reqDataMap = new LinkedHashMap<>();
				reqDataMap.put("requestNo", fcpTrxNo);
				reqDataMap.put("projectNo", paramDTO.getProjectNo());
				reqDataMap.put("status", paramDTO.getStatus());
				
				AppConfig config = AppConfig.getConfig();
				List<BasicNameValuePair> postParam = null;
				JSONObject result = null;
				try {
					postParam = AppUtil.createServicePostParam(ApiType.MODIFY_PROJECT.getCode(), reqDataMap);
					result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
				} catch (CdgException e) {
					//异常流程处理
					 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
						 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
						 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
						 flow.setResult(ResultCode.FAIL.getCode());
						 flow.setFailCode(CdgExceptionCode.CDG10023.getCode());
					 }
					 else{
						 rsp.setFailCode(e.getCode());
						 rsp.setFailReason(e.getMsg());
						 flow.setResult(ResultCode.UNKNOWN.getCode());
					 }
					 //更新异常流水信息
					 projectFlowInfoMapper.updateByPrimaryKey(flow);
					 return rsp;
				}
				String code = result.getString("code");
				String status = result.getString("status");

				if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
					//更新流水表和信息表
					  flow.setResult(ResultCode.SUCCESS.getCode());
					  projectFlowInfoMapper.updateByPrimaryKey(flow);
					  
					   //更新标的信息表
					   proInfo.setProjectStatus(EnumsDBMap.PROJECT_STATUS.get(result.getString("projectStatus")));
					   projectListMapper.updateByPrimaryKey(proInfo);
					   
					//返回成功结果
					  rsp.setResult(ResultCode.SUCCESS);
					  rsp.setProjectStatus(result.getString("projectStatus"));
				} else {
					String failCode = result.getString("errorCode");
					//更新流水表和信息表
					 flow.setResult(ResultCode.FAIL.getCode());
					 flow.setFailCode(sysCodeSrv.getExplainByLm(failCode));
					 flow.setFailReason(sysCodeSrv.getResCodeByLm(failCode));
					 projectFlowInfoMapper.updateByPrimaryKey(flow);
					 //封装返回报文
					 rsp.setResult(ResultCode.FAIL);
					 rsp.setFailReason(sysCodeSrv.getExplainByLm(failCode));
					 rsp.setFailCode(sysCodeSrv.getResCodeByLm(failCode));
				}
				logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
				return rsp;
	}

	/**
	 * 委托支付授权
	 */
	@Override
	public LmAuthorizationEntrustPayResultDTO authorizationEntrustPay(
			LmAuthorizationEntrustPayParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		//获取交易流水号
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.MODIFY_PROJECT);
		Date now = new Date();

		//返回结果预封装
        LmAuthorizationEntrustPayResultDTO rsp = new LmAuthorizationEntrustPayResultDTO();
	    rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		
		//判断是否重复上送报文
		LmProjectAuthListExample example = new LmProjectAuthListExample();
		example.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		List<LmProjectAuthList> infoList = projectAuthListMapper.selectByExample(example);
		if(infoList.size()>0){
			rsp.setResult(ResultCode.FAIL);
			rsp.setFailCode("CDG10013");
			rsp.setFailReason(sysCodeSrv.getExplain("CDG10013"));
			return rsp;
		}
		
		//新增委托支付信息
		LmProjectAuthList proInfo = new LmProjectAuthList();
		proInfo.setCheckType(EnumsDBMap.CHECK_TYPE_MAP.get("LIMIT"));
		proInfo.setCreateTime(now);
		proInfo.setEntrustedType(EnumsDBMap.ENTRUSTED_TYPE.get(paramDTO.getEntrustedType()));
		proInfo.setEntrustPlatformUserId(paramDTO.getToPlatformUserNo());
		proInfo.setFcpTrxNo(fcpTrxNo);
		proInfo.setPlatformUserId(paramDTO.getPlatformUserNo());
		proInfo.setProjectNo(paramDTO.getProjectNo());
		proInfo.setRequestRefNo(paramDTO.getRequestRefNo());
		proInfo.setRequestTime(paramDTO.getRequestTime());
		proInfo.setResult(ResultCode.ACCEPTED.getCode());
		projectAuthListMapper.insert(proInfo);
		
		
		//调用懒猫接口
	    Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("projectNo", paramDTO.getProjectNo());
		reqDataMap.put("borrowPlatformUserNo", paramDTO.getPlatformUserNo());	
		reqDataMap.put("checkType", "LIMIT");	
		reqDataMap.put("entrustedType", paramDTO.getEntrustedType());	
		reqDataMap.put("entrustedPlatformUserNo",paramDTO.getToPlatformUserNo());
		
		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.AUTHORIZATION_ENTRUST_PAY.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (CdgException e) {
			//异常流程处理
			 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
				 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 proInfo.setResult(ResultCode.FAIL.getCode());
				 proInfo.setFailCode(CdgExceptionCode.CDG10023.getCode());
			 }
			 else{
				 rsp.setFailCode(e.getCode());
				 rsp.setFailReason(e.getMsg());
				 proInfo.setResult(ResultCode.UNKNOWN.getCode());
			 }
			 //更新异常流水信息
			  projectAuthListMapper.updateByPrimaryKey(proInfo);
			 return rsp;
		}
		String code = result.getString("code");
		String status = result.getString("status");

		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			//更新流水表和信息表
			  proInfo.setResult(ResultCode.SUCCESS.getCode());
			  proInfo.setUpdateTime(now);
			  projectAuthListMapper.updateByPrimaryKey(proInfo);
			   
			//返回成功结果
			  rsp.setResult(ResultCode.SUCCESS);
			  rsp.setAuthorizeStatus(AuthorizeStatusType.PASSED.getCode());
		} else {
			String failCode = result.getString("errorCode");
			//更新流水表和信息表
			proInfo.setResult(ResultCode.FAIL.getCode());
			proInfo.setFailCode(sysCodeSrv.getExplainByLm(failCode));
			proInfo.setFailReason(sysCodeSrv.getResCodeByLm(failCode));
			proInfo.setUpdateTime(now);
			projectAuthListMapper.updateByPrimaryKey(proInfo);
			 //封装返回报文
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(sysCodeSrv.getExplainByLm(failCode));
			 rsp.setFailCode(sysCodeSrv.getResCodeByLm(failCode));
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}


	

	
}
