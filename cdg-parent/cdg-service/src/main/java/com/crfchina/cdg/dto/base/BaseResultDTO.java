/**    
 * @Title：BaseResultDTO.java    
 * @Package com.crfchina.cdg.dto.base
 *     
 * @date 2018年1月5日 下午4:07:05 
 * @version V1.0
 */
package com.crfchina.cdg.dto.base;

import java.io.Serializable;

import com.crfchina.cdg.common.enums.common.ResultCode;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：BaseResultDTO 
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午4:07:05
 * @updateBy：William
 * @updateDate：2018年1月5日 下午4:07:05
 * @remarks：
 */
public class BaseResultDTO implements Serializable {
	
	private static final long serialVersionUID = -1412416545350234317L;

	protected ResultCode result;//结果状态
	
	protected String failCode;//失败Code
	
	protected String failReason;//失败原因
	

	public ResultCode getResult() {
		return result;
	}

	public void setResult(ResultCode result) {
		this.result = result;
	}

	public String getFailCode() {
		return failCode;
	}

	public void setFailCode(String failCode) {
		this.failCode = failCode;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
	
}
