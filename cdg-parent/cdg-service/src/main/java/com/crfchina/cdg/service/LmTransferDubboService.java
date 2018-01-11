/**    
 * @Title：LmTransferDubboService.java    
 * @Package com.crfchina.cdg.service
 *     
 * @date 2018年1月5日 下午4:37:07 
 * @version V1.0
 */
package com.crfchina.cdg.service;

import com.crfchina.cdg.dto.param.LmFreezePreTransactionParamDTO;
import com.crfchina.cdg.dto.result.LmFreezePreTransactionResultDTO;

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

	LmFreezePreTransactionResultDTO freezePreTransaction(LmFreezePreTransactionParamDTO paramDTO);
}
