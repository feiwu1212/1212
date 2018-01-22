
/**   
 * @Title: PlatformAccountNo.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

/** 
 * @Description 懒猫存管系统-平台账户编号管理
 * @author William
 * @date 2017年12月25日 下午1:43:17 
 * @version V1.3.1
 */

public enum PlatformAccountNo {
	
	SYS_GENERATE_000("SYS_GENERATE_000","平台总账户"),
	SYS_GENERATE_002("SYS_GENERATE_002","营销款账户"),
	SYS_GENERATE_003("SYS_GENERATE_003","分润账户"),
	SYS_GENERATE_004("SYS_GENERATE_004","收入账户"),
	SYS_GENERATE_005("SYS_GENERATE_005","派息账户"),
	SYS_GENERATE_006("SYS_GENERATE_006","代充值账户"),
	SYS_GENERATE_007("SYS_GENERATE_007","平台垫资账户"),
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


	private PlatformAccountNo(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
