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
import com.crfchina.cdg.common.exception.CdgException;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.core.dto.param.LmActiveAccountParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangeBankCardParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangeMobileParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangePwdParamDTO;
import com.crfchina.cdg.core.dto.param.LmCheckPwdParamDTO;
import com.crfchina.cdg.core.dto.param.LmOpenAccountCompanyParamDTO;
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
import com.crfchina.cdg.core.service.LmAccountService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	public static final Logger logger = LoggerFactory
			.getLogger(AccountController.class);

	@Autowired
	LmAccountService lmAccountService;

	/**
	 * 个人绑卡
	 * @param request
	 * @return
	 */
	@RequestMapping("/personOpen")
	public ModelAndView personOpen(HttpServletRequest request) {
		logger.info("个人绑卡拼装参数开始【begin】");
		LmOpenAccountParamDTO paramDto = AppUtil.getParamDto(request, LmOpenAccountParamDTO.class);
		Map<String, Object> personOpenReqDataMap = lmAccountService.personBindCard(paramDto);
		// 获取properties参数
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.PERSONAL_REGISTER_EXPAND.getCode(), personOpenReqDataMap, paramDto.getUserDevice().getCode());
		}catch (CdgException e) {
			logger.error("拼装请求参数异常", e);
			return new ModelAndView("error");
		}
		logger.info("个人绑卡拼装参数结束【end】result---->{}", JSONObject.toJSONString(result));
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 企业绑卡
	 * @param request
	 * @return
	 */
	@RequestMapping("/companyopenaccount")
	public ModelAndView enterpriseOpen(HttpServletRequest request) {
		logger.info("企业绑卡拼装参数开始【begin】");
		LmOpenAccountCompanyParamDTO paramDto = AppUtil.getParamDto(request, LmOpenAccountCompanyParamDTO.class);
		Map<String, Object> enterpriseOpenReqDataMap = lmAccountService.enterpriseBindCard(paramDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.ENTERPRISE_REGISTER.getCode(), enterpriseOpenReqDataMap, paramDto.getUserDevice().getCode());
		} catch (CdgException e) {
			logger.error("拼装请求参数异常", e);
			return new ModelAndView("error");
		}
		logger.info("企业绑卡拼装参数结束【end】result---->{}", JSONObject.toJSONString(result));
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 个人换绑卡
	 * @param request
	 * @return
	 */
	@RequestMapping("/changeCard")
	public ModelAndView changeCard(HttpServletRequest request) {
		logger.info("个人换绑卡拼装参数开始【begin】");
		LmChangeBankCardParamDTO changeCardDto = AppUtil.getParamDto(request, LmChangeBankCardParamDTO.class);
		Map<String, Object> changeCardReqDataMap = lmAccountService.changeCard(changeCardDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.PERSONAL_BIND_BANKCARD_EXPAND.getCode(), changeCardReqDataMap, changeCardDto.getUserDevice().getCode());
		}catch (CdgException e) {
			logger.error("拼装请求参数异常", e);
			return new ModelAndView("error");
		}
		logger.info("个人换绑卡拼装参数结束【end】result---->{}", JSONObject.toJSONString(result));
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 个人用户修改交易密码
	 */
	@RequestMapping("/changePwd")
	public ModelAndView changePwd(HttpServletRequest request) {
		logger.info("修改密码拼装参数开始【begin】");
		LmChangePwdParamDTO changePwdDto = AppUtil.getParamDto(request, LmChangePwdParamDTO.class);
		Map<String, Object> changePwdReqDataMap = lmAccountService.changePwd(changePwdDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.RESET_PASSWORD.getCode(), changePwdReqDataMap, changePwdDto.getUserDevice().getCode());
		}catch (CdgException e) {
			logger.error("拼装请求参数异常", e);
			return new ModelAndView("error");
		}
		logger.info("修改密码拼装参数结束【end】result---->{}", JSONObject.toJSONString(result));
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 个人用户验证交易密码
	 */
	@RequestMapping("/checkpwd")
	public ModelAndView checkpwd(HttpServletRequest request) {
		logger.info("验证密码拼装参数开始【begin】");
		LmCheckPwdParamDTO checkPwdDto = AppUtil.getParamDto(request, LmCheckPwdParamDTO.class);
		Map<String, Object> checkPwdReqDataMap = lmAccountService.checkPwd(checkPwdDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.CHECK_PASSWORD.getCode(), checkPwdReqDataMap, checkPwdDto.getUserDevice().getCode());
		}catch (CdgException e) {
			logger.error("拼装请求参数异常", e);
			return new ModelAndView("error");
		}
		logger.info("验证密码拼装参数结束【end】result---->{}", JSONObject.toJSONString(result));
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 更换预留手机号
	 */
	@RequestMapping("/changemobile")
	public ModelAndView changemobile(HttpServletRequest request) {
		logger.info("更换预留手机号拼装参数开始【begin】");
		LmChangeMobileParamDTO changeMobileDto = AppUtil.getParamDto(request, LmChangeMobileParamDTO.class);
		Map<String, Object> changeMobileReqDataMap = lmAccountService.changeMobile(changeMobileDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.MODIFY_MOBILE_EXPAND.getCode(), changeMobileReqDataMap, changeMobileDto.getUserDevice().getCode());
		}catch (CdgException e) {
			logger.error("拼装请求参数异常", e);
			return new ModelAndView("error");
		}
		logger.info("更换预留手机号拼装参数结束【end】result---->{}", JSONObject.toJSONString(result));
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 会员激活
	 */
	@RequestMapping("/activeaccount")
	public ModelAndView activeaccount(HttpServletRequest request) {
		logger.info("会员激活拼装参数开始【begin】");
		LmActiveAccountParamDTO activeAccountDto = AppUtil.getParamDto(request, LmActiveAccountParamDTO.class);
		Map<String, Object> activeAccountReqDataMap = lmAccountService.activeAccount(activeAccountDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.ACTIVATE_STOCKED_USER.getCode(), activeAccountReqDataMap, activeAccountDto.getUserDevice().getCode());
		}catch (CdgException e) {
			logger.error("拼装请求参数异常", e);
			return new ModelAndView("error");
		}
		logger.info("会员激活拼装参数结束【end】result---->{}", JSONObject.toJSONString(result));
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}
}