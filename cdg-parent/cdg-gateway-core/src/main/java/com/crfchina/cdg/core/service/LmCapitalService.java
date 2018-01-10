/**
 * 
 */
package com.crfchina.cdg.core.service;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.crfchina.cdg.core.dto.base.LmGatewayPageCallbackResult;
import com.crfchina.cdg.core.dto.param.LmRechargeParamDTO;
import com.crfchina.cdg.core.dto.param.LmWithdrawParamDTO;

/**
 * @author ghf
 *
 */
public interface LmCapitalService {

	/**
	 * 
	 * @Title: recharge  
	 * @Description: 充值接口
	 * @param paramDto
	 * @return
	 * Map<String,Object>
	 * @throws
	 */
	Map<String, Object> recharge(LmRechargeParamDTO paramDto);
	
	/**
	 * 
	 * @Title: withdraw  
	 * @Description: TODO
	 * @param paramDto
	 * @return
	 * Map<String,Object>
	 * @throws
	 */
	Map<String,Object> withdraw(LmWithdrawParamDTO paramDto);
    
}
