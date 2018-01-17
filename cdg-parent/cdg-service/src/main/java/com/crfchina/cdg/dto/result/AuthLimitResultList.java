/**    
 * @Title：AuthLimitResultList.java    
 * @Package com.crfchina.cdg.dto.result
 *     
 * @date 2018年1月17日 上午10:37:56 
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：AuthLimitResultList 
 * @Description:
 * @author: ghf
 * @date：2018年1月17日 上午10:37:56
 * @updateBy：ghf
 * @updateDate：2018年1月17日 上午10:37:56
 * @remarks：
 */
public class AuthLimitResultList {
   
	  protected String amount;
	  protected String failTime;
	  protected String authType;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getFailTime() {
		return failTime;
	}
	public void setFailTime(String failTime) {
		this.failTime = failTime;
	}
	public String getAuthType() {
		return authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	  
	  
	  
}
