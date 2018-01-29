/**
 * @Title：
 * @Package com.crfchina.cdg.notify.util
 * @date 2018/1/29 10:42
 * @version V1.0
 */
package com.crfchina.cdg.notify.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmDateUtils
 * @Description: 懒猫接口数据类型转换工具类
 * @author: Administrator
 * @date：2018/1/29 10:42
 * @updateBy：但锐轩
 * @updateDate：2018/1/29 10:42
 * @remarks：
 */
public class LmDateUtils {

	private static final Logger logger = LoggerFactory
			.getLogger(LmDateUtils.class);

	private static final DateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");

	private static final DateFormat YYYYMMDD = new SimpleDateFormat("YYYYMMDD");

	/**
	 * 获取懒猫date类型数据
	 * @param dateStr
	 * @return
	 */
	public static Date getLmDate(String dateStr) {
		Date date = null;
		try {
			date = YYYYMMDD.parse(dateStr);
		}catch (ParseException e) {
			logger.error("时间转换异常", e);
		}
		return date;
	}

	/**
	 * 获取懒猫time类型数据
	 * @param dateStr
	 * @return
	 */
	public static Date getLmTime(String dateStr) {
		Date date = null;
		try {
			date = YYYYMMDDHHMMSS.parse(dateStr);
		}catch (ParseException e) {
			logger.error("时间转换异常", e);
		}
		return date;
	}
}
