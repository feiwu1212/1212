/**    
 * @Title：AccountProject.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月25日 下午3:52:50 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.common;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：AccountProject
 * @Description:财务科目枚举汇总（用于放款、还款收入拆分各项费用）
 * @author: William
 * @date：2017年12月25日 下午3:52:50
 * @updateBy：William
 * @updateDate：2017年12月25日 下午3:52:50
 * @remarks：
 */
public enum AccountSubject {
	
	
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


	private AccountSubject(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
