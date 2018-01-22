/**    
 * @Title：LmFreezePreTransactionResultDTO.java    
 * @Package com.crfchina.cdg.dto.result
 *     
 * @date 2018年1月6日 上午10:41:11 
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;

import java.util.Date;

import com.crfchina.cdg.dto.base.LmBaseResultDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmFreezePreTransactionResultDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 上午10:41:11
 * @updateBy：William
 * @updateDate：2018年1月6日 上午10:41:11
 * @remarks：
 */
public class LmFreezePreTransactionResultDTO extends LmBaseResultDTO {

	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	
	protected Date transactionTime;// 交易完成时间

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	
	
	
	
}
