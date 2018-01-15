/**
 * @Title：
 * @Package com.crfchina.cdg.core.dto.param
 * @date 2018/1/13 14:09
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

import com.crfchina.cdg.core.dto.base.LmGatewayBaseParamDTO;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmCheckPwdParamDTO
 * @Description:
 * @author: Administrator
 * @date：2018/1/13 14:09
 * @updateBy：但锐轩
 * @updateDate：2018/1/13 14:09
 * @remarks：
 */
public class LmCheckPwdParamDTO extends LmGatewayBaseParamDTO {

	/**
	 * 验证密码，业务场景描述
	 */
	String bizTypeDescription;

	public String getBizTypeDescription() {
		return bizTypeDescription;
	}

	public void setBizTypeDescription(String bizTypeDescription) {
		this.bizTypeDescription = bizTypeDescription;
	}
}
