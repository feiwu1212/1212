/**
 * @Title：
 * @Package com.crfchina.cdg.common.enums.business
 * @date 2018/1/8 22:16
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**
 * @ProjectName：cdg-parent
 * @ClassName：EntrustedType
 * @Description:委托支付标的授权用户类型
 * @author: William
 * @date：2018/1/8 22:16
 * @updateBy：William
 * @updateDate：2018/1/8 22:16
 * @remarks：
 */
public enum EntrustedType {

	PERSONAL("PERSONAL", "个人"),
	ENTERPRISE("ENTERPRISE", "企业"),
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


	private EntrustedType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
