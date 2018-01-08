/**    
 * @Title：LmChangeBankCardParamDTO.java    
 * @Package com.crfchina.cdg.core.dto.param
 *     
 * @date 2018年1月6日 下午4:06:00 
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

import com.crfchina.cdg.core.dto.base.LmGatewayBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * @ClassName：LmChangeBankCardParamDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 下午4:06:00
 * @updateBy：William
 * @updateDate：2018年1月6日 下午4:06:00
 * @remarks：
 */
public class LmChangeBankCardParamDTO extends LmGatewayBaseParamDTO {
	
	protected String mobile;//银行预留手机号
	protected String bankcardNo;//银行卡号
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBankcardNo() {
		return bankcardNo;
	}
	public void setBankcardNo(String bankcardNo) {
		this.bankcardNo = bankcardNo;
	}
	

}
