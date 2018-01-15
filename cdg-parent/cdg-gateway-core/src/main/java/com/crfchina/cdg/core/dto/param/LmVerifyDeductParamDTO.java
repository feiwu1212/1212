/**
 * @Title：
 * @Package com.crfchina.cdg.core.dto.param
 * @date 2018/1/15 18:46
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

import com.crfchina.cdg.core.dto.base.LmGatewayBaseParamDTO;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmVerifyDeductParamDTO
 * @Description:
 * @author: Administrator
 * @date：2018/1/15 18:46
 * @updateBy：但锐轩
 * @updateDate：2018/1/15 18:46
 * @remarks：
 */
public class LmVerifyDeductParamDTO extends LmGatewayBaseParamDTO {

	/**
	 * 扣费金额
	 */
	String amount;

	/**
	 * 扣费说明
	 */
	String customDefine;

	/**
	 * 收款方平台用户编号
	 */
	String targetPlatformUserNo;

	/**
	 * 页面过期时间
	 */
	String expired;

	/**
	 * 标注
	 */
	String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCustomDefine() {
		return customDefine;
	}

	public void setCustomDefine(String customDefine) {
		this.customDefine = customDefine;
	}

	public String getTargetPlatformUserNo() {
		return targetPlatformUserNo;
	}

	public void setTargetPlatformUserNo(String targetPlatformUserNo) {
		this.targetPlatformUserNo = targetPlatformUserNo;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}
}
