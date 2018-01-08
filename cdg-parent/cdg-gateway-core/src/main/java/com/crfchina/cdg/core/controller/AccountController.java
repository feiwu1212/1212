/**    
 * @Title：AccountController.java    
 * @Package com.crfchina.cdg.core.controller
 *     
 * @date 2018年1月6日 下午4:23:21 
 * @version V1.0
 */
package com.crfchina.cdg.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
import java.security.GeneralSecurityException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * @ClassName：AccountController 
 * @Description:懒猫账户相关接口定义，包括个人用户开户、企业用户开户、存量用户账户激活、
 * 更改银行卡号、更改银行预留手机号等网关跳转层面业务。
 * @author: William
 * @date：2018年1月6日 下午4:23:21
 * @updateBy：William
 * @updateDate：2018年1月6日 下午4:23:21
 * @remarks：
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	@RequestMapping("/personOpen")
	public ModelAndView personOpen(HttpServletRequest request) {
		LmOpenAccountParamDTO paramDto = getParamDto(request, LmOpenAccountParamDTO.class);
		Map<String, Object> personOpenReqDataMap = getPersonOpenReqDataMap(paramDto);
		// 获取properties参数
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.PERSONAL_REGISTER_EXPAND.getCode(), personOpenReqDataMap);
		}catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	private Map<String, Object> getPersonOpenReqDataMap(LmOpenAccountParamDTO paramDto) {
		System.out.println(JSONObject.toJSONString(paramDto));
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", paramDto.getPlatformUserNo());
		reqDataMap.put("requestNo", TrxNoUtils.getTrxNo("OC"));
		reqDataMap.put("realName", paramDto.getRealName());
		reqDataMap.put("idCardNo", paramDto.getIdCardNo());
		reqDataMap.put("bankcardNo", paramDto.getBankCardNo());
		reqDataMap.put("mobile", paramDto.getMobile());
		reqDataMap.put("idCardType", paramDto.getIdCardType());
		reqDataMap.put("userRole", paramDto.getUserRole());
		reqDataMap.put("checkType", Constants.CHECK_TYPE);
		//TODO 配置本地回调地址
		reqDataMap.put("redirectUrl", "http://127.0.0.1:8080/cdg-geteway/callBack/pageCallBack");
		reqDataMap.put("userLimitType", Constants.ID_CARD_NO_UNIQUE);
		reqDataMap.put("authList", StringUtils.join(paramDto.getUserAuthList(), ","));
		reqDataMap.put("failTime", paramDto.getFailTime());
		reqDataMap.put("amount", paramDto.getAuthAmount());
		return reqDataMap;
	}

	public <T> T getParamDto(HttpServletRequest request, Class<T> clazz) {
		Enumeration<String> parameterNames = request.getParameterNames();
		JSONObject paramObj = new JSONObject();
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = request.getParameter(key);
			if (value.contains(",")) {
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