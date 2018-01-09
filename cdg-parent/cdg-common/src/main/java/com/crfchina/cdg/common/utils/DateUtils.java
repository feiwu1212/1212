package com.crfchina.cdg.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 时间工具类
 * @author Administrator
 *
 */
public class DateUtils {

	private static Log log = LogFactory.getLog("WEBP2P");

	public final static DateFormat YYYY_MM_DD_MM_HH_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public final static DateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");

	public final static DateFormat YYYYMMDDMMHHSSSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	public final static DateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");

	public static final DateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");

	public final static DateFormat YYYY_MM_DD_HH = new SimpleDateFormat("yyyy-MM-dd HH");

	private static SimpleDateFormat normalDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 将Date转化为对应格式的字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * 时间转换为yyyy-MM-dd HH:mm:ss格式的字符串
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		return YYYY_MM_DD_MM_HH_SS.format(date);
	}

	public static Date strToDate(String dateString){
		Date date = null;
		try {
			date = YYYY_MM_DD_MM_HH_SS.parse(dateString);
		} catch (ParseException e) {
			log.error("时间转换异常",e);
		}
		return date;
	}

	public static Date strToYYMMDDDate(String dateString){
		Date date = null;
		try {
			date = YYYY_MM_DD.parse(dateString);
		} catch (ParseException e) {
			log.error("时间转换异常", e);
		}
		return date;
	}

	/**
	 * 计算两个时间之间相差的天数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long diffDays(Date startDate,Date endDate){
		long days = 0;
		long start = startDate.getTime();
		long end = endDate.getTime();
		//一天的毫秒数1000 * 60 * 60 * 24=86400000
		days = (end - start) / 86400000;
		return days;
	}

	/**
	 * 日期加上月数的时间
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date dateAddMonth(Date date,int month){
		return add(date,Calendar.MONTH,month);
	}

	/**
	 * 日期加上天数的时间
	 * @param date
	 * @return
	 */
	public static Date dateAddDay(Date date,int day){
		return add(date,Calendar.DAY_OF_YEAR,day);
	}

	/**
	 * 日期加上年数的时间
	 * @param date
	 * @param year
	 * @return
	 */
	public static Date dateAddYear(Date date,int year){
		return add(date,Calendar.YEAR,year);
	}

	/**
	 * 计算剩余时间 (多少天多少时多少分)
	 * @return
	 */
	public static String remainDateToString(Date startDate, Date endDate){
		StringBuilder result = new StringBuilder();
		if(endDate == null ){
			return "过期";
		}
		long times = endDate.getTime() - startDate.getTime();
		if(times < -1){
			result.append("过期");
		}else{
			long temp = 1000 * 60 * 60 *24;
			//天数
			long d = times / temp;

			//小时数
			times %= temp;
			temp  /= 24;
			long m = times /temp;
			//分钟数
			times %= temp;
			temp  /= 60;
			long s = times /temp;

			result.append(d);
			result.append("天");
			result.append(m);
			result.append("小时");
			result.append(s);
			result.append("分");
		}
		return result.toString();
	}

	private static Date add(Date date,int type,int value){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, value);
		return calendar.getTime();
	}

	public static Date addHourOnDate(Date date, int hour)
	{
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(11, hour);
		return calendar.getTime();
	}

	/**
	 * @MethodName: getLinkUrl
	 * @Param: DateUtil
	 * flag ： true 转换  false 不转换
	 * @Author: gang.lv
	 * @Date: 2013-5-8 下午02:52:44
	 * @Return:
	 * @Descb:
	 * @Throws:
	 */
	public static String getLinkUrl(boolean flag,String content,String id){
		if(flag){
			content = "<a href='finance.do?id="+id+"'>"+content+"</a>";
		}
		return content;
	}

	/**
	 * 时间转换为时间戳
	 * @param format
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static long getTimeCur(String format,String date) throws ParseException{
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return  sf.parse(sf.format(date)).getTime();
	}
	/**
	 * 时间转换为时间戳
	 * @param format
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static long getTimeCur(String format,Date date) throws ParseException{
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return  sf.parse(sf.format(date)).getTime();
	}

	/**
	 * 将时间戳转为字符串
	 * @param cc_time
	 * @return
	 */
	public static String getStrTime(String cc_time) {
		String re_StrTime = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		long lcc_time = Long.valueOf(cc_time);
		re_StrTime = sdf.format(new Date(lcc_time * 1000L));
		return re_StrTime;
	}

	public static String parseDateFormat(Date date, String formate) {
		try {
			SimpleDateFormat sdf = getSimpleDateFormat(formate);
			return sdf.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	public static SimpleDateFormat getSimpleDateFormat(String format)
			throws Exception {
		try {
			return new SimpleDateFormat(format);
		} catch (Exception ex) {
			return normalDateFormat;
		}
	}
	/**
	 *
	 * <b>描述:获取格式化的日期类型</b>
	 * @param format
	 * @return
	 */
	public static Date getDate(String format){

		try {
			return new SimpleDateFormat(format).parse(new SimpleDateFormat(format).format(new Date()));
		} catch (ParseException e) {
			log.error("获取格式的日期类型异常", e);
		}
		return null;
	}

	/**
	 * 将指定字符串格式转化成日期
	 * @param dateStr
	 * @param formate
	 * @return
	 * @throws Exception
	 */
	public static Date parseStringToDate(String dateStr, String formate) {
		try {
			SimpleDateFormat sdf = getSimpleDateFormat(formate);
			return sdf.parse(dateStr);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将指定日期格式转化成日期
	 * @param dateStr
	 * @param formate
	 * @return
	 * @throws Exception
	 */
	public static Date parseDateToDate(Date dateStr, String formate) throws Exception {
		try {
			SimpleDateFormat sdf = getSimpleDateFormat(formate);
			return sdf.parse(new SimpleDateFormat(formate).format(dateStr));
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 计算时间差 (分钟)
	 * @return
	 */
	public static String minute(Date startDate, Date endDate){
		StringBuilder result = new StringBuilder();
		if(endDate == null ){
			return "过期";
		}

		long times = endDate.getTime() - startDate.getTime();
		if(times < -1){
			result.append("过期");
		}else{
			long temp = 1000 * 60;
			long timeed = endDate.getTime()/temp;
			long timesd = startDate.getTime()/temp;

			result.append(timeed - timesd);
			result.append("分钟");
		}
		return result.toString();
	}

	/**
	 * @功能描述:获取指定格式的字符串
	 * @return
	 * @创建时间 2008-7-26
	 * @author beedoor
	 */
	public static String getFormatDateStr(Object obj, String format)
			throws Exception {
		Date d = null;
		SimpleDateFormat sdf = getSimpleDateFormat(format);
		if (obj instanceof String) {
			d = sdf.parse(obj.toString());
		} else if (obj instanceof Date) {
			d = (Date) obj;

		}
		if (null != d) {
			return sdf.format(d);
		}

		return "";
	}

	/**
	 * 每个月的最后一天
	 * @param dateStr
	 * @return
	 */
	public static int getLastDay(String dateStr) {
		int day = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(dateStr);
			Calendar lastDate = Calendar.getInstance();
			lastDate.setTime(date);
			lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
			lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
			lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

			String str = sdf.format(lastDate.getTime());
			String dayStr = str.substring(8);
			day = new Integer(dayStr).intValue();
		} catch (Exception e) {
			//System.out.println("error:getLastDay()==" + e.getMessage());
			log.error("设置时间出错", e);
		}
		return day;
	}

	/**
	 * 比较2个日期的大小
	 * @param from
	 * @param to
	 * @return
	 */
	public static int compare_date(Date from, Date to) {
		if (from.getTime() > to.getTime()) {
			return 1;
		} else if (from.getTime() < to.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * 计算时间 (多少天)
	 * @return
	 */
	public static String holdDays(Date startDate, Date endDate){
		if(endDate == null ){
			return "0";
		}
		long times = endDate.getTime() - startDate.getTime();
		if(times < -1){
			return "0";
		}else{
			long temp = 1000 * 60 * 60 *24;
			//天数
			long d = times / temp;
			return String.valueOf(d);
		}
	}

	/**
	 * date2比date1多的天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDays(Date date1,Date date2)
	{
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1= cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if(year1 != year2)   //同一年
		{
			int timeDistance = 0 ;
			for(int i = year1 ; i < year2 ; i ++)
			{
				if(i%4==0 && i%100!=0 || i%400==0)    //闰年
				{
					timeDistance += 366;
				}
				else    //不是闰年
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2-day1) ;
		}
		else    //不同年
		{
			return day2-day1;
		}
	}
	public static void main(String[] args) throws Exception {
//		System.out.println(DateUtil.parseDateToDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
//		System.out.println(DateUtil.getDate("yyyy-MM-dd HH:mm:ss"));
//		System.out.println(compare_date(parseStringToDate("2014-05-22","yyyy-MM-dd"), new Date()));
//		System.out.println(parseStringToDate("2014-05-23","yyyy-MM-dd").compareTo(getDate("yyyy-MM-dd")));
//    	System.out.println(parseDateFormat(dateAddDay(parseStringToDate("2014-05-31", "yyyy-MM-dd"), 1), "yyyy-MM-dd"));

//    	System.out.println(differentDays(new Date("1997/01/01 00:00:00"), new Date()));
//    	System.out.println(diffDays(new Date("1997/01/01 00:00:00"), new Date()));
	}
}
