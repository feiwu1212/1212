/**    
 * @Title：AccountController.java    
 * @Package com.crfchina.cdg.core.controller
 *     
 * @date 2018年1月6日 下午4:23:21 
 * @version V1.0
 */
package com.crfchina.cdg.core.controller;

import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.core.dto.param.LmRechargeParamDTO;
import com.crfchina.cdg.core.dto.param.LmUserPreTransactionParamDTO;
import com.crfchina.cdg.core.dto.param.LmVerifyDeductParamDTO;
import com.crfchina.cdg.core.dto.param.LmWithdrawParamDTO;
import com.crfchina.cdg.core.service.LmCapitalService;
import java.security.GeneralSecurityException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/ca")
public class CaptialController {

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
		LmRechargeParamDTO paramDto = AppUtil.getParamDto(request, LmRechargeParamDTO.class);
		Map<String, Object> rechargeReqDataMap = lmCapitalService.recharge(paramDto);
		// 获取properties参数
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.RECHARGE.getCode(), rechargeReqDataMap, paramDto.getUserDevice().getCode());
		}catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	
	/**
	 * 
	 * @Title: withdraw   
	 * @Description: 用户在 P2P 平台发起提现请求，平台调用此接口引导用户跳转至存管页面完成充值
	 * @param request
	 * @return
	 * ModelAndView
	 * @throws
	 */
	@RequestMapping("/withdraw")
	public ModelAndView withdraw(HttpServletRequest request) {
		LmWithdrawParamDTO paramDto = AppUtil.getParamDto(request, LmWithdrawParamDTO.class);
		Map<String, Object> withdrawReqDataMap = lmCapitalService.withdraw(paramDto);
		// 获取properties参数
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.RECHARGE.getCode(), withdrawReqDataMap, paramDto.getUserDevice().getCode());
		}catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 
	 * @Title: userPreTransaction   
	 * @Description: 用户在 P2P 平台资金预处理请求
	 * @param request
	 * @return
	 * ModelAndView
	 * @throws
	 */
	@RequestMapping("/userPreTransaction")
	public ModelAndView userPreTransaction(HttpServletRequest request) {
		LmUserPreTransactionParamDTO paramDto = AppUtil.getParamDto(request, LmUserPreTransactionParamDTO.class);
		Map<String, Object> userPreTransactionReqDataMap = lmCapitalService.userPreTransaction(paramDto);
		// 获取properties参数
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.USERPRETRANSACTION.getCode(), userPreTransactionReqDataMap, paramDto.getUserDevice().getCode() );
		}catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 验密扣费
	 * @param request
	 * @return
	 */
	@RequestMapping("/verifyDeduct")
	public ModelAndView verifyDeduct(HttpServletRequest request) {
		LmVerifyDeductParamDTO paramDto = AppUtil.getParamDto(request, LmVerifyDeductParamDTO.class);
		Map<String, Object> verifyDeductReqDataMap = lmCapitalService.verifyDeduct(paramDto);
		// 获取properties参数
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.VERIFY_DEDUCT.getCode(), verifyDeductReqDataMap, paramDto.getUserDevice().getCode() );
		}catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}
}