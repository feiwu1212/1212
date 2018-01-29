/**
 * @Title：
 * @Package com.crfchina.cdg.common.enums.business
 * @date 2018/1/8 22:16
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**
 * @ProjectName：cdg-parent
 * @ClassName：ApiType
 * @Description:
 * @author: Administrator
 * @date：2018/1/8 22:16
 * @updateBy：但锐轩
 * @updateDate：2018/1/8 22:16
 * @remarks：
 */
public enum ApiType {

	PERSONAL_REGISTER_EXPAND("PERSONAL_REGISTER_EXPAND", "个人绑卡注册"),
	ENTERPRISE_REGISTER("ENTERPRISE_REGISTER", "企业绑卡注册"),
	RECHARGE("RECHARGE","充值"),
	WITHDRAW("WITHDRAW","提现"),
	USERPRETRANSACTION("USER_PRE_TRANSACTION","用户预处理"),
	FREEZE_PRE_TRANSACTION("FREEZE_PRE_TRANSACTION","冻结预处理"),
	DIRECT_RECHARGE("DIRECT_RECHARGE","自动充值"),
	PERSONAL_BIND_BANKCARD_EXPAND("PERSONAL_BIND_BANKCARD_EXPAND", "个人换绑卡"),
	RESET_PASSWORD("RESET_PASSWORD", "修改密码"),
	CHECK_PASSWORD("CHECK_PASSWORD", "验证密码"),
	MODIFY_MOBILE_EXPAND("MODIFY_MOBILE_EXPAND", "预留手机号更新"),
	ACTIVATE_STOCKED_USER("ACTIVATE_STOCKED_USER", "会员激活"),
	AUTO_WITHDRAW("AUTO_WITHDRAW","自动提现"),
	ESTABLISH_PROJECT("ESTABLISH_PROJECT","创建标的"),
	MODIFY_PROJECT("MODIFY_PROJECT","更改标的"),
	CANCEL_PRE_TRANSACTION("CANCEL_PRE_TRANSACTION","预处理取消"),
	AUTO_PRE_TRANSACTION("USER_AUTO_PRE_TRANSACTION","授权预处理"),
	UNFREEZE_TRADE_PASSWORD("UNFREEZE_TRADE_PASSWORD", "解冻交易密码"),
	VERIFY_DEDUCT("VERIFY_DEDUCT", "验密扣费"),
	DEBENTURE_SALE("DEBENTURE_SALE","债权转让申请"),
	CANCEL_DEBENTURE_SALE("CANCEL_DEBENTURE_SALE","取消债权转让申请"),
	AUTHORIZATION_ENTRUST_PAY("AUTHORIZATION_ENTRUST_PAY","委托支付授权"),
	QUERY_USER_INFORMATION("QUERY_USER_INFORMATION","用户信息查询"),
	QUERY_TRANSACTION("QUERY_TRANSACTION","单笔交易查询"),
	CONFIRM_CHECKFILE("CONFIRM_CHECKFILE","对账确认"),
	BACKROLL_RECHARGE(" BACKROLL_RECHARGE", "资金回退")
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


	private ApiType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
