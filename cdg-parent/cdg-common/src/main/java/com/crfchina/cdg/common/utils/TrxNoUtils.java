package com.crfchina.cdg.common.utils;

import com.crfchina.cdg.common.constants.Constants;

public class TrxNoUtils {

	public static String getTrxNo(String serviceType) {
		StringBuilder builder = new StringBuilder();
		builder.append(Constants.TRX_PERFIX).append(serviceType).append(System.currentTimeMillis()).append(RandomString.getCharAndNumr(6));
		return builder.toString();
	}

	public static void main(String[] args) {
		String oc = TrxNoUtils.getTrxNo("OC");
		System.out.println(oc);
	}
}
