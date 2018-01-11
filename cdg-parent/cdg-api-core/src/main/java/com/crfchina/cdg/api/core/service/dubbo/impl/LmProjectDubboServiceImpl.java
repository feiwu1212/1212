/**
 * @Title：
 * @Package com.crfchina.cdg.api.core.service.dubbo
 * @date 2018/1/8 15:00
 * @version V1.0
 */
package com.crfchina.cdg.api.core.service.dubbo.impl;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.dto.base.BaseParamDTO;
import com.crfchina.cdg.dto.base.BaseResultDTO;
import com.crfchina.cdg.service.LmProjectDubboService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmProjectDubboServiceImpl
 * @Description:
 * @author: Administrator
 * @date：2018/1/8 15:00
 * @updateBy：但锐轩
 * @updateDate：2018/1/8 15:00
 * @remarks：
 */
@Service("lmProjectDubboService")
public class LmProjectDubboServiceImpl implements LmProjectDubboService {

	@Override
	public BaseResultDTO test(BaseParamDTO dto) {
		System.out.println(JSONObject.toJSONString(dto));
		BaseResultDTO baseResultDTO = new BaseResultDTO();
		baseResultDTO.setResult(ResultCode.SUCCESS);
		baseResultDTO.setFailCode("11");
		baseResultDTO.setFailReason("测试");
		return baseResultDTO;
	}
}
