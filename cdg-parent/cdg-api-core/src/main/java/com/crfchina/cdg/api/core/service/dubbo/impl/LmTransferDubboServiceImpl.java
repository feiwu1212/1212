/**
 * @Title：
 * @Package com.crfchina.cdg.api.core.service.dubbo
 * @date 2018/1/10 16:30
 * @version V1.0
 */
package com.crfchina.cdg.api.core.service.dubbo.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.api.cache.SysCodeService;
import com.crfchina.cdg.api.dto.BizDetail;
import com.crfchina.cdg.api.dto.Detail;
import com.crfchina.cdg.basedb.dao.LmTransferReckonLogMapper;
import com.crfchina.cdg.basedb.dao.LmUserOperationFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferBatchMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferLogMapper;
import com.crfchina.cdg.basedb.entity.LmTransferReckonLog;
import com.crfchina.cdg.basedb.entity.LmTransferReckonLogExample;
import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferBatch;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetail;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetailExample;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfoExample;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferLog;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.business.CurrencyType;
import com.crfchina.cdg.common.enums.business.PreBusinessType;
import com.crfchina.cdg.common.enums.business.WithdrawalType;
import com.crfchina.cdg.common.enums.common.EnumsDBMap;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.exception.CdgException;
import com.crfchina.cdg.common.exception.CdgExceptionCode;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.LmHttpUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.dto.param.FundTransferDetailDTO;
import com.crfchina.cdg.dto.param.LmAutoPreTransactionParamDTO;
import com.crfchina.cdg.dto.param.LmAutoRechargeParamDTO;
import com.crfchina.cdg.dto.param.LmAutoWithdrawParamDTO;
import com.crfchina.cdg.dto.param.LmFreezePreTransactionParamDTO;
import com.crfchina.cdg.dto.param.LmFundTransferParamDTO;
import com.crfchina.cdg.dto.param.LmReckonConfirmParamDTO;
import com.crfchina.cdg.dto.param.LmRepayPreTransactionParamDTO;
import com.crfchina.cdg.dto.param.LmUnFreezePreTransactionParamDTO;
import com.crfchina.cdg.dto.param.LmUnFreezePwdParamDTO;
import com.crfchina.cdg.dto.result.LmAutoPreTransactionResultDTO;
import com.crfchina.cdg.dto.result.LmAutoRechargeResultDTO;
import com.crfchina.cdg.dto.result.LmAutoWithdrawResultDTO;
import com.crfchina.cdg.dto.result.LmFreezePreTransactionResultDTO;
import com.crfchina.cdg.dto.result.LmFundTransferResultDTO;
import com.crfchina.cdg.dto.result.LmReckonConfirmResultDTO;
import com.crfchina.cdg.dto.result.LmRepayPreTransactionResultDTO;
import com.crfchina.cdg.dto.result.LmUnFreezePreTransactionResultDTO;
import com.crfchina.cdg.dto.result.LmUnFreezePwdResultDTO;
import com.crfchina.cdg.service.LmTransferDubboService;
import com.crfchina.csf.enums.SystemNo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmTransferDubboServiceImpl
 * @Description:
 * @author: Administrator
 * @date：2018/1/10 16:30
 * @updateBy：但锐轩
 * @updateDate：2018/1/10 16:30
 * @remarks：
 */
@Service("lmTransferDubboService")
public class LmTransferDubboServiceImpl implements LmTransferDubboService {

	public static final Logger logger = LoggerFactory
			.getLogger(LmTransferDubboServiceImpl.class);

	@Autowired
	LmVaccountTransferInfoMapper lmVaccountTransferInfoMapper;

	@Autowired
	LmVaccountTransferDetailMapper lmVaccountTransferDetailMapper;

	@Autowired
	LmVaccountTransferBatchMapper lmVaccountTransferBatchMapper;
	
	@Autowired
	LmVaccountTransferLogMapper lmVaccountTransferLogMapper;

	@Autowired
	LmUserOperationFlowinfoMapper lmUserOperationFlowinfoMapper;

	@Autowired
	LmTransferReckonLogMapper reckMapper;
	
	@Autowired
	SysCodeService sysCodeSrv;
	
	/**
	 * 冻结预处理
	 */
	public LmFreezePreTransactionResultDTO freezePreTransaction(LmFreezePreTransactionParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.PRE_FREEZE_TRANSACTION);
		Date now = new Date();
		//返回结果预封装
		LmFreezePreTransactionResultDTO rsp = new LmFreezePreTransactionResultDTO();
		if(StringUtils.isEmpty(paramDTO.getRequestRefNo())){
			rsp.setFailCode("CDG10002");
			rsp.setFailReason(sysCodeSrv.getExplain("CDG10002"));
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		}
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		rsp.setTransactionTime(now);
		// 新增LOG
		LmVaccountTransferLog txnLog = new LmVaccountTransferLog();
		txnLog.setRequestRefNo(paramDTO.getRequestRefNo());
		txnLog.setRequestTime(new Date());
		txnLog.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		txnLog.setFcpTrxNo(fcpTrxNo);
		txnLog.setTransferAmount(paramDTO.getAmount().toString());
		txnLog.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		txnLog.setOutExternalAccount(paramDTO.getPlatformUserNo());
		txnLog.setTransferType(Constants.PRE_FREEZE_TRANSACTION);
		txnLog.setLmBizType(paramDTO.getBizType());
		txnLog.setCrfBizType(Constants.PRE_FREEZE_TRANSACTION);
		txnLog.setCreateTime(now);
		txnLog.setUpdateTime(now);
		txnLog.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));
		txnLog.setResult(ResultCode.UNKNOWN.getCode());
		lmVaccountTransferLogMapper.insert(txnLog);


		//重复提交判断，通过requestRefNo判断,若存在重复记录，则将老交易取出，若不存在则新增INFO和DETAIL
		 LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		 LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();

		 LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		 infoExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		 List<LmVaccountTransferInfo> infoList = lmVaccountTransferInfoMapper.selectByExample(infoExample);
		 if(infoList.size()==1){
			  transferInfo = infoList.get(0);
			  //原始交易成功判断判断,只要不是失败状态，则激立即返回结果为目前状态
			  if(!transferInfo.getResult().equals(ResultCode.FAIL.getCode())){
					logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
					rsp.setResult(ResultCode.valueOf(transferInfo.getResult()));
					//更新流水
					txnLog.setResult(transferInfo.getResult());
					lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
					return rsp;
			  }
			  //获取detail信息
			  LmVaccountTransferDetailExample detailExample = new LmVaccountTransferDetailExample();
			  detailExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
			  List<LmVaccountTransferDetail> detailList = lmVaccountTransferDetailMapper.selectByExample(detailExample);
			  transferDetail = detailList.get(0);
		 }
		 else if(infoList.size()==0){
			BeanUtils.copyProperties(transferInfo, txnLog);
			//新增info
			lmVaccountTransferInfoMapper.insert(transferInfo);
			// 新增detail
			transferDetail.setRequestRefNo(paramDTO.getRequestRefNo());
			transferDetail.setFcpTrxNo(fcpTrxNo);
			transferDetail.setTransferInfoId(String.valueOf(transferInfo.getId()));
			transferDetail.setTransferAmount(paramDTO.getAmount().toString());
			transferDetail.setOutExternalAccount(paramDTO.getPlatformUserNo());
			transferDetail.setLmBizType(ApiType.DIRECT_RECHARGE.getCode());
			transferDetail.setCrfBizType(Constants.DIRECT_RECHARGE);
			transferDetail.setCreateTime(now);
			transferDetail.setUpdateTime(now);
			lmVaccountTransferDetailMapper.insert(transferDetail);
		 }
		 else{
			logger.error("流水号："+paramDTO.getRequestRefNo()+"在txninfo表中数据异常");
			rsp.setResult(ResultCode.FAIL);
			//更新流水
			txnLog.setResult(ResultCode.FAIL.getCode());
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			return rsp;
		 }
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("platformUserNo", paramDTO.getPlatformUserNo());
		reqDataMap.put("bizType", PreBusinessType.PRETRANSACTION.getCode());
		reqDataMap.put("amount", MoneyUtils.toDollar(paramDTO.getAmount()));

		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.FREEZE_PRE_TRANSACTION.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(postParam);
		} catch (CdgException e) {
			logger.error("调用懒猫接口异常", e);
			//异常流程处理
			 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
				 //封装返回信息
				 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 rsp.setResult(ResultCode.FAIL);

				 //更新流水和交易信息
				 transferInfo.setResult(ResultCode.FAIL.getCode());
				 transferInfo.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferInfo.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 transferDetail.setResult(ResultCode.FAIL.getCode());
				 transferDetail.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferDetail.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 txnLog.setResult(ResultCode.FAIL.getCode());
				 txnLog.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 txnLog.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
			 }
			 else{
				 rsp.setFailCode(e.getCode());
				 rsp.setFailReason(e.getMsg());
				 rsp.setResult(ResultCode.UNKNOWN);
			 }
			 //更新异常流水信息
			 lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			 lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			 lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			 return rsp;
		}

		String code = result.getString("code");
		String status = result.getString("status");
		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.SUCCESS.getCode());
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.SUCCESS.getCode());
			transferDetail.setUpdateTime(now);

			txnLog.setResult(ResultCode.SUCCESS.getCode());
			txnLog.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			//返回成功结果
			rsp.setResult(ResultCode.SUCCESS);
			rsp.setTransactionTime(now);
		} else {
			String failCode = sysCodeSrv.getResCodeByLm(result.getString("errorCode"));
			String failReason = sysCodeSrv.getExplainByLm(result.getString("errorCode"));
			transferInfo.setResult(ResultCode.FAIL.getCode());
			transferInfo.setFailCode(sysCodeSrv.getResCodeByLm(failCode));
			transferInfo.setFailReason(sysCodeSrv.getExplainByLm(failReason));
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.FAIL.getCode());
			transferDetail.setFailCode(sysCodeSrv.getResCodeByLm(failCode));
			transferDetail.setFailReason(sysCodeSrv.getExplainByLm(failReason));
			transferDetail.setUpdateTime(now);

			txnLog.setResult(ResultCode.FAIL.getCode());
			txnLog.setFailCode(failCode);
			txnLog.setFailReason(failReason);
			txnLog.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			//返回失败结果
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(failCode);
			 rsp.setFailCode(failCode);
			 rsp.setTransactionTime(now);
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}

	/**
	 * 自动充值
	 */
	public LmAutoRechargeResultDTO autoRecharge(LmAutoRechargeParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.DIRECT_RECHARGE);
		Date now = new Date();
		//返回结果预封装
		LmAutoRechargeResultDTO rsp = new LmAutoRechargeResultDTO();
		if(StringUtils.isEmpty(paramDTO.getRequestRefNo())){
			rsp.setFailCode("CDG10002");
			rsp.setFailReason(sysCodeSrv.getExplain("CDG10002"));
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		}
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		rsp.setTransactionTime(now);

		// 新增LOG
		LmVaccountTransferLog txnLog = new LmVaccountTransferLog();
		txnLog.setRequestRefNo(paramDTO.getRequestRefNo());
		txnLog.setRequestTime(new Date());
		txnLog.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		txnLog.setFcpTrxNo(fcpTrxNo);
		txnLog.setTransferAmount(paramDTO.getAmount().toString());
		txnLog.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		txnLog.setOutExternalAccount(paramDTO.getPlatformUserNo());
		txnLog.setTransferType(Constants.DIRECT_RECHARGE);
		txnLog.setLmBizType(ApiType.DIRECT_RECHARGE.getCode());
		txnLog.setCrfBizType(Constants.DIRECT_RECHARGE);
		txnLog.setCreateTime(now);
		txnLog.setUpdateTime(now);
		txnLog.setNotifyUrl(paramDTO.getNotifyUrl());
		txnLog.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));
		lmVaccountTransferLogMapper.insert(txnLog);
		
		//重复提交判断，通过requestRefNo判断,若存在重复记录，则将老交易取出，若不存在则新增INFO和DETAIL
		 LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		 LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();
		 LmVaccountTransferDetail transferDetail2 = new LmVaccountTransferDetail();

		 LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		 infoExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		 List<LmVaccountTransferInfo> infoList = lmVaccountTransferInfoMapper.selectByExample(infoExample);
		 if(infoList.size()==1){
			  transferInfo = infoList.get(0);
			  //原始交易成功判断判断,只要不是失败状态，则激立即返回结果为目前状态
			  if(!transferInfo.getResult().equals(ResultCode.FAIL.getCode())){
					rsp.setAmount(paramDTO.getAmount());
					if(!StringUtils.isEmpty(paramDTO.getCommissionAmount()))
					rsp.setCommissionAmount(paramDTO.getCommissionAmount());
					rsp.setResult(ResultCode.valueOf(transferInfo.getResult()));
					rsp.setTransactionTime(transferInfo.getFinishDate());
					rsp.setResult(ResultCode.valueOf(transferInfo.getResult()));
					//更新流水
					txnLog.setResult(transferInfo.getResult());
					lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
					logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
					return rsp;
			  }
			  //获取detail信息
			  LmVaccountTransferDetailExample detailExample = new LmVaccountTransferDetailExample();
			  detailExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
			  List<LmVaccountTransferDetail> detailList = lmVaccountTransferDetailMapper.selectByExample(detailExample);
			  transferDetail = detailList.get(0);
			  if(null != paramDTO.getCommissionAmount()){
				transferDetail2 = detailList.get(1);
			  }
		 }
		 else if(infoList.size()==0){
			BeanUtils.copyProperties(transferInfo, txnLog);
			//新增info
			lmVaccountTransferInfoMapper.insert(transferInfo);
			// 新增detail
			transferDetail.setRequestRefNo(paramDTO.getRequestRefNo());
			transferDetail.setFcpTrxNo(fcpTrxNo);
			transferDetail.setTransferInfoId(String.valueOf(transferInfo.getId()));
			transferDetail.setTransferAmount(paramDTO.getAmount().toString());
			transferDetail.setOutExternalAccount(paramDTO.getPlatformUserNo());
			transferDetail.setLmBizType(ApiType.DIRECT_RECHARGE.getCode());
			transferDetail.setCrfBizType(Constants.DIRECT_RECHARGE);
			transferDetail.setCreateTime(now);
			transferDetail.setUpdateTime(now);
			//佣金分拆
			if(null != paramDTO.getCommissionAmount()){
				transferDetail2 = transferDetail;
				transferDetail2.setTransferAmount(paramDTO.getCommissionAmount().toString());
				lmVaccountTransferDetailMapper.insert(transferDetail2);
			}
			lmVaccountTransferDetailMapper.insert(transferDetail);
		 }
		 else{
			logger.error("流水号："+paramDTO.getRequestRefNo()+"在txninfo表中数据异常");
			rsp.setResult(ResultCode.FAIL);
			//更新流水
			txnLog.setResult(ResultCode.FAIL.getCode());
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			return rsp;
		 }
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("platformUserNo", paramDTO.getPlatformUserNo());
		//佣金分拆
		if(null != paramDTO.getCommissionAmount()){
			reqDataMap.put("commission", MoneyUtils.toDollar(paramDTO.getCommissionAmount()));
		}
		reqDataMap.put("amount", MoneyUtils.toDollar(paramDTO.getAmount()));
		//判断理财端过来的自动充值走富友，现金贷走拉卡拉，不过目前懒猫没有拉卡拉的支付通道，默认富友？
	    if(transferInfo.getSystemNo().equals(SystemNo.website.getValue())){
	    	reqDataMap.put("expectPayCompany","FUIOU");
	    }
	    else {
	    	reqDataMap.put("expectPayCompany","FUIOU");
	    }
        if(!StringUtils.isEmpty(paramDTO.getBankCode()))
        reqDataMap.put("bankcode",sysCodeSrv.getLmBankCode(paramDTO.getBankCode()));
        
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.DIRECT_RECHARGE.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(postParam);
		} catch (CdgException e) {
			logger.error("调用懒猫接口异常", e);
			//异常流程处理
			 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
				 //封装返回信息
				 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 rsp.setResult(ResultCode.FAIL);

				 //更新流水和交易信息
				 transferInfo.setResult(ResultCode.FAIL.getCode());
				 transferInfo.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferInfo.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 transferDetail.setResult(ResultCode.FAIL.getCode());
				 transferDetail.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferDetail.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 if(null != paramDTO.getCommissionAmount()){
					 transferDetail2.setResult(ResultCode.FAIL.getCode());
					 transferDetail2.setFailCode(CdgExceptionCode.CDG10023.getCode());
					 transferDetail2.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
					 lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
				 }
				 txnLog.setResult(ResultCode.FAIL.getCode());
				 txnLog.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 txnLog.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
			 }
			 else{
				 rsp.setFailCode(e.getCode());
				 rsp.setFailReason(e.getMsg());
				 rsp.setResult(ResultCode.UNKNOWN);
			 }
			 //更新异常流水信息
			 lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			 lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			 lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			 return rsp;
		}
		String code = result.getString("code");
		String status = result.getString("status");

		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.ACCEPTED.getCode());
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.ACCEPTED.getCode());
			transferDetail.setUpdateTime(now);
			if(null != paramDTO.getCommissionAmount()){
				transferDetail2.setUpdateTime(now);
				transferDetail2.setResult(ResultCode.ACCEPTED.getCode());
				lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
			}
			txnLog.setResult(ResultCode.ACCEPTED.getCode());
			txnLog.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);

			//返回成功结果
			rsp.setAmount(paramDTO.getAmount());
			if(!StringUtils.isEmpty(result.getString("commission")))
			rsp.setCommissionAmount(paramDTO.getCommissionAmount());
			rsp.setResult(ResultCode.ACCEPTED);
			rsp.setTransactionTime(DateUtils.strToDate(result.getString("transactionTime")));
			rsp.setPayMobile(result.getString("payMobile"));
		} else {
			String failCode = sysCodeSrv.getResCodeByLm(result.getString("errorCode"));
			String failReason = sysCodeSrv.getExplainByLm(result.getString("errorCode"));
			transferInfo.setResult(ResultCode.FAIL.getCode());
			transferInfo.setFailCode(failCode);
			transferInfo.setFailReason(failReason);
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.FAIL.getCode());
			transferDetail.setFailCode(failCode);
			transferDetail.setFailReason(failReason);
			transferDetail.setUpdateTime(now);
			if(null != paramDTO.getCommissionAmount()){
				transferDetail2.setUpdateTime(now);
				transferDetail2.setResult(ResultCode.FAIL.getCode());
				transferDetail2.setFailCode(failCode);
				transferDetail2.setFailReason(failReason);
				lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
			}
			txnLog.setUpdateTime(now);
			txnLog.setResult(ResultCode.FAIL.getCode());
			txnLog.setFailCode(failCode);
			txnLog.setFailReason(failReason);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);

			rsp.setResult(ResultCode.FAIL);
			if(!StringUtils.isEmpty(result.getString("channelErrorCode")))
			rsp.setChannelErrorCode(result.getString("channelErrorCode"));
			if(!StringUtils.isEmpty(result.getString("channelErrorMessage")))
			rsp.setChannelErrorMessage(result.getString("channelErrorMessage"));
			 rsp.setFailReason(failCode);
			 rsp.setFailCode(failCode);
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}
	
	/**
	 * 自动提现
	 */
	public LmAutoWithdrawResultDTO autoWithdraw(LmAutoWithdrawParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.AUTO_WITHDRAW);
		Date now = new Date();
		//返回结果预封装
		LmAutoWithdrawResultDTO rsp = new LmAutoWithdrawResultDTO();
		if(StringUtils.isEmpty(paramDTO.getRequestRefNo())){
			rsp.setFailCode("CDG10002");
			rsp.setFailReason(sysCodeSrv.getExplain("CDG10002"));
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		}
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		rsp.setTransactionTime(now);


		// 新增LOG
		LmVaccountTransferLog txnLog = new LmVaccountTransferLog();
		txnLog.setRequestRefNo(paramDTO.getRequestRefNo());
		txnLog.setRequestTime(new Date());
		txnLog.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		txnLog.setFcpTrxNo(fcpTrxNo);
		txnLog.setTransferAmount(paramDTO.getAmount().toString());
		txnLog.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		txnLog.setOutExternalAccount(paramDTO.getPlatformUserNo());
		txnLog.setTransferType(Constants.AUTO_WITHDRAW);
		txnLog.setLmBizType(ApiType.AUTO_WITHDRAW.getCode());
		txnLog.setCrfBizType(Constants.AUTO_WITHDRAW);
		txnLog.setCreateTime(now);
		txnLog.setUpdateTime(now);
		txnLog.setNotifyUrl(paramDTO.getNotifyUrl());
		txnLog.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));
		lmVaccountTransferLogMapper.insert(txnLog);

		
		//重复提交判断，通过requestRefNo判断,若存在重复记录，则将老交易取出，若不存在则新增INFO和DETAIL
		 LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		 LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();
		 LmVaccountTransferDetail transferDetail2 = new LmVaccountTransferDetail();

		 LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		 infoExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		 List<LmVaccountTransferInfo> infoList = lmVaccountTransferInfoMapper.selectByExample(infoExample);
		 if(infoList.size()==1){
			  transferInfo = infoList.get(0);
			  //原始交易成功判断判断,只要不是失败状态，则激立即返回结果为目前状态
			  if(!transferInfo.getResult().equals(ResultCode.FAIL.getCode())){
					rsp.setAmount(paramDTO.getAmount());
					if(!StringUtils.isEmpty(paramDTO.getCommissionAmount()))
					rsp.setCommissionAmount(paramDTO.getCommissionAmount());
					rsp.setResult(ResultCode.valueOf(transferInfo.getResult()));
					rsp.setTransactionTime(transferInfo.getFinishDate());
					//更新流水
					txnLog.setResult(transferInfo.getResult());
					lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
					logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
					return rsp;
			  }
			  //获取detail信息
			  LmVaccountTransferDetailExample detailExample = new LmVaccountTransferDetailExample();
			  detailExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
			  List<LmVaccountTransferDetail> detailList = lmVaccountTransferDetailMapper.selectByExample(detailExample);
			  transferDetail = detailList.get(0);
			  if(null != paramDTO.getCommissionAmount()){
				transferDetail2 = detailList.get(1);
			  }
		 }
		 else if(infoList.size()==0){
			BeanUtils.copyProperties(transferInfo, txnLog);
			//新增info
			lmVaccountTransferInfoMapper.insert(transferInfo);
			// 新增detail
			transferDetail.setRequestRefNo(paramDTO.getRequestRefNo());
			transferDetail.setFcpTrxNo(fcpTrxNo);
			transferDetail.setTransferInfoId(String.valueOf(transferInfo.getId()));
			transferDetail.setTransferAmount(paramDTO.getAmount().toString());
			transferDetail.setOutExternalAccount(paramDTO.getPlatformUserNo());
			transferDetail.setLmBizType(ApiType.AUTO_WITHDRAW.getCode());
			transferDetail.setCrfBizType(Constants.AUTO_WITHDRAW);
			transferDetail.setCreateTime(now);
			transferDetail.setUpdateTime(now);
			//佣金分拆
			if(null != paramDTO.getCommissionAmount()){
				transferDetail2 = transferDetail;
				transferDetail2.setTransferAmount(paramDTO.getCommissionAmount().toString());
				lmVaccountTransferDetailMapper.insert(transferDetail2);
			}
			lmVaccountTransferDetailMapper.insert(transferDetail);
		 }
		 else{
			logger.error("流水号："+paramDTO.getRequestRefNo()+"在txninfo表中数据异常");
			rsp.setResult(ResultCode.FAIL);
			//更新流水
			txnLog.setResult(ResultCode.FAIL.getCode());
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			return rsp;
		 }
		 
		 //封装懒猫请求报文
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("platformUserNo", paramDTO.getPlatformUserNo());
		if(null != paramDTO.getCommissionAmount()){
			reqDataMap.put("commission", MoneyUtils.toDollar(paramDTO.getCommissionAmount()));
		}
			reqDataMap.put("amount", MoneyUtils.toDollar(paramDTO.getAmount()));
	    	reqDataMap.put("withdrawType",WithdrawalType.URGENT.getCode());
        
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.AUTO_WITHDRAW.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(postParam);
		} catch (CdgException e) {
			logger.error("调用懒猫接口异常", e);
			//异常流程处理
			 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
				 //封装返回信息
				 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 rsp.setResult(ResultCode.FAIL);

				 //更新流水和交易信息
				 transferInfo.setResult(ResultCode.FAIL.getCode());
				 transferInfo.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferInfo.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 transferDetail.setResult(ResultCode.FAIL.getCode());
				 transferDetail.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferDetail.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 txnLog.setResult(ResultCode.FAIL.getCode());
				 if(null != paramDTO.getCommissionAmount()){
					 transferDetail2.setResult(ResultCode.FAIL.getCode());
					 transferDetail2.setFailCode(CdgExceptionCode.CDG10023.getCode());
					 transferDetail2.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
					 txnLog.setResult(ResultCode.FAIL.getCode());
					 lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
				 }
				 txnLog.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 txnLog.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
			 }
			 else{
				 rsp.setFailCode(e.getCode());
				 rsp.setFailReason(e.getMsg());
				 rsp.setResult(ResultCode.UNKNOWN);
			 }
			 //更新异常流水信息
			 lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			 lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			 lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			 return rsp;
		}
		String code = result.getString("code");
		String status = result.getString("status");
		
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.ACCEPTED.getCode());
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.ACCEPTED.getCode());
			transferDetail.setUpdateTime(now);
			if(null != paramDTO.getCommissionAmount()){
				transferDetail2.setUpdateTime(now);
				transferDetail2.setResult(ResultCode.ACCEPTED.getCode());
				lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
			}
			txnLog.setResult(ResultCode.ACCEPTED.getCode());
			txnLog.setUpdateTime(now);
			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);

			// 返回成功结果
			rsp.setAmount(paramDTO.getAmount());
			rsp.setBankcardNo(result.getString("bankcardNo"));
			rsp.setBankcode(result.getString("bankcode"));
			if(null != result.getString("commission"))
			rsp.setCommissionAmount(paramDTO.getCommissionAmount());
			rsp.setFloatAmount(Long.valueOf(result.getString("floatAmount")));
			rsp.setRemitType(result.getString("remitType"));
			rsp.setResult(ResultCode.ACCEPTED);
			rsp.setTransactionTime(DateUtils.strToDate(result.getString("transactionTime")));
			rsp.setWithdrawForm(result.getString("withdrawForm"));
			rsp.setWithdrawWay(result.getString("withdrawWay"));
		} else {
			String failCode = sysCodeSrv.getResCodeByLm(result.getString("errorCode"));
			String failReason = sysCodeSrv.getExplainByLm(result.getString("errorCode"));
			transferInfo.setResult(ResultCode.FAIL.getCode());
			transferInfo.setFailCode(failCode);
			transferInfo.setFailReason(failReason);
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.FAIL.getCode());
			transferDetail.setFailCode(failCode);
			transferDetail.setFailReason(failReason);
			transferDetail.setUpdateTime(now);
			if(null != paramDTO.getCommissionAmount()){
				transferDetail2.setUpdateTime(now);
				transferDetail2.setResult(ResultCode.FAIL.getCode());
				transferDetail2.setFailCode(failCode);
				transferDetail2.setFailReason(failReason);
				lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
			}
			txnLog.setResult(ResultCode.FAIL.getCode());
			txnLog.setFailCode(failCode);
			txnLog.setFailReason(failReason);
			txnLog.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);

			// 返回失败结果
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(failReason);
			 rsp.setFailCode(failCode);
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}

	/**
	 *预处理取消
	 */
	public LmUnFreezePreTransactionResultDTO cancelPreTransaction(
			LmUnFreezePreTransactionParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.CANCEL_PRE_TRANSACTION);
		Date now = new Date();
		//返回结果预封装
		LmUnFreezePreTransactionResultDTO rsp = new LmUnFreezePreTransactionResultDTO();
		if(StringUtils.isEmpty(paramDTO.getRequestRefNo())){
			rsp.setFailCode("CDG10002");
			rsp.setFailReason(sysCodeSrv.getExplain("CDG10002"));
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		}
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		rsp.setTransactionTime(now);

		// 新增LOG
		LmVaccountTransferLog txnLog = new LmVaccountTransferLog();
		txnLog.setRequestRefNo(paramDTO.getRequestRefNo());
		txnLog.setRequestTime(new Date());
		txnLog.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		txnLog.setFcpTrxNo(fcpTrxNo);
		txnLog.setTransferAmount(String.valueOf(paramDTO.getAmount()));
		txnLog.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		txnLog.setOutExternalAccount(paramDTO.getPlatformUserNo());
		txnLog.setTransferType(Constants.CANCEL_PRE_TRANSACTION);
		txnLog.setLmBizType(ApiType.CANCEL_PRE_TRANSACTION.getCode());
		txnLog.setCrfBizType(Constants.CANCEL_PRE_TRANSACTION);
		txnLog.setCreateTime(now);
		txnLog.setUpdateTime(now);
		txnLog.setOriginFcpTrxno(paramDTO.getOriginFcpTrxNo());
		txnLog.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));
		lmVaccountTransferLogMapper.insert(txnLog);

		//重复提交判断，通过requestRefNo判断,若存在重复记录，则将老交易取出，若不存在则新增INFO和DETAIL
		 LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		 LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();
		 LmVaccountTransferDetail transferDetail2 = new LmVaccountTransferDetail();

		 LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		 infoExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		 List<LmVaccountTransferInfo> infoList = lmVaccountTransferInfoMapper.selectByExample(infoExample);
		 if(infoList.size()==1){
			  transferInfo = infoList.get(0);
			  //原始交易成功判断判断,只要不是失败状态，则激立即返回结果为目前状态
			  if(!transferInfo.getResult().equals(ResultCode.FAIL.getCode())){
					rsp.setResult(ResultCode.valueOf(transferInfo.getResult()));
					//更新流水
					txnLog.setResult(transferInfo.getResult());
					lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
					logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
					return rsp;
			  }
			  //获取detail信息
			  LmVaccountTransferDetailExample detailExample = new LmVaccountTransferDetailExample();
			  detailExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
			  List<LmVaccountTransferDetail> detailList = lmVaccountTransferDetailMapper.selectByExample(detailExample);
			  transferDetail = detailList.get(0);
			  if(null != paramDTO.getCommissionAmount()){
				transferDetail2 = detailList.get(1);
			  }
		 }
		 else if(infoList.size()==0){
			BeanUtils.copyProperties(transferInfo, txnLog);
			//新增info
			lmVaccountTransferInfoMapper.insert(transferInfo);
			// 新增detail
			transferDetail.setRequestRefNo(paramDTO.getRequestRefNo());
			transferDetail.setFcpTrxNo(fcpTrxNo);
			transferDetail.setTransferInfoId(transferInfo.getId().toString());
			transferDetail.setTransferAmount(paramDTO.getAmount().toString());
			transferDetail.setOutExternalAccount(paramDTO.getPlatformUserNo());
			transferDetail.setLmBizType(ApiType.CANCEL_PRE_TRANSACTION.getCode());
			transferDetail.setCrfBizType(Constants.CANCEL_PRE_TRANSACTION);
			transferDetail.setCreateTime(now);
			transferDetail.setUpdateTime(now);
			transferDetail.setPartitionDate(transferInfo.getPartitionDate());
			//佣金分拆
			if(null != paramDTO.getCommissionAmount()){
				transferDetail2 = transferDetail;
				transferDetail2.setTransferAmount(paramDTO.getCommissionAmount().toString());
				lmVaccountTransferDetailMapper.insert(transferDetail2);
			}
			lmVaccountTransferDetailMapper.insert(transferDetail);
		 }
		 else{
			logger.error("流水号："+paramDTO.getRequestRefNo()+"在txninfo表中数据异常");
			rsp.setResult(ResultCode.FAIL);
			//更新流水
			txnLog.setResult(ResultCode.FAIL.getCode());
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			return rsp;
		 }

		//封装懒猫接口
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("preTransactionNo", paramDTO.getOriginFcpTrxNo());
		reqDataMap.put("amount", MoneyUtils.toDollar(paramDTO.getAmount()));
		if(null!=paramDTO.getCommissionAmount()){
			reqDataMap.put("commission", MoneyUtils.toDollar(paramDTO.getCommissionAmount()));
		}
		if(paramDTO.getProfitDetailList().size()>0){
			reqDataMap.put("profitDetails",paramDTO.getProfitDetailList() );
		}
		
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.CANCEL_PRE_TRANSACTION.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(postParam);
		} catch (CdgException e) {
			logger.error("调用懒猫接口异常", e);
			//异常流程处理
			 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
				 //封装返回信息
				 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 rsp.setResult(ResultCode.FAIL);

				 //更新流水和交易信息
				 transferInfo.setResult(ResultCode.FAIL.getCode());
				 transferInfo.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferInfo.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 transferDetail.setResult(ResultCode.FAIL.getCode());
				 transferDetail.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferDetail.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 if(null!=paramDTO.getCommissionAmount()){
					 transferDetail2.setResult(ResultCode.FAIL.getCode());
					 transferDetail2.setFailCode(CdgExceptionCode.CDG10023.getCode());
					 transferDetail2.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
					 lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
				 }
				 txnLog.setResult(ResultCode.FAIL.getCode());
				 txnLog.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 txnLog.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
			 }
			 else{
				 rsp.setFailCode(e.getCode());
				 rsp.setFailReason(e.getMsg());
				 rsp.setResult(ResultCode.UNKNOWN);
			 }
			 //更新异常流水信息
			 lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			 lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			 lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			 return rsp;
		}

		String code = result.getString("code");
		String status = result.getString("status");
		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.SUCCESS.getCode());
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.SUCCESS.getCode());
			transferDetail.setUpdateTime(now);

			txnLog.setResult(ResultCode.SUCCESS.getCode());
			txnLog.setUpdateTime(now);
			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			//若存在佣金，则新增明细表
			if(null != paramDTO.getCommissionAmount()){
				transferDetail2.setResult(ResultCode.SUCCESS.getCode());
				txnLog.setUpdateTime(now);
				lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
			}
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);

			//返回成功结果
			rsp.setResult(ResultCode.SUCCESS);
			
		} else {
			String failCode = sysCodeSrv.getResCodeByLm(result.getString("errorCode"));
			String failReason = sysCodeSrv.getExplainByLm(result.getString("errorCode"));
			transferInfo.setResult(ResultCode.FAIL.getCode());
			transferInfo.setFailCode(failCode);
			transferInfo.setFailReason(failReason);
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.FAIL.getCode());
			transferDetail.setFailCode(failCode);
			transferDetail.setFailReason(failReason);
			transferDetail.setUpdateTime(now);
			//若存在佣金，则新增明细表
			if(null != paramDTO.getCommissionAmount()){
				transferDetail2.setResult(ResultCode.FAIL.getCode());
				transferDetail2.setFailCode(failCode);
				transferDetail2.setFailReason(failReason);
				transferDetail2.setUpdateTime(now);
				lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
			}

			txnLog.setResult(ResultCode.FAIL.getCode());
			txnLog.setFailCode(failCode);
			txnLog.setFailReason(failReason);
			txnLog.setUpdateTime(now);


			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);

			// 返回失败结果
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(failReason);
			 rsp.setFailCode(failCode);
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}

	/**
	 * 授权预处理
	 */
	public LmAutoPreTransactionResultDTO autoPreTransaction(
			LmAutoPreTransactionParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.AUTO_PRE_TRANSACTION);
		Date now = new Date();
		//返回结果预封装
		LmAutoPreTransactionResultDTO rsp = new LmAutoPreTransactionResultDTO();
		if(StringUtils.isEmpty(paramDTO.getRequestRefNo())){
			rsp.setFailCode("CDG10002");
			rsp.setFailReason(sysCodeSrv.getExplain("CDG10002"));
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		}
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());

		// 新增LOG
		LmVaccountTransferLog txnLog = new LmVaccountTransferLog();
		txnLog.setRequestRefNo(paramDTO.getRequestRefNo());
		txnLog.setRequestTime(new Date());
		txnLog.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		txnLog.setFcpTrxNo(fcpTrxNo);
		txnLog.setTransferAmount(String.valueOf(paramDTO.getAmount()));
		txnLog.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		txnLog.setOutExternalAccount(paramDTO.getPlatformUserNo());
		txnLog.setTransferType(Constants.AUTO_PRE_TRANSACTION);
		txnLog.setLmBizType(ApiType.AUTO_PRE_TRANSACTION.getCode());
		txnLog.setCrfBizType(Constants.AUTO_PRE_TRANSACTION);
		txnLog.setCreateTime(now);
		txnLog.setUpdateTime(now);
		if(!StringUtils.isEmpty(paramDTO.getOriginFcpTrxNo()))
		txnLog.setOriginFcpTrxno(paramDTO.getOriginFcpTrxNo());
		if(!StringUtils.isEmpty(paramDTO.getRemark()))
		txnLog.setRemark(paramDTO.getRemark());
		txnLog.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));
		if(!StringUtils.isEmpty(paramDTO.getShare()))
		txnLog.setRightShare(paramDTO.getRemark());
		
		lmVaccountTransferLogMapper.insert(txnLog);

		//重复提交判断，通过requestRefNo判断,若存在重复记录，则将老交易取出，若不存在则新增INFO和DETAIL
		 LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		 LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();

		 LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		 infoExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		 List<LmVaccountTransferInfo> infoList = lmVaccountTransferInfoMapper.selectByExample(infoExample);
		 if(infoList.size()==1){
			  transferInfo = infoList.get(0);
			  //原始交易成功判断判断,只要不是失败状态，则激立即返回结果为目前状态
			  if(!transferInfo.getResult().equals(ResultCode.FAIL.getCode())){
					rsp.setResult(ResultCode.valueOf(transferInfo.getResult()));
					//更新流水
					txnLog.setResult(transferInfo.getResult());
					lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
					logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
					return rsp;
			  }
			  //获取detail信息
			  LmVaccountTransferDetailExample detailExample = new LmVaccountTransferDetailExample();
			  detailExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
			  List<LmVaccountTransferDetail> detailList = lmVaccountTransferDetailMapper.selectByExample(detailExample);
			  transferDetail = detailList.get(0);
		 }
		 else if(infoList.size()==0){
			BeanUtils.copyProperties(transferInfo, txnLog);
			//新增info
			lmVaccountTransferInfoMapper.insert(transferInfo);
			//新增detail
			BeanUtils.copyProperties(transferDetail, txnLog);
			lmVaccountTransferDetailMapper.insert(transferDetail);
		 }
		 else{
			logger.error("流水号："+paramDTO.getRequestRefNo()+"在txninfo表中数据异常");
			rsp.setResult(ResultCode.FAIL);
			//更新流水
			txnLog.setResult(ResultCode.FAIL.getCode());
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			return rsp;
		 }
		
		
		//封装懒猫接口
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("amount", MoneyUtils.toDollar(paramDTO.getAmount()));
		reqDataMap.put("bizType", paramDTO.getBizType());
		if(!StringUtils.isEmpty(paramDTO.getPreMarketingAmount()))
		reqDataMap.put("preMarketingAmount", paramDTO.getPreMarketingAmount());
        if(!StringUtils.isEmpty(paramDTO.getOriginFcpTrxNo()))
        reqDataMap.put("originalRechargeNo", paramDTO.getOriginFcpTrxNo());
        if(!StringUtils.isEmpty(paramDTO.getShare()))
        reqDataMap.put("share", paramDTO.getShare());
        if(!StringUtils.isEmpty(paramDTO.getProjectNo()))
        reqDataMap.put("remark", paramDTO.getRemark());
        if(!StringUtils.isEmpty(paramDTO.getProjectNo()))
        reqDataMap.put("projectNo", paramDTO.getProjectNo());
        
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.AUTO_PRE_TRANSACTION.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(postParam);
		} catch (CdgException e) {
			logger.error("调用懒猫接口异常", e);
			//异常流程处理
			 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
				 //封装返回信息
				 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 rsp.setResult(ResultCode.FAIL);

				 //更新流水和交易信息
				 transferInfo.setResult(ResultCode.FAIL.getCode());
				 transferInfo.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferInfo.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 transferDetail.setResult(ResultCode.FAIL.getCode());
				 transferDetail.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferDetail.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 txnLog.setResult(ResultCode.FAIL.getCode());
				 txnLog.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 txnLog.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
			 }
			 else{
				 rsp.setFailCode(e.getCode());
				 rsp.setFailReason(e.getMsg());
				 rsp.setResult(ResultCode.UNKNOWN);
			 }
			 //更新异常流水信息
			 lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			 lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			 lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			 return rsp;
		}

		String code = result.getString("code");
		String status = result.getString("status");
		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.SUCCESS.getCode());
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.SUCCESS.getCode());
			transferDetail.setUpdateTime(now);

			txnLog.setResult(ResultCode.SUCCESS.getCode());
			txnLog.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);

			//返回成功结果
			rsp.setResult(ResultCode.SUCCESS);
			
		} else {
			String failCode = sysCodeSrv.getResCodeByLm(result.getString("errorCode"));
			String failReason = sysCodeSrv.getExplainByLm(result.getString("errorCode"));
			transferInfo.setResult(ResultCode.FAIL.getCode());
			transferInfo.setFailCode(failCode);
			transferInfo.setFailReason(failReason);
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.FAIL.getCode());
			transferDetail.setFailCode(failCode);
			transferDetail.setFailReason(failReason);
			transferDetail.setUpdateTime(now);

			txnLog.setResult(ResultCode.FAIL.getCode());
			txnLog.setFailCode(failCode);
			txnLog.setFailReason(failReason);
			txnLog.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);

			// 返回失败结果
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(failReason);
			 rsp.setFailCode(failCode);
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}

	@Override
	public LmFundTransferResultDTO batchTransfer(LmFundTransferParamDTO paramDTO) {
		logger.info("批量交易开始【begin】paramDTO-->{}", JSONObject.toJSONString(paramDTO));
		LmFundTransferResultDTO rsp = new LmFundTransferResultDTO();
		Date now = new Date();
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.BATCH_TRANSFER);
		String batchNo = TrxNoUtils.getBatchNo();
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		//生成batch
		LmVaccountTransferBatch batchInfo = new LmVaccountTransferBatch();
		batchInfo.setBatchNo(batchNo);
		batchInfo.setCreateTime(now);
		batchInfo.setUpdateTime(now);
		lmVaccountTransferBatchMapper.insert(batchInfo);

		//主交易保存info
		LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		transferInfo.setBatchNo(batchInfo.getBatchNo());
		transferInfo.setRequestRefNo(paramDTO.getRequestRefNo());
		transferInfo.setRequestTime(paramDTO.getRequestTime());
		transferInfo.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		transferInfo.setFcpTrxNo(fcpTrxNo);
		transferInfo.setTransferAmount(paramDTO.getTotalAmount().toString());
		transferInfo.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		transferInfo.setTransferType(EnumsDBMap.TRADE_TYPE_MAP.get(paramDTO.getTradeType().getCode()));
		transferInfo.setLmBizType(paramDTO.getTradeType().getCode());
		transferInfo.setCrfBizType(transferInfo.getTransferType());
		transferInfo.setResult(ResultCode.UNKNOWN.getCode());
		transferInfo.setCreateTime(now);
		transferInfo.setUpdateTime(now);
		transferInfo.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));
		lmVaccountTransferInfoMapper.insert(transferInfo);


		List<FundTransferDetailDTO> mainTransferList = paramDTO.getMainTransferList();
		List<FundTransferDetailDTO> subTransferDetailList = paramDTO.getSubTransferDetailList();
		List<FundTransferDetailDTO> allTransferDetail = new LinkedList<>();
		allTransferDetail.addAll(mainTransferList);
		if (subTransferDetailList != null) {
			allTransferDetail.addAll(subTransferDetailList);
		}

		List<LmVaccountTransferDetail> transferDetailList = new LinkedList<>();
		List<Detail> details = new ArrayList<>();
		//拼装自己detail和懒猫detail
		for (FundTransferDetailDTO item : allTransferDetail) {
			//自己detail
			LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();
			transferDetail.setRequestRefNo(paramDTO.getRequestRefNo());
			transferDetail.setFcpTrxNo(fcpTrxNo);
			transferDetail.setTransferInfoId(String.valueOf(transferInfo.getId()));
			transferDetail.setTransferAmount(item.getAmount().toString());
			transferDetail.setOutExternalAccount(item.getFromPlatformUserNo());
			transferDetail.setOutRealName(item.getFromUserName());
			transferDetail.setInExternalAccount(item.getToPlatformUserNo());
			transferDetail.setInRealName(item.getToUserName());
			transferDetail.setResult(ResultCode.UNKNOWN.getCode());
			//FIXME 详细交易的类型
//			detail.setLmBizType(o.get);
			transferDetail.setCrfBizType(item.getAccountSubjectCode());
			transferDetail.setOriginFcpTrxno(item.getOriginFcpTrxNo());
			if (item.getShare() != null) {
				transferDetail.setRightShare(item.getShare().toString());
			}
			transferDetail.setRemark(item.getRemark());
			transferDetail.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));
			transferDetailList.add(transferDetail);
			//懒猫detail
			Detail detail = new Detail();
			//FIXME 科目类型转换
			detail.setBizType("FUNDS_TRANSFER");
			detail.setTargetPlatformUserNo(item.getToPlatformUserNo());
			detail.setSourcePlatformUserNo(item.getFromPlatformUserNo());
			detail.setFreezeRequestNo(item.getOriginFcpTrxNo());
			detail.setAmount(MoneyUtils.toDollar(item.getAmount()));
			if (item.getShare() != null) {
				detail.setShare(MoneyUtils.toDollar(item.getShare()));
			}
			detail.setRemark(item.getRemark());
			details.add(detail);
		}

		lmVaccountTransferDetailMapper.insertBatch(transferDetailList);

		LmVaccountTransferLog transferLog = new LmVaccountTransferLog();
		BeanUtils.copyProperties(transferInfo, transferLog);
		lmVaccountTransferLogMapper.insert(transferLog);


		BizDetail bizDetail = new BizDetail();
		bizDetail.setRequestNo(fcpTrxNo);
		bizDetail.setProjectNo(paramDTO.getProjectNo());
		bizDetail.setTradeType(paramDTO.getTradeType().getCode());
		bizDetail.setDetails(details);
		List<BizDetail> bizDetails = new LinkedList<>();
		bizDetails.add(bizDetail);

		Map<String, Object> reqDataMap = new HashMap<String, Object>();
		reqDataMap.put("batchNo", batchNo);
		reqDataMap.put("bizDetails", bizDetails);

		LmVaccountTransferDetail temp = new LmVaccountTransferDetail();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;

		try {
			postParam = AppUtil.createServicePostParam(ApiType.ASYNC_TRANSACTION.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(postParam);
		} catch (CdgException e) {
			logger.error("调用懒猫接口异常", e);
			//异常流程处理
			if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
				//封装返回信息
				rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				rsp.setResult(ResultCode.FAIL);

				//更新流水和交易信息
				transferInfo.setResult(ResultCode.FAIL.getCode());
				transferInfo.setFailCode(CdgExceptionCode.CDG10023.getCode());
				transferInfo.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));

				temp.setTransferInfoId(String.valueOf(transferInfo.getId()));
				temp.setResult(ResultCode.FAIL.getCode());
				temp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				temp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));

				transferLog.setResult(ResultCode.FAIL.getCode());
				transferLog.setFailCode(CdgExceptionCode.CDG10023.getCode());
				transferLog.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
			} else{
				rsp.setFailCode(e.getCode());
				rsp.setFailReason(e.getMsg());
				rsp.setResult(ResultCode.UNKNOWN);
			}

			//更新异常流水信息
			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateResultByTransferInfoId(temp);
			lmVaccountTransferLogMapper.updateByPrimaryKey(transferLog);
			return rsp;
		}

		String code = result.getString("code");
		String status = result.getString("status");

		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.ACCEPTED.getCode());
			transferInfo.setUpdateTime(now);

			temp.setTransferInfoId(String.valueOf(transferInfo.getId()));
			temp.setResult(ResultCode.ACCEPTED.getCode());
			temp.setUpdateTime(now);

			transferLog.setResult(ResultCode.ACCEPTED.getCode());
			transferLog.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateResultByTransferInfoId(temp);
			lmVaccountTransferLogMapper.updateByPrimaryKey(transferLog);

			//返回成功结果
			rsp.setResult(ResultCode.ACCEPTED);

		} else {
			String failCode = sysCodeSrv.getResCodeByLm(result.getString("errorCode"));
			String failReason = sysCodeSrv.getExplainByLm(result.getString("errorCode")) + "[" + result.getString("errorMessage") + "]";
			transferInfo.setResult(ResultCode.FAIL.getCode());
			transferInfo.setFailCode(failCode);
			transferInfo.setFailReason(failReason);
			transferInfo.setUpdateTime(now);

			temp.setTransferInfoId(String.valueOf(transferInfo.getId()));
			temp.setResult(ResultCode.FAIL.getCode());
			temp.setFailCode(failCode);
			temp.setFailReason(failReason);
			temp.setUpdateTime(now);

			transferLog.setResult(ResultCode.FAIL.getCode());
			transferLog.setFailCode(failCode);
			transferLog.setFailReason(failReason);
			transferLog.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateResultByTransferInfoId(temp);
			lmVaccountTransferLogMapper.updateByPrimaryKey(transferLog);

			// 返回失败结果
			rsp.setResult(ResultCode.FAIL);
			rsp.setFailReason(failReason);
			rsp.setFailCode(failCode);
		}
		logger.info("批量交易结束【end】rsp-->{}", JSONObject.toJSONString(rsp));
		return rsp;
	}

	/**
	 * 解冻交易密码
	 * @param paramDTO
	 * @return
	 */
	@Override
	public LmUnFreezePwdResultDTO unFreezePwd(LmUnFreezePwdParamDTO paramDTO) {
		LmUnFreezePwdResultDTO returnResult = new LmUnFreezePwdResultDTO();
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.UNFREEZE_PWD);
		Date now = new Date();
		LmUserOperationFlowinfo flowInfo = new LmUserOperationFlowinfo();
		flowInfo.setRequestRefNo(paramDTO.getRequestRefNo());
		flowInfo.setFcpTrxNo(fcpTrxNo);
		flowInfo.setRequestTime(now);
		flowInfo.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		flowInfo.setPlatformUserId(paramDTO.getPlatformUserNo());
		flowInfo.setOperType(EnumsDBMap.OPER_TYPE_MAP.get(ApiType.UNFREEZE_TRADE_PASSWORD.getCode()));
		flowInfo.setNotifyUrl(paramDTO.getNotifyUrl());
		flowInfo.setResult(ResultCode.UNKNOWN.getCode());
		flowInfo.setCreateTime(now);
		flowInfo.setUpdateTime(now);
		flowInfo.setPartitionDate(Integer.valueOf(DateUtils.dateToString(now, "yyyyMM")));

		lmUserOperationFlowinfoMapper.insert(flowInfo);

		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("platformUserNo", paramDTO.getPlatformUserNo());

		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;

		try {
			postParam = AppUtil.createServicePostParam(ApiType.UNFREEZE_TRADE_PASSWORD.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(postParam);
		} catch (Exception e) {
			logger.error("调用懒猫接口异常", e);
			flowInfo.setResult(ResultCode.FAIL.getCode());
			flowInfo.setFailCode("");
			flowInfo.setFailReason("调用懒猫接口异常");
			flowInfo.setUpdateTime(now);
			lmUserOperationFlowinfoMapper.updateByPrimaryKey(flowInfo);
			returnResult.setFcpTrxNo(fcpTrxNo);
			returnResult.setResult(ResultCode.FAIL);
		}

		String code = result.getString("code");
		String status = result.getString("status");
		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			flowInfo.setResult(ResultCode.SUCCESS.getCode());
			flowInfo.setUpdateTime(now);

			lmUserOperationFlowinfoMapper.updateByPrimaryKey(flowInfo);

			returnResult.setFcpTrxNo(fcpTrxNo);
			returnResult.setResult(ResultCode.SUCCESS);
		} else {
			String failCode = sysCodeSrv.getResCodeByLm(result.getString("errorCode"));
			String failReason = sysCodeSrv.getExplainByLm(result.getString("errorCode"));
			flowInfo.setResult(ResultCode.FAIL.getCode());
			flowInfo.setFailCode(failCode);
			flowInfo.setFailReason(failReason);
			flowInfo.setUpdateTime(now);
			lmUserOperationFlowinfoMapper.updateByPrimaryKey(flowInfo);
			returnResult.setFcpTrxNo(fcpTrxNo);
			returnResult.setResult(ResultCode.FAIL);
		}
		return returnResult;
	}

	/**
	 * 还款冻结预处理
	 */
	@Override
	public LmRepayPreTransactionResultDTO repayPreTransaction(
			LmRepayPreTransactionParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.AUTO_PRE_TRANSACTION);
		Date now = new Date();
		//返回结果预封装
		LmRepayPreTransactionResultDTO rsp = new LmRepayPreTransactionResultDTO();
		if(StringUtils.isEmpty(paramDTO.getRequestRefNo())){
			rsp.setFailCode("CDG10002");
			rsp.setFailReason(sysCodeSrv.getExplain("CDG10002"));
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		}
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		
		// 新增LOG
		LmVaccountTransferLog txnLog = new LmVaccountTransferLog();
		txnLog.setRequestRefNo(paramDTO.getRequestRefNo());
		txnLog.setRequestTime(new Date());
		txnLog.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		txnLog.setFcpTrxNo(fcpTrxNo);
		txnLog.setTransferAmount(String.valueOf(paramDTO.getAmount()));
		txnLog.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		txnLog.setOutExternalAccount(paramDTO.getPlatformUserNo());
		txnLog.setTransferType(Constants.AUTO_PRE_TRANSACTION);
		txnLog.setLmBizType(ApiType.AUTO_PRE_TRANSACTION.getCode());
		txnLog.setCrfBizType(Constants.AUTO_PRE_TRANSACTION);
		txnLog.setCreateTime(now);
		txnLog.setUpdateTime(now);
		if(!StringUtils.isEmpty(paramDTO.getOriginFcpTrxNo()))
		txnLog.setOriginFcpTrxno(paramDTO.getOriginFcpTrxNo());
		if(!StringUtils.isEmpty(paramDTO.getRemark()))
		txnLog.setRemark(paramDTO.getRemark());
		txnLog.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));
		
		lmVaccountTransferLogMapper.insert(txnLog);

		//重复提交判断，通过requestRefNo判断,若存在重复记录，则将老交易取出，若不存在则新增INFO和DETAIL
		 LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		 LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();

		 LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		 infoExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		 List<LmVaccountTransferInfo> infoList = lmVaccountTransferInfoMapper.selectByExample(infoExample);
		 if(infoList.size()==1){
			  transferInfo = infoList.get(0);
			  //原始交易成功判断判断,只要不是失败状态，则激立即返回结果为目前状态
			  if(!transferInfo.getResult().equals(ResultCode.FAIL.getCode())){
					rsp.setResult(ResultCode.valueOf(transferInfo.getResult()));
					//更新流水
					txnLog.setResult(transferInfo.getResult());
					lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);	
					logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
					return rsp;
			  }
			  //获取detail信息
			  LmVaccountTransferDetailExample detailExample = new LmVaccountTransferDetailExample();
			  detailExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
			  List<LmVaccountTransferDetail> detailList = lmVaccountTransferDetailMapper.selectByExample(detailExample);
			  transferDetail = detailList.get(0);
		 }
		 else if(infoList.size()==0){
			BeanUtils.copyProperties(transferInfo, txnLog);
			//新增info
			lmVaccountTransferInfoMapper.insert(transferInfo);
			//新增detail
			BeanUtils.copyProperties(transferDetail, txnLog);
			lmVaccountTransferDetailMapper.insert(transferDetail);
		 }
		 else{
			logger.error("流水号："+paramDTO.getRequestRefNo()+"在txninfo表中数据异常");
			rsp.setResult(ResultCode.FAIL);
			//更新流水
			txnLog.setResult(ResultCode.FAIL.getCode());
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);		
			return rsp;
		 }
		
		
		//封装懒猫接口
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("amount", MoneyUtils.toDollar(paramDTO.getAmount()));
		reqDataMap.put("bizType",PreBusinessType.REPAYMENT.getCode() );//还款业务
        if(!StringUtils.isEmpty(paramDTO.getOriginFcpTrxNo()))
        reqDataMap.put("originalRechargeNo", paramDTO.getOriginFcpTrxNo());
        if(!StringUtils.isEmpty(paramDTO.getProjectNo()))
        reqDataMap.put("remark", paramDTO.getRemark());
        if(!StringUtils.isEmpty(paramDTO.getProjectNo()))
		reqDataMap.put("projectNo", paramDTO.getProjectNo());
        
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.AUTO_PRE_TRANSACTION.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(postParam);
		} catch (CdgException e) {
			logger.error("调用懒猫接口异常", e);
			//异常流程处理
			 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
				 //封装返回信息
				 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 rsp.setResult(ResultCode.FAIL);

				 //更新流水和交易信息
				 transferInfo.setResult(ResultCode.FAIL.getCode());
				 transferInfo.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferInfo.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 transferDetail.setResult(ResultCode.FAIL.getCode());
				 transferDetail.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 transferDetail.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
				 txnLog.setResult(ResultCode.FAIL.getCode());
				 txnLog.setFailCode(CdgExceptionCode.CDG10023.getCode());
				 txnLog.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
			 }
			 else{
				 rsp.setFailCode(e.getCode());
				 rsp.setFailReason(e.getMsg());
				 rsp.setResult(ResultCode.UNKNOWN);
			 }
			 //更新异常流水信息
			 lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			 lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			 lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			 return rsp;
		}

		String code = result.getString("code");
		String status = result.getString("status");
		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.SUCCESS.getCode());
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.SUCCESS.getCode());
			transferDetail.setUpdateTime(now);

			txnLog.setResult(ResultCode.SUCCESS.getCode());
			txnLog.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);
			
			//返回成功结果
			rsp.setResult(ResultCode.SUCCESS);
			
		} else {
			String failCode = sysCodeSrv.getResCodeByLm(result.getString("errorCode"));
			String failReason = sysCodeSrv.getExplainByLm(result.getString("errorCode"));
			transferInfo.setResult(ResultCode.FAIL.getCode());
			transferInfo.setFailCode(failCode);
			transferInfo.setFailReason(failReason);
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.FAIL.getCode());
			transferDetail.setFailCode(failCode);
			transferDetail.setFailReason(failReason);
			transferDetail.setUpdateTime(now);
			
			txnLog.setResult(ResultCode.FAIL.getCode());
			txnLog.setFailCode(failCode);
			txnLog.setFailReason(failReason);
			txnLog.setUpdateTime(now);
			
			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			lmVaccountTransferLogMapper.updateByPrimaryKey(txnLog);

			// 返回失败结果
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(failReason);
			 rsp.setFailCode(failCode);
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}

	/**
	 * 对账确认
	 */
	@Override
	public LmReckonConfirmResultDTO LmReckonConfirm(
			LmReckonConfirmParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.RECKON_CONFIRM);
		Date now = new Date();
		//返回结果预封装
		LmReckonConfirmResultDTO rsp = new LmReckonConfirmResultDTO();
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		
		//判断当日有否对账确认(若有并且成功，直接返回，若无则新增，若失败则返回失败的记录重新发对账确认)
		LmTransferReckonLogExample reckLogExp = new LmTransferReckonLogExample();
		reckLogExp.createCriteria().andReckonDateEqualTo(paramDTO.getReckonDate()).andReckonTypeEqualTo("10");
		List<LmTransferReckonLog> reckList = reckMapper.selectByExample(reckLogExp);
		LmTransferReckonLog reckLog = new LmTransferReckonLog();
		if(reckList.size()==1){
			reckLog = reckList.get(0);
			//如果状态成功，则直接返回成功
			if(reckLog.getStatue().equals("4")){
				rsp.setResult(ResultCode.SUCCESS);
				return rsp;
			}
		}
		//记录对账确认日志
		else if(reckList.size() ==0){
			reckLog.setCreateTime(now);
			reckLog.setReckonDate(paramDTO.getReckonDate());
			reckLog.setReckonId(fcpTrxNo);
			reckLog.setReckonType("10");
			reckLog.setStatue(0);
			reckMapper.insert(reckLog);
		}
		
		//封装懒猫接口
				Map<String, Object> reqDataMap = new LinkedHashMap<>();
				reqDataMap.put("requestNo", fcpTrxNo);
				reqDataMap.put("fileDate", paramDTO.getReckonDate());
		        List<String> reckFileList = new ArrayList<>();
		        reckFileList.add("RECHARGE");
		        reckFileList.add("TRANSACTION");
		        reckFileList.add("WITHDRAW");
		        reckFileList.add("COMMISSION");
		        reckFileList.add("BACKROLL_RECHARGE");
		        JSONArray jsonArray = new JSONArray();
		        JSONObject object;
		        for(String s : reckFileList){
		        	object = new JSONObject();
		            object.put("fileType", s);
		            jsonArray.add(object);
		        }
		        reqDataMap.put("detail", jsonArray);
				List<BasicNameValuePair> postParam = null;
				JSONObject result = null;
				try {
					postParam = AppUtil.createServicePostParam(ApiType.CONFIRM_CHECKFILE.getCode(), reqDataMap);
					result = LmHttpUtils.postServiceResult(postParam);
				} catch (CdgException e) {
					logger.error("调用懒猫接口异常", e);
					//异常流程处理
					 if(e.getCode().equals(CdgExceptionCode.CDG10023.getCode())){
						 //封装返回信息
						 rsp.setFailCode(CdgExceptionCode.CDG10023.getCode());
						 rsp.setFailReason(sysCodeSrv.getExplain(CdgExceptionCode.CDG10023.getCode()));
						 rsp.setResult(ResultCode.FAIL);
					 }
					 else{
						 rsp.setFailCode(e.getCode());
						 rsp.setFailReason(e.getMsg());
						 rsp.setResult(ResultCode.UNKNOWN);
					 }
					 return rsp;
				}

				String code = result.getString("code");
				String status = result.getString("status");
				now = new Date();
				if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
					reckLog.setStatue(4);
					reckMapper.updateByPrimaryKey(reckLog);
					//返回成功结果
					rsp.setResult(ResultCode.SUCCESS);
					
				} else {
					String failCode = sysCodeSrv.getResCodeByLm(result.getString("errorCode"));
					String failReason = sysCodeSrv.getExplainByLm(result.getString("errorCode"));

					reckLog.setStatue(5);
					reckLog.setReckonResult(failReason);
					reckMapper.updateByPrimaryKey(reckLog);
					
					// 返回失败结果
					 rsp.setResult(ResultCode.FAIL);
					 rsp.setFailReason(failReason);
					 rsp.setFailCode(failCode);
				}
				logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
				return rsp;
	}
	
}
