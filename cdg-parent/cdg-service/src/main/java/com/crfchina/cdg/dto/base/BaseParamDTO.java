/**    
 * @Title：BaseParamDTO.java    
 * @Package com.crfchina.cdg.dto.base
 *     
 * @date 2018年1月5日 下午3:38:13 
 * @version V1.0
 */
package com.crfchina.cdg.dto.base;


import com.crfchina.csf.enums.SystemNo;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ProjectName：cdg-service
 * @ClassName：BaseParamDTO 
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午3:38:13
 * @updateBy：William
 * @updateDate：2018年1月5日 下午3:38:13
 * @remarks：
 */
public class BaseParamDTO implements Serializable{
	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	private SystemNo systemNo;//系统编号
	private String requestRefNo;//请求参考号
	protected Date requestTime;//请求时间
	
	public SystemNo getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(SystemNo systemNo) {
		this.systemNo = systemNo;
	}
	public String getRequestRefNo() {
		return requestRefNo;
	}
	public void setRequestRefNo(String requestRefNo) {
		this.requestRefNo = requestRefNo;
	}
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	
	
	
}
