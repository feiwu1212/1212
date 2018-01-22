/**
 * @Title：
 * @Package com.crfchina.cdg.common.enums.common
 * @date 2018/1/9 16:51
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName：cdg-parent
 * @ClassName：EnumsDBMap
 * @Description:
 * @author: Administrator
 * @date：2018/1/9 16:51
 * @updateBy：但锐轩
 * @updateDate：2018/1/9 16:51
 * @remarks：
 */
public class EnumsDBMap {

	/**
	 * 身份证枚举key--db映射
	 */
	public static Map<String, Integer> ID_CARD_TYPE_MAP = new HashMap<String, Integer>() {
		{
			put("PRC_ID", 1);
			put("PASSPORT", 2);
			put("COMPATRIOTS_CARD", 3);
			put("PERMANENT_RESIDENCE", 4);
		}
	};

	/**
	 * 鉴权通过类型枚举key--db映射
	 */
	public static Map<String, Integer> ACCESS_TYPE_MAP = new HashMap<String, Integer>() {
		{
			put("FULL_CHECKED", 1);
			put("NOT_AUTH", 2);
			put("AUDIT_AUTH", 3);
			put("PART_CHECKED ", 4);
		}
	};

	/**
	 * 鉴权通过类型枚举key--db映射
	 */
	public static Map<String, Integer> AUDIT_STATUS_MAP = new HashMap<String, Integer>() {
		{
			put("AUDIT", 1);
			put("PASSED", 2);
			put("BACK", 3);
			put("REFUSED ", 4);
		}
	};

	/**
	 * 标的类型枚举key--db映射
	 */
	public static Map<String, Integer> PROJECT_TYPE_MAP = new HashMap<String, Integer>() {
		{
			put("STANDARDPOWDER", 1);
			put("ENTRUST_PAY", 2);
		}
	};

	/**
	 * 还款方式枚举key--db映射
	 */
	public static Map<String, Integer> REPAYMENT_WAY = new HashMap<String, Integer>() {
		{
			put("ONE_TIME_SERVICING", 1);
			put("FIRSEINTREST_LASTPRICIPAL", 2);
			put("FIXED_PAYMENT_MORTGAGE",3);
			put("FIXED_BASIS_MORTGAGE",4);
		}
	};
	/**
	 * 标的状态枚举key--db映射ProjectStatus
	 */
	public static Map<String, Integer> PROJECT_STATUS = new HashMap<String, Integer>() {
		{
			put("COLLECTING", 1);
			put("REPAYING", 2);
			put("FINISH",3);
			put("MISCARRY",4);
		}
	};

	/**
	 * 绑定类型枚举key--db映射
	 */
	public static Map<String, Integer> BIND_TYPE_MAP = new HashMap<String, Integer>() {
		{
			put("UPDATE_BANKCARD", 1);
		}
	};

	/**
	 * 操作类型枚举key--db映射
	 */
	public static Map<String, Integer> OPER_TYPE_MAP = new HashMap<String, Integer>() {
		{
			put("ACTIVATE_STOCKED_USER", 1);
			put("RESET_PASSWORD", 2);
			put("CHECK_PASSWORD", 3);
			put("UNFREEZE_TRADE_PASSWORD", 4);
		}
	};

	/**
	 * 鉴权类型枚举key--db映射
	 */
	public static Map<String, Integer> CHECK_TYPE_MAP = new HashMap<String, Integer>() {
		{
			put("LIMIT", 1);
		}
	};

	/**
	 * 验证身份唯一性，枚举key--db映射
	 */
	public static Map<String, Integer> USER_LIMIT_TYPE_MAP = new HashMap<String, Integer>() {
		{
			put("ID_CARD_NO_UNIQUE", 1);
		}
	};

	/**
	 * 受托方类型 ENTRUSTED_TYPE
	 */
	public static Map<String, Integer> ENTRUSTED_TYPE = new HashMap<String, Integer>() {
		{
			put("PERSONAL", 1);
			put("ENTERPRISE", 2);
		}
	};

	public static Map<String, String>  TRADE_TYPE_MAP = new HashMap<String, String>() {
		{
			put("TENDER", "FKHB");
			put("REPAYMENT", "HKHB");
		}
	};
}
