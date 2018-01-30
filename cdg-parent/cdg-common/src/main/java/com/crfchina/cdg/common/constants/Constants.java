package com.crfchina.cdg.common.constants;


public class Constants {

	/**
	 * 操作类型:个人开户
	 */
	public static final String PERSON_OPEN_ACCOUNT = "GRKH";

	/**
	 * 操作类型:企业绑卡
	 */
	public static final String COMPANY_OPEN_ACCOUNT = "QYBK";

	/**
	 * 操作类型：个人换卡
	 */
	public static final String PERSON_CHANGE_CARD = "GRHK";

	/**
	 * 操作类型：更换交易密码
	 */
	public static final String PERSON_CHANGE_PWD = "GHMM";

	/**
	 * 操作类型：验证密码
	 */
	public static final String PERSON_NCHECK_PWD = "YZMM";

	/**
	 * 操作类型：更换预留手机号
	 */
	public static final String PERSON_CHANGE_MOBILE = "GHSJ";

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
	 * 操作类型：授权预处理
	 */
	public static final String AUTO_PRE_TRANSACTION = "SQYCL";

	/**
	 * 操作类型：债券转让申请
	 */
	public static final String DEBENTURE_SALE = "ZQZR";

	/**
	 * 操作类型：取消债券转让申请
	 */
	public static final String CANCEL_DEBENTURE_SALE = "QXZQ";

	
	/**
	 * 操作类型：创建标的
	 */
	public static final String CREATE_PROJECT = "CJBD";
	
	/**
	 * 操作类型：变更标的
	 */
	public static final String MODIFY_PROJECT = "BGBD";

	/**
	 * 操作类型 用户查询
	 */
	public static final String QUERY_USER_INFORMATION = "YHCX";
	
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
	 * 操作类型：批量交易
	 */
	public static final String BATCH_TRANSFER= "PLJY";

	/**
	 * 操作类型：解冻交易密码
	 */
	public static final String UNFREEZE_PWD = "JDMM";

	/**
	 * 验密扣费
	 */
	public static final String VERIFY_DEDUCT = "YMKF";

	
	/**
	 * 操作类型：对账确认
	 */
	public static final String RECKON_CONFIRM = "DZQR";
	
	/**
	 * 网关地址后缀
	 */
	public static final String GATEWAY_SUFFIX = "/gateway";

	public static final String SERVICE_SUFFIX = "/service";
	
	public static final String DOWNLOAD_SUFFIX = "/download";

	/**
	 * 流水号前缀
	 */
	public static final String TRX_PERFIX = "CDG";

	/**
	 * 批次号前缀
	 */
	public static final String BATCH_NO_PERFIX = "BN";

	/**
	 * 鉴权验证类型
	 */
	public static final String CHECK_TYPE = "LIMIT";

	/**
	 * 验证身份证唯一性
	 */
	public static final String ID_CARD_NO_UNIQUE = "ID_CARD_NO_UNIQUE";

	/**
	 * 绑卡类型
	 */
	public static final String UPDATE_BANKCARD = "UPDATE_BANKCARD";

	/**
	 * 绑卡taskContext
	 */
	public static final String CONTEXT_BIND_CARD = "CONTEXT_BIND_CARD";
	
	/**
	 * 充值taskContext
	 */
	public static final String CONTEXT_RECHARGE = "CONTEXT_RECHARGE";
	

	public static final String CONTEXT_CHANGE_CARD_MOBILE = "CONTEXT_CHANGE_CARD_MOBILE";

	public static final String CONTEXT_TRANSFER_INFO = "CONTEXT_TRANSFER_INFO";

	/**
	 * 异步通知结果
	 */
	public static final String NOTIFY_RESP_RESULT = "result";

	/**
	 * 通知状态：待通知
	 */
	public static final Integer NOTIFY_STATUS_WAIT = 1;

	/**
	 * 通知状态：已通知
	 */
	public static final Integer NOTIFY_STATUS_FINISH = 2;

	/**
	 * 退票处理状态 待处理
	 */
	public static final Integer TXTP_STATUS_WAIT = 1;

	/**
	 * 退票处理状态 处理中
	 */
	public static final Integer TXTP_STATUS_DOING = 2;

	/**
	 * 退票处理状态 处理完成
	 */
	public static final Integer TXTP_STATUS_FINISH = 3;
}
