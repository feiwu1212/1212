/**    
 * @Title：SystemBackCode.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月25日 下午3:52:50 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.common;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：SystemBackCode
 * @Description:懒猫存管系统-系统返回Code枚举值
 * @author: William
 * @date：2017年12月25日 下午3:52:50
 * @updateBy：William
 * @updateDate：2017年12月25日 下午3:52:50
 * @remarks：
 */
public enum ResultCode {
	
	ACCEPTED("ACCEPTED","已受理"),
	UNKNOWN("UNKNOWN","未知"),
	SUCCESS("SUCCESS","成功"),
	FAIL("FAIL","失败"),
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


	private ResultCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
