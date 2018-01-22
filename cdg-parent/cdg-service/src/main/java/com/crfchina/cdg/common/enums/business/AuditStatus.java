/**    
 * @Title：AuditStatus.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月25日 下午3:52:50 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：AuditStatus 
 * @Description:懒猫存管系统-审核状态
 * @author: William
 * @date：2017年12月25日 下午3:52:50
 * @updateBy：William
 * @updateDate：2017年12月25日 下午3:52:50
 * @remarks：
 */
public enum AuditStatus {
	
	AUDIT("AUDIT","审核中"),
	PASSED("PASSED","审核通过"),
	BACK("BACK","审核回退"),
	REFUSED("REFUSED","审核拒绝"),
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


	private AuditStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
