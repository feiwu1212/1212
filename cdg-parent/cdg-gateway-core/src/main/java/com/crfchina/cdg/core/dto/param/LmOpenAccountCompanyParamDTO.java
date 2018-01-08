/**    
 * @Title：LmOpenAccountCompanyParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月5日 下午3:41:51 
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.crfchina.cdg.common.enums.business.IDCardType;
import com.crfchina.cdg.common.enums.business.UserAuthType;
import com.crfchina.cdg.common.enums.business.UserRoles;
import com.crfchina.cdg.core.dto.base.LmGatewayBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmOpenAccountCompanyParamDTO
 * @Description:企业用户注册请求参数DTO
 * @author: William
 * @date：2018年1月5日 下午3:41:51
 * @updateBy：William
 * @updateDate：2018年1月5日 下午3:41:51
 * @remarks：
 */
public class LmOpenAccountCompanyParamDTO  extends LmGatewayBaseParamDTO{
	
	protected String enterpriseName;//企业姓名
	protected String bankLicense;//开户银行许可证核准号
	protected String orgNo;//组织机构代码
	protected String businessLicense;//营业执照编号
	protected String taxNo;//税务登记号
	protected String unifiedCode;//统一社会信用代码(可替代营业执照编号、税务登记号、组织机构代码此三证)， 统一社会信用代码和三证信息两者必须有一个传
	protected String creditCode;//机构信用代码
	protected String legal;//法人姓名
	protected IDCardType idCardType;//见【证件类型】
	protected String legalIdCardNo;//法人证件号
	
	protected String contact;//企业联系人
	protected String contactPhone;//联系人手机号
	protected UserRoles userRole;//用户角色
	protected String bandCardNo;//银行卡号
	protected String bankcode;//银行编码
	
	protected List<UserAuthType> authList;//用户授权集合
	
	protected String failTime;//授权期限
	protected String amount;//授权金额
	
	
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
	public IDCardType getIdCardType() {
		return idCardType;
	}
	public void setIdCardType(IDCardType idCardType) {
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
	public UserRoles getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
	}
	@JSONField(name = "bankcardNo")
	public String getBandCardNo() {
		return bandCardNo;
	}
	public void setBandCardNo(String bandCardNo) {
		this.bandCardNo = bandCardNo;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public List<UserAuthType> getAuthList() {
		return authList;
	}
	public void setAuthList(List<UserAuthType> authList) {
		this.authList = authList;
	}
	public String getFailTime() {
		return failTime;
	}
	public void setFailTime(String failTime) {
		this.failTime = failTime;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

}
