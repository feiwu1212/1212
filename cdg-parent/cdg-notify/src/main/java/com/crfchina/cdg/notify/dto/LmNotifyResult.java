/**
 * @Title：
 * @Package com.crfchina.cdg.core.dto.base
 * @date 2018/1/9 14:55
 * @version V1.0
 */
package com.crfchina.cdg.notify.dto;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.enums.business.Terminal;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmGatewayPageCallbackResult
 * @Description: 懒猫网关接口统一返回
 * @author: Administrator
 * @date：2018/1/9 14:55
 * @updateBy：但锐轩
 * @updateDate：2018/1/9 14:55
 * @remarks：
 */
public class LmNotifyResult {

	String serviceName; // 接口名称

	String platformNo; // 平台编号

	Terminal userDevice; // 用户终端设备类型

	JSONObject respData; // 业务数据报文

	String keySerial;

	String sign;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPlatformNo() {
		return platformNo;
	}

	public void setPlatformNo(String platformNo) {
		this.platformNo = platformNo;
	}

	public String getKeySerial() {
		return keySerial;
	}

	public void setKeySerial(String keySerial) {
		this.keySerial = keySerial;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Terminal getUserDevice() {
		return userDevice;
	}

	public void setUserDevice(Terminal userDevice) {
		this.userDevice = userDevice;
	}

	public JSONObject getRespData() {
		return respData;
	}

	public void setRespData(JSONObject respData) {
		this.respData = respData;
	}
}
