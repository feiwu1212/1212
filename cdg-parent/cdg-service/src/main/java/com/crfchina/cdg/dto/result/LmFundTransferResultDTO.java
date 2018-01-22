/**    
 * @Title：LmFundTransferResultDTO.java    
 * @Package com.crfchina.cdg.dto.result
 *     
 * @date 2018年1月6日 上午11:34:26 
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;

import java.util.Date;

import com.crfchina.cdg.dto.base.LmBaseResultDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmFundTransferResultDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 上午11:34:26
 * @updateBy：William
 * @updateDate：2018年1月6日 上午11:34:26
 * @remarks：
 */
public class LmFundTransferResultDTO extends LmBaseResultDTO{

	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	
	protected String platformUserNo;//平台用户编号
	
	protected Date transactionTime;// 交易完成时间


	public Date getTransactionTime() {
		return transactionTime;
	}


	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	
}
