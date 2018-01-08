/**
 * 
 */
package com.crfchina.cdg.common.exception;

/**
 * @author Administrator
 *
 */
public enum BIZExceptionCode{
	
	SUCCESS("0000","成功");
	
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

	private BIZExceptionCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
}
