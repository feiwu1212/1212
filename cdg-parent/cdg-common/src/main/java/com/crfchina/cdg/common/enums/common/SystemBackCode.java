/**    
 * @Title：SystemBackCode.java    
 * @Package com.crfchina.lanmaoly.common.enums
 *     
 * @date 2017年12月25日 下午3:52:50 
 * @version V1.0
 */
package com.crfchina.cdg.common.enums.common;

/**    
 * 
 * @ProjectName：lanmaoly-common
 * @ClassName：SystemBackCode
 * @Description:懒猫存管系统-系统返回Code枚举值
 * @author: William
 * @date：2017年12月25日 下午3:52:50
 * @updateBy：William
 * @updateDate：2017年12月25日 下午3:52:50
 * @remarks：
 */
public enum SystemBackCode {
	
	SUCCESS("0","调用成功"),
	FAIL("1","调用失败"),
	
	//失败常用错误码表
	ERROR_100001("100001","系统错误"),
	ERROR_100002("100002","json son参数格式错误"),
	ERROR_100003("100003","签名验证失败"),
	ERROR_100004("100004","平台编号不存在"),
	ERROR_100005("100005","平台状态异常"),
	ERROR_100006("100006","业务未开通"),
	ERROR_100007("100007","查询对象不存在"),
	ERROR_100008("100008","业务受理失败"),
	ERROR_100009("100009","用户不存在"),
	ERROR_100010("100010","用户账户不可用"),
	ERROR_100011("100011","该用户无此操作权限"),
	ERROR_100012("100012","非常抱歉，暂不支持此银行"),
	ERROR_100013("100013","请求流水号重复"),
	ERROR_100014("100014","余额不足"),
	ERROR_100015("100015","标的状态与业务不匹配"),
	ERROR_100016("100016","平台垫资 账户可用余额不足，请联系平台处理"),
	ERROR_100017("100017","平台未开通垫资账户，请联系处理"),
	ERROR_100018("100018","当前时间不受理加急对公提现"),
	ERROR_100019("100019","标的类型与业务不匹配"),
	ERROR_100020("100020","交易处理中，请勿重试"),
	;
	
	private String code;
	
	private String desc;

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	private SystemBackCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
