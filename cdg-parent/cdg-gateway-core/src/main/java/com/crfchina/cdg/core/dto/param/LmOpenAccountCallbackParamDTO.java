/**
 * @Title：
 * @Package com.crfchina.cdg.core.dto.param
 * @date 2018/1/9 17:31
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmOpenAccountCallbackParam
 * @Description: 个人开户同步回调参数
 * @author: Administrator
 * @date：2018/1/9 17:31
 * @updateBy：但锐轩
 * @updateDate：2018/1/9 17:31
 * @remarks：
 */
public class LmOpenAccountCallbackParamDTO {

	String fcpTrxNo;

	String platformUserNo;

	String realName;

	String idCardNo;

	String bankCardNo;

	String bankCode;

	String mobile;

	String idCardType;

	String accessType;

	String userRole;

	String auditStatus;

	String fallTime;

	String authAmount;

	public String getFcpTrxNo() {
		return fcpTrxNo;
	}

	public void setFcpTrxNo(String fcpTrxNo) {
		this.fcpTrxNo = fcpTrxNo;
	}

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getFallTime() {
		return fallTime;
	}

	public void setFallTime(String fallTime) {
		this.fallTime = fallTime;
	}

	public String getAuthAmount() {
		return authAmount;
	}

	public void setAuthAmount(String authAmount) {
		this.authAmount = authAmount;
	}
}
