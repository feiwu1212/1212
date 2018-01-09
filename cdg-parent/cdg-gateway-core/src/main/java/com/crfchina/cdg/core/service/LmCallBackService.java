/**
 * @Title：
 * @Package com.crfchina.cdg.core.service
 * @date 2018/1/9 15:06
 * @version V1.0
 */
package com.crfchina.cdg.core.service;

import com.crfchina.cdg.core.dto.base.LmGatewayPageCallbackResult;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName：cdg-parent
 * @ClassName：CallBackService
 * @Description:
 * @author: Administrator
 * @date：2018/1/9 15:06
 * @updateBy：但锐轩
 * @updateDate：2018/1/9 15:06
 * @remarks：
 */
public interface LmCallBackService {

	ModelAndView dealCallBack(LmGatewayPageCallbackResult result);
}
