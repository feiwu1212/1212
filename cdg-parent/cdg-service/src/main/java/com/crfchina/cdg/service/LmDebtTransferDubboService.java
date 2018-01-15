/**    
 * @Title：LmDebtTransferDubboService.java    
 * @Package com.crfchina.cdg.service
 *     
 * @date 2018年1月5日 下午4:52:54 
 * @version V1.0
 */
package com.crfchina.cdg.service;

import com.crfchina.cdg.dto.param.LmCancelDebentureSaleParamDTO;
import com.crfchina.cdg.dto.param.LmDebentureSaleParamDTO;
import com.crfchina.cdg.dto.result.LmCancelDebentureSaleResultDTO;
import com.crfchina.cdg.dto.result.LmDebentureSaleResultDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmDebtTransferDubboService 
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午4:52:54
 * @updateBy：William
 * @updateDate：2018年1月5日 下午4:52:54
 * @remarks：
 */
public interface LmDebtTransferDubboService {

	 /**
	  * 
	  * @Title: debentureSale  
	  * @Description: TODO
	  * @param paramDTO
	  * @return
	  * LmDebentureSaleResultDTO
	  * @throws
	  */
	LmDebentureSaleResultDTO debentureSale(LmDebentureSaleParamDTO paramDTO);
	/**
	 * 
	 * @Title: cancelDebentureSale  
	 * @Description: TODO
	 * @param paramDTO
	 * @return
	 * LmCancelDebentureSaleResultDTO
	 * @throws
	 */
	LmCancelDebentureSaleResultDTO cancelDebentureSale(LmCancelDebentureSaleParamDTO paramDTO);

	
}
