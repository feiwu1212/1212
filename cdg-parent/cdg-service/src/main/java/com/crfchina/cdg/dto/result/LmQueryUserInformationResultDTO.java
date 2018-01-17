/**
 * @Title：
 * @Package com.crfchina.cdg.dto.result
 * @date 2018/1/15 15:22
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;

import java.util.List;

import com.crfchina.cdg.dto.base.LmBaseResultDTO;

/**
 * @ProjectName：cdg-parent
 * @ClassName： LmQueryUserInformationResultDTO
 * @Description:
 * @author: Administrator
 * @date：2018/1/15 15:22
 * @updateBy：但锐轩
 * @updateDate：2018/1/15 15:22
 * @remarks：
 */
public class LmQueryUserInformationResultDTO extends LmBaseResultDTO {

	private static final long serialVersionUID = 1L;

    protected String platformUserNo ;
    protected String name                  ;
    protected String idCardNo              ;
    protected String bankCardNo            ;
    protected String bankCode              ;
    protected String mobile                ;
    protected String idCardType            ;
    protected String accessType            ;
    protected String userType              ;
    protected String userRole              ;
    protected String auditStatus           ;
    protected String activeStatus          ;
    protected Long balance               ;
    protected Long availableAmount       ;
    protected Long arriveBalance         ;
    protected Long floatBalance          ;
    protected Long freezeAmount          ;
    protected String authList              ;
    protected String isImportUserActivate  ;
    protected String bankLicense           ;
    protected String orgNo                 ;
    protected String businessLicense       ;
    protected String taxNo                 ;
    protected String unifiedCode           ;
    protected String creditCode            ;
    protected String legal                 ;
    protected List<AuthLimitResultList> authLimitResultList;
	public String getPlatformUserNo() {
		return platformUserNo;
	}
	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Long getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(Long availableAmount) {
		this.availableAmount = availableAmount;
	}
	public Long getArriveBalance() {
		return arriveBalance;
	}
	public void setArriveBalance(Long arriveBalance) {
		this.arriveBalance = arriveBalance;
	}
	public Long getFloatBalance() {
		return floatBalance;
	}
	public void setFloatBalance(Long floatBalance) {
		this.floatBalance = floatBalance;
	}
	public Long getFreezeAmount() {
		return freezeAmount;
	}
	public void setFreezeAmount(Long freezeAmount) {
		this.freezeAmount = freezeAmount;
	}
	public String getAuthList() {
		return authList;
	}
	public void setAuthList(String authList) {
		this.authList = authList;
	}
	public String getIsImportUserActivate() {
		return isImportUserActivate;
	}
	public void setIsImportUserActivate(String isImportUserActivate) {
		this.isImportUserActivate = isImportUserActivate;
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
	public List<AuthLimitResultList> getAuthLimitResultList() {
		return authLimitResultList;
	}
	public void setAuthLimitResultList(List<AuthLimitResultList> authLimitResultList) {
		this.authLimitResultList = authLimitResultList;
	}
 
    
	
}
