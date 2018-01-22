/**
 * @Title：
 * @Package com.crfchina.cdg.core.impl
 * @date 2018/1/8 15:29
 * @version V1.0
 */
package com.crfchina.cdg.core.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferLogMapper;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetail;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferLog;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.business.CurrencyType;
import com.crfchina.cdg.common.enums.business.TransferResultType;
import com.crfchina.cdg.common.enums.business.WithdrawForm;
import com.crfchina.cdg.common.enums.business.WithdrawalType;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.core.dto.param.LmRechargeParamDTO;
import com.crfchina.cdg.core.dto.param.LmUserPreTransactionParamDTO;
import com.crfchina.cdg.core.dto.param.LmVerifyDeductParamDTO;
import com.crfchina.cdg.core.dto.param.LmWithdrawParamDTO;
import com.crfchina.cdg.core.service.LmCapitalService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmAccountServiceImpl
 * @Description:
 * @author: ghf
 * @date：2018/1/8 15:29
 * @updateBy：ghf
 * @updateDate：2018/1/8 15:29
 * @remarks：
 */
@Service
public class LmCapitalServiceImpl implements LmCapitalService {

	@Autowired
	LmVaccountTransferInfoMapper txnInfoMapper;

	@Autowired
	LmVaccountTransferDetailMapper txnDetailMapper;

	@Autowired
	LmVaccountTransferLogMapper lmVaccountTransferLogMapper;
	/**
	 * 充值
	 * @param lmrpDto
	 */
	@Override
	public Map<String, Object> recharge(LmRechargeParamDTO lmrpDto) {
		
		String trxNo = TrxNoUtils.getTrxNo(Constants.RECHARGE);//获取当前交易流水
		Date now = new Date();
		String crfBizType=Constants.RECHARGE;
		String lmBizType=ApiType.RECHARGE.getCode();
        int partitionDt=Integer.valueOf(DateUtils.dateToString(now, "yyyyMM"));
		
		//txnInfo封装
		LmVaccountTransferInfo txnInfo = new LmVaccountTransferInfo();
		txnInfo.setAccountDate(now);
		txnInfo.setBatchNo("");
		txnInfo.setCallbackUrl(lmrpDto.getCallbackUrl());
		txnInfo.setChannelFeeAmount("");
		txnInfo.setCreateTime(now);
		txnInfo.setCrfBizType(crfBizType);
		txnInfo.setCurrency(1);
		txnInfo.setExpiredTime(DateUtils.parseStringToDate(lmrpDto.getExpired(), "yyyyMMddHHmmss"));
		txnInfo.setFailCode("");//异步通知时候更新
		txnInfo.setFailReason("");//异步通知时候更新
		txnInfo.setFcpTrxNo(trxNo);
		txnInfo.setFinishDate(null);//异步通知时候更新
		txnInfo.setInExternalAccount(lmrpDto.getPlatformUserNo());
		txnInfo.setInRealName("");
		txnInfo.setLmBizType(lmBizType);
		txnInfo.setNotifyUrl(lmrpDto.getNotifyUrl());
		txnInfo.setOriginFcpTrxno("");
		txnInfo.setOutExternalAccount("");
		txnInfo.setOutRealName("");
		txnInfo.setPartitionDate(partitionDt);
		txnInfo.setRemark("");
		txnInfo.setRequestRefNo(lmrpDto.getRequestRefNo());
		txnInfo.setRequestTime(now);
		txnInfo.setResult(TransferResultType.UNKNOW.getCode());//异步通知时候更新
		txnInfo.setRightShare("");
		txnInfo.setSettleAmount("");//异步通知成功更新
		txnInfo.setSystemNo(String.valueOf(lmrpDto.getSystemNo().getValue()));
		txnInfo.setTransferAmount(String.valueOf(lmrpDto.getAmount()));
		txnInfo.setTransferType(crfBizType);
		txnInfo.setUpdateTime(now);//异步通知时候更新
		int txnId = txnInfoMapper.insert(txnInfo);

		//txnDetail封装
		LmVaccountTransferDetail txnDetail = new LmVaccountTransferDetail();
		txnDetail.setAccountDate(now);
		txnDetail.setCreateTime(now);
		txnDetail.setCrfBizType(crfBizType);
		txnDetail.setCustomDefine("");
		txnDetail.setFailCode("");
		txnDetail.setFailReason("");
		txnDetail.setFcpTrxNo(trxNo);
		txnDetail.setFinishDate(null);//异步通知时候更新
		txnDetail.setInExternalAccount(lmrpDto.getPlatformUserNo());
		txnDetail.setInRealName("");
		txnDetail.setLmBizType(lmBizType);
		txnDetail.setOriginFcpTrxno("");
		txnDetail.setOutExternalAccount("");
		txnDetail.setOutRealName("");
		txnDetail.setPartitionDate(partitionDt);
		txnDetail.setRemark("");
		txnDetail.setRequestRefNo(lmrpDto.getRequestRefNo());
		txnDetail.setResult(TransferResultType.UNKNOW.getCode());//异步通知时候更新
		txnDetail.setRightShare("");
		txnDetail.setSettleAmount("");
		txnDetail.setSettleDate(null);
		txnDetail.setTransferAmount(String.valueOf(lmrpDto.getAmount()));
		txnDetail.setTransferInfoId("");//交易表主键 交易表新增成功则获取此值
		txnDetail.setUpdateTime(now);
		//赋值detail中主表主键字段
		txnDetail.setTransferInfoId(String.valueOf(txnId));
		txnDetailMapper.insert(txnDetail);
		
		if(null != lmrpDto.getCommissionAmount()){
			LmVaccountTransferDetail txnDetail2 = txnDetail;
			txnDetail2.setTransferAmount(String.valueOf(lmrpDto.getCommissionAmount()));
			txnDetailMapper.insert(txnDetail2);
		}
		//拼接reqData
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", lmrpDto.getPlatformUserNo());
		reqDataMap.put("requestNo", trxNo);
		reqDataMap.put("amount", MoneyUtils.toDollar(lmrpDto.getAmount()));
		if(null != lmrpDto.getCommissionAmount())
		reqDataMap.put("commission", MoneyUtils.toDollar(lmrpDto.getCommissionAmount()));
		reqDataMap.put("expectPayCompany", lmrpDto.getExpectPayCompany());
		reqDataMap.put("rechargeWay", lmrpDto.getRechargeWay().getCode());
		if(null != lmrpDto.getPayType())
		reqDataMap.put("payType", lmrpDto.getPayType().getCode());
		if(!StringUtils.isEmpty(lmrpDto.getBankCode()))
		reqDataMap.put("bankcode", lmrpDto.getBankCode());
		
		//reqDataMap.put("authtradeType",);//暂无此应用场景
	    //reqDataMap.put("authtenderAmount",);//暂无此应用场景
	    //reqDataMap.put("projectNo",);//暂无此应用场景

		//TODO 配置本地回调地址
		reqDataMap.put("redirectUrl", AppConfig.getConfig().getCallBackUrl());//需要配置
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");    
		reqDataMap.put("expired", lmrpDto.getExpired());
		reqDataMap.put("callbackMode", lmrpDto.getCallbackMode());
	
		return reqDataMap;
	}
	


	/**
	 * 提现业务流程
	 */
	public Map<String, Object> withdraw(LmWithdrawParamDTO paramDto) {
		String trxNo = TrxNoUtils.getTrxNo(Constants.WITHDRAW);//获取当前交易流水
		Date now = new Date();
		String crfBizType=Constants.WITHDRAW;
		String lmBizType=ApiType.WITHDRAW.getCode();
        int partitionDt=Integer.valueOf(DateUtils.dateToString(now, "yyyyMM"));
        
      //txnInfo封装
      		LmVaccountTransferInfo txnInfo = new LmVaccountTransferInfo();
      		txnInfo.setAccountDate(now);
      		txnInfo.setBatchNo("");
      		txnInfo.setCallbackUrl(paramDto.getCallbackUrl());
      		txnInfo.setChannelFeeAmount("");
      		txnInfo.setCreateTime(now);
      		txnInfo.setCrfBizType(crfBizType);
      		txnInfo.setCurrency(1);
      		txnInfo.setExpiredTime(DateUtils.parseStringToDate(paramDto.getExpired(), "yyyyMMddHHmmss"));
      		txnInfo.setFailCode("");//异步通知时候更新
      		txnInfo.setFailReason("");//异步通知时候更新
      		txnInfo.setFcpTrxNo(trxNo);
      		txnInfo.setFinishDate(null);//异步通知时候更新
      		txnInfo.setInExternalAccount("");
      		txnInfo.setInRealName("");
      		txnInfo.setLmBizType(lmBizType);
      		txnInfo.setNotifyUrl(paramDto.getNotifyUrl());
      		txnInfo.setOriginFcpTrxno("");
      		txnInfo.setOutExternalAccount(paramDto.getPlatformUserNo());
      		txnInfo.setOutRealName("");
      		txnInfo.setPartitionDate(partitionDt);
      		txnInfo.setRemark("");
      		txnInfo.setRequestRefNo(paramDto.getRequestRefNo());
      		txnInfo.setRequestTime(now);
      		txnInfo.setResult(TransferResultType.UNKNOW.getCode());//异步通知时候更新
      		txnInfo.setRightShare("");
      		txnInfo.setSettleAmount("");//异步通知成功更新
      		txnInfo.setSystemNo(String.valueOf(paramDto.getSystemNo().getValue()));
      		txnInfo.setTransferAmount(String.valueOf(paramDto.getAmount()));
      		txnInfo.setTransferType(crfBizType);
      		txnInfo.setUpdateTime(now);//异步通知时候更新
      		
      		//txnDetail封装
      		LmVaccountTransferDetail txnDetail = new LmVaccountTransferDetail();
      		txnDetail.setAccountDate(now);
      		txnDetail.setCreateTime(now);
      		txnDetail.setCrfBizType(crfBizType);
      		txnDetail.setCustomDefine("");
      		txnDetail.setFailCode("");
      		txnDetail.setFailReason("");
      		txnDetail.setFcpTrxNo(trxNo);
      		txnDetail.setFinishDate(null);//异步通知时候更新
      		txnDetail.setInExternalAccount("");
      		txnDetail.setInRealName("");
      		txnDetail.setLmBizType(lmBizType);
      		txnDetail.setOriginFcpTrxno("");
      		txnDetail.setOutExternalAccount(paramDto.getPlatformUserNo());
      		txnDetail.setOutRealName("");
      		txnDetail.setPartitionDate(partitionDt);
      		txnDetail.setRemark("");
      		txnDetail.setRequestRefNo(paramDto.getRequestRefNo());
      		txnDetail.setResult(TransferResultType.UNKNOW.getCode());//异步通知时候更新
      		txnDetail.setRightShare("");
      		txnDetail.setSettleAmount("");
      		txnDetail.setSettleDate(null);
      		txnDetail.setTransferAmount(String.valueOf(paramDto.getAmount()));
      		txnDetail.setTransferInfoId("");//交易表主键 交易表新增成功则获取此值
      		txnDetail.setUpdateTime(now);
      		
      		Map<String, Object> reqDataMap = new LinkedHashMap<>();
      		//拼接reqData
      		reqDataMap.put("platformUserNo", paramDto.getPlatformUserNo());
      		reqDataMap.put("requestNo", trxNo);
      		reqDataMap.put("amount", MoneyUtils.toDollar(paramDto.getAmount()));
      		reqDataMap.put("withdrawType", WithdrawalType.URGENT.getCode());
      		reqDataMap.put("withdrawForm", WithdrawForm.IMMEDIATE.getCode());
      		//TODO 配置本地回调地址
      		reqDataMap.put("redirectUrl", AppConfig.getConfig().getCallBackUrl());//需要配置
      		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");    
      		reqDataMap.put("expired", df.format(paramDto.getExpired()) );
      		int txnId = txnInfoMapper.insert(txnInfo);
      		//赋值detail中主表主键字段
      		txnDetail.setTransferInfoId(String.valueOf(txnId));
      	   //判断佣金是否存在，存在新增佣金明细记录表
      		if(null != paramDto.getCommissionAmount()){
      			LmVaccountTransferDetail txnDetail2 = txnDetail;
          		txnDetail2.setTransferAmount(String.valueOf(paramDto.getCommissionAmount()));
          		reqDataMap.put("commission", MoneyUtils.toDollar(paramDto.getCommissionAmount()));
          		txnDetail2.setTransferInfoId(String.valueOf(txnId));
          		txnDetailMapper.insert(txnDetail2);
      		}
      		txnDetailMapper.insert(txnDetail);
      		return reqDataMap;
	}


/**
 * 用户预处理
 */
	public Map<String, Object> userPreTransaction(
			LmUserPreTransactionParamDTO paramDto) {
		String trxNo = TrxNoUtils.getTrxNo(Constants.USERPRETRANSACTION);//获取当前交易流水
		Date now = new Date();
		String crfBizType=Constants.USERPRETRANSACTION;
		String lmBizType=paramDto.getBizType();
        int partitionDt=Integer.valueOf(DateUtils.dateToString(now, "yyyyMM"));
        
          //txnInfo封装
      		LmVaccountTransferInfo txnInfo = new LmVaccountTransferInfo();
      		txnInfo.setAccountDate(now);
      		txnInfo.setBatchNo("");
      		txnInfo.setCallbackUrl(paramDto.getCallbackUrl());
      		txnInfo.setChannelFeeAmount("");
      		txnInfo.setCreateTime(now);
      		txnInfo.setCrfBizType(crfBizType);
      		txnInfo.setCurrency(1);
      		txnInfo.setExpiredTime(DateUtils.parseStringToDate(paramDto.getExpired(), "yyyyMMddHHmmss"));
      		txnInfo.setFailCode("");//异步通知时候更新
      		txnInfo.setFailReason("");//异步通知时候更新
      		txnInfo.setFcpTrxNo(trxNo);
      		txnInfo.setFinishDate(null);//异步通知时候更新
      		txnInfo.setInExternalAccount("");
      		txnInfo.setInRealName("");
      		txnInfo.setLmBizType(lmBizType);
      		txnInfo.setNotifyUrl("");
      		if(!StringUtils.isEmpty(paramDto.getOriginFcpTrxNo()))
      		txnInfo.setOriginFcpTrxno(paramDto.getOriginFcpTrxNo());
      		txnInfo.setOutExternalAccount(paramDto.getPlatformUserNo());
      		txnInfo.setOutRealName("");
      		txnInfo.setPartitionDate(partitionDt);
      		txnInfo.setRemark("");
      		txnInfo.setRequestRefNo(paramDto.getRequestRefNo());
      		txnInfo.setRequestTime(now);
      		txnInfo.setResult(TransferResultType.UNKNOW.getCode());//异步通知时候更新
      		txnInfo.setRightShare("");
      		txnInfo.setSettleAmount("");//异步通知成功更新
      		txnInfo.setSystemNo(String.valueOf(paramDto.getSystemNo().getValue()));
      		txnInfo.setTransferAmount(String.valueOf(paramDto.getAmount()));
      		txnInfo.setTransferType(crfBizType);
      		txnInfo.setUpdateTime(now);//异步通知时候更新
      		
      		//txnDetail封装
      		LmVaccountTransferDetail txnDetail = new LmVaccountTransferDetail();
      		txnDetail.setAccountDate(now);
      		txnDetail.setCreateTime(now);
      		txnDetail.setCrfBizType(crfBizType);
      		txnDetail.setCustomDefine("");
      		txnDetail.setFailCode("");
      		txnDetail.setFailReason("");
      		txnDetail.setFcpTrxNo(trxNo);
      		txnDetail.setFinishDate(null);//异步通知时候更新
      		txnDetail.setInExternalAccount("");
      		txnDetail.setInRealName("");
      		txnDetail.setLmBizType(lmBizType);
      		if(!StringUtils.isEmpty(paramDto.getOriginFcpTrxNo()))
      		txnDetail.setOriginFcpTrxno(paramDto.getOriginFcpTrxNo());
      		txnDetail.setOutExternalAccount(paramDto.getPlatformUserNo());
      		txnDetail.setOutRealName("");
      		txnDetail.setPartitionDate(partitionDt);
      		txnDetail.setRemark("");
      		txnDetail.setRequestRefNo(paramDto.getRequestRefNo());
      		txnDetail.setResult(TransferResultType.UNKNOW.getCode());//异步通知时候更新
      		txnDetail.setRightShare("");
      		txnDetail.setSettleAmount(String.valueOf(paramDto.getAmount()));
      		txnDetail.setSettleDate(null);
      		txnDetail.setTransferAmount(String.valueOf(paramDto.getAmount()));
      		txnDetail.setTransferInfoId("");//交易表主键 交易表新增成功则获取此值
      		txnDetail.setUpdateTime(now);
      		
      			//拼接reqData
      		Map<String, Object> reqDataMap = new LinkedHashMap<>();
      		reqDataMap.put("platformUserNo", paramDto.getPlatformUserNo());
      		reqDataMap.put("requestNo", trxNo);
      		reqDataMap.put("amount", MoneyUtils.toDollar(paramDto.getAmount()));
      		reqDataMap.put("bizType", paramDto.getBizType());
      		if(null != paramDto.getPreMarketingAmount())
      		reqDataMap.put("preMarketingAmount", MoneyUtils.toDollar(paramDto.getPreMarketingAmount()));
      		if(!StringUtils.isEmpty(paramDto.getRemark()))
      		reqDataMap.put("remark", paramDto.getRemark());
      		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");    
      		reqDataMap.put("expired", df.format(paramDto.getExpired()) );
      		if(!StringUtils.isEmpty(paramDto.getProjectNo()))
      		reqDataMap.put("projectNo", paramDto.getProjectNo());
            if(!StringUtils.isEmpty(paramDto.getShare()))
            reqDataMap.put("share", paramDto.getShare());
            if(!StringUtils.isEmpty(paramDto.getOriginFcpTrxNo()))
            reqDataMap.put("creditsaleRequestNo", paramDto.getOriginFcpTrxNo());
      		//TODO 配置本地回调地址
      		reqDataMap.put("redirectUrl", AppConfig.getConfig().getCallBackUrl());//需要配置
      		int txnId = txnInfoMapper.insert(txnInfo);
      		//赋值detail中主表主键字段
      		txnDetail.setTransferInfoId(String.valueOf(txnId));
      		txnDetailMapper.insert(txnDetail);
      		return reqDataMap;
	}

	/**
	 * 验密扣费
	 * @param paramDTO
	 * @return
	 */
	@Override
	public Map<String, Object> verifyDeduct(LmVerifyDeductParamDTO paramDTO) {
		String trxNo = TrxNoUtils.getTrxNo(Constants.VERIFY_DEDUCT);//获取当前交易流水
		Date now = new Date();
		String crfBizType=Constants.VERIFY_DEDUCT;
		String lmBizType=ApiType.VERIFY_DEDUCT.getCode();
		int partitionDt=Integer.valueOf(DateUtils.dateToString(now, "yyyyMM"));

		//txnInfo封装
		LmVaccountTransferInfo txnInfo = new LmVaccountTransferInfo();
		txnInfo.setAccountDate(now);
		txnInfo.setCallbackUrl(paramDTO.getCallbackUrl());
		txnInfo.setCreateTime(now);
		txnInfo.setCrfBizType(crfBizType);
		txnInfo.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		txnInfo.setExpiredTime(DateUtils.parseStringToDate(paramDTO.getExpired(), "yyyyMMddHHmmss"));
		txnInfo.setFcpTrxNo(trxNo);
		txnInfo.setOutExternalAccount(paramDTO.getPlatformUserNo());
		txnInfo.setInExternalAccount(paramDTO.getTargetPlatformUserNo());
		txnInfo.setLmBizType(lmBizType);
		txnInfo.setNotifyUrl(paramDTO.getNotifyUrl());
		txnInfo.setPartitionDate(partitionDt);
		txnInfo.setRemark(paramDTO.getRemark());
		txnInfo.setRequestRefNo(paramDTO.getRequestRefNo());
		txnInfo.setRequestTime(now);
		txnInfo.setResult(ResultCode.UNKNOWN.getCode());//异步通知时候更新
		txnInfo.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		txnInfo.setTransferAmount(String.valueOf(paramDTO.getAmount()));
		txnInfo.setTransferType(crfBizType);
		txnInfo.setUpdateTime(now);//异步通知时候更新
		txnInfo.setCreateTime(now);
		//txnDetail封装
		LmVaccountTransferDetail txnDetail = new LmVaccountTransferDetail();
		txnDetail.setAccountDate(now);
		txnDetail.setCreateTime(now);
		txnDetail.setCrfBizType(crfBizType);
		txnDetail.setFcpTrxNo(trxNo);
		txnDetail.setOutExternalAccount(paramDTO.getPlatformUserNo());
		txnDetail.setInExternalAccount(paramDTO.getTargetPlatformUserNo());
		txnDetail.setLmBizType(lmBizType);
		txnDetail.setPartitionDate(partitionDt);
		txnDetail.setRemark(paramDTO.getRemark());
		txnDetail.setRequestRefNo(paramDTO.getRequestRefNo());
		txnDetail.setResult(ResultCode.UNKNOWN.getCode());//异步通知时候更新
		txnDetail.setTransferAmount(String.valueOf(paramDTO.getAmount()));
		txnDetail.setUpdateTime(now);//异步通知时候更新
		txnDetail.setCreateTime(now);
		//log生成
		LmVaccountTransferLog txnLog = new LmVaccountTransferLog();
		BeanUtils.copyProperties(txnInfo, txnLog);
		//拼接reqData
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", paramDTO.getPlatformUserNo());
		reqDataMap.put("requestNo", trxNo);
		reqDataMap.put("amount", MoneyUtils.toDollar(paramDTO.getAmount()));
		reqDataMap.put("customDefine", paramDTO.getCustomDefine());
		reqDataMap.put("targetPlatformUserNo", paramDTO.getTargetPlatformUserNo());
		//TODO 配置本地回调地址
		reqDataMap.put("redirectUrl", AppConfig.getConfig().getCallBackUrl());//需要配置
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		reqDataMap.put("expired", paramDTO.getExpired());

		int txnId = txnInfoMapper.insert(txnInfo);
		//赋值detail中主表主键字段
		txnDetail.setTransferInfoId(String.valueOf(txnId));
		txnDetailMapper.insert(txnDetail);
		lmVaccountTransferLogMapper.insert(txnLog);
		return reqDataMap;
	}
}
