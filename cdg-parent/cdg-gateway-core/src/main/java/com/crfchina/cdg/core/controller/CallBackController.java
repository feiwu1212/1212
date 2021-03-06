/**
 * @Title：
 * @Package com.crfchina.cdg.core.controller
 * @date 2018/1/8 21:41
 * @version V1.0
 */
package com.crfchina.cdg.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.enums.business.Terminal;
import com.crfchina.cdg.common.exception.CdgException;
import com.crfchina.cdg.common.utils.SignatureUtils;
import com.crfchina.cdg.core.dto.base.LmGatewayPageCallbackResult;
import com.crfchina.cdg.core.service.LmCallBackService;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	public static final Logger logger = LoggerFactory
			.getLogger(CallBackController.class);

	@Autowired
	LmCallBackService callBackService;

	@RequestMapping("/pageCallBack")
	public ModelAndView pageCallBack(HttpServletRequest request) {
		logger.info("网关接口页面回调开始【begin】");
		LmGatewayPageCallbackResult resultFromRequest = null;
		ModelAndView mav = null;
		try {
			boolean verify = SignatureUtils.checkSign(request.getParameter("sign"), request.getParameter("respData"));
			if (verify) {
				resultFromRequest = getResultFromRequest(request);
				mav = callBackService.dealCallBack(resultFromRequest);
			} else {
				logger.info("验签结果为false");
				return new ModelAndView("error");
			}
		}catch (CdgException e) {
			logger.error("网关接口页面回调异常", e);
			return new ModelAndView("error");
		}
		return mav;
	}

	private LmGatewayPageCallbackResult getResultFromRequest(HttpServletRequest  request) {
		LmGatewayPageCallbackResult result = new LmGatewayPageCallbackResult();
		result.setServiceName(request.getParameter("serviceName"));
		result.setPlatformNo(request.getParameter("platformNo"));
		result.setUserDevice(Terminal.valueOf(request.getParameter("userDevice")));
		result.setRespData(JSONObject.parseObject(request.getParameter("respData")));
		result.setKeySerial(request.getParameter("keySerial"));
		result.setSign(request.getParameter("sign"));
		return result;
	}
}
