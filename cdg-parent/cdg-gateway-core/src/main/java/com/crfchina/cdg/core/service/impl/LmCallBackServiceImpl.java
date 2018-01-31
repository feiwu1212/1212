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
import com.crfchina.cdg.basedb.dao.LmVaccountTransferLogMapper;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfoExample;
import com.crfchina.cdg.basedb.entity.LmChangeCardmobileFlowinfo;
import com.crfchina.cdg.basedb.entity.LmChangeCardmobileFlowinfoExample;
import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfo;
import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfoExample;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetail;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetailExample;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfoExample;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferLog;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferLogExample;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.common.EnumsDBMap;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.core.dto.base.CallBackParam;
import com.crfchina.cdg.core.dto.base.LmGatewayPageCallbackResult;
import com.crfchina.cdg.core.service.LmCacheService;
import com.crfchina.cdg.core.service.LmCallBackService;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	public static final Logger logger = LoggerFactory
			.getLogger(LmCallBackServiceImpl.class);

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

	@Autowired
	LmChangeCardmobileFlowinfoMapper lmChangeCardmobileFlowinfoMapper;

	@Autowired
	LmUserOperationFlowinfoMapper lmUserOperationFlowinfoMapper;

	@Autowired
	LmCacheService cacheService;

	@Override
	public ModelAndView dealCallBack(LmGatewayPageCallbackResult result) {
		ApiType apiType = ApiType.valueOf(result.getServiceName());
		if (ApiType.PERSONAL_REGISTER_EXPAND.equals(apiType)) {
			return dealPersonOpenAccount(result.getRespData());
		}
		if (ApiType.ENTERPRISE_REGISTER.equals(apiType)) {
			return dealEnterpriseOpenCallBack(result.getRespData());
		}
		else if (ApiType.RECHARGE.equals(apiType)) { //充值业务回调入口
			return dealRechargeCallBack(result.getRespData());
		}
		else if (ApiType.WITHDRAW.equals(apiType)) { //充值业务回调入口
			return dealWithdrawCallBack(result.getRespData());
		}
		else if (ApiType.USERPRETRANSACTION.equals(apiType)) { //用户预处理业务回调入口
			return dealUserPreTransactionCallBack(result.getRespData());
		}
		else if (ApiType.PERSONAL_BIND_BANKCARD_EXPAND.equals(apiType)) {
			return dealChangeCard(result.getRespData());
		}
		else if (ApiType.CHECK_PASSWORD.equals(apiType)) {
			return dealCheckPwd(result.getRespData());
		}
		else if (ApiType.MODIFY_MOBILE_EXPAND.equals(apiType)) {
			return dealChangeMobile(result.getRespData());
		}
		else if (ApiType.RESET_PASSWORD.equals(apiType)) {
			return dealChangePwd(result.getRespData());
		}
		else if (ApiType.ACTIVATE_STOCKED_USER.equals(apiType)) {
			return dealActiveAccount(result.getRespData());
		}
		else if (ApiType.VERIFY_DEDUCT.equals(apiType)) {

		}

		return null;
	}

	/**
	 * 绑卡页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealPersonOpenAccount(JSONObject respData) {
		logger.info("个人绑卡页面回调开始【begin】参数{}", respData.toJSONString());
		CallBackParam callBackParam = new CallBackParam();
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
				flow.setBankCode(cacheService.getBankCode(respData.getString("bankcode"))); //bankcode
				flow.setAccessType(EnumsDBMap.ACCESS_TYPE_MAP.get(respData.getString("accessType"))); // AuthenticationType
				flow.setAuditStatus(EnumsDBMap.AUDIT_STATUS_MAP.get(respData.getString("auditStatus"))); // AuditStatus
				if (ResultCode.UNKNOWN.equals(flow.getResult())) {
					flow.setResult(ResultCode.ACCEPTED.getCode());
				}
				flow.setUpdateTime(now);
				lmBindCardFlowinfoMapper.updateByPrimaryKey(flow);

				callBackParam.setResult(flow.getResult());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				JSONObject data = new JSONObject();
				data.put("fcpTrxNo", flow.getFcpTrxNo());
				data.put("platformUserNo", respData.getString("platformUserNo"));
				data.put("realName", respData.getString("realName"));
				data.put("idCardNo", respData.getString("idCardNo"));
				data.put("bankCardNo", respData.getString("bankcardNo"));
				data.put("bankCode", flow.getBankCode());
				data.put("mobile", respData.getString("mobile"));
				data.put("idCardType", respData.getString("idCardType"));
				data.put("accessType", respData.getString("accessType"));
				data.put("userRole", respData.getString("userRole"));
				data.put("auditStatus", respData.getString("auditStatus"));
				data.put("failTime", respData.getString("failTime"));
				if (!StringUtils.isBlank(respData.getString("amount"))) {
					data.put("authAmount", MoneyUtils.toCent(respData.getString("amount")));
				}
				callBackParam.setData(data.toJSONString());

			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmBindCardFlowinfoMapper.updateByPrimaryKey(flow);

				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
			}
			logger.info("个人绑卡页面回调结束【begin】结果{}", JSONObject.toJSONString(callBackParam));
			return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
		} else {
			logger.info("未找到对应的bindCardFlow历史订单记录fcpTrxNo-->{}", fcpTrxNo);
			return new ModelAndView("error");
		}
	}

	/**
	 * 企业绑卡页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealEnterpriseOpenCallBack(JSONObject respData) {
		logger.info("企业绑卡页面回调开始【begin】参数{}", respData.toJSONString());
		CallBackParam callBackParam = new CallBackParam();
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
				flow.setUserRole(respData.getString("userRole"));
				flow.setBankcardNo(respData.getString("bankcardNo"));
				flow.setBankCode(cacheService.getBankCode(respData.getString("bankcode"))); //bankcode
				flow.setAuditStatus(EnumsDBMap.AUDIT_STATUS_MAP.get(respData.getString("auditStatus"))); // AuditStatus
				if (ResultCode.UNKNOWN.equals(flow.getResult())) {
					flow.setResult(ResultCode.ACCEPTED.getCode());
				}
				flow.setUpdateTime(now);
				lmBindCardFlowinfoMapper.updateByPrimaryKey(flow);

				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				JSONObject data = new JSONObject();
				data.put("fcpTrxNo", flow.getFcpTrxNo());
				data.put("platformUserNo", respData.getString("platformUserNo"));
				data.put("bankCardNo", respData.getString("bankcardNo"));
				data.put("bankCode", flow.getBankCode());
				data.put("userRole", respData.getString("userRole"));
				data.put("auditStatus", respData.getString("auditStatus"));
				data.put("failTime", respData.getString("failTime"));
				data.put("authAmount", respData.getString("amount"));
				callBackParam.setData(respData.toJSONString());

			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmBindCardFlowinfoMapper.updateByPrimaryKey(flow);

				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
			}
			logger.info("企业绑卡页面回调结束【begin】结果{}", JSONObject.toJSONString(callBackParam));
			return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
		} else {
			logger.info("bindCardFlow订单异常fcpTrxNo-->{}", fcpTrxNo);
			return new ModelAndView("error");
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
		logger.info("充值页面回调开始【begin】参数{}", respData.toJSONString());
		Date now = new Date();
		String fcpTrxNo = respData.getString("requestNo");
		String code = respData.getString("code");
		String status = respData.getString("status");
		LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		LmVaccountTransferLogExample logExample = new LmVaccountTransferLogExample();
		infoExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		logExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmVaccountTransferInfo> flowInfoList = txnInfoMapper.selectByExample(infoExample);
		List<LmVaccountTransferLog> logInfoList = txnLogMapper.selectByExample(logExample);
		LmVaccountTransferInfo flowInfo = null;
		LmVaccountTransferLog logInfo = null;
		if (flowInfoList != null && flowInfoList.size() == 1) {
			flowInfo = flowInfoList.get(0);
			if (logInfoList != null && logInfoList.size() == 1) {
				logInfo = logInfoList.get(0);
			} else {
				logger.info("transferLog订单异常fcpTrxNo-->{}", fcpTrxNo);
				return new ModelAndView("error");
			}
			LmVaccountTransferDetail txnDtl = null;
			LmVaccountTransferDetail txnDtl2 = null;
			//获取交易明细表
			LmVaccountTransferDetailExample txnDtlExample = new LmVaccountTransferDetailExample();
			txnDtlExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
			List<LmVaccountTransferDetail> txnDtlList = txnDetailMapper.selectByExample(txnDtlExample);
			if (txnDtlList != null ) {
				 txnDtl = txnDtlList.get(0);
				 //如果返回字段中有佣金字段，则获取第二条dtl记录
				 if(!StringUtils.isEmpty(respData.getString("commission")) || !Integer.valueOf(respData.getString("commission")).equals(0)){
					 txnDtl2 = txnDtlList.get(1);
				 }
			}
			else{
				logger.info("transferDetail订单异常fcpTrxNo-->{}", fcpTrxNo);
				return new ModelAndView("error");
			}
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				//更新交易主表
				if (ResultCode.UNKNOWN.equals(flowInfo.getResult())) {
					flowInfo.setResult(ResultCode.ACCEPTED.getCode());
					flowInfo.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
					flowInfo.setUpdateTime(now);
					flowInfo.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
					flowInfo.setSettleDate(now);
					txnInfoMapper.updateByPrimaryKey(flowInfo);
				}

				if (ResultCode.UNKNOWN.equals(txnDtl.getResult())) {
					txnDtl.setResult(ResultCode.ACCEPTED.getCode());
					txnDtl.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
					txnDtl.setUpdateTime(now);
					txnDtl.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
					txnDtl.setSettleDate(now);
					txnDetailMapper.updateByPrimaryKey(txnDtl);
				}

				
				 if(!StringUtils.isEmpty(respData.getString("commission")) || !Integer.valueOf(respData.getString("commission")).equals(0)){
					 if (ResultCode.UNKNOWN.equals(txnDtl2.getResult())) {
						 txnDtl2.setResult(ResultCode.ACCEPTED.getCode());
						 txnDtl2.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
						 txnDtl2.setUpdateTime(now);
						 txnDtl2.setSettleAmount(MoneyUtils.toCent(respData.getString("commission")));
						 txnDtl2.setSettleDate(now);
						 txnDetailMapper.updateByPrimaryKey(txnDtl2);
					 }
				 }

				//更新log表
				if (ResultCode.UNKNOWN.equals(logInfo.getResult())) {
					logInfo.setResult(ResultCode.ACCEPTED.getCode());
					logInfo.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
					logInfo.setUpdateTime(now);
					logInfo.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
					logInfo.setSettleDate(now);
					txnLogMapper.updateByPrimaryKey(logInfo);
				}

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flowInfo.getRequestRefNo());
				JSONObject data = new JSONObject();
				data.put("fcptrxNo", fcpTrxNo);
				data.put("platformUserNo", respData.getString("platformUserNo"));
				data.put("amount", MoneyUtils.toCent(respData.getString("amount")));
				data.put("commission", MoneyUtils.toCent(respData.getString("commission")));
				data.put("payCompany", respData.getString("payCompany"));
				data.put("rechargeWay", respData.getString("rechargeWay"));
				data.put("bankCode", respData.getString("bankcode"));
				data.put("payMobile", respData.getString("payMobile"));
				data.put("transactionTime", respData.getString("transactionTime"));
				callBackParam.setData(data.toJSONString());
				return new ModelAndView("callback").addObject("url", flowInfo.getCallbackUrl()).addObject("paramDto", callBackParam);
			} else {
				flowInfo.setResult(ResultCode.FAIL.getCode());
				flowInfo.setFailCode(respData.getString("errorCode"));
				flowInfo.setFailReason(respData.getString("errorMessage"));
				flowInfo.setUpdateTime(now);
				txnInfoMapper.updateByPrimaryKey(flowInfo);

				txnDtl.setResult(ResultCode.FAIL.getCode());
				txnDtl.setFailCode(respData.getString("errorCode"));
				txnDtl.setFailReason(respData.getString("errorCode"));
				txnDtl.setUpdateTime(now);
				txnDetailMapper.updateByPrimaryKey(txnDtl);

				if(!StringUtils.isEmpty(respData.getString("commission")) || !Integer.valueOf(respData.getString("commission")).equals(0)){
					txnDtl2.setResult(ResultCode.FAIL.getCode());
					txnDtl2.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
					txnDtl2.setUpdateTime(now);
					txnDtl2.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
					txnDtl2.setSettleDate(now);
					txnDetailMapper.updateByPrimaryKey(txnDtl2);
				}

				logInfo.setResult(ResultCode.FAIL.getCode());
				logInfo.setFailCode(respData.getString("errorCode"));
				logInfo.setFailReason(respData.getString("errorMessage"));
				logInfo.setUpdateTime(now);
				txnLogMapper.updateByPrimaryKey(logInfo);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flowInfo.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("url", flowInfo.getCallbackUrl()).addObject("paramDto", callBackParam);
			}
		} else {
			logger.info("transferInfo订单异常fcpTrxNo-->{}", fcpTrxNo);
			return new ModelAndView("error");
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
		LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		LmVaccountTransferLogExample logExample = new LmVaccountTransferLogExample();
		infoExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		logExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		LmVaccountTransferInfo flowInfo = null;
		LmVaccountTransferLog logInfo = null;
		List<LmVaccountTransferInfo> flowInfoList = txnInfoMapper.selectByExample(infoExample);
		List<LmVaccountTransferLog> logList = txnLogMapper.selectByExample(logExample);
		if (flowInfoList != null && flowInfoList.size() == 1) {
			flowInfo = flowInfoList.get(0);
			if (logList != null && logList.size() == 1) {
				logInfo = logList.get(0);
			} else {
				logger.info("transferLog订单异常fcpTrxNo-->{}", fcpTrxNo);
				return new ModelAndView("error");
			}
			//获取交易明细表
			LmVaccountTransferDetailExample txnDtlExample = new LmVaccountTransferDetailExample();
			txnDtlExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
			List<LmVaccountTransferDetail> txnDtlList = txnDetailMapper.selectByExample(txnDtlExample);

			LmVaccountTransferDetail txnDtl = null;
			LmVaccountTransferDetail txnDtl2 = null;

			if (null != txnDtlList) {
				txnDtl = txnDtlList.get(0);
				if(!StringUtils.isEmpty(respData.getString("commission"))){
					txnDtl2 = txnDtlList.get(1);
				}
			} else {
				logger.info("transferDetail订单异常fcpTrxNo-->{}", fcpTrxNo);
				return new ModelAndView("error");
			}
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				//更新交易主表
				if (ResultCode.UNKNOWN.equals(flowInfo.getResult())) {
					flowInfo.setResult(ResultCode.ACCEPTED.getCode());
					flowInfo.setFinishDate(DateUtils.strToDate(respData.getString("transactionTime")));
					flowInfo.setUpdateTime(now);
					flowInfo.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
					flowInfo.setSettleDate(now);
					txnInfoMapper.updateByPrimaryKey(flowInfo);
				}

				//更新交易明细表
				if (ResultCode.UNKNOWN.equals(txnDtl.getResult())) {
					txnDtl.setResult(ResultCode.ACCEPTED.getCode());
					txnDtl.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
					txnDtl.setUpdateTime(now);
					txnDtl.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
					txnDtl.setSettleDate(now);
					txnDetailMapper.updateByPrimaryKey(txnDtl);
				}


				if(!StringUtils.isEmpty(respData.getString("commission"))){
					if (ResultCode.UNKNOWN.equals(txnDtl2.getResult())) {
						txnDtl2.setResult(ResultCode.ACCEPTED.getCode());
						txnDtl2.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
						txnDtl2.setUpdateTime(now);
						txnDtl2.setSettleAmount(MoneyUtils.toCent(respData.getString("commission")));
						txnDtl2.setSettleDate(now);
						txnDetailMapper.updateByPrimaryKey(txnDtl2);
					}
				}

				//更新log表
				if (ResultCode.UNKNOWN.equals(logInfo.getResult())) {
					logInfo.setResult(ResultCode.ACCEPTED.getCode());
					logInfo.setFinishDate(DateUtils.strToDate(respData.getString("transactionTime")));
					logInfo.setUpdateTime(now);
					logInfo.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
					logInfo.setSettleDate(now);
					txnLogMapper.updateByPrimaryKey(logInfo);
				}
				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.SUCCESS.getCode());
				callBackParam.setRequestRefNo(flowInfo.getRequestRefNo());
				JSONObject data = new JSONObject();
				data.put("fcptrxNo", fcpTrxNo);
				data.put("platformUserNo", respData.getString("platformUserNo"));
				data.put("amount", respData.getString("amount"));
				data.put("commission", MoneyUtils.toCent(respData.getString("commission")));
				data.put("withdrawWay", respData.getString("withdrawWay"));
				data.put("withdrawForm", respData.getString("withdrawForm"));
				data.put("bankcardNo", respData.getString("bankcardNo"));
				data.put("bankCode", respData.getString("bankcode"));
				data.put("createTime", respData.getString("createTime"));
				data.put("transactionTime", respData.getString("transactionTime"));
				data.put("remitType", respData.getString("remitType"));
				data.put("floatAmount", respData.getString("floatAmount"));
				callBackParam.setData(data.toJSONString());
				return new ModelAndView("callback").addObject("url", flowInfo.getCallbackUrl()).addObject("paramDto", callBackParam);
			} else {
				flowInfo.setResult(ResultCode.FAIL.getCode());
				flowInfo.setFailCode(respData.getString("errorCode"));
				flowInfo.setFailReason(respData.getString("errorMessage"));
				flowInfo.setUpdateTime(now);
				txnInfoMapper.updateByPrimaryKey(flowInfo);

				//更新交易明细表
				txnDtl.setResult(ResultCode.FAIL.getCode());
				txnDtl.setFailCode(respData.getString("errorCode"));
				txnDtl.setFailReason(respData.getString("errorCode"));
				txnDtl.setUpdateTime(now);
				txnDetailMapper.updateByPrimaryKey(txnDtl);

				if(!StringUtils.isEmpty(respData.getString("commission"))){
					txnDtl2.setResult(ResultCode.FAIL.getCode());
					txnDtl2.setFinishDate(DateUtils.parseStringToDate(respData.getString("transactionTime"), "yyyyMMddHHmmss"));
					txnDtl2.setUpdateTime(now);
					txnDtl2.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
					txnDtl2.setSettleDate(now);
					txnDetailMapper.updateByPrimaryKey(txnDtl2);
				}

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flowInfo.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("url", flowInfo.getCallbackUrl()).addObject("paramDto", callBackParam);
			}
		} else {
			logger.info("transferInfo订单异常fcpTrxNo-->{}", fcpTrxNo);
			return new ModelAndView("error");
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
				logger.info("transferDetail订单异常fcpTrxNo-->{}", fcpTrxNo);
				return new ModelAndView("error");
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
			logger.info("transferInfo订单异常fcpTrxNo-->{}", fcpTrxNo);
			return new ModelAndView("error");
		}
	}

	/**
	 * 更换银行卡页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealChangeCard(JSONObject respData) {
		logger.info("更换银行卡页面回调开始【begin】参数{}", respData.toJSONString());
		Date now = new Date();
		CallBackParam callBackParam = new CallBackParam();
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

				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				JSONObject data = new JSONObject();
				data.put("fcptrxNo", flow.getFcpTrxNo());
				data.put("platformUserNo", respData.getString("platformUserNo"));
				data.put("realName", flow.getRealName());
				data.put("bankCardNo", respData.getString("bankcardNo"));
				data.put("bankCode", cacheService.getBankCode(respData.getString("bankcode")));
				data.put("mobile", respData.getString("mobile"));
				data.put("accessType", respData.getString("accessType"));
				data.put("auditStatus", respData.getString("auditStatus"));
				callBackParam.setData(data.toJSONString());
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmChangeCardmobileFlowinfoMapper.updateByPrimaryKey(flow);

				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
			}
			logger.info("更换银行卡页面回调结束【begin】结果{}", JSONObject.toJSONString(callBackParam));
			return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
		} else {
			logger.info("未找到对应的历史订单记录fcpTrxNo-->{}", fcpTrxNo);
			return new ModelAndView("error");
		}
	}

	/**
	 * 更换密码页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealChangePwd(JSONObject respData) {
		logger.info("更换密码页面回调开始【begin】参数{}", respData.toJSONString());
		Date now = new Date();
		CallBackParam callBackParam = new CallBackParam();
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

				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				JSONObject data = new JSONObject();
				data.put("fcptrxNo", flow.getFcpTrxNo());
				data.put("platformUserNo", flow.getPlatformUserId());
				callBackParam.setData(data.toJSONString());

			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);


				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
			}
			logger.info("更换密码页面回调结束【begin】结果{}", JSONObject.toJSONString(callBackParam));
			return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
		} else {
			logger.info("未找到对应的历史订单记录fcpTrxNo-->{}", fcpTrxNo);
			return new ModelAndView("error");
		}
	}

	/**
	 * 验证密码页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealCheckPwd(JSONObject respData) {
		logger.info("验证密码页面回调开始【begin】参数{}", respData.toJSONString());
		Date now = new Date();
		CallBackParam callBackParam = new CallBackParam();
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

				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				JSONObject data = new JSONObject();
				data.put("fcptrxNo", flow.getFcpTrxNo());
				data.put("platformUserNo", flow.getPlatformUserId());
				data.put("bizTypeDescription", flow.getBizTypeDesc());
				callBackParam.setData(data.toJSONString());

			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);

				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
			}
			logger.info("验证密码页面回调结束【begin】结果{}", JSONObject.toJSONString(callBackParam));
			return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
		} else {
			logger.info("未找到对应的历史订单记录fcpTrxNo-->{}", fcpTrxNo);
			return new ModelAndView("error");
		}
	}

	/**
	 * 更换预留手机页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealChangeMobile(JSONObject respData) {
		logger.info("更换预留手机号页面回调开始【begin】参数{}", respData.toJSONString());
		Date now = new Date();
		CallBackParam callBackParam = new CallBackParam();
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


				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				JSONObject data = new JSONObject();
				data.put("fcpTrxNo", flow.getFcpTrxNo());
				data.put("platformUserNo", flow.getPlatformUserId());
				data.put("bankCardNo", respData.getString("bankcardNo"));
				data.put("bankCode", respData.getString("bankCode"));
				data.put("mobile", respData.getString("mobile"));
				callBackParam.setData(data.toJSONString());

			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);

				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
			}
			logger.info("更换预留手机号页面回调结束【begin】结果{}", JSONObject.toJSONString(callBackParam));
			return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
		} else {
			logger.info("未找到对应的历史订单记录fcpTrxNo-->{}", fcpTrxNo);
			return new ModelAndView("error");
		}
	}

	/**
	 * 用户激活页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealActiveAccount(JSONObject respData) {
		logger.info("用户激活页面回调开始【begin】参数{}", respData.toJSONString());
		Date now = new Date();
		CallBackParam callBackParam = new CallBackParam();
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

				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				JSONObject data = new JSONObject();
				data.put("fcpTrxNo", flow.getFcpTrxNo());
				data.put("platformUserNo", flow.getPlatformUserId());
				//FIXME 没有这两个参数
//				data.put("realName", respData.getString(""))
//				data.put("idCardNo", respData.getString(""))
				data.put("bankCardNo", respData.getString("bankcardNo"));
				data.put("bankCode", respData.getString("bankcode"));
				data.put("mobile", respData.getString("mobile"));
//				data.put("idCardType", respData.getString())
				data.put("accessType", respData.getString("accessType"));
				data.put("userRole", respData.getString("userRole"));
				data.put("cardNolsChange", respData.getString("cardNolsChange"));
				data.put("auditStatus", respData.getString("auditStatus"));
				data.put("failTime", respData.getString("failTime"));
				data.put("authAmount", respData.getString("amount"));
				callBackParam.setData(data.toJSONString());
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);

				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
			}
			logger.info("用户激活页面回调结束【begin】结果{}", JSONObject.toJSONString(callBackParam));
			return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
		} else {
			logger.info("未找到对应的历史订单记录fcpTrxNo-->{}", fcpTrxNo);
			return new ModelAndView("error");
		}
	}

	/**
	 * 验密扣费页面回调
	 * @param respData
	 * @return
	 */
	private ModelAndView dealVerifyDeduct(JSONObject respData) {
//		logger.info("验密扣费页面回调开始【begin】参数{}", respData.toJSONString());
//		Date now = new Date();
//		CallBackParam callBackParam = new CallBackParam();
//		String fcpTrxNo = respData.getString("requestNo");
//		String code = respData.getString("code");
//		String status = respData.getString("status");
//		LmVaccountTransferInfoExample example = new LmVaccountTransferInfoExample();
//		example.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
//		List<LmVaccountTransferInfo> flowInfoList = txnInfoMapper.selectByExample(example);
//		if (flowInfoList != null || flowInfoList.size() == 1) {
//			LmVaccountTransferInfo flow = flowInfoList.get(0);
//			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
//				flow.setResult(ResultCode.ACCEPTED.getCode());
//				flow.setUpdateTime(now);
//				txnInfoMapper.updateByPrimaryKey(flow);
//
//				callBackParam.setResult(ResultCode.ACCEPTED.getCode());
//				callBackParam.setRequestRefNo(flow.getRequestRefNo());
//				JSONObject data = new JSONObject();
//				data.put("fcpTrxNo", flow.getFcpTrxNo());
//				data.put("platformUserNo", flow.getPlatformUserId());
//				data.put("bankCardNo", respData.getString("bankcardNo"));
//				data.put("bankCode", respData.getString("bankcode"));
//				data.put("mobile", respData.getString("mobile"));
////				data.put("idCardType", respData.getString())
//				data.put("accessType", respData.getString("accessType"));
//				data.put("userRole", respData.getString("userRole"));
//				data.put("cardNolsChange", respData.getString("cardNolsChange"));
//				data.put("auditStatus", respData.getString("auditStatus"));
//				data.put("failTime", respData.getString("failTime"));
//				data.put("authAmount", respData.getString("amount"));
//				callBackParam.setData(data.toJSONString());
//			} else {
//				flow.setResult(ResultCode.FAIL.getCode());
//				flow.setFailCode(respData.getString("errorCode"));
//				flow.setFailReason(respData.getString("errorMessage"));
//				flow.setUpdateTime(now);
//				lmUserOperationFlowinfoMapper.updateByPrimaryKey(flow);
//
//				callBackParam.setResult(ResultCode.FAIL.getCode());
//				callBackParam.setRequestRefNo(flow.getRequestRefNo());
//				callBackParam.setFailCode(respData.getString("errorCode"));
//				callBackParam.setFailReason(respData.getString("errorMessage"));
//			}
//			logger.info("用户激活页面回调结束【begin】结果{}", JSONObject.toJSONString(callBackParam));
//			return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("paramDto", callBackParam);
//		} else {
////			logger.info("未找到对应的历史订单记录fcpTrxNo-->{}", fcpTrxNo);
////			return new ModelAndView("error");
//		}
		return null;
	}

}
