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
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
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

}
