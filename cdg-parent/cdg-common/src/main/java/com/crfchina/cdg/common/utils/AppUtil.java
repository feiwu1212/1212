package com.crfchina.cdg.common.utils;

import com.alibaba.fastjson.JSON;
import com.crfchina.cdg.common.enums.common.SignatureAlgorithm;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Iren08
 * @date 2017年3月8日 下午12:51:48
 * @version 1.0
 */
public class AppUtil {

	private final static Logger logger = LoggerFactory.getLogger(AppUtil.class);

	/**
	 * 生成参数<br>
	 * 签名加密
	 */
	public static Map<String, String> createPostParam(String serviceName,
			Map<String, Object> reqDataMap) throws GeneralSecurityException {
		Map<String, String> result = new HashMap<String, String>();

		AppConfig config = AppConfig.getConfig();
		String privateStr = config.getPrivateKey();

		String reqData = JSON.toJSONString(reqDataMap);
		logger.debug("请求参数reqData:" + reqData);
		PrivateKey privateKey = SignatureUtils.getRsaPkcs8PrivateKey(Base64
				.decodeBase64(privateStr));
		byte[] sign = SignatureUtils.sign(SignatureAlgorithm.SHA1WithRSA,
				privateKey, reqData);

		// 拼装网关参数
		result.put("serviceName", serviceName);
		result.put("platformNo", config.getPlatformNo());
		result.put("reqData", reqData);
		result.put("keySerial", config.getKeySerial());
		result.put("sign", Base64.encodeBase64String(sign));

		return result;
	}

}
