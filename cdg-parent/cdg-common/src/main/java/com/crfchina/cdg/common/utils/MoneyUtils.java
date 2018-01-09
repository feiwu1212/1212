package com.crfchina.cdg.common.utils;

import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * 金额处理公用类
 * @author ghf
 * @date 2018-01-09
 * @version 1.0
 */
public class MoneyUtils {

	/**
	 * 转变元金额字符串为分单位.
	 * @param money  元单位的金额
	 * @return  分单位的金额
	 */
	public static String toCent(String money) {
		String moneyValue = "0";
		if (money == null || money.equals("")) {
			return moneyValue;
		}
		money = money.trim();
		BigDecimal bigDecimal = new BigDecimal(money);
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		money = bigDecimal.toString();
		StringTokenizer st = new StringTokenizer(money, ".");
		return st.nextToken() + st.nextToken();
	}

	/**
	 * 转变元金额字符串为分单位.
	 * @param money Log  元单位的金额
	 * @return  分单位的金额
	 */
	public static String toCent(Long money) {
		return toCent(money.toString());
	}

	/**
	 * 转变元金额字符串为分单位.
	 * @param BigDecimal money 元单位的金额
	 * @return  分单位的金额
	 */
	public static String toCent(BigDecimal money) {
		money = money.setScale(2, BigDecimal.ROUND_HALF_UP);
		StringTokenizer st = new StringTokenizer(money.toString(), ".");
		return st.nextToken() + st.nextToken();
	}

	/**
	 * 转变元金额字符串为分单位.
	 * @param Double money 元单位的金额
	 * @return  分单位的金额
	 */
	public static String toCent(Double doubleMoney) {
		BigDecimal money = new BigDecimal(doubleMoney);
		money = money.setScale(2, BigDecimal.ROUND_HALF_UP);
		StringTokenizer st = new StringTokenizer(money.toString(), ".");
		return st.nextToken() + st.nextToken();
	}

	/**
	 * 转变分金额字符串为元单位.
	 * @param money String 分单位
	 * @return 元单位的金额
	 */
	public static String toDollar(String money) {
		BigDecimal bigDecimal = new BigDecimal(money);
		bigDecimal = bigDecimal.movePointLeft(2);
		return bigDecimal.toString();
	}

	/**
	 * 转变分金额字符串为元单位
	 * @param money Long 分单位
	 * @return 元单位的金额
	 */
	public static String toDollar(Long money) {
		return toDollar(money.toString());
	}

	/**
	 * 转变分金额字符串为元单位
	 * @param money Integer 分单位
	 * @return 元单位的金额
	 */
	public static String toDollar(Integer txnFee) {
		return toDollar(txnFee.toString());
	}

	/**
	 * 将v精确到小数点后第scale位数
	 * 并四舍五入
	 */
	public static double round(double v, int scale) {
		if (Double.isInfinite(v) || Double.isNaN(v)) {
			v = 0;
		}
		if (scale < 0) {
			scale = 0;
		}
		String vStr = Double.toString(v);
		BigDecimal b = new BigDecimal(vStr);
		BigDecimal one = new BigDecimal("1");

		double result = b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}

	/**
	 * 两个金额对比
	 * 第一个金额小于第二个金额返回-1，大于返回1，等于返回0
	 * @param money1
	 * @param money2
	 * @return
	 */
	public static int compareMoney(String money1, String money2) {
		BigDecimal bigDecimal = new BigDecimal(money1);
		BigDecimal bigDecima2 = new BigDecimal(money2);
		return bigDecimal.compareTo(bigDecima2);
	}

	/**
	 * 把元为单位的金额格式化
	 * @param money
	 * @return 100.00
	 */
	public static String formatMoney(String money) {
		BigDecimal bigDecimal = new BigDecimal(money);
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bigDecimal.toString();
	}

	/**
	 * 去除已分为单位的金额的前置0,反正实际的金额值
	 *  原  000020000000 返回 20000000 
	 * @param money
	 * @return 实际的金额值，已分为单位，如 20000000 
	 */
	public static String trimPrefixZeroMoney(String money) {
		BigDecimal bigDecimal = new BigDecimal(money);
		return bigDecimal.toString();
	}

}
