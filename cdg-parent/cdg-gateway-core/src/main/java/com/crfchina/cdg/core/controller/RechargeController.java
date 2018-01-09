/**    
 * @Title：AccountController.java    
 * @Package com.crfchina.cdg.core.controller
 *     
 * @date 2018年1月6日 下午4:23:21 
 * @version V1.0
 */
package com.crfchina.cdg.core.controller;

import java.security.GeneralSecurityException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.business.Terminal;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.core.dto.base.LmGatewayPageCallbackResult;
import com.crfchina.cdg.core.dto.param.LmOpenAccountCompanyParamDTO;
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
import com.crfchina.cdg.core.dto.param.LmRechargeParamDTO;
import com.crfchina.cdg.core.service.LmCallBackService;
import com.crfchina.cdg.core.service.LmCapitalService;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * @ClassName：RechargeController
 * @Description:懒猫提充相关接口定义，包括提现、充值
 * 更改银行卡号、更改银行预留手机号等网关跳转层面业务。
 * @author: ghf
 * @date：2018年1月6日 下午4:23:21
 * @updateBy：ghf
 * @updateDate：2018年1月6日 下午4:23:21
 * @remarks：
 */
@RestController
@RequestMapping("/account")
public class RechargeController {

	@Autowired
    LmCapitalService lmCapitalService;
	
	/**
	 * 
	 * @Title: recharge  
	 * @Description: 用户在 P2P 平台发起充值请求，平台调用此接口引导用户跳转至存管页面完成充值
	 * @param request
	 * @return
	 * ModelAndView
	 * @throws
	 */
	@RequestMapping("/recharge")
	public ModelAndView recharge(HttpServletRequest request) {
		LmRechargeParamDTO paramDto = getParamDto(request, LmRechargeParamDTO.class);
		Map<String, Object> rechargeReqDataMap = lmCapitalService.recharge(paramDto);
		// 获取properties参数
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.RECHARGE.getCode(), rechargeReqDataMap);
		}catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	public <T> T getParamDto(HttpServletRequest request, Class<T> clazz) {
		Enumeration<String> parameterNames = request.getParameterNames();
		JSONObject paramObj = new JSONObject();
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = request.getParameter(key);
			if (value.contains(",") || "authList".equals(key)) {
				paramObj.put(key, value.split(","));
			} else {
				paramObj.put(key, value);
			}

		}
		System.out.println(paramObj.toJSONString());
		T object = JSONObject.parseObject(paramObj.toJSONString(), clazz);
		return object;
	}

	
	
	
	
	public static void main(String[] args) {
//		LmOpenAccountParamDTO a = new LmOpenAccountParamDTO();
//		a.setIdCardType(IDCardType.COMPATRIOTS_CARD);
//		a.setAuthAmount("11111");
		String a = "{\"authAmount\":\"9999999\",\"bankCardNo\":\"6226660404352422\",\"callbackUrl\":\"\",\"failTime\":\"20180602\",\"idCardNo\":\"650102199106220732\",\"idCardType\":\"PRC_ID\",\"mobile\":\"181684089854\",\"notifyUrl\":\"\",\"platformUserNo\":\"CRF0009\",\"realName\":\"但锐轩\",\"requestRefNo\":\"123\",\"systemNo\":\"website\",\"userAuthList\":[\"TENDER\"]}";
		System.out.println();
		LmOpenAccountParamDTO jsonObject = JSONObject.parseObject(a, LmOpenAccountParamDTO.class);
	}
}