/**
 * 
 */
package com.crfchina.cdg.common.exception;

/**
 * @author Administrator
 *
 */
public class LMUnKnowException extends LMException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LMUnKnowException(BIZExceptionCode bizCode, Exception exce) {
		super(bizCode, exce);
	}


}
