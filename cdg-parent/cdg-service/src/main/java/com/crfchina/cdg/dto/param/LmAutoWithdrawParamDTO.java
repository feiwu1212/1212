/**    
 * @Title：LmAutoWithdrawParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 上午11:53:49 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import com.crfchina.cdg.common.enums.business.WithdrawalType;
import com.crfchina.cdg.dto.base.LmAPIBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmAutoWithdrawParamDTO
 * @Description:自动提现DTO
 * @author: William
 * @date：2018年1月6日 上午11:53:49
 * @updateBy：William
 * @updateDate：2018年1月6日 上午11:53:49
 * @remarks：
 */
public class LmAutoWithdrawParamDTO extends LmAPIBaseParamDTO {
	protected WithdrawalType withdrawType;//提醒类型
	protected Long amount;//提现金额（分）
	protected Long commissionAmount;//提现分佣(分)
	public WithdrawalType getWithdrawType() {
		return withdrawType;
	}
	public void setWithdrawType(WithdrawalType withdrawType) {
		if(withdrawType==null){
			this.withdrawType = WithdrawalType.URGENT;
		}
		this.withdrawType = withdrawType;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getCommissionAmount() {
		return commissionAmount;
	}
	public void setCommissionAmount(Long commissionAmount) {
		this.commissionAmount = commissionAmount;
	}
	
	
	
}
