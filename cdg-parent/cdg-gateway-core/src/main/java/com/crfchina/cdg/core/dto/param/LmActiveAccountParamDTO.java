/**    
 * @Title：LmActiveAccountParamDTO.java    
 * @Package com.crfchina.cdg.core.dto.param
 *     
 * @date 2018年1月6日 下午4:19:01 
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

import java.util.List;

import com.crfchina.cdg.common.enums.business.IDCardType;
import com.crfchina.cdg.common.enums.business.UserAuthType;
import com.crfchina.cdg.common.enums.business.UserRoles;
import com.crfchina.cdg.core.dto.base.LmGatewayBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * @ClassName：LmActiveAccountParamDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 下午4:19:01
 * @updateBy：William
 * @updateDate：2018年1月6日 下午4:19:01
 * @remarks：
 */
public class LmActiveAccountParamDTO extends LmGatewayBaseParamDTO {
	
	protected IDCardType idCardType;//证件类型
	protected UserRoles userRole;//用户角色
	protected List<UserAuthType> authList;//用户授权集合
	protected String failTime;//授权期限
	protected String authAmount;//授权金额
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
	public String getAuthAmount() {
		return authAmount;
	}
	public void setAuthAmount(String authAmount) {
		this.authAmount = authAmount;
	}
	
	
}
