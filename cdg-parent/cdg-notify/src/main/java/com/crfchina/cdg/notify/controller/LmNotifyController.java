/**
 * @Title：
 * @Package com.crfchina.cdg.notify.controller
 * @date 2018/1/10 11:09
 * @version V1.0
 */
package com.crfchina.cdg.notify.controller;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.enums.business.Terminal;
import com.crfchina.cdg.common.exception.CdgException;
import com.crfchina.cdg.common.utils.SignatureUtils;
import com.crfchina.cdg.notify.dto.LmNotifyResult;
import com.crfchina.cdg.notify.service.LmNotifyService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	private static final Logger logger = LoggerFactory
			.getLogger(LmNotifyController.class);

	@Autowired
	LmNotifyService lmNotifyService;

	@RequestMapping("/notify")
	public String notify(HttpServletRequest request, HttpServletResponse response) {
		logger.info("懒猫异步通知开始【begin】");
		try {
			boolean verify = SignatureUtils.checkSign(request.getParameter("sign"), request.getParameter("respData"));
			if (verify) {
				LmNotifyResult resultFromRequest = getResultFromRequest(request);
				logger.info("懒猫异步通知返回参数为{}", JSONObject.toJSONString(resultFromRequest));
				lmNotifyService.dealNotify(resultFromRequest);
			} else {
				logger.info("验签结果为false");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("FAIL");
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("SUCCESS");
			return null;
		}catch (IOException e) {
			logger.error("返回异常", e);
		}catch (CdgException e) {
			logger.error("系统异常，代码为{}", e.getCode());
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("FAIL");
			}catch (IOException e1) {
				logger.error("返回异常", e1);
			}
		}
		logger.info("懒猫异步通知结束【end】");
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
