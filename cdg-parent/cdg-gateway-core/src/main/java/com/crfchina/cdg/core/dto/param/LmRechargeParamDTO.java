/**    
 * @Title：LmRechargeParamDTO.java    
 * @Package com.crfchina.cdg.core.dto.param
 *     
 * @date 2018年1月6日 下午4:28:33 
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

import java.util.Date;

import com.crfchina.cdg.common.enums.business.PayMode;
import com.crfchina.cdg.common.enums.business.WebType;
import com.crfchina.cdg.core.dto.base.LmGatewayBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * @ClassName：LmRechargeParamDTO 
 * @Description:客户自主充值接口请求参数定义
 * @author: William
 * @date：2018年1月6日 下午4:28:33
 * @updateBy：William
 * @updateDate：2018年1月6日 下午4:28:33
 * @remarks：
 */
public class LmRechargeParamDTO extends LmGatewayBaseParamDTO {
	
	protected Long amount;//充值金额
	protected Long commissionAmount;//佣金
	protected PayMode rechargeWay;//支持网银(WEB)、快捷支付(SWIFT)
	protected String bankCode;//若支付方式为快捷支付，此处必传;若支付方式为网银且传了 payType 则此处必传，不传 payTyp 则此处传了也不生效
	protected WebType payType;//网银支付方式下，若此处传值则直接跳转至银行页面，不传则跳转至 支付公司收银台页面;
	protected String projectNo;//标的号
	protected Date expired;//页面过期时间
	protected String callbackMode;//快捷充值回调模式，如传入 DIRECT_CALLBACK，则订单支付不论成功、失败、 处理中均直接同步、异步通知商户
	protected String expectPayCompany;//偏好支付公司
	
	public String getExpectPayCompany() {
		return expectPayCompany;
	}
	public void setExpectPayCompany(String expectPayCompany) {
		this.expectPayCompany = expectPayCompany;
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
	public PayMode getRechargeWay() {
		return rechargeWay;
	}
	public void setRechargeWay(PayMode rechargeWay) {
		this.rechargeWay = rechargeWay;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public WebType getPayType() {
		return payType;
	}
	public void setPayType(WebType payType) {
		this.payType = payType;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public Date getExpired() {
		return expired;
	}
	public void setExpired(Date expired) {
		this.expired = expired;
	}
	public String getCallbackMode() {
		return callbackMode;
	}
	public void setCallbackMode(String callbackMode) {
		this.callbackMode = callbackMode;
	}
	
}
