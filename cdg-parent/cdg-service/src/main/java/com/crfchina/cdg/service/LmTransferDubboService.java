/**    
 * @Title：LmTransferDubboService.java    
 * @Package com.crfchina.cdg.service
 *     
 * @date 2018年1月5日 下午4:37:07 
 * @version V1.0
 */
package com.crfchina.cdg.service;

import com.crfchina.cdg.dto.param.LmAutoPreTransactionParamDTO;
import com.crfchina.cdg.dto.param.LmAutoRechargeParamDTO;
import com.crfchina.cdg.dto.param.LmAutoWithdrawParamDTO;
import com.crfchina.cdg.dto.param.LmFreezePreTransactionParamDTO;
import com.crfchina.cdg.dto.param.LmFundTransferParamDTO;
import com.crfchina.cdg.dto.param.LmUnFreezePreTransactionParamDTO;
import com.crfchina.cdg.dto.param.LmUnFreezePwdParamDTO;
import com.crfchina.cdg.dto.result.LmAutoPreTransactionResultDTO;
import com.crfchina.cdg.dto.result.LmAutoRechargeResultDTO;
import com.crfchina.cdg.dto.result.LmAutoWithdrawResultDTO;
import com.crfchina.cdg.dto.result.LmFreezePreTransactionResultDTO;
import com.crfchina.cdg.dto.result.LmFundTransferResultDTO;
import com.crfchina.cdg.dto.result.LmUnFreezePreTransactionResultDTO;
import com.crfchina.cdg.dto.result.LmUnFreezePwdResultDTO;

/**
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmTransferDubboService
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午4:37:07
 * @updateBy：William
 * @updateDate：2018年1月5日 下午4:37:07
 * @remarks：交易相关 Dubbo Service定义
 */
public interface LmTransferDubboService {

	/**
	 * 
	 * @Title: freezePreTransaction  
	 * @Description: 冻结预处理
	 * @param paramDTO
	 * @return
	 * LmFreezePreTransactionResultDTO
	 * @throws
	 */
	LmFreezePreTransactionResultDTO freezePreTransaction(LmFreezePreTransactionParamDTO paramDTO);
	
	/**
	 * 自动充值
	 */
	LmAutoRechargeResultDTO autoRecharge(LmAutoRechargeParamDTO paramDTO);
	/**
	 * 自动提现
	 * @Title: autoRecharge  
	 * @Description: TODO
	 * @param paramDTO
	 * @return
	 * LmAutoRechargeResultDTO
	 * @throws
	 */
	LmAutoWithdrawResultDTO autoWithdraw(LmAutoWithdrawParamDTO paramDTO);
	
	/**
	 * 
	 * @Title: freezePreTransaction  
	 * @Description: 冻结预处理取消
	 * @param paramDTO
	 * @return
	 * LmFreezePreTransactionResultDTO
	 * @throws
	 */
	LmUnFreezePreTransactionResultDTO cancelPreTransaction(LmUnFreezePreTransactionParamDTO paramDTO);
	
	/**
	 * 
	 * @Title: autoPreTransaction  
	 * @Description: 授权预处理
	 * @param paramDTO
	 * @return
	 * LmAutoPreTransactionResultDTO
	 * @throws
	 */
    LmAutoPreTransactionResultDTO autoPreTransaction(LmAutoPreTransactionParamDTO paramDTO);

	/**
	 * 批量交易
	 * @param paramDTO
	 * @return
	 */
	LmFundTransferResultDTO batchTransfer(LmFundTransferParamDTO paramDTO);

	/**
	 * 交易密码解冻
	 * @param paramDTO
	 * @return
	 */
	LmUnFreezePwdResultDTO unFreezePwd(LmUnFreezePwdParamDTO paramDTO);
}
