package com.crfchina.cdg.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.crfchina.cdg.common.constants.Constants;

/** 
 * @ProjectName：cdg-common
 * @ClassName：TrxNoUtils 
 * @Description:交易流水号生成
 * @author: William
 * @date：2018年1月9日 下午8:03:39
 * @updateBy：William
 * @updateDate：2018年1月9日 下午8:03:39
 * @remarks：
 */
public class TrxNoUtils {
	
	public static final DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
	
	public static SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 20);//引用Twitter分布式获取唯一ID策略

	/**
	 * 
	 * @Title: getTrxNo  获取唯一流水号
	 * @param serviceType 业务类型
	 * @param workerId 工作ID (0~31)
     * @param datacenterId 数据中心ID (0~31)
	 * @return
	 * String
	 * @throws
	 */
	public static String getTrxNo(String serviceType) {
		StringBuilder builder = new StringBuilder();
		String currentTime = df.format(new Date());//当前时间
		builder.append(Constants.TRX_PERFIX).append(serviceType).append(currentTime).append(idWorker.nextId());
		return builder.toString();
	}

	public static String getBatchNo() {
		StringBuilder builder = new StringBuilder();
		String currentTime = df.format(new Date());//当前时间
		builder.append(Constants.BATCH_NO_PERFIX).append(currentTime).append(idWorker.nextId());
		return builder.toString();
	}
	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			String oc = TrxNoUtils.getTrxNo("HB");
			System.out.println(oc);
		}
		
	}
}
