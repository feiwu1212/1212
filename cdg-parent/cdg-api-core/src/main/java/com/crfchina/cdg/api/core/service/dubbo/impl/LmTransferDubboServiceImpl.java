/**
 * @Title：
 * @Package com.crfchina.cdg.api.core.service.dubbo
 * @date 2018/1/10 16:30
 * @version V1.0
 */
package com.crfchina.cdg.api.core.service.dubbo.impl;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferBatchMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetail;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.business.CurrencyType;
import com.crfchina.cdg.common.enums.business.PreBusinessType;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.LmHttpUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.dto.param.LmFreezePreTransactionParamDTO;
import com.crfchina.cdg.dto.result.LmFreezePreTransactionResultDTO;
import com.crfchina.cdg.service.LmTransferDubboService;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmTransferDubboServiceImpl
 * @Description:
 * @author: Administrator
 * @date：2018/1/10 16:30
 * @updateBy：但锐轩
 * @updateDate：2018/1/10 16:30
 * @remarks：
 */
@Service("lmTransferDubboService")
public class LmTransferDubboServiceImpl implements LmTransferDubboService {

	public static final Logger logger = LoggerFactory
			.getLogger(LmTransferDubboServiceImpl.class);

	@Autowired
	LmVaccountTransferInfoMapper lmVaccountTransferInfoMapper;

	@Autowired
	LmVaccountTransferDetailMapper lmVaccountTransferDetailMapper;

	@Autowired
	LmVaccountTransferBatchMapper lmVaccountTransferBatchMapper;

	@Override
	public LmFreezePreTransactionResultDTO freezePreTransaction(LmFreezePreTransactionParamDTO paramDTO) {
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.PRE_FREEZE_TRANSACTION);
		Date now = new Date();
		// 新增info
		LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		transferInfo.setRequestRefNo(paramDTO.getRequestRefNo());
		transferInfo.setRequestTime(new Date());
		transferInfo.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		transferInfo.setFcpTrxNo(fcpTrxNo);
		transferInfo.setTransferAmount(paramDTO.getAmount().toString());
		transferInfo.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		transferInfo.setOutExternalAccount(paramDTO.getPlatformUserNo());
		transferInfo.setTransferType(Constants.PRE_FREEZE_TRANSACTION);
		transferInfo.setLmBizType(paramDTO.getBizType());
		transferInfo.setCrfBizType(Constants.PRE_FREEZE_TRANSACTION);
		transferInfo.setCreateTime(now);
		transferInfo.setUpdateTime(now);
		transferInfo.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));

		lmVaccountTransferInfoMapper.insert(transferInfo);

		// 新增detail
		LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();
		transferDetail.setRequestRefNo(paramDTO.getRequestRefNo());
		transferDetail.setFcpTrxNo(fcpTrxNo);
		transferDetail.setTransferInfoId(transferInfo.getId().toString());
		transferDetail.setTransferAmount(paramDTO.getAmount().toString());
		transferDetail.setOutExternalAccount(paramDTO.getPlatformUserNo());
		transferDetail.setLmBizType(paramDTO.getBizType());
		transferDetail.setCrfBizType(Constants.PRE_FREEZE_TRANSACTION);
		transferDetail.setCreateTime(now);
		transferDetail.setUpdateTime(now);
		lmVaccountTransferDetailMapper.insert(transferDetail);

		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("platformUserNo", paramDTO.getPlatformUserNo());
		reqDataMap.put("bizType", PreBusinessType.PRETRANSACTION.getCode());
		reqDataMap.put("amount", MoneyUtils.toDollar(paramDTO.getAmount()));

		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.FREEZE_PRE_TRANSACTION.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (Exception e) {
			logger.error("调用懒猫接口异常", e);
			//TODO 返回失败结果 更新失败状态

		}

		String code = result.getString("code");
		String status = result.getString("status");
		String failCode = result.getString("errorCode");
		String failReason = result.getString("errorMessage");
		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.SUCCESS.getCode());
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.SUCCESS.getCode());
			transferDetail.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			//TODO 返回成功结果
		} else {
			transferInfo.setResult(ResultCode.FAIL.getCode());
			transferInfo.setFailCode(failCode);
			transferInfo.setFailReason(failReason);
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.FAIL.getCode());
			transferDetail.setFailCode(failCode);
			transferDetail.setFailReason(failReason);
			transferDetail.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			//TODO 返回失败结果
		}
		return null;
	}
}
