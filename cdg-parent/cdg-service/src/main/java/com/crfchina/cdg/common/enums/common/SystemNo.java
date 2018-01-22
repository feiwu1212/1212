/**
 * @Title：
 * @Package com.crfchina.cdg.common.enums.common
 * @date 2018/1/8 10:56
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.common;

/**
 * @ProjectName：cdg-parent
 * @ClassName：SystemNo
 * @Description:
 * @author: Administrator
 * @date：2018/1/8 10:56
 * @updateBy：但锐轩
 * @updateDate：2018/1/8 10:56
 * @remarks：
 */
/**
 * 信而富内部系统编号
 *
 * @author dennis
 *
 */
public enum SystemNo {
	/** 网站后台 */
	website(1),
	/** 分期app */
	fqapp(2),
	/** 信而富现金贷 */
	crfxjd(3),
	/** 资金系统 */
	fts(6),
	/** 资金通道 */
	fcp(7),
	/** QQ现金贷 */
	qqxjd(8),
	/** 循环贷 */
	rcs(31),
	/** 线下贷款系统 */
	offlineLoan(32),
	/** 通融小贷 */
	trxd(81),
	/** 营销活动系统 */
	campaign(5),
	/** 广州小贷 */
	gzxd(82)
	;

	private int value;

	private SystemNo(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public SystemNo getSystemNo(int code) {
		for (SystemNo s: SystemNo.values()) {
			if (s.getValue() == code) {
				return s;
			}
		}
		return null;
	}
}
