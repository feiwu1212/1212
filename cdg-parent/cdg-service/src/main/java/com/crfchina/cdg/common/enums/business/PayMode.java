
/**   
 * @Title: PayMode.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

/** 
 * @Description 懒猫存管系统-支付方式
 * @author William
 * @date 2017年12月25日 下午1:43:17 
 * @version V1.3.1
 */

public enum PayMode {
	
	WEB("WEB","网银"),
	SWIFT("SWIFT","快捷支付"),
	BANK("BANK","转账充值，仅适用迁移场景调单笔充订查询接口返回"),
	BACKROLL("BACKROLL","资金回退充值"),
	PROXY("PROXY","自动充值"),
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


	private PayMode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
