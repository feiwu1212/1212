/**    
 * @Title：LmAutoWithdrawResultDTO.java    
 * @Package com.crfchina.cdg.dto.result
 *     
 * @date 2018年1月6日 上午11:59:57 
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;

import com.crfchina.cdg.dto.base.LmBaseResultDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmAutoWithdrawResultDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 上午11:59:57
 * @updateBy：William
 * @updateDate：2018年1月6日 上午11:59:57
 * @remarks：
 */
public class LmAutoWithdrawResultDTO extends LmBaseResultDTO {

	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	protected String platformUserNo;// 平台用户编号
	protected Long amount; //提现金额
	protected Long commissionAmount; //提现分佣
	protected String withdrawWay;//提现方式
	protected String bankcardNo;//提现银行卡号
	protected String bankcode;//【银行编码】
	protected String remitType; //出款类型;NORMAL:T1 出款;NORMAL_URGENT:普通 T0 出款;URGENT: 实时 T0 出款;
	protected String withdrawForm; //提现类型:IMMEDIATE 为直接提现，提现类型：CONFIRMED为待确认提现
	protected Long floatAmount; //垫资金额
	public String getPlatformUserNo() {
		return platformUserNo;
	}
	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
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
	public String getWithdrawWay() {
		return withdrawWay;
	}
	public void setWithdrawWay(String withdrawWay) {
		this.withdrawWay = withdrawWay;
	}
	public String getBankcardNo() {
		return bankcardNo;
	}
	public void setBankcardNo(String bankcardNo) {
		this.bankcardNo = bankcardNo;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getRemitType() {
		return remitType;
	}
	public void setRemitType(String remitType) {
		this.remitType = remitType;
	}
	public String getWithdrawForm() {
		return withdrawForm;
	}
	public void setWithdrawForm(String withdrawForm) {
		this.withdrawForm = withdrawForm;
	}
	public Long getFloatAmount() {
		return floatAmount;
	}
	public void setFloatAmount(Long floatAmount) {
		this.floatAmount = floatAmount;
	}
	
	

}
