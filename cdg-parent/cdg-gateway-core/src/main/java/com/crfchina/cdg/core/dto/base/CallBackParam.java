/**
 * @Title：
 * @Package com.crfchina.cdg.core.dto.base
 * @date 2018/1/9 17:24
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.base;

/**
 * @ProjectName：cdg-parent
 * @ClassName：CallBackResult
 * @Description: 回调上层业务系统参数
 * @author: Administrator
 * @date：2018/1/9 17:24
 * @updateBy：但锐轩
 * @updateDate：2018/1/9 17:24
 * @remarks：
 */
public class CallBackParam {

	/**
	 * 请求参考号
	 */
	String requestRefNo;

	/**
	 * 返回结果码
	 */
	String result;

	/**
	 * 失败code
	 */
	String failCode;

	/**
	 * 失败原因
	 */
	String failReason;

	/**
	 * 业务数据（JSON格式）
	 */
	String data;

	public String getRequestRefNo() {
		return requestRefNo;
	}

	public void setRequestRefNo(String requestRefNo) {
		this.requestRefNo = requestRefNo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
