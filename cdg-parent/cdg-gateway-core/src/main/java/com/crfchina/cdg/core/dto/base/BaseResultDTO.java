/**    
 * @Title：BaseResultDTO.java    
 * @Package com.crfchina.cdg.core.dto.base
 *     
 * @date 2018年1月9日 下午7:39:26 
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.base;

import java.io.Serializable;

import com.crfchina.cdg.common.enums.common.ResultCode;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * @ClassName：BaseResultDTO 
 * @Description:基础参数返回
 * @author: William
 * @date：2018年1月9日 下午7:39:26
 * @updateBy：William
 * @updateDate：2018年1月9日 下午7:39:26
 * @remarks：
 */
public class BaseResultDTO<T> implements  Serializable{

	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	
	protected String requestRefNo;//请求参考号
	protected ResultCode result;//结果
	protected String failCode;//失败Code
	protected String failReason;//失败原因
	private T data;//业务数据
	
	public BaseResultDTO() {
		
	}
	
	public BaseResultDTO(String requestRefNo,ResultCode result,String failCode,String fainReason) {
		this.requestRefNo = requestRefNo;
		this.result = result;
		this.failCode = failCode;
		this.failReason = fainReason;
	}

	public String getRequestRefNo() {
		return requestRefNo;
	}

	public void setRequestRefNo(String requestRefNo) {
		this.requestRefNo = requestRefNo;
	}

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

}
