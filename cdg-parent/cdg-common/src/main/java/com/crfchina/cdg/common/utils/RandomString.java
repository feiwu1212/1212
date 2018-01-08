package com.crfchina.cdg.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomString {

	public static void main(String[] args) {
		RandomString rs = new RandomString();
		// System.out.println(rs.getBBContractNo());
		System.out.println(rs.getBBContractNoByHexadecimal());
		System.out.println(getRecommCode("13765421579", 6));
	}

	public String getBBContractNo() {
		String s = "";
		for (int i = 0; i < 10; i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9) {
				s += getRandomInt(9, 0);
			} else {
				s += getRandomChar();
			}
		}
		return s;

	}

	/**
	 * 生成随机10位项目编号供报备到恒丰银行 1 来源标识 A 表示线下P2P合同件 B表示现金贷 5 日期 yyMMdd 的十六进制数值 4 计数器
	 * [0-9A-Z]
	 */
	@SuppressWarnings("static-access")
	public String getBBContractNoByHexadecimal() {
		StringBuffer buf = new StringBuffer("A");// 1位,标识符
		DateFormat df = new SimpleDateFormat("yyMMdd");
		Long date = Long.valueOf(df.format(new Date()));
		buf.append(date.toHexString(date));// 5位 ,(日期转16进制)
		buf.append(RandomString.getCharAndNumr(4));// 4位,随机数
		return buf.toString();

	}

	public char getRandomChar() {
		int i = getRandomInt(122, 65);
		if (i > 90 && i < 97) {
			return getRandomChar();
		} else {
			return (char) i;
		}
	}

	public int getRandomInt(int max, int min) {

		return (int) (Math.random() * (max + 1 - min) + min);
	}

	/**
	 * java生成随机数字和字母组合
	 * 
	 * @param length[生成随机数的长度]
	 * @return
	 */
	public static String getCharAndNumr(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	/**
	 * 
	 * @Title: getRecommCode @Description: 获取推荐码 @param mobilePhone @param
	 *         digit @return String @throws
	 */
	public static String getRecommCode(String mobilePhone, int digit) {
		StringBuffer buf = new StringBuffer(mobilePhone.substring(mobilePhone.length() - 4)); // 手机号后四位
		buf.append(RandomString.getCharAndNumr(digit)); // 六位随机数
		return buf.toString();
	}
	
	/**
	 * 
	 * @Title: getRandomLoginPwd  
	 * @Description: 获取随机登录密码
	 * @param mobilePhone
	 * @param digit
	 * @return
	 * String
	 * @throws
	 */
	public static String getRandomLoginPwd(String mobilePhone, int digit) {
		StringBuffer buf = new StringBuffer(RandomString.getCharAndNumr(digit).toLowerCase()); // 六位随机数
		buf.append(mobilePhone.substring(mobilePhone.length() - 4)); // 手机号后四位
		return buf.toString();
	}
}
