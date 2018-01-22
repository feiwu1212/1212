/**
 * @Title：
 * @Package com.crfchina.cdg.dto.result
 * @date 2018/1/15 15:22
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;


import java.util.Date;

import com.crfchina.cdg.dto.base.LmBaseResultDTO;

/**
 * @ProjectName：cdg-parent
 * @ClassName： LmQueryUserInformationResultDTO
 * @Description:
 * @author: Administrator
 * @date：2018/1/15 15:22
 * @updateBy：但锐轩
 * @updateDate：2018/1/15 15:22
 * @remarks：
 */
public class LmQueryTransferInfoResultDTO extends LmBaseResultDTO {

	private static final long serialVersionUID = 1L;
 
    protected Date transactionTime ;//交易完成时间

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
    
	
}
