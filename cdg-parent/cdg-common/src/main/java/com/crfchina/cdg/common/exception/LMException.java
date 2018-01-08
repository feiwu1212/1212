/**
 * 
 */
package com.crfchina.cdg.common.exception;

/**
 * @author William
 *
 */
public class LMException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LMException(BIZExceptionCode bizCode,Exception exce) {
		super(bizCode.getMsg(), exce);
	}
}
