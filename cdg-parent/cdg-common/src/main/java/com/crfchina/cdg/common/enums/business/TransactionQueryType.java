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
 * @Description:懒猫存管-交易查询类型
 * @author: William
 * @date：2017年12月25日 下午4:07:04
 * @updateBy：William
 * @updateDate：2017年12月25日 下午4:07:04
 * @remarks：
 */
public enum TransactionQueryType {
	RECHARG("RECHARG","充值"),
	WITHDRAW("WITHDRAW","提现"),
	PRETRANSACTION("PRETRANSACTION","交易预处理"),
	TRANSACTION("TRANSACTION","交易确认"),
	FREEZE("FREEZE","冻结"),
	DEBENTURE_SALE("DEBENTURE_SALE","债权出让"),
	CANCEL_PRETRANSACTION("CANCEL_PRETRANSACTION","取消预处理"),
	UNFREEZE("UNFREEZE","解冻"),
	INTERCEPT_WITHDRAW("INTERCEPT_WITHDRAW","提现拦截"),
	GENERAL_FREEZE("GENERAL_FREEZE","通用冻结"),
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


	private TransactionQueryType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
