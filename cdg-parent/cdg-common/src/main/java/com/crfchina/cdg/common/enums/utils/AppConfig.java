package com.crfchina.cdg.common.enums.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Iren08
 * @date 2017年3月8日 下午1:17:25
 * @version 1.0
 */
public final class AppConfig {

	private static final Logger logger = LoggerFactory
			.getLogger(AppConfig.class);

	private static final String FILE_NAME = "lanmao.properties";

	private static AppConfig sdkConfig = null;

	/**
	 * 请求地址
	 */
	private String url;

	/**
	 * 平台编好
	 */
	private String platformNo;

	/**
	 * 证书编号
	 */
	private String keySerial;

	/**
	 * 平台私钥
	 */
	private String privateKey;
	
	/**
	 * 平台公钥
	 */
	private String publicKey;
	
	/**
	 * 懒猫私钥
	 */
	private String lmPrivateKey;
	
	/**
	 * 懒猫公钥
	 */
	private String lmPublicKey;

	private int connectionTimeout;

	private int readTimeout;

	private AppConfig() {
		this.loadPropertiesFromSrc();
	}

	public static AppConfig getConfig() {
		synchronized (AppConfig.class) {
			if (null == sdkConfig) {
				sdkConfig = new AppConfig();
			}
			return sdkConfig;
		}
	}

	private void loadPropertiesFromSrc() {
		InputStream in = null;
		try {
			Properties properties = null;
			logger.info("从classpath: "
					+ AppConfig.class.getClassLoader().getResource("")
							.getPath() + " 获取属性文件" + FILE_NAME);
			in = AppConfig.class.getClassLoader()
					.getResourceAsStream(FILE_NAME);
			if (null != in) {
				BufferedReader bf = new BufferedReader(new InputStreamReader(
						in, "utf-8"));
				properties = new Properties();
				try {
					properties.load(bf);
				} catch (IOException e) {
					throw e;
				}
			} else {
				logger.error(FILE_NAME
						+ "属性文件未能在classpath指定的目录下 "
						+ AppConfig.class.getClassLoader().getResource("")
								.getPath() + " 找到!");
				return;
			}
			loadProperties(properties);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 根据传入的properties对象设置配置参数
	 * 
	 * @param pro
	 */
	private void loadProperties(Properties pro) {
		logger.info("开始从属性文件中加载配置项");
		String value = null;
		value = pro.getProperty("url");
		if (!StringUtils.isEmpty(value)) {
			this.url = value.trim();
		}
		value = pro.getProperty("platformNo");
		if (!StringUtils.isEmpty(value)) {
			this.platformNo = value.trim();
		}
		value = pro.getProperty("keySerial");
		if (!StringUtils.isEmpty(value)) {
			this.keySerial = value.trim();
		}
		value = pro.getProperty("privateKey");
		if (!StringUtils.isEmpty(value)) {
			this.privateKey = value.trim();
		}
		value = pro.getProperty("publicKey");
		if (!StringUtils.isEmpty(value)) {
			this.publicKey = value.trim();
		}
		value = pro.getProperty("lmPrivateKey");
		if (!StringUtils.isEmpty(value)) {
			this.lmPrivateKey = value.trim();
		}
		value = pro.getProperty("lmPublicKey");
		if (!StringUtils.isEmpty(value)) {
			this.lmPublicKey = value.trim();
		}
		value = pro.getProperty("connectionTimeout");
		if (!StringUtils.isEmpty(value)) {
			this.connectionTimeout = Integer.valueOf(value.trim());
		}
		value = pro.getProperty("readTimeout");
		if (!StringUtils.isEmpty(value)) {
			this.readTimeout = Integer.valueOf(value.trim());
		}

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getLmPrivateKey() {
		return lmPrivateKey;
	}

	public void setLmPrivateKey(String lmPrivateKey) {
		this.lmPrivateKey = lmPrivateKey;
	}

	public String getLmPublicKey() {
		return lmPublicKey;
	}

	public void setLmPublicKey(String lmPublicKey) {
		this.lmPublicKey = lmPublicKey;
	}
}
