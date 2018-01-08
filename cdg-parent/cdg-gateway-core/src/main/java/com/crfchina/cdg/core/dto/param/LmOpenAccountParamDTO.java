/**    
 * @Title：LmOpenAccountParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月5日 下午3:41:51 
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
 * @ProjectName：cdg-service
 * @ClassName：LmOpenAccountParamDTO
 * @Description:个人用户注册请求参数DTO
 * @author: William
 * @date：2018年1月5日 下午3:41:51
 * @updateBy：William
 * @updateDate：2018年1月5日 下午3:41:51
 * @remarks：
 */
public class LmOpenAccountParamDTO extends LmGatewayBaseParamDTO {
	
	protected String realName;//客户姓名
	protected String idCardNo;//证件号
	protected String bandCardNo;//银行卡号
	protected String mobile;//银行预留手机号
	protected IDCardType idCardType;//证件类型
	protected UserRoles userRole;//用户角色
	protected List<UserAuthType> userAuthList;//用户授权集合
	protected String failTime;//授权期限
	protected String authAmount;//授权金额
	
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
	public String getBandCardNo() {
		return bandCardNo;
	}
	public void setBandCardNo(String bandCardNo) {
		this.bandCardNo = bandCardNo;
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
	public List<UserAuthType> getUserAuthList() {
		return userAuthList;
	}
	public void setUserAuthList(List<UserAuthType> userAuthList) {
		this.userAuthList = userAuthList;
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
