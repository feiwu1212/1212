/**
 * @Title：
 * @Package com.crfchina.cdg.core.dto.param
 * @date 2018/1/13 13:33
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

import com.crfchina.cdg.core.dto.base.LmGatewayBaseParamDTO;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmChangePwdParamDTO
 * @Description:
 * @author: Administrator
 * @date：2018/1/13 13:33
 * @updateBy：但锐轩
 * @updateDate：2018/1/13 13:33
 * @remarks：
 */
public class LmChangePwdParamDTO extends LmGatewayBaseParamDTO {

	/**
	 * 变更类型:
	 * Remember主动修改密码;
	 * Forget 为忘记密码，重新设置 密码;
	 */
	String isSkip;

	public String getIsSkip() {
		return isSkip;
	}

	public void setIsSkip(String isSkip) {
		this.isSkip = isSkip;
	}
}
