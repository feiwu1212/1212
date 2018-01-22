/**
 * @Title：
 * @Package com.crfchina.cdg.notify.impl
 * @date 2018/1/10 13:45
 * @version V1.0
 */
package com.crfchina.cdg.notify.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmBindCardFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmBindCardListMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferLogMapper;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfoExample;
import com.crfchina.cdg.basedb.entity.LmBindCardList;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetail;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetailExample;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfoExample;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.common.EnumsDBMap;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.notify.dto.BaseResultDTO;
import com.crfchina.cdg.notify.dto.LmNotifyResult;
import com.crfchina.cdg.notify.service.LmNotifyService;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmNotifyServiceImpl
 * @Description:
 * @author: Administrator
 * @date：2018/1/10 13:45
 * @updateBy：但锐轩
 * @updateDate：2018/1/10 13:45
 * @remarks：
 */
@Service
public class LmNotifyServiceImpl implements LmNotifyService {
	
	public static final Logger logger = LoggerFactory
			.getLogger(LmNotifyServiceImpl.class);
	
	@Autowired
	LmBindCardFlowinfoMapper lmBindCardFlowinfoMapper;

	@Autowired
	LmBindCardListMapper lmBindCardListMapper;


	@Autowired
	LmVaccountTransferInfoMapper txnInfoMapper;

	@Autowired
	LmVaccountTransferDetailMapper txnDetailMapper;
	
	@Autowired
	LmVaccountTransferLogMapper txnLogMapper;

	@Override
	public void dealNotify(LmNotifyResult result) {
		ApiType apiType = ApiType.valueOf(result.getServiceName());
		if (apiType.equals(ApiType.PERSONAL_REGISTER_EXPAND)) {
			dealPersonOpenAccount(result.getRespData());
		}else if(apiType.equals(ApiType.RECHARGE)){
			dealRecharge(result.getRespData());
		}
	}

	private void dealPersonOpenAccount(JSONObject respData) {
		Date now = new Date();
		String fcpTrxNo = respData.getString("requestNo");
		String code = respData.getString("code");
		String status = respData.getString("status");
		LmBindCardFlowinfoExample example = new LmBindCardFlowinfoExample();
		example.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmBindCardFlowinfo> flowInfoList = lmBindCardFlowinfoMapper.selectByExample(example);
		if (flowInfoList != null || flowInfoList.size() == 1) {
			LmBindCardFlowinfo flow = flowInfoList.get(0);
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				flow.setUserRealName(respData.getString("realName"));
				flow.setIdType(EnumsDBMap.ID_CARD_TYPE_MAP.get(respData.getString("idCardType"))); // idCardType
				flow.setUserRole(respData.getString("userRole"));
				flow.setIdNo(respData.getString("idCardNo"));
				flow.setMobile(respData.getString("mobile"));
				flow.setBankcardNo(respData.getString("bankcardNo"));
				//FIXME 取库映射
				flow.setBankCode(""); //bankcode
				flow.setAccessType(EnumsDBMap.ACCESS_TYPE_MAP.get(respData.getString("accessType"))); // AuthenticationType
				flow.setAuditStatus(EnumsDBMap.AUDIT_STATUS_MAP.get(respData.getString("auditStatus"))); // AuditStatus
				flow.setResult(ResultCode.SUCCESS.getCode());
				flow.setUpdateTime(now);
				lmBindCardFlowinfoMapper.updateByPrimaryKey(flow);

				LmBindCardList lmBindCardList = new LmBindCardList();
				BeanUtils.copyProperties(flow, lmBindCardList);
				lmBindCardList.setCreateTime(now);
				lmBindCardList.setUpdateTime(now);
				lmBindCardListMapper.insert(lmBindCardList);

				BaseResultDTO<String> result = new BaseResultDTO();
				result.setResult(ResultCode.SUCCESS);
				result.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				result.setData(respData.toJSONString());

				//TODO 通知业务系统
				String notifyUrl = flow.getNotifyUrl();

			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmBindCardFlowinfoMapper.updateByPrimaryKey(flow);

				//TODO 通知业务系统
			}
		} else {
			//TODO 通知业务系统
		}
	}
	
	/**
	 * 
	 * @Title: dealRecharge  
	 * @Description: 充值异步通知处理
	 * @param respData
	 * void
	 * @throws
	 */
	private void dealRecharge(JSONObject respData) {
		logger.info("充值异步通知开始【begin】参数{}", respData.toJSONString());
		Date now = new Date();
		String fcpTrxNo = respData.getString("requestNo");
		String code = respData.getString("code");
		String status = respData.getString("status");
		LmVaccountTransferInfoExample example = new LmVaccountTransferInfoExample();
		example.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmVaccountTransferInfo> flowInfoList = txnInfoMapper.selectByExample(example);
		if (flowInfoList != null && flowInfoList.size() == 1) {
			LmVaccountTransferInfo flow = flowInfoList.get(0);
			LmVaccountTransferDetail txnDtl = null;
			LmVaccountTransferDetail txnDtl2 = null;
			//获取交易明细表
			LmVaccountTransferDetailExample txnDtlExample = new LmVaccountTransferDetailExample();
			txnDtlExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
			List<LmVaccountTransferDetail> txnDtlList = txnDetailMapper.selectByExample(txnDtlExample);
			if (txnDtlList != null ) {
				 txnDtl = txnDtlList.get(0);
				 //如果返回字段中有佣金字段，则获取第二条dtl记录
				 if(!StringUtils.isEmpty(respData.getString("commission"))){
					 txnDtl2 = txnDtlList.get(1);
				 }
				 if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
						//更新交易主表
						if(respData.getString("rechargeStatus").equals(ResultCode.SUCCESS.getCode())){
							flow.setResult(ResultCode.SUCCESS.getCode());
						}else if(respData.getString("rechargeStatus").equals(ResultCode.FAIL.getCode())){
							flow.setResult(ResultCode.FAIL.getCode());
						}
						else{
							flow.setResult(ResultCode.ACCEPTED.getCode());
						}
						flow.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
						flow.setUpdateTime(now);
						flow.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
						flow.setSettleDate(now);
						
						if(respData.getString("rechargeStatus").equals(ResultCode.SUCCESS.getCode())){
							txnDtl.setResult(ResultCode.SUCCESS.getCode());
						}else if(respData.getString("rechargeStatus").equals(ResultCode.FAIL.getCode())){
							txnDtl.setResult(ResultCode.FAIL.getCode());
						}
						else{
							txnDtl.setResult(ResultCode.ACCEPTED.getCode());
						}
						txnDtl.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
						txnDtl.setUpdateTime(now);
						txnDtl.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
						txnDtl.setSettleDate(now);
						
						 if(!StringUtils.isEmpty(respData.getString("commission"))){
							 if(respData.getString("rechargeStatus").equals(ResultCode.SUCCESS.getCode())){
								 txnDtl2.setResult(ResultCode.SUCCESS.getCode());
								}else if(respData.getString("rechargeStatus").equals(ResultCode.FAIL.getCode())){
									txnDtl2.setResult(ResultCode.FAIL.getCode());
								}
								else{
									txnDtl2.setResult(ResultCode.ACCEPTED.getCode());
								}
							 txnDtl2.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
							 txnDtl2.setUpdateTime(now);
							 txnDtl2.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
							 txnDtl2.setSettleDate(now);
							 txnDetailMapper.updateByPrimaryKey(txnDtl2);
						 }
						txnInfoMapper.updateByPrimaryKey(flow);
						txnDetailMapper.updateByPrimaryKey(txnDtl);
						//返回业务平台通知信息
						
					} else {
						flow.setResult(ResultCode.FAIL.getCode());
						flow.setFailCode(respData.getString("errorCode"));
						flow.setFailReason(respData.getString("errorMessage"));
						flow.setUpdateTime(now);
						
						txnDtl.setResult(ResultCode.FAIL.getCode());
						txnDtl.setFailCode(respData.getString("errorCode"));
						txnDtl.setFailReason(respData.getString("errorCode"));
						txnDtl.setUpdateTime(now);
						
						 if(!StringUtils.isEmpty(respData.getString("commission"))){
							 txnDtl2.setResult(ResultCode.FAIL.getCode());
							 txnDtl2.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
							 txnDtl2.setUpdateTime(now);
							 txnDtl2.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
							 txnDtl2.setSettleDate(now);
							 txnDetailMapper.updateByPrimaryKey(txnDtl2);
						 }
						txnInfoMapper.updateByPrimaryKey(flow);
						txnDetailMapper.updateByPrimaryKey(txnDtl);
						//返回业务平台信息
						
						
					} 
			}
			else{
				logger.info("未找到对应的txnDtl订单记录");
			}
		} else {
			logger.info("未找到对应的txnInfo订单记录");
		}
	}
	
	
	
}
