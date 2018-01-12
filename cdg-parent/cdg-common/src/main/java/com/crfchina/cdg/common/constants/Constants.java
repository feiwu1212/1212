package com.crfchina.cdg.common.constants;


public class Constants {

	/**
	 * 操作类型:个人开户
	 */
	public static final String PERSON_OPEN_ACCOUNT = "POA";

	/**
	 * 操作类型:企业绑卡
	 */
	public static final String COMPANY_OPEN_ACCOUNT = "COA";

	/**
	 * 操作类型：充值
	 */
	public static final String RECHARGE = "CZ";
	
	/**
	 * 操作类型：提现
	 */
	public static final String WITHDRAW = "TX";

	/**
	 * 操作类型：冻结预处理
	 */
	public static final String PRE_FREEZE_TRANSACTION = "DJYCL";
	
	/**
	 * 操作类型：预处理取消
	 */
	public static final String CANCEL_PRE_TRANSACTION = "YCLQX";

	/**
	 * 操作类型：创建标的
	 */
	public static final String CREATE_PROJECT = "CJBD";
	
	/**
	 * 操作类型：变更标的
	 */
	public static final String MODIFY_PROJECT = "BGBD";

	/**
	 * 操作类型：自动充值
	 */
	public static final String DIRECT_RECHARGE = "ZDCZ";
	
	/**
	 * 操作类型：自动提现
	 */
	public static final String AUTO_WITHDRAW = "ZDTX";
	
	/**
	 * 操作类型：用户预处理
	 */
	public static final String USERPRETRANSACTION = "YHYCL";
	/**
	 * 网关地址后缀
	 */
	public static final String GATEWAY_SUFFIX = "/gateway";
	/**
	 * 流水号前缀
	 */
	public static final String TRX_PERFIX = "CDG";

	/**
	 * 鉴权验证类型
	 */
	public static final String CHECK_TYPE = "LIMIT";

	/**
	 * 验证身份证唯一性
	 */
	public static final String ID_CARD_NO_UNIQUE = "ID_CARD_NO_UNIQUE";

}
