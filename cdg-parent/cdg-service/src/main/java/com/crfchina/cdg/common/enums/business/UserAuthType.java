
/**   
 * @Title: UserAuthType.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

/** 
 * @Description 懒猫存管系统-用户授权清单list
 * @author William
 * @date 2017年12月25日 下午1:43:17 
 * @version V1.3.1
 */

public enum UserAuthType {
	
	TENDER("TENDER","自动投标"),
	REPAYMENT("REPAYMENT","自动还款"),
	CREDIT_ASSIGNMENT("CREDIT_ASSIGNMENT","自动债权认购"),
	COMPENSATORY("COMPENSATORY","自动代偿"),
	RECHARG("RECHARG","自动充值"),
	WITHDRAW("WITHDRAW","自动提现"),
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


	private UserAuthType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
