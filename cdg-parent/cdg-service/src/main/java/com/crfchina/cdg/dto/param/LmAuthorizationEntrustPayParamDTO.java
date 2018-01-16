/**    
 * @Title：LmAuthorizationEntrustPayParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 上午10:53:02 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import com.crfchina.cdg.dto.base.LmAPIBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmAuthorizationEntrustPayParamDTO
 * @Description:
 * @author: William
 * @date：2018年1月6日 上午10:53:02
 * @updateBy：William
 * @updateDate：2018年1月6日 上午10:53:02
 * @remarks：
 */
public class LmAuthorizationEntrustPayParamDTO extends LmAPIBaseParamDTO {
	
	private static final long serialVersionUID = 1L;
	protected String projectNo;//标的编号
	protected String entrustedType; //受托方支付类型
	protected String toPlatformUserNo; //受托方平台用户ID
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getEntrustedType() {
		return entrustedType;
	}
	public void setEntrustedType(String entrustedType) {
		this.entrustedType = entrustedType;
	}
	public String getToPlatformUserNo() {
		return toPlatformUserNo;
	}
	public void setToPlatformUserNo(String toPlatformUserNo) {
		this.toPlatformUserNo = toPlatformUserNo;
	}
	
	

}
