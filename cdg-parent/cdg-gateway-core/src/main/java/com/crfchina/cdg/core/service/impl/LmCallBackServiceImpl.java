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
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
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

	
	
	
	@Override
	public ModelAndView dealCallBack(LmGatewayPageCallbackResult result) {
		ApiType apiType = ApiType.valueOf(result.getServiceName());
		if (apiType.equals(ApiType.PERSONAL_REGISTER_EXPAND)) {
			return dealPersonOpenAccount(result.getRespData());
		}
		else if (apiType.equals(ApiType.RECHARGE)) { //充值业务回调入口
			return dealPersonOpenAccount(result.getRespData());
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
	 * @Description: 处理充值回掉业务
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
		if (flowInfoList != null || flowInfoList.size() == 1) {
			LmVaccountTransferInfo flow = flowInfoList.get(0);
			LmVaccountTransferDetail txnDtl = null;
			//获取交易明细表
			LmVaccountTransferDetailExample txnDtlExample = new LmVaccountTransferDetailExample();
			txnDtlExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
			List<LmVaccountTransferDetail> txnDtlList = txnDetailMapper.selectByExample(txnDtlExample);
			if (txnDtlList != null || txnDtlList.size() == 1) {
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
				flow.setResult(ResultCode.SUCCESS.getCode());
				flow.setFinishDate(DateUtils.strToDate(respData.getString("transactionTime")));
				flow.setUpdateTime(now);
				flow.setSettleAmount(MoneyUtils.toCent(respData.getString("amount")));
				flow.setSettleDate(now);
			
				txnDtl.setResult(ResultCode.SUCCESS.getCode());
				txnDtl.setFinishDate(DateUtils.strToDate(respData.getString("transactionTime")));
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
	 * @Description: 处理提现回掉业务
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
		if (flowInfoList != null || flowInfoList.size() == 1) {
			LmVaccountTransferInfo flow = flowInfoList.get(0);
			LmVaccountTransferDetail txnDtl = null;
			//获取交易明细表
			LmVaccountTransferDetailExample txnDtlExample = new LmVaccountTransferDetailExample();
			txnDtlExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
			List<LmVaccountTransferDetail> txnDtlList = txnDetailMapper.selectByExample(txnDtlExample);
			if (txnDtlList != null || txnDtlList.size() == 1) {
				 txnDtl = txnDtlList.get(0);
			}
			else{
				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult("系统异常");
				callBackParam.setRequestRefNo(fcpTrxNo);
				callBackParam.setFailCode("99");
				callBackParam.setFailReason("未找到原始交易明细记录");
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("param", callBackParam);
			}
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				//更新交易主表
				flow.setResult(ResultCode.SUCCESS.getCode());
				flow.setFinishDate(DateUtils.strToDate(respData.getString("transactionTime")));
				flow.setUpdateTime(now);
				flow.setSettleAmount(MoneyUtils.toCent(respData.getString("paramDto")));
				flow.setSettleDate(now);

				txnDtl.setResult(ResultCode.SUCCESS.getCode());
				txnDtl.setFinishDate(DateUtils.strToDate(respData.getString("transactionTime")));
				txnDtl.setUpdateTime(now);
				txnDtl.setSettleAmount(MoneyUtils.toCent(respData.getString("paramDto")));
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

}