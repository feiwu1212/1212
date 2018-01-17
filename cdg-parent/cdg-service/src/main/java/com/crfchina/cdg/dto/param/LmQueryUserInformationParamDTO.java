/**    
 * @Title：LmQueryUserInformationParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月17日 上午10:20:41 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import com.crfchina.cdg.dto.base.BaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmQueryUserInformationParamDTO 
 * @Description:
 * @author: ghf
 * @date：2018年1月17日 上午10:20:41
 * @updateBy：ghf
 * @updateDate：2018年1月17日 上午10:20:41
 * @remarks：
 */
public class LmQueryUserInformationParamDTO extends BaseParamDTO {

	private static final long serialVersionUID = -5687120744000829277L;
    
	protected String platformUserNo; //平台用户编号

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}
	
	
}
