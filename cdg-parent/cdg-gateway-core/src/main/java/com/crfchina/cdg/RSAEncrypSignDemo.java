/**    
 * @Title：RSAEncrypSignDemo.java    
 * @Package com.crfchina.cdg.common.demo
 *     
 * @date 2018年1月19日 下午6:25:07 
 * @version V1.0
 */
package com.crfchina.cdg;

import rsautil.RSAUtils;

/**    
 * 
 * @ProjectName：cdg-common
 * @ClassName：RSAEncrypSignDemo 
 * @Description:
 * @author: William
 * @date：2018年1月19日 下午6:25:07
 * @updateBy：William
 * @updateDate：2018年1月19日 下午6:25:07
 * @remarks：
 */
public class RSAEncrypSignDemo {
	
	//系统编号
	public static String systemNo="rcs";
	
	//公钥(提供给每个业务系统)
	public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCZLNwrm1wbdfDYpP21+zDaccJKdLH76WpBNQMe9O4h7QqTeSQeF/HLa1v+pJyC4k7sCa51WNOlMnO/z71nxZDZFgkeAOknbyBmGIkxlm7DdYWKU52w3viG2YdvmN9kaXQPExzFHvIT1RdxES8aPx4gSmtAveBjD7Z7ugfeQ3B3VQIDAQAB";

	//私钥(CDG保存)
	public static String privateKey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJks3CubXBt18Nik/bX7MNpxwkp0sfvpakE1Ax707iHtCpN5JB4X8ctrW/6knILiTuwJrnVY06Uyc7/PvWfFkNkWCR4A6SdvIGYYiTGWbsN1hYpTnbDe+IbZh2+Y32RpdA8THMUe8hPVF3ERLxo/HiBKa0C94GMPtnu6B95DcHdVAgMBAAECgYAR8patqVuGgDBDQjnUG+WigtfQH5JHQRdJIqwF8Y8BfKPTmcsol4emXSL/WExabafvska1yz2pSpsTa4T25shM6OrrJzuj3i+C3EpxVEq5VnNn61VLuL9M72SmUN2TY2dIZt//m0+CD/MYTbNiG5PTZvyYuHIsT5OfWYpl9jRzwQJBANQvkONqce9Pb+wDJ6tP35KvMXPue2eIjpE2qHGeibLGBfGb/8Phk2c2QpbAPLTkLbJLSPb4KgEdHVABSCrAYxECQQC4zen9Kg+u+fcltmyj4FPlFFfIRjF/eJThN0jJT7bo3S5/RL8+n6Qm5gHQBXVC0bwX6ID1yI9o8khn5og1NggFAkEAj5fNBonfpuLsTBzqeJ2qIHtdDSaj7rHUQWNq5NE0QH6QQSygDrCWb2+h6qEXtBcC8bjPHQteabiJQL5NV1kw8QJAf28+0xyWBArKqm7JK5gdQfJtNeVxbH0x7Lu6rVcSwjEDRy+Y0Q40m74vscqRuan3EmV5yAKtIakw1LTbaBYCIQJAOkikdErdanmtScJOHZG35k5h4v05WUNGedzRVzanriQ8yrEu/HR9ARN0F4OQvJxJOCijJrFpkJFdUTksaPElgw==";

	//沙子
	public static String sand = "gkeAOknbyBmGIkxlm7DdYWKU";
	
	public static void main(String[] args) throws Exception{
		
		//-----------------业务系统加密签名Start------------------
		//请求报文转json
		String reqData = "{\"systemNo\": \"rcs\", \"requestRefNo\":\"FTS2180119092019CDTP0019\", \"requestTime\": \"20180119190455\",\"platformUserNo\":\"CRF12302929\" }";
		System.out.println("加密前报文JSON:"+reqData);
		//RSA对请求报文加密
		String encrystr = RSAUtils.encryptByPublicKey(reqData, publicKey);
		System.out.println("加密后字符串:"+encrystr);
		
		//签名字符串拼接(由系统编号+加密后reqData组成)
		String signStr = systemNo+encrystr;
		//签名
		String sign = RSAUtils.getSHA256StrJava(signStr+sand);
		System.out.println("签名字符串："+sign);
		//-----------------业务系统加密签名End------------------
		
		
		
		
		
		//-----------------网关系统验签解密Start------------------
		//验证签名
		String checkSign = RSAUtils.getSHA256StrJava("rcs"+encrystr+sand);
		System.out.println("验签字符串:"+checkSign);
		
		if(sign.equals(checkSign)){
			System.out.println("========验签通过======");
			byte []jiemistr = RSAUtils.decryptByPrivateKey(encrystr, privateKey);
			System.out.println("解密后的字符串:"+new String(jiemistr,"UTF-8"));
		}else {
			System.out.println("========验签失败======");
		}
		//-----------------网关系统验签解密End------------------
		
		
	}

}
