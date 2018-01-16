package com.crfchina.cdg.common.enums.business;

/**
 * 
 * 
 * @ProjectName：cdg-common
 * @ClassName：ChlInfoNoType 
 * @Description:
 * @author: ghf
 * @date：2018年1月16日 下午3:40:04
 * @updateBy：ghf
 * @updateDate：2018年1月16日 下午3:40:04
 * @remarks：
 */
public enum ChlInfoNoType {
	
	LANMAO("1","懒猫存管系统");
	
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


	private ChlInfoNoType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
