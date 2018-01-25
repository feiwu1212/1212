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
import com.crfchina.cdg.common.enums.business.PayMode;
import com.crfchina.cdg.common.enums.business.Terminal;
import com.crfchina.cdg.common.enums.business.UserAuthType;
import com.crfchina.cdg.common.enums.business.UserRoles;
import com.crfchina.cdg.common.enums.common.SystemNo;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.core.dto.param.LmOpenAccountCompanyParamDTO;
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
import com.crfchina.cdg.core.dto.param.LmRechargeParamDTO;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
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
		LmOpenAccountParamDTO loapDto = new LmOpenAccountParamDTO();
		loapDto.setSystemNo(SystemNo.crfxjd);
		loapDto.setRequestRefNo(DateUtils.dateToString(new Date(), "yyyyMMddHHmmss"));
		loapDto.setPlatformUserNo("CRF" + DateUtils.dateToString(new Date(), "yyyyMMddHHmmss"));
		loapDto.setCallbackUrl("http://baidu.com");
		loapDto.setNotifyUrl("http://baidu.com");
		loapDto.setRealName("但锐轩" + DateUtils.dateToString(new Date(), "yyyyMMddHHmmss"));
		loapDto.setIdCardNo("650102199106220731");
		loapDto.setMobile("18168408959");
		loapDto.setBankCardNo("6217002180000447799");
		loapDto.setIdCardType(IDCardType.PRC_ID);
		loapDto.setUserRole(UserRoles.INVESTOR);
		List<UserAuthType> authTypeList = new LinkedList<>();
		authTypeList.add(UserAuthType.TENDER);
		loapDto.setAuthList(authTypeList);
		loapDto.setFailTime("20181231");
		loapDto.setAuthAmount("9999999");
		loapDto.setUserDevice(Terminal.PC);
		String s = JSONObject.toJSONString(loapDto, SerializerFeature.WriteMapNullValue);
		JSONObject jsonObject = JSON.parseObject(s);
		return new ModelAndView("test").addObject("url", "/cdg-gateway/account/personOpen").addObject("myparam", jsonObject);
	}
	
	@RequestMapping("/toEnterpriseOpen")
	public ModelAndView toEnterpriseOpen() {
		LmOpenAccountCompanyParamDTO oacParam = new LmOpenAccountCompanyParamDTO();
		oacParam.setBusinessLicense("796678464654"); // 营业执照编号 
		oacParam.setAuthAmount("1000.12");
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
		oacParam.setBankCardNo("11212442124634543454");
		oacParam.setCallbackUrl("http://127.0.0.1:8080/cdg-gateway/callBack/pageCallBack");  
		oacParam.setUserDevice(Terminal.PC);  
		oacParam.setAuthList(Arrays.asList(UserAuthType.COMPENSATORY));  
		oacParam.setContactPhone("13325412365");  
		oacParam.setLegalIdCardNo("612601195108041814");  
		oacParam.setTaxNo("dsfdsrfwe541321");  
		oacParam.setUserRole(UserRoles.INVESTOR);  
		oacParam.setEnterpriseName("企业1231213");  
		oacParam.setBankCode("ABOC");
		String s = JSONObject.toJSONString(oacParam, SerializerFeature.WriteMapNullValue);
		System.out.println(s);
		JSONObject jsonObject = JSON.parseObject(s);
		return new ModelAndView("test").addObject("url", "/cdg-gateway/account/enterpriseOpen").addObject("myparam",jsonObject);
	}

	@RequestMapping("/toRecharge")
	public ModelAndView toRecharge() {
		LmRechargeParamDTO rp = new LmRechargeParamDTO();
		rp.setSystemNo(SystemNo.crfxjd);
		rp.setRequestRefNo(DateUtils.dateToString(new Date(), "yyyyMMddHHmmss"));
		rp.setPlatformUserNo("CRF20180111162517");
		rp.setCallbackUrl("http://baidu.com");
		rp.setNotifyUrl("http://baidu.com");
		rp.setUserDevice(Terminal.PC);
		rp.setAmount(200000L);
		rp.setCommissionAmount(100L);
		rp.setRechargeWay(PayMode.SWIFT);
		rp.setBankCode("PCBC");
		String s = JSONObject.toJSONString(rp, SerializerFeature.WriteMapNullValue);
		System.out.println(s);
		JSONObject jsonObject = JSON.parseObject(s);
		return new ModelAndView("test").addObject("url", "/cdg-gateway/ca/recharge").addObject("myparam",jsonObject);
	}
}
