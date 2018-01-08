/**    
 * @Title：TransactionType.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月25日 下午4:07:04 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：TransactionType 
 * @Description:懒猫存管-交易类型
 * @author: William
 * @date：2017年12月25日 下午4:07:04
 * @updateBy：William
 * @updateDate：2017年12月25日 下午4:07:04
 * @remarks：
 */
public enum TransactionType {
	TENDER("TENDER","投标"),
	REPAYMENT("REPAYMENT","还款"),
	CREDIT_ASSIGNMENT("CREDIT_ASSIGNMENT","债权认购"),
	COMPENSATORY("COMPENSATORY","直接代偿"),
	INDIRECT_COMPENSATORY("PRETRANSACTION","间接代偿"),
	PLATFORM_INDEPENDENT_PROFIT("PLATFORM_INDEPENDENT_PROFIT","独立分润"),
	MARKETING("MARKETING","平台营销款"),
	PLATFORM_SERVICE_DEDUCT("PLATFORM_SERVICE_DEDUCT","收费"),
	FUNDS_TRANSFER("FUNDS_TRANSFER","平台资金划拨"),
	INTELLIGENT_APPEND("INTELLIGENT_APPEND","批量追加冻结"),
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


	private TransactionType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
