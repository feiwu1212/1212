/**
 * @Title：
 * @Package com.crfchina.cdg.core.impl
 * @date 2018/1/9 15:09
 * @version V1.0
 */
package com.crfchina.cdg.core.impl;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmBindCardFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmBindCardListMapper;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfoExample;
import com.crfchina.cdg.basedb.entity.LmBindCardList;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.common.EnumsDBMap;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.utils.SignatureUtils;
import com.crfchina.cdg.core.dto.base.CallBackParam;
import com.crfchina.cdg.core.dto.base.LmGatewayPageCallbackResult;
import com.crfchina.cdg.core.service.LmCallBackService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmCallBackServiceImpl
 * @Description:
 * @author: Administrator
 * @date：2018/1/9 15:09
 * @updateBy：但锐轩
 * @updateDate：2018/1/9 15:09
 * @remarks：
 */
@Service
public class LmCallBackServiceImpl implements LmCallBackService {

	@Autowired
	LmBindCardFlowinfoMapper lmBindCardFlowinfoMapper;

	@Autowired
	LmBindCardListMapper lmBindCardListMapper;

	@Override
	public ModelAndView dealCallBack(LmGatewayPageCallbackResult result) {
		//验签
		boolean verify = SignatureUtils.checkSign(result.getSign(), result.getRespData().toJSONString());
		if (verify) {
			ApiType apiType = ApiType.valueOf(result.getServiceName());
			if (apiType.equals(ApiType.PERSONAL_REGISTER_EXPAND)) {
				return dealPersonOpenAccount(result.getRespData());
			}
		} else {
			System.out.println("验签不通过");
		}

		return null;
	}

	private ModelAndView dealPersonOpenAccount(JSONObject respData) {
		Date now = new Date();
		String fcpTrxNo = respData.getString("requestNo");
		String code = respData.getString("code");
		String status = respData.getString("status");
		LmBindCardFlowinfoExample example = new LmBindCardFlowinfoExample();
		example.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmBindCardFlowinfo> flowInfoList = lmBindCardFlowinfoMapper.selectByExample(example);
		if (flowInfoList != null || flowInfoList.size() == 1) {
			LmBindCardFlowinfo flow = flowInfoList.get(0);
			if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
				flow.setUserRealName(respData.getString("realName"));
				flow.setIdType(EnumsDBMap.ID_CARD_TYPE_MAP.get(respData.getString("idCardType"))); // idCardType
				flow.setUserRole(respData.getString("userRole"));
				flow.setIdNo(respData.getString("idCardNo"));
				flow.setMobile(respData.getString("mobile"));
				flow.setBankcardNo(respData.getString("bankcardNo"));
				//FIXME 取库映射
				flow.setBankCode(""); //bankcode
				flow.setAccessType(EnumsDBMap.ACCESS_TYPE_MAP.get(respData.getString("accessType"))); // AuthenticationType
				flow.setAuditStatus(EnumsDBMap.AUDIT_STATUS_MAP.get(respData.getString("auditStatus"))); // AuditStatus
				flow.setResult(ResultCode.SUCCESS.getCode());
				flow.setUpdateTime(now);
				lmBindCardFlowinfoMapper.updateByPrimaryKey(flow);

				LmBindCardList lmBindCardList = new LmBindCardList();
				BeanUtils.copyProperties(flow, lmBindCardList);
				lmBindCardList.setCreateTime(now);
				lmBindCardList.setUpdateTime(now);
				lmBindCardListMapper.insert(lmBindCardList);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.SUCCESS.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				callBackParam.setData(respData.toJSONString());
				return new ModelAndView("callback").addObject("url", flow.getCallbackUrl()).addObject("param", callBackParam);
			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmBindCardFlowinfoMapper.updateByPrimaryKey(flow);

				CallBackParam callBackParam = new CallBackParam();
				callBackParam.setResult(ResultCode.FAIL.getCode());
				callBackParam.setRequestRefNo(flow.getRequestRefNo());
				callBackParam.setFailCode(respData.getString("errorCode"));
				callBackParam.setFailReason(respData.getString("errorMessage"));
				return new ModelAndView("callback").addObject("param", callBackParam);
			}
		} else {
			//TODO 根据流水号查询流水信息有误返回
			return null;
		}
	}
}
