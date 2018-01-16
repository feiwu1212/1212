/**
 * 
 */
package com.crfchina.cdg.common.exception;

/**
 * @author Administrator
 *
 */
public enum CdgExceptionCode{
	
	SUCCESS("0000","成功"),
	CDG10021("CDG10021", "返回验证签名失败"),
	CDG10022("CDG10022", "调用懒猫接口异常");
	
	private String msg;

	private String code;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private CdgExceptionCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
}
