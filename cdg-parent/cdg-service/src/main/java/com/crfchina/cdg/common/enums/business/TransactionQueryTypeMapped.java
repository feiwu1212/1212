/**    
 * @Title：TransactionQueryType.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月25日 下午4:07:04 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：TransactionQueryType
 * @Description:懒猫存管-交易查询类-交易号隐射
 * @author: William
 * @date：2017年12月25日 下午4:07:04
 * @updateBy：William
 * @updateDate：2017年12月25日 下午4:07:04
 * @remarks：
 */
public enum TransactionQueryTypeMapped {
	RECHARG("RECHARG","充值"),
	DIRECT_RECHARGE("RECHARG","充值"),
	WITHDRAW("WITHDRAW","提现"),
	AUTO_WITHDRAW("WITHDRAW","提现"),
	USER_PRE_TRANSACTION("PRETRANSACTION","交易预处理"),
	FREEZE_PRE_TRANSACTION("PRETRANSACTION","交易预处理"),
	USER_AUTO_PRE_TRANSACTION("PRETRANSACTION","交易预处理"),
	DEBENTURE_SALE("DEBENTURE_SALE","债权出让"),
	CANCEL_PRE_TRANSACTION("CANCEL_PRETRANSACTION","取消预处理"),
	
	TENDER("TRANSACTION","交易确认"),
	REPAYMENT("TRANSACTION","交易确认"),
	CREDIT_ASSIGNMENT("TRANSACTION","交易确认"),
	COMPENSATORY("TRANSACTION","交易确认"),
	PRETRANSACTION("TRANSACTION","交易确认"),
	PLATFORM_INDEPENDENT_PROFIT("TRANSACTION","交易确认"),
	MARKETING("TRANSACTION","交易确认"),
	PLATFORM_SERVICE_DEDUCT("TRANSACTION","交易确认"),
	FUNDS_TRANSFER("TRANSACTION","交易确认"),
	APPEND_FREEZE("TRANSACTION","交易确认"),
	INTELLIGENT_APPEND("TRANSACTION","交易确认")
	
	
//	FREEZE("FREEZE","冻结"),
//	UNFREEZE("UNFREEZE","解冻"),
//	INTERCEPT_WITHDRAW("INTERCEPT_WITHDRAW","提现拦截"),
//	GENERAL_FREEZE("GENERAL_FREEZE","通用冻结"),
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


	private TransactionQueryTypeMapped(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
