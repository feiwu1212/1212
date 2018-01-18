/**
 * @Title：
 * @Package com.crfchina.cdg.api.core.service.dubbo
 * @date 2018/1/10 16:30
 * @version V1.0
 */
package com.crfchina.cdg.api.core.service.dubbo.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.api.cache.SysCodeService;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfoExample;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.business.TransactionQueryTypeMapped;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.exception.CdgException;
import com.crfchina.cdg.common.exception.CdgExceptionCode;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.common.utils.LmHttpUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.dto.param.LmQueryTransferInfoParamDTO;
import com.crfchina.cdg.dto.param.LmQueryUserInformationParamDTO;
import com.crfchina.cdg.dto.result.AuthLimitResultList;
import com.crfchina.cdg.dto.result.LmQueryTransferInfoResultDTO;
import com.crfchina.cdg.dto.result.LmQueryUserInformationResultDTO;
import com.crfchina.cdg.service.LmQueryDubboService;

/**
 * 
 * 
 * @ProjectName：cdg-api-core
 * @ClassName： LmQueryDubboServiceImpl 
 * @Description:
 * @author: ghf
 * @date：2018年1月12日 下午2:40:21
 * @updateBy：ghf
 * @updateDate：2018年1月12日 下午2:40:21
 * @remarks：
 */
@Service("lmQueryDubboService")
public class LmQueryDubboServiceImpl implements LmQueryDubboService {

	public static final Logger logger = LoggerFactory
			.getLogger(LmQueryDubboServiceImpl.class);

	@Autowired
	SysCodeService sysCodeSrv;
	
	@Autowired
	LmVaccountTransferInfoMapper lmVaccountTransferInfoMapper;
	/**
	 * 用户信息查询
	 */
	public LmQueryUserInformationResultDTO querUserInformation(
			LmQueryUserInformationParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		//获取交易流水号
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.QUERY_USER_INFORMATION);

		//返回结果预封装
		LmQueryUserInformationResultDTO rsp = new LmQueryUserInformationResultDTO();
		if(StringUtils.isEmpty(paramDTO.getRequestRefNo())){
			rsp.setFailCode("CDG10002");
			rsp.setFailReason(sysCodeSrv.getExplain("CDG10002"));
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		}
	    rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
	
		//调用懒猫接口
	    Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", paramDTO.getPlatformUserNo());	
		
		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.QUERY_USER_INFORMATION.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (CdgException e) {
			//异常流程处理
			 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
				 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
			 }
			 else{
				 rsp.setFailCode(e.getCode());
				 rsp.setFailReason(e.getMsg());
			 }
			 return rsp;
		}
		String code = result.getString("code");
		String status = result.getString("status");
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			  rsp.setPlatformUserNo(result.getString("platformUserNo"));
			  rsp.setUserType(result.getString("userType"));
			  rsp.setUserRole(result.getString("userRole"));
			  rsp.setAuditStatus(result.getString("auditStatus"));
			  rsp.setActiveStatus(result.getString("activeStatus"));
			  rsp.setBalance(Long.valueOf(MoneyUtils.toCent(result.getString("balance"))));
			  rsp.setAvailableAmount(Long.valueOf(MoneyUtils.toCent(result.getString("availableAmount"))));
			  rsp.setArriveBalance(Long.valueOf(MoneyUtils.toCent(result.getString("arriveBalance"))));
			  rsp.setFloatBalance(Long.valueOf(MoneyUtils.toCent(result.getString("floatBalance"))));			  
			  rsp.setFreezeAmount(Long.valueOf(MoneyUtils.toCent(result.getString("freezeAmount"))));
			  rsp.setBankCardNo(null == result.getString("bankcardNo") ? "" : result.getString("bankcardNo"));
			  rsp.setBankCode(null == result.getString("bankcode") ? "" : result.getString("bankcode"));
			  rsp.setMobile(null == result.getString("mobile") ? "" : result.getString("mobile"));
			  rsp.setAuthList(result.getString("authList"));
			  rsp.setIsImportUserActivate(result.getString("isImportUserActivate"));
			  rsp.setAccessType(null == result.getString("accessType") ? "" : result.getString("accessType"));
			  rsp.setIdCardType(null == result.getString("idCardType") ? "" : result.getString("idCardType"));
			  rsp.setIdCardNo(result.getString("idCardNo"));
			  rsp.setName(result.getString("name"));
			  if(!StringUtils.isEmpty(result.getString("bankLicense")))
				 rsp.setBankLicense(result.getString("bankLicense"));
			  if(!StringUtils.isEmpty(result.getString("orgNo")))
				  rsp.setOrgNo(result.getString("orgNo"));
			  if(!StringUtils.isEmpty(result.getString("businessLicense")))
				  rsp.setBusinessLicense(result.getString("businessLicense"));
			  if(!StringUtils.isEmpty(result.getString("taxNo")))
				  rsp.setTaxNo(result.getString("taxNo"));
			  if(!StringUtils.isEmpty(result.getString("unifiedCode")))
				  rsp.setUnifiedCode(result.getString("unifiedCode"));
			  if(!StringUtils.isEmpty(result.getString("creditCode")))
				  rsp.setCreditCode(result.getString("creditCode"));
			  if(!StringUtils.isEmpty(result.getString("legal")))
				  rsp.setLegal(result.getString("legal"));
			  if(!StringUtils.isEmpty(result.getString("authLimitResultList"))){
				  List<AuthLimitResultList> authLimitResultList = JSONArray.parseArray(result.getString("authLimitResultList"), AuthLimitResultList.class);
			      rsp.setAuthLimitResultList(authLimitResultList);
			  }
			//返回成功结果
			  rsp.setResult(ResultCode.SUCCESS);
		} else {
			String failCode = result.getString("errorCode");
			 //封装返回报文
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(sysCodeSrv.getExplainByLm(failCode));
			 rsp.setFailCode(sysCodeSrv.getResCodeByLm(failCode));
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}

	/**
	 * 交易信息查询
	 */
	@Override
	public LmQueryTransferInfoResultDTO querTransferInfo(
			LmQueryTransferInfoParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		//返回结果预封装
		LmQueryTransferInfoResultDTO rsp = new LmQueryTransferInfoResultDTO();
		if(StringUtils.isEmpty(paramDTO.getRequestRefNo())){
			rsp.setFailCode("CDG10002");
			rsp.setFailReason(sysCodeSrv.getExplain("CDG10002"));
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		}
	    rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		
	    //通过原交易流水信息查询本地交易信息
	    LmVaccountTransferInfo transferInfo = null;
		 LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		 infoExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		 List<LmVaccountTransferInfo> infoList = lmVaccountTransferInfoMapper.selectByExample(infoExample);
		 if(infoList.size() == 0){
			 rsp.setFailCode("CDG10004");
			 rsp.setFailReason(sysCodeSrv.getExplain("CDG10004"));
			 rsp.setResult(ResultCode.FAIL);
			 return rsp;
		 }
		 transferInfo = infoList.get(0);
         //如果交易是最终状态直接返回结果
		 if(transferInfo.getResult().equals(ResultCode.SUCCESS.getCode())){
			 rsp.setResult(ResultCode.SUCCESS);
			 return rsp;
		 }
		 else if(transferInfo.getResult().equals(ResultCode.FAIL.getCode())){
			 rsp.setFailCode(transferInfo.getFailCode());
			 rsp.setFailReason(transferInfo.getFailReason());
			 rsp.setResult(ResultCode.FAIL);
			 return rsp;
		 }
		//调用懒猫接口
		    Map<String, Object> reqDataMap = new LinkedHashMap<>();
			reqDataMap.put("requestNo", paramDTO.getRequestRefNo());	
			reqDataMap.put("transactionType",TransactionQueryTypeMapped.valueOf(transferInfo.getCrfBizType()).getCode());
			
			
			AppConfig config = AppConfig.getConfig();
			List<BasicNameValuePair> postParam = null;
			JSONObject result = null;
			try {
				postParam = AppUtil.createServicePostParam(ApiType.QUERY_TRANSACTION.getCode(), reqDataMap);
				result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
			} catch (CdgException e) {
				//异常流程处理
				 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
					 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
					 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 }
				 else{
					 rsp.setFailCode(e.getCode());
					 rsp.setFailReason(e.getMsg());
				 }
				 return rsp;
			}
			String code = result.getString("code");
			String status = result.getString("status");
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				
			}
		 
		 
		return null;
	}

	


	

	
}
