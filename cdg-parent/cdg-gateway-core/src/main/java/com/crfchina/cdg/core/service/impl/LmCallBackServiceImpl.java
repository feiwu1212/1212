/**
 * @Title：
 * @Package com.crfchina.cdg.core.impl
 * @date 2018/1/9 15:09
 * @version V1.0
 */
package com.crfchina.cdg.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmBindCardFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmBindCardListMapper;
import com.crfchina.cdg.basedb.dao.LmChangeCardmobileFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmUserOperationFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfoExample;
import com.crfchina.cdg.basedb.entity.LmBindCardList;
import com.crfchina.cdg.basedb.entity.LmChangeCardmobileFlowinfo;
import com.crfchina.cdg.basedb.entity.LmChangeCardmobileFlowinfoExample;
import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfo;
import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfoExample;
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
import com.crfchina.cdg.core.dto.base.CallBackParam;
import com.crfchina.cdg.core.dto.base.LmGatewayPageCallbackResult;
import com.crfchina.cdg.core.service.LmCallBackService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmCallBackServiceImpl
 * @Description:
 * @author: Administrator
 * @date：2018/1/9 15:09
 * @updateBy：但锐轩
 * @updateDate：2018/1/9 15:09
 * @remarks：
 */
@Service
public class LmCallBackServiceImpl implements LmCallBackService {

	@Autowired
	LmBindCardFlowinfoMapper lmBindCardFlowinfoMapper;

	@Autowired
	LmBindCardListMapper lmBindCardListMapper;

	@Autowired
	LmVaccountTransferInfoMapper txnInfoMapper;

	@Autowired
	LmVaccountTransferDetailMapper txnDetailMapper;

	@Autowired
	LmChangeCardmobileFlowinfoMapper lmChangeCardmobileFlowinfoMapper;

	@Autowired
	LmUserOperationFlowinfoMapper lmUserOperationFlowinfoMapper;

	@Override
	public ModelAndView dealCallBack(LmGatewayPageCallbackResult result) {
		ApiType apiType = ApiType.valueOf(result.getServiceName());
		if (apiType.equals(ApiType.PERSONAL_REGISTER_EXPAND)) {
			return dealPersonOpenAccount(result.getRespData());
		}
		else if (apiType.equals(ApiType.RECHARGE)) { //充值业务回调入口
			return dealRechargeCallBack(result.getRespData());
		}
		else if (apiType.equals(ApiType.WITHDRAW)) { //充值业务回调入口
			return dealWithdrawCallBack(result.getRespData());
		}
		else if (apiType.equals(ApiType.USERPRETRANSACTION)) { //用户预处理业务回调入口
			return dealUserPreTransactionCallBack(result.getRespData());
		}
		else if (apiType.equals(ApiType.PERSONAL_BIND_BANKCARD_EXPAND)) {
			return dealChangeCard(result.getRespData());
		}
		else if (apiType.equals(ApiType.CHECK_PASSWORD)) {
			return dealCheckPwd(result.getRespData());
		}
		return null;
	}

	private ModelAndView dealPersonOpenAccount(JSONObject respData) {
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

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.SUCCESS.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				callBackParam.setData(respData.toJSONString());
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmBindCardFlowinfoMapper.updateByPrimaryKey(flow);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("paramDto", callBackParam);
			}
		} else {
			CallBackParam callBackParam = new CallBackParam();
			callBackParam.setResult("系统异常");
			callBackParam.setRequestRefNo(fcpTrxNo);
			callBackParam.setFailCode("99");
			callBackParam.setFailReason("未找到原始交易记录");
			return new ModelAndView("callback").addObject("paramDto", callBackParam);
		}
	}
	/**
	 * 
	 * @Title: dealRechargeCallBack  
	 * @Description: 处理充值回调业务
	 * @param respData
	 * @return
	 * ModelAndView
	 * @throws
	 */
	private ModelAndView dealRechargeCallBack(JSONObject respData) {
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
			//获取交易明细表
			LmVaccountTransferDetailExample txnDtlExample = new LmVaccountTransferDetailExample();
			txnDtlExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
			List<LmVaccountTransferDetail> txnDtlList = txnDetailMapper.selectByExample(txnDtlExample);
			if (txnDtlList != null && txnDtlList.size() == 1) {
				 txnDtl = txnDtlList.get(0);
			}
			else{
				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult("系统异常");
				callBackParam.setRequestRefNo(fcpTrxNo);
				callBackParam.setFailCode("99");
				callBackParam.setFailReason("未找到原始交易明细记录");
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			}
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				//更新交易主表
				flow.setResult(ResultCode.ACCEPTED.getCode());
				flow.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
				flow.setUpdateTime(now);
				flow.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
				flow.setSettleDate(now);
			
				txnDtl.setResult(ResultCode.ACCEPTED.getCode());
				txnDtl.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
				txnDtl.setUpdateTime(now);
				txnDtl.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
				txnDtl.setSettleDate(now);
				
				txnInfoMapper.updateByPrimaryKey(flow);
				txnDetailMapper.updateByPrimaryKey(txnDtl);
				
				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.SUCCESS.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				callBackParam.setData(respData.toJSONString());
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				
				txnDtl.setResult(ResultCode.FAIL.getCode());
				txnDtl.setFailCode(respData.getString("errorCode"));
				txnDtl.setFailReason(respData.getString("errorCode"));
				txnDtl.setUpdateTime(now);
				
				txnInfoMapper.updateByPrimaryKey(flow);
				txnDetailMapper.updateByPrimaryKey(txnDtl);
				
				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			}
		} else {
			CallBackParam callBackParam = new CallBackParam();
			callBackParam.setResult("系统异常");
			callBackParam.setRequestRefNo(fcpTrxNo);
			callBackParam.setFailCode("99");
			callBackParam.setFailReason("未找到原始交易记录");
			return new ModelAndView("callback").addObject("paramDto", callBackParam);
		}
	}

	/**
	 *
	 * @Title: dealRechargeCallBack
	 * @Description: 处理提现回调业务
	 * @param respData
	 * @return
	 * ModelAndView
	 * @throws
	 */
	private ModelAndView dealWithdrawCallBack(JSONObject respData) {
		Date now = new Date();
		String fcpTrxNo = respData.getString("requestNo");
		String code = respData.getString("code");
		String status = respData.getString("status");
		LmVaccountTransferInfoExample example = new LmVaccountTransferInfoExample();
		example.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmVaccountTransferInfo> flowInfoList = txnInfoMapper.selectByExample(example);
		if (flowInfoList != null && flowInfoList.size() == 1) {
			LmVaccountTransferInfo flow = flowInfoList.get(0);
			//获取交易明细表
			LmVaccountTransferDetailExample txnDtlExample = new LmVaccountTransferDetailExample();
			txnDtlExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
			List<LmVaccountTransferDetail> txnDtlList = txnDetailMapper.selectByExample(txnDtlExample);
			if (null == txnDtlList   || txnDtlList.size() == 0) {
				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult("系统异常");
				callBackParam.setRequestRefNo(fcpTrxNo);
				callBackParam.setFailCode("99");
				callBackParam.setFailReason("未找到原始交易明细记录");
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("param", callBackParam);
			}
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				//更新交易主表
				flow.setResult(ResultCode.ACCEPTED.getCode());
				flow.setFinishDate(DateUtils.strToDate(respData.getString("transactionTime")));
				flow.setUpdateTime(now);
				flow.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
				flow.setSettleDate(now);
				txnInfoMapper.updateByPrimaryKey(flow);

				//更新交易明细表
				for(LmVaccountTransferDetail txnDtl : txnDtlList){
					txnDtl.setResult(ResultCode.ACCEPTED.getCode());
					txnDtl.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
					txnDtl.setUpdateTime(now);
					txnDtl.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
					txnDtl.setSettleDate(now);
					txnDetailMapper.updateByPrimaryKey(txnDtl);
				}
				
				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.SUCCESS.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				callBackParam.setData(respData.toJSONString());
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				txnInfoMapper.updateByPrimaryKey(flow);

				//更新交易明细表
				for(LmVaccountTransferDetail txnDtl : txnDtlList){
					txnDtl.setResult(ResultCode.ACCEPTED.getCode());
					txnDtl.setFinishDate(DateUtils.strToDate(respData.getString("transactionTime")));
					txnDtl.setUpdateTime(now);
					txnDtl.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
					txnDtl.setSettleDate(now);
					txnDetailMapper.updateByPrimaryKey(txnDtl);
				}

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			}
		} else {
			CallBackParam callBackParam = new CallBackParam();
			callBackParam.setResult("系统异常");
			callBackParam.setRequestRefNo(fcpTrxNo);
			callBackParam.setFailCode("99");
			callBackParam.setFailReason("未找到原始交易记录");
			return new ModelAndView("callback").addObject("paramDto", callBackParam);
		}
	}

	
	/**
	 * 
	 * @Title: dealUserPreTransactionCallBack  
	 * @Description: 处理用户预处理回调业务
	 * @param respData
	 * @return
	 * ModelAndView
	 * @throws
	 */
	private ModelAndView dealUserPreTransactionCallBack(JSONObject respData) {
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
			//获取交易明细表
			LmVaccountTransferDetailExample txnDtlExample = new LmVaccountTransferDetailExample();
			txnDtlExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
			List<LmVaccountTransferDetail> txnDtlList = txnDetailMapper.selectByExample(txnDtlExample);
			if (txnDtlList != null && txnDtlList.size() == 1) {
				 txnDtl = txnDtlList.get(0);
			}
			else{
				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult("系统异常");
				callBackParam.setRequestRefNo(fcpTrxNo);
				callBackParam.setFailCode("99");
				callBackParam.setFailReason("未找到原始交易明细记录");
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			}
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				//更新交易主表
				flow.setResult(ResultCode.ACCEPTED.getCode());
				flow.setUpdateTime(now);
				flow.setSettleDate(now);
			
				txnDtl.setResult(ResultCode.ACCEPTED.getCode());
				txnDtl.setUpdateTime(now);
				txnDtl.setSettleDate(now);
				
				txnInfoMapper.updateByPrimaryKey(flow);
				txnDetailMapper.updateByPrimaryKey(txnDtl);
				
				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.SUCCESS.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				callBackParam.setData(respData.toJSONString());
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				
				txnDtl.setResult(ResultCode.FAIL.getCode());
				txnDtl.setFailCode(respData.getString("errorCode"));
				txnDtl.setFailReason(respData.getString("errorCode"));
				txnDtl.setUpdateTime(now);
				
				txnInfoMapper.updateByPrimaryKey(flow);
				txnDetailMapper.updateByPrimaryKey(txnDtl);
				
				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			}
		} else {
			CallBackParam callBackParam = new CallBackParam();
			callBackParam.setResult("系统异常");
			callBackParam.setRequestRefNo(fcpTrxNo);
			callBackParam.setFailCode("99");
			callBackParam.setFailReason("未找到原始交易记录");
			return new ModelAndView("callback").addObject("paramDto", callBackParam);
		}
	}

	/**
	 * 更换银行卡页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealChangeCard(JSONObject respData) {
		Date now = new Date();
		String fcpTrxNo = respData.getString("requestNo");
		String code = respData.getString("code");
		String status = respData.getString("status");
		LmChangeCardmobileFlowinfoExample example = new LmChangeCardmobileFlowinfoExample();
		example.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmChangeCardmobileFlowinfo> flowInfoList = lmChangeCardmobileFlowinfoMapper.selectByExample(example);
		if (flowInfoList != null || flowInfoList.size() == 1) {
			LmChangeCardmobileFlowinfo flow = flowInfoList.get(0);
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				flow.setBankCode(respData.getString("bankcode"));
				flow.setAccessType(EnumsDBMap.ACCESS_TYPE_MAP.get(respData.getString("accessType"))); // idCardType
				flow.setAuditStatus(EnumsDBMap.AUDIT_STATUS_MAP.get(respData.getString("auditStatus"))); // AuditStatus
				flow.setResult(ResultCode.ACCEPTED.getCode());
				flow.setUpdateTime(now);
				lmChangeCardmobileFlowinfoMapper.updateByPrimaryKey(flow);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				callBackParam.setData(respData.toJSONString());
				//TODO 页面返回塞值
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmChangeCardmobileFlowinfoMapper.updateByPrimaryKey(flow);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("paramDto", callBackParam);
			}
		} else {
			CallBackParam callBackParam = new CallBackParam();
			callBackParam.setResult("系统异常");
			callBackParam.setRequestRefNo(fcpTrxNo);
			callBackParam.setFailCode("99");
			callBackParam.setFailReason("未找到原始交易记录");
			return new ModelAndView("callback").addObject("paramDto", callBackParam);
		}
	}

	/**
	 * 更换密码页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealChangePwd(JSONObject respData) {
		Date now = new Date();
		String fcpTrxNo = respData.getString("requestNo");
		String code = respData.getString("code");
		String status = respData.getString("status");
		LmUserOperationFlowinfoExample example = new LmUserOperationFlowinfoExample();
		example.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmUserOperationFlowinfo> flowInfoList = lmUserOperationFlowinfoMapper.selectByExample(example);
		if (flowInfoList != null || flowInfoList.size() == 1) {
			LmUserOperationFlowinfo flow = flowInfoList.get(0);
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				flow.setResult(ResultCode.ACCEPTED.getCode());
				flow.setUpdateTime(now);
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				callBackParam.setData(respData.toJSONString());
				//TODO 页面返回塞值
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("paramDto", callBackParam);
			}
		} else {
			CallBackParam callBackParam = new CallBackParam();
			callBackParam.setResult("系统异常");
			callBackParam.setRequestRefNo(fcpTrxNo);
			callBackParam.setFailCode("99");
			callBackParam.setFailReason("未找到原始交易记录");
			return new ModelAndView("callback").addObject("paramDto", callBackParam);
		}
	}

	/**
	 * 验证密码页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealCheckPwd(JSONObject respData) {
		Date now = new Date();
		String fcpTrxNo = respData.getString("requestNo");
		String code = respData.getString("code");
		String status = respData.getString("status");
		LmUserOperationFlowinfoExample example = new LmUserOperationFlowinfoExample();
		example.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmUserOperationFlowinfo> flowInfoList = lmUserOperationFlowinfoMapper.selectByExample(example);
		if (flowInfoList != null || flowInfoList.size() == 1) {
			LmUserOperationFlowinfo flow = flowInfoList.get(0);
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				flow.setResult(ResultCode.ACCEPTED.getCode());
				flow.setUpdateTime(now);
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				callBackParam.setData(respData.toJSONString());
				//TODO 页面返回塞值
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("paramDto", callBackParam);
			}
		} else {
			CallBackParam callBackParam = new CallBackParam();
			callBackParam.setResult("系统异常");
			callBackParam.setRequestRefNo(fcpTrxNo);
			callBackParam.setFailCode("99");
			callBackParam.setFailReason("未找到原始交易记录");
			return new ModelAndView("callback").addObject("paramDto", callBackParam);
		}
	}

	/**
	 * 更换预留手机页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealChangeMobile(JSONObject respData) {
		Date now = new Date();
		String fcpTrxNo = respData.getString("requestNo");
		String code = respData.getString("code");
		String status = respData.getString("status");
		LmUserOperationFlowinfoExample example = new LmUserOperationFlowinfoExample();
		example.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmUserOperationFlowinfo> flowInfoList = lmUserOperationFlowinfoMapper.selectByExample(example);
		if (flowInfoList != null || flowInfoList.size() == 1) {
			LmUserOperationFlowinfo flow = flowInfoList.get(0);
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				flow.setResult(ResultCode.ACCEPTED.getCode());
				flow.setUpdateTime(now);
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				callBackParam.setData(respData.toJSONString());
				//TODO 页面返回塞值
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("paramDto", callBackParam);
			}
		} else {
			CallBackParam callBackParam = new CallBackParam();
			callBackParam.setResult("系统异常");
			callBackParam.setRequestRefNo(fcpTrxNo);
			callBackParam.setFailCode("99");
			callBackParam.setFailReason("未找到原始交易记录");
			return new ModelAndView("callback").addObject("paramDto", callBackParam);
		}
	}
}
