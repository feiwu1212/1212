/**    
 * @Title：LmAutoRechargeResultDTO.java    
 * @Package com.crfchina.cdg.dto.result
 *     
 * @date 2018年1月6日 下午1:19:07 
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;

import java.util.Date;

import com.crfchina.cdg.dto.base.LmBaseResultDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmAutoRechargeResultDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 下午1:19:07
 * @updateBy：William
 * @updateDate：2018年1月6日 下午1:19:07
 * @remarks：
 */
public class LmAutoRechargeResultDTO extends LmBaseResultDTO {

	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	
	protected String platformUserNo;//  平台用户编号
	protected Long amount; // 充值金额
	protected Long commissionAmount;// 平台佣金
	protected String payMobile;// 本次充值手机号
	protected Date transactionTime;// 交易完成时间
	protected String channelErrorCode;// 【支付通道错误码】
	protected String channelErrorMessage;// 【支付通道返回错误消息】
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
	public String getPayMobile() {
		return payMobile;
	}
	public void setPayMobile(String payMobile) {
		this.payMobile = payMobile;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getChannelErrorCode() {
		return channelErrorCode;
	}
	public void setChannelErrorCode(String channelErrorCode) {
		this.channelErrorCode = channelErrorCode;
	}
	public String getChannelErrorMessage() {
		return channelErrorMessage;
	}
	public void setChannelErrorMessage(String channelErrorMessage) {
		this.channelErrorMessage = channelErrorMessage;
	}
	
	

}
