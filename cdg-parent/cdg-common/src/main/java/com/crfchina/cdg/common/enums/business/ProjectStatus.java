
/**   
 * @Title: StandardType.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

/** 
 * @Description 懒猫存管系统-业务类型
 * @author William
 * @date 2017年12月25日 下午1:43:17 
 * @version V1.3.1
 */

public enum ProjectStatus {
	
	COLLECTING("COLLECTING","募集中"),
	REPAYING("REPAYING","还款中"),
	FINISH("FINISH","已截标"),
	MISCARRY("MISCARRY","流标"),
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


	private ProjectStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
