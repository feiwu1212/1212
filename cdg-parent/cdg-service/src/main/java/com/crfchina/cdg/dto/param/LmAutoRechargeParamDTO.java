/**    
 * @Title：LmAutoRechargeParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 下午1:14:46 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import com.crfchina.cdg.dto.base.LmAPIBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmAutoRechargeParamDTO
 * @Description:自动充值请求参数
 * @author: William
 * @date：2018年1月6日 下午1:14:46
 * @updateBy：William
 * @updateDate：2018年1月6日 下午1:14:46
 * @remarks：
 */
public class LmAutoRechargeParamDTO extends LmAPIBaseParamDTO {
	protected Long amount;// 充值金额(分)
	protected Long commissionAmount; // 平台佣金
	
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
