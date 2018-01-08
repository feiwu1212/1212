/**    
 * @Title：PayCompany.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月28日 下午3:20:30 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.business;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：PayCompany 
 * @Description:
 * @author: William
 * @date：2017年12月28日 下午3:20:30
 * @updateBy：William
 * @updateDate：2017年12月28日 下午3:20:30
 * @remarks：
 */
public enum PayCompany {
	
	YEEPAY("YEEPAY","易宝支付"),
	FUIOU("FUIOU","富友支付"),
	ALLINPAY("ALLINPAY","通联支付"),
	UCFPAY("UCFPAY","先锋支付"),
	BAOFOO("BAOFOO","宝付"),
	REAPAL("REAPAL","融宝支付"),
	BILL99("BILL99","快钱支付"),
	LIANLIAN("LIANLIAN","连连支付"),
	SUMAPAY("SUMAPAY","丰付"),
	NEWPAY("NEWPAY","新生支付"),
	BFBPAY("BFBPAY","邦付宝"),
	CHINAGPAY("CHINAGPAY","爱农"),
	GOPAY("GOPAY","国付宝"),
	UMPAY("UMPAY","联动优势"),
	TFTPAY("TFTPAY","腾付通"),
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


	private PayCompany(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
