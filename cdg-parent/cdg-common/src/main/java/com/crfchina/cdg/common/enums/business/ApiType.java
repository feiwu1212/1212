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
public enum ApiType {

	PERSONAL_REGISTER_EXPAND("PERSONAL_REGISTER_EXPAND", "个人绑卡注册"),
	ENTERPRISE_REGISTER("ENTERPRISE_REGISTER", "企业绑卡注册")
	
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


	private ApiType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
