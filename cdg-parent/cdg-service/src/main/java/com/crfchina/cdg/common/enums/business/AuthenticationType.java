
/**   
 * @Title: AuthenticationType.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

/** 
 * @Description 懒猫存管系统-鉴权通过类型
 * @author William
 * @date 2017年12月25日 下午1:43:17 
 * @version V1.3.1
 */

public enum AuthenticationType {
	
	FULL_CHECKED("FULL_CHECKED","四要素验证通过"),
	NOT_AUTH("NOT_AUTH","未鉴权"),
	AUDIT_AUTH("AUDIT_AUTH","特殊用户认证"),
	PART_CHECKED("PART_CHECKED","企业用户认证"),
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


	private AuthenticationType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
