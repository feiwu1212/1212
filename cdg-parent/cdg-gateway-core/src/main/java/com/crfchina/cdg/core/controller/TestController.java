/**
 * @Title：
 * @Package com.crfchina.cdg.core.controller
 * @date 2018/1/8 22:43
 * @version V1.0
 */
package com.crfchina.cdg.core.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.crfchina.cdg.common.enums.business.IDCardType;
import com.crfchina.cdg.common.enums.business.Terminal;
import com.crfchina.cdg.common.enums.business.UserAuthType;
import com.crfchina.cdg.common.enums.business.UserRoles;
import com.crfchina.cdg.common.enums.common.SystemNo;
import com.crfchina.cdg.core.dto.param.LmOpenAccountCompanyParamDTO;
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;

import java.util.Arrays;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName：cdg-parent
 * @ClassName：TestController
 * @Description:
 * @author: Administrator
 * @date：2018/1/8 22:43
 * @updateBy：但锐轩
 * @updateDate：2018/1/8 22:43
 * @remarks：
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/toPersonOpen")
	public ModelAndView toPersonOpen() {
		String s = JSONObject.toJSONString(new LmOpenAccountParamDTO(), SerializerFeature.WriteMapNullValue);
		System.out.println(s);
		JSONObject jsonObject = JSON.parseObject(s);
		Set<String> keySet = jsonObject.keySet();
		return new ModelAndView("test").addObject("url", "/cdg-geteway/account/personOpen").addObject("myparam",keySet);
	}
	
	@RequestMapping("/toEnterpriseOpen")
	public ModelAndView toEnterpriseOpen() {
		LmOpenAccountCompanyParamDTO oacParam = new LmOpenAccountCompanyParamDTO();
		oacParam.setBusinessLicense("796678464654"); // 营业执照编号 
		oacParam.setAmount("1000.12");
		oacParam.setBankLicense("13464635443");  
		oacParam.setFailTime("20190101101010");
		oacParam.setIdCardType(IDCardType.PRC_ID);  
		oacParam.setCreditCode("31313464");  
		oacParam.setPlatformUserNo("1213131345");  
		oacParam.setOrgNo("13131312");  
		oacParam.setRequestRefNo("xzxz13131321");  
		oacParam.setContact("4esa21e2");  
		oacParam.setLegal("法人");  
		oacParam.setSystemNo(SystemNo.campaign);  
		oacParam.setNotifyUrl("http://127.0.0.1:8080/cdg-notify/notify/notiryAddr");  
		oacParam.setUnifiedCode("13f1sd2f1sd31");  
		oacParam.setBandCardNo("11212442124634543454");  
		oacParam.setCallbackUrl("http://127.0.0.1:8080/cdg-geteway/callBack/pageCallBack");  
		oacParam.setUserDevice(Terminal.PC);  
		oacParam.setAuthList(Arrays.asList(UserAuthType.COMPENSATORY));  
		oacParam.setContactPhone("13325412365");  
		oacParam.setLegalIdCardNo("612601195108041814");  
		oacParam.setTaxNo("dsfdsrfwe541321");  
		oacParam.setUserRole(UserRoles.INVESTOR);  
		oacParam.setEnterpriseName("企业1231213");  
		oacParam.setBankcode("ABOC");
		String s = JSONObject.toJSONString(oacParam, SerializerFeature.WriteMapNullValue);
		System.out.println(s);
		JSONObject jsonObject = JSON.parseObject(s);
		Set<String> keySet = jsonObject.keySet();
		return new ModelAndView("test").addObject("url", "/cdg-geteway/account/enterpriseOpen").addObject("myparam",keySet);
	}

}
