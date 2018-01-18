/**
 * @Title：
 * @Package com.crfchina.cdg.core.impl
 * @date 2018/1/8 15:29
 * @version V1.0
 */
package com.crfchina.cdg.core.service.impl;

import com.crfchina.cdg.basedb.dao.LmBindCardFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmBindCardListMapper;
import com.crfchina.cdg.basedb.dao.LmChangeCardmobileFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmUserOperationFlowinfoMapper;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.basedb.entity.LmChangeCardmobileFlowinfo;
import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfo;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.common.EnumsDBMap;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.core.dto.param.LmActiveAccountParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangeBankCardParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangeMobileParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangePwdParamDTO;
import com.crfchina.cdg.core.dto.param.LmCheckPwdParamDTO;
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
import com.crfchina.cdg.core.service.LmAccountService;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class LmAccountServiceImpl implements LmAccountService {

	public static final Logger logger = LoggerFactory
			.getLogger(LmAccountServiceImpl.class);
	@Autowired
	LmBindCardFlowinfoMapper lmBindCardFlowinfoMapper;

	@Autowired
	LmBindCardListMapper lmBindCardListMapper;

	@Autowired
	LmChangeCardmobileFlowinfoMapper lmChangeCardmobileFlowinfoMapper;

	@Autowired
	LmUserOperationFlowinfoMapper lmUserOperationFlowinfoMapper;
	/**
	 * 个人绑卡申请
	 * @param loapDto
	 */
	@Override
	public Map<String, Object> personBindCard(LmOpenAccountParamDTO loapDto) {
		logger.info("个人绑卡参数拼装入库开始【begin】");
		String trxNo = TrxNoUtils.getTrxNo(Constants.PERSON_OPEN_ACCOUNT);
		Date now = new Date();
		LmBindCardFlowinfo flowInfo = new LmBindCardFlowinfo();
		flowInfo.setRequestRefNo(loapDto.getRequestRefNo());
		flowInfo.setFcpTrxNo(trxNo);
		flowInfo.setRequestTime(now);
		flowInfo.setSystemNo(String.valueOf(loapDto.getSystemNo().getValue()));
		flowInfo.setPlatformUserId(loapDto.getPlatformUserNo());
		flowInfo.setUserRealName(loapDto.getRealName());
		flowInfo.setBankcardNo(loapDto.getBankCardNo());
		flowInfo.setMobile(loapDto.getMobile());
		flowInfo.setIdNo(loapDto.getIdCardNo());
		flowInfo.setIdType(EnumsDBMap.ID_CARD_TYPE_MAP.get(loapDto.getIdCardType().getCode()));
		flowInfo.setBindcardTime(now);
		flowInfo.setResult(ResultCode.UNKNOWN.getCode()); // 新创建绑卡申请结果为unknown
		flowInfo.setUserRole(loapDto.getUserRole().getCode());
		List<String> authStrList = loapDto.getAuthList().stream().map(o -> o.getCode()).collect(Collectors.toList());
		String authStr = String.join(",", authStrList);
		flowInfo.setAuthList(authStr);
		flowInfo.setCheckType(EnumsDBMap.CHECK_TYPE_MAP.get(Constants.CHECK_TYPE));
		flowInfo.setUserLimitType(EnumsDBMap.USER_LIMIT_TYPE_MAP.get(Constants.ID_CARD_NO_UNIQUE));
		flowInfo.setCallbackUrl(loapDto.getCallbackUrl());
		flowInfo.setNotifyUrl(loapDto.getNotifyUrl());
		flowInfo.setCreateTime(now);
		flowInfo.setUpdateTime(now);
		flowInfo.setPartitionDate(Integer.valueOf(DateUtils.dateToString(now, "yyyyMM")));

		//拼接reqData
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", loapDto.getPlatformUserNo());
		reqDataMap.put("requestNo", trxNo);
		reqDataMap.put("realName", loapDto.getRealName());
		reqDataMap.put("idCardNo", loapDto.getIdCardNo());
		reqDataMap.put("bankcardNo", loapDto.getBankCardNo());
		reqDataMap.put("mobile", loapDto.getMobile());
		reqDataMap.put("idCardType", loapDto.getIdCardType());
		reqDataMap.put("userRole", loapDto.getUserRole());
		reqDataMap.put("checkType", Constants.CHECK_TYPE);
		// 本地调试配置本地回调地址
		reqDataMap.put("redirectUrl", AppConfig.getConfig().getCallBackUrl());
		reqDataMap.put("userLimitType", Constants.ID_CARD_NO_UNIQUE);
		reqDataMap.put("authList", authStr);
		reqDataMap.put("failTime", loapDto.getFailTime());
		reqDataMap.put("amount", MoneyUtils.toDollar(loapDto.getAuthAmount()));

		lmBindCardFlowinfoMapper.insert(flowInfo);

		logger.info("个人绑卡参数拼装入库结束【end】");
		return reqDataMap;
	}

	/**
	 * 用户换绑卡
	 * @param lcbcDto
	 * @return
	 */
	@Override
	public Map<String, Object> changeCard(LmChangeBankCardParamDTO lcbcDto) {
		String trxNo = TrxNoUtils.getTrxNo(Constants.PERSON_CHANGE_CARD);
		Date now = new Date();
		LmChangeCardmobileFlowinfo flowInfo = new LmChangeCardmobileFlowinfo();
		flowInfo.setRequestRefNo(lcbcDto.getRequestRefNo());
		flowInfo.setFcpTrxNo(trxNo);
		flowInfo.setRequestTime(now);
		flowInfo.setSystemNo(String.valueOf(lcbcDto.getSystemNo().getValue()));
		flowInfo.setPlatformUserId(lcbcDto.getPlatformUserNo());
		flowInfo.setMobile(lcbcDto.getMobile());
		flowInfo.setBankCardNo(lcbcDto.getBankcardNo());
		flowInfo.setBindType(EnumsDBMap.BIND_TYPE_MAP.get(Constants.UPDATE_BANKCARD));
		flowInfo.setCallbackUrl(lcbcDto.getCallbackUrl());
		flowInfo.setNotifyUrl(lcbcDto.getNotifyUrl());
		flowInfo.setResult(ResultCode.UNKNOWN.getCode());
		flowInfo.setCreateTime(now);
		flowInfo.setUpdateTime(now);
		flowInfo.setPartitionDate(Integer.valueOf(DateUtils.dateToString(now, "yyyyMM")));

		//拼接reqData
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", lcbcDto.getPlatformUserNo());
		reqDataMap.put("requestNo", trxNo);
		reqDataMap.put("bankcardNo", lcbcDto.getBankcardNo());
		reqDataMap.put("mobile", lcbcDto.getMobile());
		reqDataMap.put("checkType", Constants.CHECK_TYPE);
		reqDataMap.put("redirectUrl", AppConfig.getConfig().getCallBackUrl());

		lmChangeCardmobileFlowinfoMapper.insert(flowInfo);
		return reqDataMap;
	}

	/**
	 * 用户更换密码
	 * @param lcpDto
	 * @return
	 */
	@Override
	public Map<String, Object> changePwd(LmChangePwdParamDTO lcpDto) {
		String trxNo = TrxNoUtils.getTrxNo(Constants.PERSON_CHANGE_PWD);
		Date now = new Date();
		LmUserOperationFlowinfo flowInfo = new LmUserOperationFlowinfo();
		flowInfo.setRequestRefNo(lcpDto.getRequestRefNo());
		flowInfo.setFcpTrxNo(trxNo);
		flowInfo.setRequestTime(now);
		flowInfo.setSystemNo(String.valueOf(lcpDto.getSystemNo().getValue()));
		flowInfo.setPlatformUserId(lcpDto.getPlatformUserNo());
		flowInfo.setOperType(EnumsDBMap.OPER_TYPE_MAP.get(ApiType.RESET_PASSWORD.getCode()));
		flowInfo.setCallbackUrl(lcpDto.getCallbackUrl());
		flowInfo.setNotifyUrl(lcpDto.getNotifyUrl());
		flowInfo.setResult(ResultCode.UNKNOWN.getCode());
		flowInfo.setCreateTime(now);
		flowInfo.setUpdateTime(now);
		flowInfo.setPartitionDate(Integer.valueOf(DateUtils.dateToString(now, "yyyyMM")));

		//拼接reqData
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", lcpDto.getPlatformUserNo());
		reqDataMap.put("requestNo", trxNo);
		reqDataMap.put("isSkip", lcpDto.getIsSkip());
		reqDataMap.put("redirectUrl", AppConfig.getConfig().getCallBackUrl());

		lmUserOperationFlowinfoMapper.insert(flowInfo);
		return reqDataMap;
	}

	/**
	 * 验证密码
	 * @param lcpDto
	 * @return
	 */
	@Override
	public Map<String, Object> checkPwd(LmCheckPwdParamDTO lcpDto) {
		String trxNo = TrxNoUtils.getTrxNo(Constants.PERSON_NCHECK_PWD);
		Date now = new Date();
		LmUserOperationFlowinfo flowInfo = new LmUserOperationFlowinfo();
		flowInfo.setRequestRefNo(lcpDto.getRequestRefNo());
		flowInfo.setFcpTrxNo(trxNo);
		flowInfo.setRequestTime(now);
		flowInfo.setSystemNo(String.valueOf(lcpDto.getSystemNo().getValue()));
		flowInfo.setPlatformUserId(lcpDto.getPlatformUserNo());
		flowInfo.setOperType(EnumsDBMap.OPER_TYPE_MAP.get(ApiType.CHECK_PASSWORD.getCode()));
		flowInfo.setCallbackUrl(lcpDto.getCallbackUrl());
		flowInfo.setNotifyUrl(lcpDto.getNotifyUrl());
		flowInfo.setResult(ResultCode.UNKNOWN.getCode());
		flowInfo.setCreateTime(now);
		flowInfo.setUpdateTime(now);
		flowInfo.setPartitionDate(Integer.valueOf(DateUtils.dateToString(now, "yyyyMM")));
		//拼接reqData
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", lcpDto.getPlatformUserNo());
		reqDataMap.put("requestNo", trxNo);
		reqDataMap.put("bizTypeDescription", lcpDto.getBizTypeDescription());
		reqDataMap.put("redirectUrl", AppConfig.getConfig().getCallBackUrl());

		lmUserOperationFlowinfoMapper.insert(flowInfo);
		return reqDataMap;
	}

	/**
	 * 更换预留手机
	 * @param lcmpDto
	 * @return
	 */
	@Override
	public Map<String, Object> changeMobile(LmChangeMobileParamDTO lcmpDto) {
		String trxNo = TrxNoUtils.getTrxNo(Constants.PERSON_CHANGE_MOBILE);
		Date now = new Date();
		LmUserOperationFlowinfo flowInfo = new LmUserOperationFlowinfo();
		flowInfo.setRequestRefNo(lcmpDto.getRequestRefNo());
		flowInfo.setFcpTrxNo(trxNo);
		flowInfo.setRequestTime(now);
		flowInfo.setSystemNo(String.valueOf(lcmpDto.getSystemNo().getValue()));
		flowInfo.setPlatformUserId(lcmpDto.getPlatformUserNo());
		flowInfo.setOperType(EnumsDBMap.OPER_TYPE_MAP.get(ApiType.MODIFY_MOBILE_EXPAND.getCode()));
		flowInfo.setCallbackUrl(lcmpDto.getCallbackUrl());
		flowInfo.setNotifyUrl(lcmpDto.getNotifyUrl());
		flowInfo.setResult(ResultCode.UNKNOWN.getCode());
		flowInfo.setCreateTime(now);
		flowInfo.setUpdateTime(now);
		flowInfo.setPartitionDate(Integer.valueOf(DateUtils.dateToString(now, "yyyyMM")));

		//拼接reqData
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", lcmpDto.getPlatformUserNo());
		reqDataMap.put("requestNo", trxNo);
		reqDataMap.put("mobile", lcmpDto.getMobile());
		reqDataMap.put("checkType", Constants.CHECK_TYPE);
		reqDataMap.put("redirectUrl", AppConfig.getConfig().getCallBackUrl());

		lmUserOperationFlowinfoMapper.insert(flowInfo);
		return reqDataMap;
	}

	@Override
	public Map<String, Object> activeAccount(LmActiveAccountParamDTO laapDto) {
		String trxNo = TrxNoUtils.getTrxNo(Constants.PERSON_CHANGE_MOBILE);
		Date now = new Date();
		LmUserOperationFlowinfo flowInfo = new LmUserOperationFlowinfo();
		flowInfo.setRequestRefNo(laapDto.getRequestRefNo());
		flowInfo.setFcpTrxNo(trxNo);
		flowInfo.setRequestTime(now);
		flowInfo.setSystemNo(String.valueOf(laapDto.getSystemNo().getValue()));
		flowInfo.setPlatformUserId(laapDto.getPlatformUserNo());
		flowInfo.setOperType(EnumsDBMap.OPER_TYPE_MAP.get(ApiType.ACTIVATE_STOCKED_USER.getCode()));
		flowInfo.setCallbackUrl(laapDto.getCallbackUrl());
		flowInfo.setNotifyUrl(laapDto.getNotifyUrl());
		flowInfo.setResult(ResultCode.UNKNOWN.getCode());
		flowInfo.setCreateTime(now);
		flowInfo.setUpdateTime(now);
		flowInfo.setPartitionDate(Integer.valueOf(DateUtils.dateToString(now, "yyyyMM")));
		List<String> authStrList = laapDto.getAuthList().stream().map(o -> o.getCode()).collect(Collectors.toList());
		String authStr = String.join(",", authStrList);
		flowInfo.setAuthList(authStr);
		flowInfo.setCheckType(EnumsDBMap.CHECK_TYPE_MAP.get(Constants.CHECK_TYPE));
		//拼接reqData
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", laapDto.getPlatformUserNo());
		reqDataMap.put("requestNo", trxNo);
		reqDataMap.put("authList", authStr);
		reqDataMap.put("checkType", Constants.CHECK_TYPE);
		reqDataMap.put("failTime", laapDto.getFailTime());
		reqDataMap.put("amount", MoneyUtils.toDollar(laapDto.getAuthAmount()));
		reqDataMap.put("redirectUrl", AppConfig.getConfig().getCallBackUrl());

		lmUserOperationFlowinfoMapper.insert(flowInfo);
		return reqDataMap;
	}
}
