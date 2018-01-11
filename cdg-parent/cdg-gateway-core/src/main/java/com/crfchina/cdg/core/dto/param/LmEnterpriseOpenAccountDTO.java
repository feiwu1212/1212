/**
 * 
 */
package com.crfchina.cdg.core.dto.param;

/**
 * @author Administrator
 *
 */
public class LmEnterpriseOpenAccountDTO {

	private String requestNo; // 请求流水号
	private String platformUserNo; // 平台用户编号
	private String enterpriseName; // 企业名称
	private String bankLicense; // 开户银行许可证核准号
	private String orgNo; // 组织机构代码
	private String businessLicense; // 营业执照编号
	private String taxNo; // 税务登记号
	private String unifiedCode; // 统一社会信用代码（可替代营业执照编号、税务登记号、组织机构代码此三证）， 统一社会信用代码和三证信息两者必须有一个传入上海银行资金存管系统 API 8 / 68
	private String creditCode; // 机构信用代码
	private String legal; // 法人姓名
	private String idCardType; // 【证件类型】
	private String legalIdCardNo; // 法人证件号
	private String contact; // 企业联系人
	private String contactPhone; // 联系人手机号
	private String userRole; // 【用户角色】
	private String bankcardNo; // 企业对公账号
	private String bankcode; // 【银行编码】
	private String redirectUrl; // 页面回跳 URL
	private String authList; // 【用户授权列表】； 此处可传多个值，传多个值用“,”英文半角逗号分隔
	private String failTime; // 授权期限
	private String amoun; // 授权金额（不限制网关的用户预处理接口）

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getBankLicense() {
		return bankLicense;
	}

	public void setBankLicense(String bankLicense) {
		this.bankLicense = bankLicense;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public String getUnifiedCode() {
		return unifiedCode;
	}

	public void setUnifiedCode(String unifiedCode) {
		this.unifiedCode = unifiedCode;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getLegal() {
		return legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	public String getLegalIdCardNo() {
		return legalIdCardNo;
	}

	public void setLegalIdCardNo(String legalIdCardNo) {
		this.legalIdCardNo = legalIdCardNo;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
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

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getAuthList() {
		return authList;
	}

	public void setAuthList(String authList) {
		this.authList = authList;
	}

	public String getFailTime() {
		return failTime;
	}

	public void setFailTime(String failTime) {
		this.failTime = failTime;
	}

	public String getAmoun() {
		return amoun;
	}

	public void setAmoun(String amoun) {
		this.amoun = amoun;
	}

}
