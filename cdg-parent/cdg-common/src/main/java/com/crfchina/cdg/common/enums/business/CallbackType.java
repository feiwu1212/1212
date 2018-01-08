/**    
 * @Title：CallbackType.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月25日 下午1:55:04 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：CallbackType 
 * @Description:懒猫存管系统-回调类型
 * @author: William
 * @date：2017年12月25日 下午1:55:04
 * @updateBy：William
 * @updateDate：2017年12月25日 下午1:55:04
 * @remarks：
 */
public enum CallbackType {
	CALLBACK("CALLBACK","浏览器返回"),
	NOTIFY("NOTIFY","服务端异步通知")	;
	
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


	private CallbackType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
