/**
 * @Title：
 * @Package com.crfchina.cdg.notify.util
 * @date 2018/1/22 14:16
 * @version V1.0
 */
package com.crfchina.cdg.notify.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.exception.CdgException;
import com.crfchina.cdg.notify.dto.BaseResultDTO;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.io.IOUtils;
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
 * @ClassName：NotifyUtils
 * @Description:
 * @author: Administrator
 * @date：2018/1/22 14:16
 * @updateBy：但锐轩
 * @updateDate：2018/1/22 14:16
 * @remarks：
 */
public class NotifyUtils {

	private final static Logger logger = LoggerFactory.getLogger(NotifyUtils.class);

	public static List<BasicNameValuePair> createNotifyParam(BaseResultDTO<String> resultDTO) {
		logger.info("拼接异步通知请求参数开始【begin】resultDTO-->{}", JSONObject.toJSONString(resultDTO));
		List<BasicNameValuePair> result = new LinkedList<>();
		BasicNameValuePair bn2 = new BasicNameValuePair("requestRefNo",resultDTO.getRequestRefNo());
		BasicNameValuePair bn5 = new BasicNameValuePair("result",resultDTO.getResult().getCode());
		BasicNameValuePair bn3 = new BasicNameValuePair("failCode",resultDTO.getFailCode());
		BasicNameValuePair bn = new BasicNameValuePair("failReason",resultDTO.getFailReason());
		BasicNameValuePair bn4 = new BasicNameValuePair("data", resultDTO.getData());
		result.add(bn2);
		result.add(bn5);
		result.add(bn3);
		result.add(bn);
		result.add(bn4);
		logger.info("拼接异步通知请求参数结束【end】result-->{}", JSONObject.toJSONString(result));
		return result;
	}

	public static JSONObject httpNotify(List<BasicNameValuePair> param, String url) throws CdgException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		// 创建httppost
		HttpPost httppost = new HttpPost(url);
		try {
			if (null != param) {
				UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(
						param, "UTF-8");
				httppost.setEntity(uefEntity);
			}
			response = httpclient.execute(httppost);
			String result = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
			return JSON.parseObject(result);
		} catch (Exception e) {
			logger.error("通知请求异常", e);
		}
		return null;
	}
}
