
/**   
 * @Title: StandardType.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

import org.apache.commons.lang.StringUtils;

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
	
	public static ProjectStatus getEnumByCode(String code){
		for (ProjectStatus item : ProjectStatus.values()) {
			if(StringUtils.equals(code, item.getCode())){
				return item;
			}
		}
		return null;
	}

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
