/**    
 * @Title：LmFreezePreTransactionParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 上午10:25:41 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import com.crfchina.cdg.dto.base.LmAPIBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmFreezePreTransactionParamDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 上午10:25:41
 * @updateBy：William
 * @updateDate：2018年1月6日 上午10:25:41
 * @remarks：冻结预处理（用户出资申请冻结）
 */
public class LmFreezePreTransactionParamDTO extends LmAPIBaseParamDTO {
	
	protected String bizType;//预处理业务类型
	protected Long amount;//交易金额
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	

}
