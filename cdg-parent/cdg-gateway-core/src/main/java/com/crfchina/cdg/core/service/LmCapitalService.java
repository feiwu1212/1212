/**
 * 
 */
package com.crfchina.cdg.core.service;

import com.crfchina.cdg.core.dto.param.LmRechargeParamDTO;
import com.crfchina.cdg.core.dto.param.LmUserPreTransactionParamDTO;
import com.crfchina.cdg.core.dto.param.LmVerifyDeductParamDTO;
import com.crfchina.cdg.core.dto.param.LmWithdrawParamDTO;
import java.util.Map;

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
    /**
     * 
     * @Title: userPreTransaction  
     * @Description: TODO
     * @param paramDto
     * @return
     * Map<String,Object>
     * @throws
     */
	Map<String, Object> userPreTransaction(LmUserPreTransactionParamDTO paramDto);

	/**
	 * 验密扣费
	 * @param paramDTO
	 * @return
	 */
	Map<String, Object> verifyDeduct(LmVerifyDeductParamDTO paramDTO);
}
