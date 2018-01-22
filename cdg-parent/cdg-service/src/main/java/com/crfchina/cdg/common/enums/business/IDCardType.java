/**    
 * @Title：IDCardType.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月25日 下午1:57:50 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：IDCardType 
 * @Description:懒猫存管系统-证件类型
 * @author: William
 * @date：2017年12月25日 下午1:57:50
 * @updateBy：William
 * @updateDate：2017年12月25日 下午1:57:50
 * @remarks：
 */
public enum IDCardType {

	PRC_ID("PRC_ID","身份证"),
	PASSPORT("PASSPORT","护照"),
	COMPATRIOTS_CARD("COMPATRIOTS_CARD","港澳台同胞回乡证"),
	PERMANENT_RESIDENCE("PERMANENT_RESIDENCE","外国人永久居留证"),
	OTHER("OTHER","其它"),
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
	private IDCardType(String code,String desc) {
		this.code=code;
		this.desc=desc;
	}
	
}
