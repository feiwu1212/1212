/**    
 * @Title：LmChangeMobileParamDTO.java    
 * @Package com.crfchina.cdg.core.dto.param
 *     
 * @date 2018年1月6日 下午4:21:32 
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

import com.crfchina.cdg.core.dto.base.LmGatewayBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * @ClassName：LmChangeMobileParamDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 下午4:21:32
 * @updateBy：William
 * @updateDate：2018年1月6日 下午4:21:32
 * @remarks：
 */
public class LmChangeMobileParamDTO extends LmGatewayBaseParamDTO {
	
	protected String mobile;//更新后用户预留手机号

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

}
