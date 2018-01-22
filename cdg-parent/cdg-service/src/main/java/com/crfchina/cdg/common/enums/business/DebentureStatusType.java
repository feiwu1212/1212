/**
 * @Title：DebentureStatusType
 * @Package com.crfchina.cdg.common.enums.business
 * @date 2018/1/8 22:16
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**
 * 
 * @ProjectName：cdg-common
 * @ClassName：DebentureStatusType 
 * @Description:
 * @author: ghf
 * @date：2018年1月15日 下午6:25:10
 * @updateBy：ghf
 * @updateDate：2018年1月15日 下午6:25:10
 * @remarks：
 */
public enum DebentureStatusType {

	ONSALE("ONSALE","出让中")
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


	private DebentureStatusType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
