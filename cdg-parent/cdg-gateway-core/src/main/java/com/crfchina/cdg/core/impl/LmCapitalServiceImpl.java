/**
 * @Title：
 * @Package com.crfchina.cdg.core.impl
 * @date 2018/1/8 15:29
 * @version V1.0
 */
package com.crfchina.cdg.core.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.validator.internal.xml.PayloadType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfoExample;
import com.crfchina.cdg.basedb.entity.LmBindCardList;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetail;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetailExample;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfoExample;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.business.CurrencyType;
import com.crfchina.cdg.common.enums.business.PayMode;
import com.crfchina.cdg.common.enums.business.TransferResultType;
import com.crfchina.cdg.common.enums.common.EnumsDBMap;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.common.utils.SignatureUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.core.dto.base.CallBackParam;
import com.crfchina.cdg.core.dto.base.LmGatewayPageCallbackResult;
import com.crfchina.cdg.core.dto.param.LmRechargeParamDTO;
import com.crfchina.cdg.core.service.LmCapitalService;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmAccountServiceImpl
 * @Description:
 * @author: Administrator
 * @date：2018/1/8 15:29
 * @updateBy：但锐轩
 * @updateDate：2018/1/8 15:29
 * @remarks：
 */
@Service
public class LmCapitalServiceImpl implements LmCapitalService {

	@Autowired
	LmVaccountTransferInfoMapper txnInfoMapper;

	@Autowired
	LmVaccountTransferDetailMapper txnDetailMapper;

	/**
	 * 提现
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
		txnInfo.setChannelFeeAmount(String.valueOf(lmrpDto.getCommissionAmount()));
		txnInfo.setCreateTime(now);
		txnInfo.setCrfBizType(crfBizType);
		txnInfo.setCurrency(1);
		txnInfo.setExpiredTime(lmrpDto.getExpired());
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
		txnDetail.setSettleAmount(String.valueOf(lmrpDto.getAmount()));
		txnDetail.setSettleDate(null);
		txnDetail.setTransferAmount(String.valueOf(lmrpDto.getAmount()));
		txnDetail.setTransferInfoId("");//交易表主键 交易表新增成功则获取此值
		txnDetail.setUpdateTime(now);
		
			//拼接reqData
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", lmrpDto.getPlatformUserNo());
		reqDataMap.put("requestNo", trxNo);
		reqDataMap.put("amount", MoneyUtils.toDollar(lmrpDto.getAmount()));
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
		reqDataMap.put("redirectUrl", "http://127.0.0.1:8080/cdg-geteway/callBack/pageCallBack");//需要配置
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");    
		reqDataMap.put("expired", df.format(lmrpDto.getExpired()) );
		reqDataMap.put("callbackMode", lmrpDto.getCallbackMode());

		int txnId = txnInfoMapper.insert(txnInfo);
		//赋值detail中主表主键字段
		txnDetail.setTransferInfoId(String.valueOf(txnId));
		txnDetailMapper.insert(txnDetail);
		return reqDataMap;
	}
	
	public Date getExpireTm(Date dt,int expiredMinute){
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt);
		c.add(Calendar.MINUTE, expiredMinute); // 目前时间+30分钟   
		Date date=c.getTime();
		return date;	
		
	}
	
}
