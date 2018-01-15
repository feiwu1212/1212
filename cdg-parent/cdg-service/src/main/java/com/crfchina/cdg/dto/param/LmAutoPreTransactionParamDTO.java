/**    
 * @Title：LmAutoPreTransactionParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 下午1:30:13 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import com.crfchina.cdg.common.enums.business.PreBusinessType;
import com.crfchina.cdg.dto.base.LmAPIBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmAutoPreTransactionParamDTO 
 * @Description:(授权预处理接口,用于还款)如用户已授权给平台做自动交易，则平台可以调用该接口进行预处理操作，无需用户交互
				平台传入关联充值流水号，若充值授权已成功，可针对未授权用户操作预处理，无需用户交互
 * @author: William
 * @date：2018年1月6日 下午1:30:13
 * @updateBy：William
 * @updateDate：2018年1月6日 下午1:30:13
 * @remarks：
 */
public class LmAutoPreTransactionParamDTO extends LmAPIBaseParamDTO {
	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	protected String originFcpTrxNo;//关联充值请求流水号(原充值成功请求流水号)
	protected PreBusinessType bizType;//预处理业务类型 通常用于还款资金冻结
	protected Long amount;//冻结金额（分）
	protected String projectNo;//标的号, 若传入关联充值请求流水号，则标的号固定为充值请求传入的标的号
	protected String remark ;
	protected String share;
	protected String preMarketingAmount;
	
	public String getPreMarketingAmount() {
		return preMarketingAmount;
	}
	public void setPreMarketingAmount(String preMarketingAmount) {
		this.preMarketingAmount = preMarketingAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		this.share = share;
	}
	public String getOriginFcpTrxNo() {
		return originFcpTrxNo;
	}
	public void setOriginFcpTrxNo(String originFcpTrxNo) {
		this.originFcpTrxNo = originFcpTrxNo;
	}
	public PreBusinessType getBizType() {
		return bizType;
	}
	public void setBizType(PreBusinessType bizType) {
		this.bizType = bizType;
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
	
	
	
}
