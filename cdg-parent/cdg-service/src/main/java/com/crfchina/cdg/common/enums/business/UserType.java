
/**   
 * @Title: UserType.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

/** 
 * @Description 懒猫存管系统-个人用户类型
 * @author William
 * @date 2017年12月25日 下午1:43:17 
 * @version V1.3.1
 */

public enum UserType {
	
	PERSONPERSON("PERSONPERSON","个人用户"),
	ORGANIZATION("ORGANIZATION","企业用户");
	
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


	private UserType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
