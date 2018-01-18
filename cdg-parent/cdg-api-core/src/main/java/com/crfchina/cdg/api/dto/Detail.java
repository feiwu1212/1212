/**
 * @Title：
 * @Package com.crfchina.cdg.api.dto
 * @date 2018/1/17 14:40
 * @version V1.0
 */
package com.crfchina.cdg.api.dto;

/**
 * @ProjectName：cdg-parent
 * @ClassName：Detail
 * @Description:
 * @author: Administrator
 * @date：2018/1/17 14:40
 * @updateBy：但锐轩
 * @updateDate：2018/1/17 14:40
 * @remarks：
 */
public class Detail {

	String bizType;

	String freezeRequestNo;

	String sourcePlatformUser;

	String targetPlatformUser;

	String amount;

	String income;

	String share;

	String customDefine;

	String remark;

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getFreezeRequestNo() {
		return freezeRequestNo;
	}

	public void setFreezeRequestNo(String freezeRequestNo) {
		this.freezeRequestNo = freezeRequestNo;
	}

	public String getSourcePlatformUser() {
		return sourcePlatformUser;
	}

	public void setSourcePlatformUser(String sourcePlatformUser) {
		this.sourcePlatformUser = sourcePlatformUser;
	}

	public String getTargetPlatformUser() {
		return targetPlatformUser;
	}

	public void setTargetPlatformUser(String targetPlatformUser) {
		this.targetPlatformUser = targetPlatformUser;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	public String getCustomDefine() {
		return customDefine;
	}

	public void setCustomDefine(String customDefine) {
		this.customDefine = customDefine;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
