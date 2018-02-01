/**
 * @Title：
 * @Package com.crfchina.cdg.notify.taskwork.exec
 * @date 2018/1/22 17:03
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork.exec;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.notify.dto.BaseResultDTO;
import com.crfchina.cdg.notify.util.NotifyUtils;
import com.crfchina.csf.task.nodetask.BusinessContext;
import com.crfchina.csf.task.nodetask.NodeTask;
import com.crfchina.csf.task.nodetask.NodeTaskResult;
import com.crfchina.csf.task.nodetask.service.NodeTaskService;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ProjectName：cdg-parent
 * @ClassName：BindCard
 * @Description:
 * @author: Administrator
 * @date：2018/1/22 17:03
 * @updateBy：但锐轩
 * @updateDate：2018/1/22 17:03
 * @remarks：
 */
@Component
public class RechargeTask extends NodeTask {

	private static final Logger logger = LoggerFactory
			.getLogger(RechargeTask.class);

	public RechargeTask(NodeTaskService nodeTaskService) {
		super(nodeTaskService);
	}

	@Autowired
	LmVaccountTransferInfoMapper txnInfoMapper;

	/**
	 * 充值异步通知task
	 * @param context
	 * @return
	 */
	@Override
	protected NodeTaskResult process(BusinessContext context) {
		logger.info("RechargeTask开始执行-->{}", JSONObject.toJSONString(context.getParam(Constants.CONTEXT_RECHARGE)));
		LmVaccountTransferInfo param = (LmVaccountTransferInfo) context.getParam(Constants.CONTEXT_RECHARGE);
		NodeTaskResult processResult = null;
		if (Constants.NOTIFY_STATUS_WAIT.equals(param.getNotifyStatus())) {
			if (param.getNotifyCount() <= 3) {
				// 结果落库以后插入taskWorker
				BaseResultDTO<String> result = new BaseResultDTO<>();
				result.setResult(ResultCode.valueOf(param.getResult()));
				result.setRequestRefNo(param.getRequestRefNo());
				result.setFailCode(param.getFailCode());
				result.setFailReason(param.getFailReason());

				JSONObject data = new JSONObject();
				data.put("fcpTrxNo", param.getFcpTrxNo());
				data.put("platformUserNo", param.getInExternalAccount());
				data.put("amount", param.getTransferAmount());
				data.put("transactionTime", param.getFinishDate());
//				data.put("commission", param.get);
//				data.put("payCompany ", param.get);
//				data.put("mobile", param.getMobile());
//				data.put("idCardType", param.getIdType());
//				data.put("accessType", param.getAccessType());
//				data.put("userRole", param.getUserRole());
//				data.put("auditStatus", param.getAuditStatus());
				result.setData(data.toJSONString());
				List<BasicNameValuePair> notifyParam = NotifyUtils.createNotifyParam(result);
				JSONObject jsonObject = NotifyUtils.httpNotify(notifyParam, param.getNotifyUrl());
				logger.info("异步通知返回参数-->", jsonObject.toJSONString());
				param.setNotifyCount(param.getNotifyCount() + 1);
				if (jsonObject != null && ResultCode.SUCCESS.equals(jsonObject.getString(Constants.NOTIFY_RESP_RESULT))) {
					param.setNotifyStatus(2);
					processResult = NodeTaskResult.success;
				} else {
					processResult = NodeTaskResult.failretry;
				}
				txnInfoMapper.updateByPrimaryKey(param);
			} else {
				processResult = NodeTaskResult.fail;
			}
		} else {
			processResult = NodeTaskResult.success;
		}
		logger.info("RechargeTask执行结束processResult-->{}", processResult);
		return processResult;
	}
}
