/**
 * @Title：
 * @Package com.crfchina.cdg.common.utils
 * @date 2018/1/11 14:46
 * @version V1.0
 */
package com.crfchina.cdg.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.common.SignatureAlgorithm;
import com.crfchina.cdg.common.exception.CdgException;
import com.crfchina.cdg.common.exception.CdgExceptionCode;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmHttpUtils
 * @Description: 懒猫直连接口请求工具类
 * @author: Administrator
 * @date：2018/1/11 14:46
 * @updateBy：但锐轩
 * @updateDate：2018/1/11 14:46
 * @remarks：
 */
public class LmHttpUtils {

	public static final Logger logger = LoggerFactory
			.getLogger(LmHttpUtils.class);
	/**
	 * 懒猫直连接口获取结果+验签
	 * @param url
	 * @param formParams
	 * @return
	 */
	public static JSONObject postServiceResult(List<BasicNameValuePair> formParams) throws CdgException {
		AppConfig config = AppConfig.getConfig();
		String url = config.getUrl() + Constants.SERVICE_SUFFIX;
		logger.info("调用懒猫直连接口开始【begin】");
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String result = null;
		// 创建httppost
		HttpPost httppost = new HttpPost(url);
		try {
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(
					formParams, "UTF-8");
			httppost.setEntity(uefEntity);
			response = httpclient.execute(httppost);
			result = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
			verifySign(response, result);
			logger.info("调用懒猫直连接口结束【end】结果:{}", result);
			return JSON.parseObject(result);
		} catch (IOException e) {
			logger.error("调用懒猫接口异常");
			throw new CdgException(CdgExceptionCode.CDG10022, e);
		}
	}

	private static void verifySign(CloseableHttpResponse response, String responseData) throws CdgException {
		AppConfig config = AppConfig.getConfig();
		Map<String, Object> respMap = JSON.parseObject(responseData);
		//接口返回code!=0 || status!=SUCCESS时，不做验签处理
		if( !"0".equals(respMap.get("code")) ||
				!"SUCCESS".equals(respMap.get("status"))) {
			return;
		}
		//校验返回报文
		String returnSign = "";
		Header[] headers = response.getHeaders("sign");
		if (headers != null && headers.length > 0) {
			Header header = headers[0];
			returnSign = header.getValue();
		}

		byte[] keyByte = Base64.decodeBase64(config.getLmPublicKey());
		byte[] signByte = Base64.decodeBase64(returnSign);
		try {
			PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(keyByte);

			boolean b = SignatureUtils.verify(SignatureAlgorithm.SHA1WithRSA, publicKey, responseData, signByte);
			if (!b) {
				logger.info("验签数据不一致--->{}", responseData);
				throw new CdgException(CdgExceptionCode.CDG10021);
			}

			logger.info("sign success ...");
		} catch (GeneralSecurityException | UnsupportedEncodingException e) {
			throw new CdgException(CdgExceptionCode.CDG10021, e);
		}
	}
}
