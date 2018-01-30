/**
 * @Title：
 * @Package com.crfchina.cdg.common.enums.business
 * @date 2018/1/8 22:16
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**
 * @ProjectName：cdg-parent
 * @ClassName：ApiType
 * @Description:
 * @author: Administrator
 * @date：2018/1/8 22:16
 * @updateBy：但锐轩
 * @updateDate：2018/1/8 22:16
 * @remarks：
 */
public enum TransferResultType {

	SUCCESS("SUCCESS", "成功确认"),
	FAIL("FAIL", "失败确认"),
	UNKNOWN("UNKNOWN","未知状态(受理中)"),
	ACCEPTED("ACCEPTED","受理成功")
	;
	private String code;

	private String desc;

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	private TransferResultType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
