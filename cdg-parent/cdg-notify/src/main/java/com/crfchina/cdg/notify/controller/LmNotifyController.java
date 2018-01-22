/**
 * @Title：
 * @Package com.crfchina.cdg.notify.controller
 * @date 2018/1/10 11:09
 * @version V1.0
 */
package com.crfchina.cdg.notify.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.enums.business.Terminal;
import com.crfchina.cdg.common.utils.SignatureUtils;
import com.crfchina.cdg.notify.dto.LmNotifyResult;
import com.crfchina.cdg.notify.service.LmNotifyService;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmNotifyController
 * @Description:
 * @author: Administrator
 * @date：2018/1/10 11:09
 * @updateBy：但锐轩
 * @updateDate：2018/1/10 11:09
 * @remarks：
 */
@Controller
@RequestMapping("/notify")
public class LmNotifyController {

	@Autowired
	LmNotifyService lmNotifyService;

	@RequestMapping("/notify")
	public String notify(HttpServletRequest request, HttpServletResponse response) {
		boolean verify = SignatureUtils.checkSign(request.getParameter("sign"), request.getParameter("respData"));
		LmNotifyResult resultFromRequest = getResultFromRequest(request);
		try {
		if (verify) {
			lmNotifyService.dealNotify(resultFromRequest);
			//异步通知返回SUCCESS
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("SUCCESS");
		} else {
			//TODO 验签不通过
		}
			return null;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private LmNotifyResult getResultFromRequest(HttpServletRequest  request) {
		LmNotifyResult result = new LmNotifyResult();
		result.setServiceName(request.getParameter("serviceName"));
		result.setPlatformNo(request.getParameter("platformNo"));
		result.setUserDevice(Terminal.valueOf(request.getParameter("userDevice")));
		result.setRespData(JSONObject.parseObject(request.getParameter("respData")));
		result.setKeySerial(request.getParameter("keySerial"));
		result.setSign(request.getParameter("sign"));
		return result;
	}
}
