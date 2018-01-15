/**
 * @Title：
 * @Package com.crfchina.cdg.api.core.service.dubbo
 * @date 2018/1/10 16:30
 * @version V1.0
 */
package com.crfchina.cdg.api.core.service.dubbo.impl;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferBatchMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferLogMapper;
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
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.enums.common.SystemNo;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.LmHttpUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.dto.param.LmAutoPreTransactionParamDTO;
import com.crfchina.cdg.dto.param.LmAutoRechargeParamDTO;
import com.crfchina.cdg.dto.param.LmAutoWithdrawParamDTO;
import com.crfchina.cdg.dto.param.LmFreezePreTransactionParamDTO;
import com.crfchina.cdg.dto.param.LmUnFreezePreTransactionParamDTO;
import com.crfchina.cdg.dto.result.LmAutoPreTransactionResultDTO;
import com.crfchina.cdg.dto.result.LmAutoRechargeResultDTO;
import com.crfchina.cdg.dto.result.LmAutoWithdrawResultDTO;
import com.crfchina.cdg.dto.result.LmFreezePreTransactionResultDTO;
import com.crfchina.cdg.dto.result.LmUnFreezePreTransactionResultDTO;
import com.crfchina.cdg.service.LmTransferDubboService;
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


	/**
	 * 冻结预处理
	 */
	public LmFreezePreTransactionResultDTO freezePreTransaction(LmFreezePreTransactionParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.PRE_FREEZE_TRANSACTION);
		Date now = new Date();
		//返回结果预封装
		LmFreezePreTransactionResultDTO rsp = new LmFreezePreTransactionResultDTO();
				rsp.setRequestRefNo(paramDTO.getRequestRefNo());
				rsp.setFcpTrxNo(fcpTrxNo);
				rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
				
				
		// 新增info
		LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		transferInfo.setRequestRefNo(paramDTO.getRequestRefNo());
		transferInfo.setRequestTime(new Date());
		transferInfo.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		transferInfo.setFcpTrxNo(fcpTrxNo);
		transferInfo.setTransferAmount(paramDTO.getAmount().toString());
		transferInfo.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		transferInfo.setOutExternalAccount(paramDTO.getPlatformUserNo());
		transferInfo.setTransferType(Constants.PRE_FREEZE_TRANSACTION);
		transferInfo.setLmBizType(paramDTO.getBizType());
		transferInfo.setCrfBizType(Constants.PRE_FREEZE_TRANSACTION);
		transferInfo.setCreateTime(now);
		transferInfo.setUpdateTime(now);
		transferInfo.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));

		lmVaccountTransferInfoMapper.insert(transferInfo);

		// 新增detail
		LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();
		transferDetail.setRequestRefNo(paramDTO.getRequestRefNo());
		transferDetail.setFcpTrxNo(fcpTrxNo);
		transferDetail.setTransferInfoId(transferInfo.getId().toString());
		transferDetail.setTransferAmount(paramDTO.getAmount().toString());
		transferDetail.setOutExternalAccount(paramDTO.getPlatformUserNo());
		transferDetail.setLmBizType(paramDTO.getBizType());
		transferDetail.setCrfBizType(Constants.PRE_FREEZE_TRANSACTION);
		transferDetail.setCreateTime(now);
		transferDetail.setUpdateTime(now);
		transferDetail.setPartitionDate(transferInfo.getPartitionDate());
		lmVaccountTransferDetailMapper.insert(transferDetail);

		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("platformUserNo", paramDTO.getPlatformUserNo());
		reqDataMap.put("bizType", PreBusinessType.PRETRANSACTION.getCode());
		reqDataMap.put("amount", MoneyUtils.toDollar(paramDTO.getAmount()));

		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.FREEZE_PRE_TRANSACTION.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (Exception e) {
			logger.error("调用懒猫接口异常", e);
			//返回失败结果 更新失败状态
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		}

		String code = result.getString("code");
		String status = result.getString("status");
		String failCode = result.getString("errorCode");
		String failReason = result.getString("errorMessage");
		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.SUCCESS.getCode());
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.SUCCESS.getCode());
			transferDetail.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			//返回成功结果
			rsp.setResult(ResultCode.SUCCESS);
		} else {
			transferInfo.setResult(ResultCode.FAIL.getCode());
			transferInfo.setFailCode(failCode);
			transferInfo.setFailReason(failReason);
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.FAIL.getCode());
			transferDetail.setFailCode(failCode);
			transferDetail.setFailReason(failReason);
			transferDetail.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			//返回失败结果
			rsp.setResult(ResultCode.FAIL);
			rsp.setFailReason(failReason);
			rsp.setFailCode(failCode);		
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
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		
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
        reqDataMap.put("bankcode",paramDTO.getBankCode());
        
		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.DIRECT_RECHARGE.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (Exception e) {
			logger.error("调用懒猫接口异常", e);
			rsp.setResult(ResultCode.FAIL);
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
			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			//返回成功结果
			rsp.setAmount(paramDTO.getAmount());
			if(!StringUtils.isEmpty(result.getString("commission")))
			rsp.setCommissionAmount(paramDTO.getCommissionAmount());
			rsp.setResult(ResultCode.ACCEPTED);
			rsp.setTransactionTime(DateUtils.strToDate(result.getString("transactionTime")));
			rsp.setPayMobile(result.getString("payMobile"));
		} else {
			String failCode = result.getString("errorCode");
			String failReason = result.getString("errorMessage");
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
			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			rsp.setResult(ResultCode.FAIL);
			if(!StringUtils.isEmpty(result.getString("channelErrorCode")))
			rsp.setChannelErrorCode(result.getString("channelErrorCode"));
			if(!StringUtils.isEmpty(result.getString("channelErrorMessage")))
			rsp.setChannelErrorMessage(result.getString("channelErrorMessage"));
			rsp.setFailReason(failReason);
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
		rsp.setRequestRefNo(paramDTO.getRequestRefNo());
		rsp.setFcpTrxNo(fcpTrxNo);
		rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		

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
        
		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.AUTO_WITHDRAW.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (Exception e) {
			logger.error("调用懒猫接口异常", e);
			 rsp.setResult(ResultCode.FAIL);
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
			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
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
			String failCode = result.getString("errorCode");
			String failReason = result.getString("errorMessage");
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
			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
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
		
		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.CANCEL_PRE_TRANSACTION.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (Exception e) {
			logger.error("调用懒猫接口异常", e);
			 rsp.setResult(ResultCode.FAIL);
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

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			//若存在佣金，则新增明细表
			if(null != paramDTO.getCommissionAmount()){
				transferDetail2.setResult(ResultCode.SUCCESS.getCode());
				lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
			}
			//返回成功结果
			rsp.setResult(ResultCode.SUCCESS);
			
		} else {
			String failCode = result.getString("errorCode");
			String failReason = result.getString("errorMessage");
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
				lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail2);
			}
			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
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
		if(StringUtils.isEmpty(paramDTO.getOriginFcpTrxNo()))
		txnLog.setOriginFcpTrxno(paramDTO.getOriginFcpTrxNo());
		if(StringUtils.isEmpty(paramDTO.getRemark()))
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
			return rsp;
		 }
		
		
		//封装懒猫接口
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("amount", MoneyUtils.toDollar(paramDTO.getAmount()));
		reqDataMap.put("bizType", paramDTO.getBizType());
		reqDataMap.put("projectNo", paramDTO.getProjectNo());
		if(StringUtils.isEmpty(paramDTO.getPreMarketingAmount()))
		reqDataMap.put("preMarketingAmount", paramDTO.getPreMarketingAmount());

		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.AUTO_PRE_TRANSACTION.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (Exception e) {
			logger.error("调用懒猫接口异常", e);
			 rsp.setResult(ResultCode.FAIL);
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

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			//返回成功结果
			rsp.setResult(ResultCode.SUCCESS);
			
		} else {
			String failCode = result.getString("errorCode");
			String failReason = result.getString("errorMessage");
			transferInfo.setResult(ResultCode.FAIL.getCode());
			transferInfo.setFailCode(failCode);
			transferInfo.setFailReason(failReason);
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.FAIL.getCode());
			transferDetail.setFailCode(failCode);
			transferDetail.setFailReason(failReason);
			transferDetail.setUpdateTime(now);
			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			// 返回失败结果
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(failReason);
			 rsp.setFailCode(failCode);
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}
	
	
	
}
