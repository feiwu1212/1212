/**    
 * @Title：AccountController.java    
 * @Package com.crfchina.cdg.core.controller
 *     
 * @date 2018年1月6日 下午4:23:21 
 * @version V1.0
 */
package com.crfchina.cdg.core.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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

		return null;
	}

	private Map<String, Object> getPersonOpenReqDataMap(LmOpenAccountParamDTO paramDto) {
		System.out.println(JSONObject.toJSONString(paramDto));
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("platformUserNo", paramDto.getPlatformUserNo());
		reqDataMap.put("requestNo", Constants.TRX_PERFIX);

//				realName
//		idCardNo
//				bankcardNo
//		mobile
//				idCardType
//		userRole
//				checkTyped
//		redirectUrl
//				userLimitType
//		authList
//				failTime
//		amount
		return null;
	}

	public <T> T getParamDto(HttpServletRequest request, Class<T> clazz) {
		Enumeration<String> parameterNames = request.getParameterNames();
		JSONObject paramObj = new JSONObject();
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			paramObj.put(key, request.getParameter(key));
		}
		T object = JSON.parseObject(paramObj.toJSONString(), clazz);
		return object;
	}
}