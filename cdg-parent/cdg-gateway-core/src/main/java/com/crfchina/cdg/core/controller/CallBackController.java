/**
 * @Title：
 * @Package com.crfchina.cdg.core.controller
 * @date 2018/1/8 21:41
 * @version V1.0
 */
package com.crfchina.cdg.core.controller;

import com.alibaba.fastjson.JSONObject;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName：cdg-parent
 * @ClassName：CallBackController
 * @Description:
 * @author: Administrator
 * @date：2018/1/8 21:41
 * @updateBy：但锐轩
 * @updateDate：2018/1/8 21:41
 * @remarks：
 */
@Controller
@RequestMapping("/callBack")
public class CallBackController {

	@RequestMapping("/pageCallBack")
	public ModelAndView pageCallBack(HttpServletRequest request) {
		Enumeration<String> parameterNames = request.getParameterNames();
		Map<String, String> returnResult = new LinkedHashMap<String, String>();
		while (parameterNames.hasMoreElements()) {
			String s = parameterNames.nextElement();
			returnResult.put(s, request.getParameter(s));
		}
		String message = JSONObject.toJSONString(returnResult);
		return new ModelAndView("success").addObject("message", message);
	}
}
