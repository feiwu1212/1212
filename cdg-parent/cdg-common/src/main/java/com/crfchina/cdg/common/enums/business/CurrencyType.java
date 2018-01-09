
/**   
 * @Title: WebType.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

/** 
 * @Description 懒猫存管系统-货币类型
 * @author GHF
 * @date 2017年12月25日 下午1:43:17 
 * @version V1.3.1
 */

public enum CurrencyType {
	
	RMB("1","人民币"),
	
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


	private CurrencyType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
