/**    
 * @Title：LmRepaymentFreezeParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 下午1:30:13 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import com.crfchina.cdg.dto.base.LmAPIBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmRepaymentFreezeParamDTO
 * @Description:还款冻结资金
 * @author: William
 * @date：2018年1月6日 下午1:30:13
 * @updateBy：William
 * @updateDate：2018年1月6日 下午1:30:13
 * @remarks：
 */
public class LmRepaymentFreezeParamDTO extends LmAPIBaseParamDTO {
	
	protected String originalRechargeNo;//关联充值请求流水号(原充值成功请求流水号)
	protected Long amount;//冻结金额（分）
	protected String projectNo;//标的号, 若传入关联充值请求流水号，则标的号固定为充值请求传入的标的号
	protected String remark;//备注
	public String getOriginalRechargeNo() {
		return originalRechargeNo;
	}
	public void setOriginalRechargeNo(String originalRechargeNo) {
		this.originalRechargeNo = originalRechargeNo;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
