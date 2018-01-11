package com.crfchina.cdg.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.enums.common.SignatureAlgorithm;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.message.BasicNameValuePair;
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

	private static final DateFormat format = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	/**
	 * 生成参数<br>
	 * 签名加密
	 */
	public static Map<String, String> createPostParam(String serviceName,
			Map<String, Object> reqDataMap) throws GeneralSecurityException {
		Map<String, String> result = new HashMap<String, String>();

		AppConfig config = AppConfig.getConfig();
		String privateStr = config.getPrivateKey();
		reqDataMap.put("timestamp", format.format(new Date()));
		String reqData = JSON.toJSONString(reqDataMap);
		logger.info("请求服务:"+serviceName+",请求参数reqData:" + reqData);
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

	public static List<BasicNameValuePair> createServicePostParam(String serviceName, Map<String, Object> reqDataMap) throws Exception{
		logger.info("拼接懒猫请求参数开始【begin】serviceName={};reqDataMap={}", serviceName, JSONObject.toJSONString(reqDataMap));
		try {
			List<BasicNameValuePair> result = new LinkedList<>();
			AppConfig config = AppConfig.getConfig();
			reqDataMap.put("timestamp", format.format(new Date()));
			String reqDataStr = JSONObject.toJSONString(reqDataMap);
			//参数加密
			String privateStr = config.getPrivateKey();
			PrivateKey privateKey = SignatureUtils.getRsaPkcs8PrivateKey(Base64
					.decodeBase64(privateStr));
			byte[] sign = SignatureUtils.sign(SignatureAlgorithm.SHA1WithRSA,
					privateKey, reqDataStr);
			BasicNameValuePair bn2 = new BasicNameValuePair("serviceName",serviceName);
			BasicNameValuePair bn5 = new BasicNameValuePair("platformNo",config.getPlatformNo());
			BasicNameValuePair bn3 = new BasicNameValuePair("reqData",reqDataStr);
			BasicNameValuePair bn = new BasicNameValuePair("keySerial",config.getKeySerial());
			BasicNameValuePair bn4 = new BasicNameValuePair("sign",Base64.encodeBase64String(sign));
			result.add(bn2);
			result.add(bn5);
			result.add(bn3);
			result.add(bn);
			result.add(bn4);
			return result;
		}catch (Exception e) {
			logger.error("拼接懒猫请求参数异常", e);
			throw e;
		}
	}
}
