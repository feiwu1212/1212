/**    
 * @Title：ProjectType.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月25日 下午3:52:50 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：ProjectType
 * @Description:懒猫存管系统-标的类型
 * @author: William
 * @date：2017年12月25日 下午3:52:50
 * @updateBy：William
 * @updateDate：2017年12月25日 下午3:52:50
 * @remarks：
 */
public enum ProjectType {
	
	STANDARDPOWDER("STANDARDPOWDER","散标"),
	ENTRUST_PAY("ENTRUST_PAY","委托支付标的"),
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


	private ProjectType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
