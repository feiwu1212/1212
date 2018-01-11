/**
 * @Title：
 * @Package com.crfchina.cdg.core.impl
 * @date 2018/1/8 15:29
 * @version V1.0
 */
package com.crfchina.cdg.core.impl;

import com.crfchina.cdg.basedb.dao.LmBindCardFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmBindCardListMapper;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
import com.crfchina.cdg.core.service.LmAccountService;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

	@Autowired
	LmBindCardFlowinfoMapper lmBindCardFlowinfoMapper;

	@Autowired
	LmBindCardListMapper lmBindCardListMapper;


	/**
	 * 个人绑卡申请
	 * @param loapDto
	 */
	@Override
	public Map<String, Object> personBindCard(LmOpenAccountParamDTO loapDto) {
		//TODO 拼接流水
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
		//FIXME 枚举映射数据库类型
		flowInfo.setIdType(1);
		flowInfo.setBindcardTime(now);
		flowInfo.setUserRole(loapDto.getUserRole().getCode());
		List<String> authStrList = loapDto.getAuthList().stream().map(o -> o.getCode()).collect(Collectors.toList());
		String authStr = String.join(",", authStrList);
		flowInfo.setAuthList(authStr);
		//FIXME 枚举映射
		flowInfo.setCheckType(1);
		//FIXME 枚举映射
		flowInfo.setUserLimitType(1);
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
		//TODO 配置本地回调地址
		reqDataMap.put("redirectUrl", "http://127.0.0.1:8080/cdg-geteway/callBack/pageCallBack");
		reqDataMap.put("userLimitType", Constants.ID_CARD_NO_UNIQUE);
		reqDataMap.put("authList", authStr);
		reqDataMap.put("failTime", loapDto.getFailTime());
		reqDataMap.put("amount", loapDto.getAuthAmount());

		lmBindCardFlowinfoMapper.insert(flowInfo);
		return reqDataMap;
	}
}
