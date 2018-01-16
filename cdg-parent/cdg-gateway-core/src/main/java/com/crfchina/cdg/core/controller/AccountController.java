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
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.core.dto.param.LmActiveAccountParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangeBankCardParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangeMobileParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangePwdParamDTO;
import com.crfchina.cdg.core.dto.param.LmCheckPwdParamDTO;
import com.crfchina.cdg.core.dto.param.LmEnterpriseOpenAccountDTO;
import com.crfchina.cdg.core.dto.param.LmOpenAccountCompanyParamDTO;
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
import com.crfchina.cdg.core.service.LmAccountService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
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

	@Autowired
	LmAccountService lmAccountService;

	/**
	 * 个人绑卡
	 * @param request
	 * @return
	 */
	@RequestMapping("/personOpen")
	public ModelAndView personOpen(HttpServletRequest request) {
		LmOpenAccountParamDTO paramDto = AppUtil.getParamDto(request, LmOpenAccountParamDTO.class);

		Map<String, Object> personOpenReqDataMap = lmAccountService.personBindCard(paramDto);
		// 获取properties参数
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.PERSONAL_REGISTER_EXPAND.getCode(), personOpenReqDataMap, paramDto.getUserDevice().getCode());
		}catch (CdgException e) {
			return new ModelAndView("error");
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 企业绑卡
	 * @param request
	 * @return
	 */
	@RequestMapping("/enterpriseOpen")
	public ModelAndView enterpriseOpen(HttpServletRequest request) {
		LmOpenAccountCompanyParamDTO paramDto = AppUtil.getParamDto(request, LmOpenAccountCompanyParamDTO.class);
		LmEnterpriseOpenAccountDTO reqDto = JSONObject.parseObject(JSONObject.toJSONString(paramDto), LmEnterpriseOpenAccountDTO.class);
		Map<String, Object> reqDataMap = JSONObject.parseObject(JSONObject.toJSONString(reqDto));
		reqDataMap.put("requestNo", TrxNoUtils.getTrxNo(Constants.COMPANY_OPEN_ACCOUNT));
		reqDataMap.put("redirectUrl", "http://127.0.0.1:8080/cdg-geteway/callBack/pageCallBack");
		reqDataMap.put("authList", StringUtils.join(paramDto.getAuthList(), ","));
		
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.ENTERPRISE_REGISTER.getCode(), reqDataMap, paramDto.getUserDevice().getCode());
		} catch (CdgException e) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 个人换绑卡
	 * @param request
	 * @return
	 */
	@RequestMapping("/changeCard")
	public ModelAndView changeCard(HttpServletRequest request) {
		LmChangeBankCardParamDTO changeCardDto = AppUtil.getParamDto(request, LmChangeBankCardParamDTO.class);
		Map<String, Object> changeCardReqDataMap = lmAccountService.changeCard(changeCardDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.PERSONAL_BIND_BANKCARD_EXPAND.getCode(), changeCardReqDataMap, changeCardDto.getUserDevice().getCode());
		}catch (CdgException e) {
			return new ModelAndView("error");
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 个人用户修改交易密码
	 */
	@RequestMapping("/changePwd")
	public ModelAndView changePwd(HttpServletRequest request) {
		LmChangePwdParamDTO changePwdDto = AppUtil.getParamDto(request, LmChangePwdParamDTO.class);
		Map<String, Object> changePwdReqDataMap = lmAccountService.changePwd(changePwdDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.RESET_PASSWORD.getCode(), changePwdReqDataMap, changePwdDto.getUserDevice().getCode());
		}catch (CdgException e) {
			return new ModelAndView("error");
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 个人用户验证交易密码
	 */
	@RequestMapping("/checkpwd")
	public ModelAndView checkpwd(HttpServletRequest request) {
		LmCheckPwdParamDTO checkPwdDto = AppUtil.getParamDto(request, LmCheckPwdParamDTO.class);
		Map<String, Object> checkPwdReqDataMap = lmAccountService.checkPwd(checkPwdDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.CHECK_PASSWORD.getCode(), checkPwdReqDataMap, checkPwdDto.getUserDevice().getCode());
		}catch (CdgException e) {
			return new ModelAndView("error");
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 个人用户验证交易密码
	 */
	@RequestMapping("/changemobile")
	public ModelAndView changemobile(HttpServletRequest request) {
		LmChangeMobileParamDTO changeMobileDto = AppUtil.getParamDto(request, LmChangeMobileParamDTO.class);
		Map<String, Object> changeMobileReqDataMap = lmAccountService.changeMobile(changeMobileDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.MODIFY_MOBILE_EXPAND.getCode(), changeMobileReqDataMap, changeMobileDto.getUserDevice().getCode());
		}catch (CdgException e) {
			return new ModelAndView("error");
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}

	/**
	 * 会员激活
	 */
	@RequestMapping("/activeaccount")
	public ModelAndView activeaccount(HttpServletRequest request) {
		LmActiveAccountParamDTO activeAccountDto = AppUtil.getParamDto(request, LmActiveAccountParamDTO.class);
		Map<String, Object> activeAccountReqDataMap = lmAccountService.activeAccount(activeAccountDto);
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.GATEWAY_SUFFIX;
		Map<String, String> result = null;
		try {
			result = AppUtil.createPostParam(ApiType.ACTIVATE_STOCKED_USER.getCode(), activeAccountReqDataMap, activeAccountDto.getUserDevice().getCode());
		}catch (CdgException e) {
			return new ModelAndView("error");
		}
		return new ModelAndView("gateway").addObject("url", url).addObject("result", result);
	}
}