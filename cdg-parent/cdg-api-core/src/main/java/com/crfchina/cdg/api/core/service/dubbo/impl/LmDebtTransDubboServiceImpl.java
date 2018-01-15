/**
 * @Title：
 * @Package com.crfchina.cdg.api.core.service.dubbo
 * @date 2018/1/10 16:30
 * @version V1.0
 */
package com.crfchina.cdg.api.core.service.dubbo.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferLogMapper;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetail;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetailExample;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfoExample;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferLog;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.business.ApiType;
import com.crfchina.cdg.common.enums.business.CurrencyType;
import com.crfchina.cdg.common.enums.business.DebentureStatusType;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.common.enums.common.SystemBackCode;
import com.crfchina.cdg.common.utils.AppConfig;
import com.crfchina.cdg.common.utils.AppUtil;
import com.crfchina.cdg.common.utils.DateUtils;
import com.crfchina.cdg.common.utils.LmHttpUtils;
import com.crfchina.cdg.common.utils.MoneyUtils;
import com.crfchina.cdg.common.utils.TrxNoUtils;
import com.crfchina.cdg.dto.param.LmCancelDebentureSaleParamDTO;
import com.crfchina.cdg.dto.param.LmDebentureSaleParamDTO;
import com.crfchina.cdg.dto.result.LmAutoPreTransactionResultDTO;
import com.crfchina.cdg.dto.result.LmCancelDebentureSaleResultDTO;
import com.crfchina.cdg.dto.result.LmDebentureSaleResultDTO;
import com.crfchina.cdg.service.LmDebtTransferDubboService;

/**
 * 
 * 
 * @ProjectName：cdg-api-core
 * @ClassName：LmDebtTransDubboServiceImpl
 * @Description:
 * @author: ghf
 * @date：2018年1月12日 下午2:40:21
 * @updateBy：ghf
 * @updateDate：2018年1月12日 下午2:40:21
 * @remarks：
 */
@Service(version="lmDebtTransferDubboService")
public class LmDebtTransDubboServiceImpl implements LmDebtTransferDubboService {

	public static final Logger logger = LoggerFactory
			.getLogger(LmDebtTransDubboServiceImpl.class);

	@Autowired
	LmVaccountTransferInfoMapper lmVaccountTransferInfoMapper;

	@Autowired
	LmVaccountTransferDetailMapper lmVaccountTransferDetailMapper;

	@Autowired
	LmVaccountTransferLogMapper lmVaccountTransferLogMapper;
	
	
	/**
	 *债券转让申请
	 */
	public LmDebentureSaleResultDTO debentureSale(
			LmDebentureSaleParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.DEBENTURE_SALE);
		Date now = new Date();
		//返回结果预封装
		LmDebentureSaleResultDTO rsp = new LmDebentureSaleResultDTO();
				rsp.setRequestRefNo(paramDTO.getRequestRefNo());
				rsp.setFcpTrxNo(fcpTrxNo);
				rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		
		// 新增LOG
		LmVaccountTransferLog txnLog = new LmVaccountTransferLog();
		txnLog.setRequestRefNo(paramDTO.getRequestRefNo());
		txnLog.setRequestTime(new Date());
		txnLog.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		txnLog.setFcpTrxNo(fcpTrxNo);
		txnLog.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		txnLog.setOutExternalAccount(paramDTO.getPlatformUserNo());
		txnLog.setTransferType(Constants.DEBENTURE_SALE);
		txnLog.setLmBizType(ApiType.DEBENTURE_SALE.getCode());
		txnLog.setCrfBizType(Constants.DEBENTURE_SALE);
		txnLog.setCreateTime(now);
		txnLog.setUpdateTime(now);
		txnLog.setRightShare(paramDTO.getSaleShare());
		txnLog.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));
		lmVaccountTransferLogMapper.insert(txnLog);

		//重复提交判断，通过requestRefNo判断,若存在重复记录，则将老交易取出，若不存在则新增INFO和DETAIL
		 LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		 LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();

		 LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		 infoExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		 List<LmVaccountTransferInfo> infoList = lmVaccountTransferInfoMapper.selectByExample(infoExample);
		 if(infoList.size()==1){
			  transferInfo = infoList.get(0);
			  //原始交易成功判断判断,只要不是失败状态，则激立即返回结果为目前状态
			  if(!transferInfo.getResult().equals(ResultCode.FAIL.getCode())){
					rsp.setResult(ResultCode.valueOf(transferInfo.getResult()));
					logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
					return rsp;
			  }
			  //获取detail信息
			  LmVaccountTransferDetailExample detailExample = new LmVaccountTransferDetailExample();
			  detailExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
			  List<LmVaccountTransferDetail> detailList = lmVaccountTransferDetailMapper.selectByExample(detailExample);
			  transferDetail = detailList.get(0);
		 }
		 else if(infoList.size()==0){
			BeanUtils.copyProperties(transferInfo, txnLog);
			//新增info
			lmVaccountTransferInfoMapper.insert(transferInfo);
			//新增detail
			BeanUtils.copyProperties(transferDetail, txnLog);
			lmVaccountTransferDetailMapper.insert(transferDetail);
		 }
		 else{
			logger.error("流水号："+paramDTO.getRequestRefNo()+"在txninfo表中数据异常");
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		 }
		
		//封装懒猫接口
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
		reqDataMap.put("projectNo", paramDTO.getProjectNo());
        reqDataMap.put("share", paramDTO.getSaleShare());
		
		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.DEBENTURE_SALE.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (Exception e) {
			logger.error("调用懒猫接口异常", e);
			 rsp.setResult(ResultCode.FAIL);
			 return rsp;
		}

		String code = result.getString("code");
		String status = result.getString("status");
		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.SUCCESS.getCode());
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.SUCCESS.getCode());
			transferDetail.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			//返回成功结果
			rsp.setResult(ResultCode.SUCCESS);
			rsp.setDebentureStatus(DebentureStatusType.ONSALE.getCode());
		} else {
			String failCode = result.getString("errorCode");
			String failReason = result.getString("errorMessage");
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
			// 返回失败结果
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(failReason);
			 rsp.setFailCode(failCode);
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}


	/**
	 * 债券转让取消
	 */
	public LmCancelDebentureSaleResultDTO cancelDebentureSale(
			LmCancelDebentureSaleParamDTO paramDTO) {
		logger.info("请求参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(paramDTO, ToStringStyle.DEFAULT_STYLE)});
		String fcpTrxNo = TrxNoUtils.getTrxNo(Constants.CANCEL_DEBENTURE_SALE);
		Date now = new Date();
		//返回结果预封装
		LmCancelDebentureSaleResultDTO rsp = new LmCancelDebentureSaleResultDTO();
				rsp.setRequestRefNo(paramDTO.getRequestRefNo());
				rsp.setFcpTrxNo(fcpTrxNo);
				rsp.setPlatformUserNo(paramDTO.getPlatformUserNo());
		
		// 新增LOG
		LmVaccountTransferLog txnLog = new LmVaccountTransferLog();
		txnLog.setRequestRefNo(paramDTO.getRequestRefNo());
		txnLog.setRequestTime(new Date());
		txnLog.setSystemNo(String.valueOf(paramDTO.getSystemNo().getValue()));
		txnLog.setFcpTrxNo(fcpTrxNo);
		txnLog.setCurrency(Integer.valueOf(CurrencyType.RMB.getCode()));
		txnLog.setOutExternalAccount(paramDTO.getPlatformUserNo());
		txnLog.setTransferType(Constants.CANCEL_DEBENTURE_SALE);
		txnLog.setLmBizType(ApiType.CANCEL_DEBENTURE_SALE.getCode());
		txnLog.setCrfBizType(Constants.CANCEL_DEBENTURE_SALE);
		txnLog.setCreateTime(now);
		txnLog.setUpdateTime(now);
		txnLog.setOriginFcpTrxno(paramDTO.getOriginFcpTrxNo());
		txnLog.setPartitionDate(Integer.valueOf(DateUtils.dateToString(new Date(), "yyyyMM")));
		lmVaccountTransferLogMapper.insert(txnLog);

		//重复提交判断，通过requestRefNo判断,若存在重复记录，则将老交易取出，若不存在则新增INFO和DETAIL
		 LmVaccountTransferInfo transferInfo = new LmVaccountTransferInfo();
		 LmVaccountTransferDetail transferDetail = new LmVaccountTransferDetail();

		 LmVaccountTransferInfoExample infoExample = new LmVaccountTransferInfoExample();
		 infoExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
		 List<LmVaccountTransferInfo> infoList = lmVaccountTransferInfoMapper.selectByExample(infoExample);
		 if(infoList.size()==1){
			  transferInfo = infoList.get(0);
			  //原始交易成功判断判断,只要不是失败状态，则激立即返回结果为目前状态
			  if(!transferInfo.getResult().equals(ResultCode.FAIL.getCode())){
					rsp.setResult(ResultCode.valueOf(transferInfo.getResult()));
					logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
					return rsp;
			  }
			  //获取detail信息
			  LmVaccountTransferDetailExample detailExample = new LmVaccountTransferDetailExample();
			  detailExample.createCriteria().andRequestRefNoEqualTo(paramDTO.getRequestRefNo());
			  List<LmVaccountTransferDetail> detailList = lmVaccountTransferDetailMapper.selectByExample(detailExample);
			  transferDetail = detailList.get(0);
		 }
		 else if(infoList.size()==0){
			BeanUtils.copyProperties(transferInfo, txnLog);
			//新增info
			lmVaccountTransferInfoMapper.insert(transferInfo);
			//新增detail
			BeanUtils.copyProperties(transferDetail, txnLog);
			lmVaccountTransferDetailMapper.insert(transferDetail);
		 }
		 else{
			logger.error("流水号："+paramDTO.getRequestRefNo()+"在txninfo表中数据异常");
			rsp.setResult(ResultCode.FAIL);
			return rsp;
		 }
		
		//封装懒猫接口
		Map<String, Object> reqDataMap = new LinkedHashMap<>();
		reqDataMap.put("requestNo", fcpTrxNo);
        reqDataMap.put("creditsaleRequestNo", paramDTO.getOriginFcpTrxNo());
		
		AppConfig config = AppConfig.getConfig();
		List<BasicNameValuePair> postParam = null;
		JSONObject result = null;
		try {
			postParam = AppUtil.createServicePostParam(ApiType.CANCEL_DEBENTURE_SALE.getCode(), reqDataMap);
			result = LmHttpUtils.postServiceResult(config.getUrl(), postParam);
		} catch (Exception e) {
			logger.error("调用懒猫接口异常", e);
			 rsp.setResult(ResultCode.FAIL);
			 return rsp;
		}

		String code = result.getString("code");
		String status = result.getString("status");
		now = new Date();
		if (SystemBackCode.SUCCESS.getCode().equals(code) && ResultCode.SUCCESS.getCode().equals(status)) {
			transferInfo.setResult(ResultCode.SUCCESS.getCode());
			transferInfo.setUpdateTime(now);

			transferDetail.setResult(ResultCode.SUCCESS.getCode());
			transferDetail.setUpdateTime(now);

			lmVaccountTransferInfoMapper.updateByPrimaryKey(transferInfo);
			lmVaccountTransferDetailMapper.updateByPrimaryKey(transferDetail);
			//返回成功结果
			rsp.setResult(ResultCode.SUCCESS);
		} else {
			String failCode = result.getString("errorCode");
			String failReason = result.getString("errorMessage");
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
			// 返回失败结果
			 rsp.setResult(ResultCode.FAIL);
			 rsp.setFailReason(failReason);
			 rsp.setFailCode(failCode);
		}
		logger.info("返回参数如下:{}",new Object[]{ToStringBuilder.reflectionToString(rsp, ToStringStyle.DEFAULT_STYLE)});
		return rsp;
	}

	



	
}
