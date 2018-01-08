/**    
 * @Title：ReconciliationFileType.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月25日 下午4:07:04 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：ReconciliationFileType
 * @Description:懒猫存管-对账文件类型
 * @author: William
 * @date：2017年12月25日 下午4:07:04
 * @updateBy：William
 * @updateDate：2017年12月25日 下午4:07:04
 * @remarks：
 */
public enum ReconciliationFileType {
	RECHARG("RECHARG","充值"),
	WITHDRAW("WITHDRAW","提现"),
	COMMISSION ("COMMISSION","佣金"),
	TRANSACTION("TRANSACTION","交易"),
	BACKROLL_RECHARGE("BACKROLL_RECHARGE","资金回退充值"),
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


	private ReconciliationFileType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
