/**    
 * @Title：LmOpenAccountResultDTO.java    
 * @Package com.crfchina.cdg.dto.result
 *     
 * @date 2018年1月5日 下午4:21:45 
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;

import com.crfchina.cdg.common.enums.business.AuditStatus;
import com.crfchina.cdg.common.enums.business.AuthenticationType;
import com.crfchina.cdg.common.enums.business.IDCardType;
import com.crfchina.cdg.common.enums.business.UserRoles;
import com.crfchina.cdg.dto.base.LmBaseResultDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmOpenAccountResultDTO 
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午4:21:45
 * @updateBy：William
 * @updateDate：2018年1月5日 下午4:21:45
 * @remarks：
 */
public class LmOpenAccountResultDTO extends LmBaseResultDTO {

	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	
	protected String platformUserNo;//平台用户编号
	protected String realName;//客户姓名
	protected String idCardNo;//证件号
	protected String mobile;//银行预留手机号
	protected IDCardType idCardType;//证件类型
	protected UserRoles userRole;//用户角色
	
	protected String bandCardNo;//银行卡号
	protected String bankcode;//银行Code
	protected AuthenticationType accessType;//鉴权通过类型
	protected AuditStatus auditStatus;//审核状态
	protected String failTime;//授权期限
	protected String authAmount;//授权金额
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public IDCardType getIdCardType() {
		return idCardType;
	}
	public void setIdCardType(IDCardType idCardType) {
		this.idCardType = idCardType;
	}
	public UserRoles getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
	}
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
	public AuthenticationType getAccessType() {
		return accessType;
	}
	public void setAccessType(AuthenticationType accessType) {
		this.accessType = accessType;
	}
	public AuditStatus getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(AuditStatus auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getFailTime() {
		return failTime;
	}
	public void setFailTime(String failTime) {
		this.failTime = failTime;
	}
	public String getAuthAmount() {
		return authAmount;
	}
	public void setAuthAmount(String authAmount) {
		this.authAmount = authAmount;
	}

	
	

}
