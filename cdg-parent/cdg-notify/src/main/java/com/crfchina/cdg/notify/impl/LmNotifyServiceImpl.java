/**
 * @Title：
 * @Package com.crfchina.cdg.notify.impl
 * @date 2018/1/10 13:45
 * @version V1.0
 */
package com.crfchina.cdg.notify.impl;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmBindCardFlowinfoMapper;
import com.crfchina.cdg.basedb.dao.LmBindCardListMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfoExample;
import com.crfchina.cdg.basedb.entity.LmBindCardList;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.common.EnumsDBMap;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.notify.dto.BaseResultDTO;
import com.crfchina.cdg.notify.dto.LmNotifyResult;
import com.crfchina.cdg.notify.service.LmNotifyService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmNotifyServiceImpl
 * @Description:
 * @author: Administrator
 * @date：2018/1/10 13:45
 * @updateBy：但锐轩
 * @updateDate：2018/1/10 13:45
 * @remarks：
 */
@Service
public class LmNotifyServiceImpl implements LmNotifyService {

	@Autowired
	LmBindCardFlowinfoMapper lmBindCardFlowinfoMapper;

	@Autowired
	LmBindCardListMapper lmBindCardListMapper;


	@Autowired
	LmVaccountTransferInfoMapper txnInfoMapper;

	@Autowired
	LmVaccountTransferDetailMapper txnDetailMapper;

	@Override
	public void dealNotify(LmNotifyResult result) {
		ApiType apiType = ApiType.valueOf(result.getServiceName());
		if (apiType.equals(ApiType.PERSONAL_REGISTER_EXPAND)) {
			dealPersonOpenAccount(result.getRespData());
		}
	}

	private void dealPersonOpenAccount(JSONObject respData) {
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

				BaseResultDTO<String> result = new BaseResultDTO();
				result.setResult(ResultCode.SUCCESS);
				result.setRequestRefNo(flow.getRequestRefNo());
				respData.put("fcpTrxNo", flow.getFcpTrxNo());
				result.setData(respData.toJSONString());

				//TODO 通知业务系统
				String notifyUrl = flow.getNotifyUrl();

			} else {
				flow.setResult(ResultCode.FAIL.getCode());
				flow.setFailCode(respData.getString("errorCode"));
				flow.setFailReason(respData.getString("errorMessage"));
				flow.setUpdateTime(now);
				lmBindCardFlowinfoMapper.updateByPrimaryKey(flow);

				//TODO 通知业务系统
			}
		} else {
			//TODO 通知业务系统
		}
	}
}
