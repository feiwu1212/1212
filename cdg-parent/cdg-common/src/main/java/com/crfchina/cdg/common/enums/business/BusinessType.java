
/**   
 * @Title: BusinessType.java 
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

public enum BusinessType {
	
	TENDER("TENDER","投标"),
	REPAYMENT("REPAYMENT","还款"),
	CREDIT_ASSIGNMENT("CREDIT_ASSIGNMENT","债权认购"),
	COMPENSATORY("COMPENSATORY","代偿"),
	COMPENSATORY_REPAYMENT("COMPENSATORY_REPAYMENT","还代偿款"),
	PLATFORM_INDEPENDENT_PROFIT("PLATFORM_INDEPENDENT_PROFIT","独立分润"),
	MARKETING("MARKETING","营销红包"),
	INTEREST("INTEREST","派息"),
	ALTERNATIVE_RECHARGE("ALTERNATIVE_RECHARGE","代充值"),
	INTEREST_REPAYMENT("INTEREST_REPAYMENT","还派息款"),
	COMMISSION("COMMISSION","佣金"),
	PROFIT("PROFIT","关联分润"),
	DEDUCT("DEDUCT","平台服务费"),
	FUNDS_TRANSFER("FUNDS_TRANSFER","平台资金划拨"),
	APPEND_FREEZ("APPEND_FREEZ","追加冻结"),
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


	private BusinessType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
