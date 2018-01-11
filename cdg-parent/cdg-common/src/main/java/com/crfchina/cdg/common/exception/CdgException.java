package com.crfchina.cdg.common.exception;

public class CdgException extends RuntimeException {
	
	private static final long serialVersionUID = -1827198664611457387L;
	private String code = "0000";
	private String msg;

	public CdgException(CdgExceptionCode codeMsgMap) {
		super(codeMsgMap.getMsg());
		this.code = codeMsgMap.getCode();
		this.msg = codeMsgMap.getMsg();
	}
	
	public CdgException(CdgExceptionCode codeMsgMap, Throwable cause) {
		super(codeMsgMap.getMsg(),cause);
		this.code = codeMsgMap.getCode();
		this.msg = codeMsgMap.getMsg();
	}
	

	public CdgException() {
		super();
	}
	
	public CdgException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CdgException(String errorCode, String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = errorCode;
	}

	public CdgException(String message, Throwable cause) {
		super(message, cause);
	}

	public CdgException(String message) {
		super(message);
	}

	public CdgException(String errorCode, String message) {
		super(message);
		this.code = errorCode;
	}

	public CdgException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
