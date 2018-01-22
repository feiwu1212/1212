
/**   
 * @Title: RepaymentType.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

import org.apache.commons.lang.StringUtils;

/** 
 * @Description 懒猫存管系统-还款方式
 * @author William
 * @date 2017年12月25日 下午1:43:17 
 * @version V1.3.1
 */

public enum RepaymentType {
	
	ONE_TIME_SERVICING("ONE_TIME_SERVICING","一次性还本付息"),
	FIRSEINTREST_LASTPRICIPAL("FIRSEINTREST_LASTPRICIPAL","先息后本"),
	FIXED_PAYMENT_MORTGAGE("FIXED_PAYMENT_MORTGAGE","等额本息"),
	FIXED_BASIS_MORTGAGE("FIXED_BASIS_MORTGAGE","等额本金"),
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


	private RepaymentType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	

	public static RepaymentType getEnumByCode(String code){
		for (RepaymentType item : RepaymentType.values()) {
			if(StringUtils.equals(code, item.getCode())){
				return item;
			}
		}
		return null;
	}
	
	
}
