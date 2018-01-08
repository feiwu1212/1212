
/**   
 * @Title: UserRoles.java 
 * @Package: com.crfchina.lanmaoly.common.enums 
 * @author William  
 * @date 2017年12月25日 下午1:43:17 
 * @version 1.3.1 
 */


package com.crfchina.cdg.common.enums.business;

/** 
 * @Description 懒猫存管系统-用户角色分类
 * @author William
 * @date 2017年12月25日 下午1:43:17 
 * @version V1.3.1
 */

public enum UserRoles {
	
	//个人类账户权限
	INVESTOR("INVESTOR","投资人")	,
	BORROWERS("BORROWERS","借款人"),
	
	//合作机构类账户
	GUARANTEECORP("GUARANTEECORP","担保机构"),
	COLLABORATOR("COLLABORATOR","合作机构"),
	SUPPLIER("SUPPLIER","供应商"),
	
	//平台类账号
	PLATFORM_MARKETING("PLATFORM_MARKETING","平台营销款账户"),
	PLATFORM_PROFIT("PLATFORM_PROFIT","平台分润账户"),
	PLATFORM_INCOME("PLATFORM_INCOME","平台收入账户"),
	PLATFORM_INTEREST("PLATFORM_INTEREST","平台派息账户"),
	PLATFORM_ALTERNATIVE_RECHARGE("PLATFORM_ALTERNATIVE_RECHARGE","平台代充值账户"),
	PLATFORM_FUNDS_TRANSFER("PLATFORM_FUNDS_TRANSFER","平台总账户"),
	PLATFORM_URGENT("PLATFORM_URGENT","垫资账户"),
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


	private UserRoles(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
