
/**   
 * @Title: PreBusinessType.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

/** 
 * @Description 懒猫存管系统-预处理业务类型
 * @author William
 * @date 2017年12月25日 下午1:43:17 
 * @version V1.3.1
 */

public enum PreBusinessType {
	
	TENDER("TENDER","投标"),
	REPAYMENT("REPAYMENT","还款"),
	CREDIT_ASSIGNMENT("CREDIT_ASSIGNMENT","债权认购"),
	COMPENSATORY("COMPENSATORY","代偿"),
	PRETRANSACTION("PRETRANSACTION","交易预处理"),
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


	private PreBusinessType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
