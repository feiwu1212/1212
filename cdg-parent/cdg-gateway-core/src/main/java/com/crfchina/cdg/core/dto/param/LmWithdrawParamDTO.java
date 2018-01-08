/**    
 * @Title：LmWithdrawParamDTO.java    
 * @Package com.crfchina.cdg.core.dto.param
 *     
 * @date 2018年1月6日 下午4:52:09 
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

import java.util.Date;

import com.crfchina.cdg.core.dto.base.LmGatewayBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * @ClassName：LmWithdrawParamDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 下午4:52:09
 * @updateBy：William
 * @updateDate：2018年1月6日 下午4:52:09
 * @remarks：
 */
public class LmWithdrawParamDTO extends LmGatewayBaseParamDTO {
	
	protected Long amount;//提现金额
	protected Long commissionAmount;//佣金
	protected Date expired;//页面过期时间
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
	public Date getExpired() {
		return expired;
	}
	public void setExpired(Date expired) {
		this.expired = expired;
	}

}
