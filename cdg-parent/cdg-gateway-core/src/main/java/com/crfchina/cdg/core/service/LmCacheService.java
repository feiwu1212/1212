/**
 * 
 */
package com.crfchina.cdg.core.service;


/**
 * @author ghf
 *
 */
public interface LmCacheService {

	
	String getLmBankCode(String bankCode);
	
	String getSysPubKey(String sysNo);
	
	String getSysPriKey(String sysNo);
	
	String getSysSand(String sysNo);
	
}
