/**    
 * @Title：LmRepaymentFreezeResultDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 下午1:30:13 
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;

import java.util.Date;

import com.crfchina.cdg.dto.base.LmBaseResultDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmRepaymentFreezeResultDTO
 * @Description:还款冻结资金
 * @author: William
 * @date：2018年1月6日 下午1:30:13
 * @updateBy：William
 * @updateDate：2018年1月6日 下午1:30:13
 * @remarks：
 */
public class LmRepaymentFreezeResultDTO extends LmBaseResultDTO {
	
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
