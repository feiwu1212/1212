/**
 * @Title：
 * @Package com.crfchina.cdg.notify.taskwork.exec
 * @date 2018/1/23 14:09
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork.exec;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmChangeCardmobileFlowinfoMapper;
import com.crfchina.cdg.basedb.entity.LmChangeCardmobileFlowinfo;
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
 * @ClassName：ChangeCardTask
 * @Description:
 * @author: Administrator
 * @date：2018/1/23 14:09
 * @updateBy：但锐轩
 * @updateDate：2018/1/23 14:09
 * @remarks：
 */
@Component
public class ChangeCardTask extends NodeTask {

	private static final Logger logger = LoggerFactory
			.getLogger(ChangeCardTask.class);

	@Autowired
	LmChangeCardmobileFlowinfoMapper changeCardFlowMapper;

	public ChangeCardTask(NodeTaskService nodeTaskService) {
		super(nodeTaskService);
	}

	/**
	 * 更换银行卡或预留手机task
	 * @param context
	 * @return
	 */
	@Override
	protected NodeTaskResult process(BusinessContext context) {
		logger.info("ChangeCardTask开始执行-->{}", JSONObject.toJSONString(context.getParam(Constants.CONTEXT_CHANGE_CARD_MOBILE)));
		LmChangeCardmobileFlowinfo param = (LmChangeCardmobileFlowinfo) context.getParam(Constants.CONTEXT_CHANGE_CARD_MOBILE);
		NodeTaskResult processResult = null;
		if (Constants.NOTIFY_STATUS_WAIT.equals(param.getNotifyStatus())) {
			if (param.getNotifyCount() <= 3) {
				BaseResultDTO<String> result = new BaseResultDTO<>();
				result.setResult(ResultCode.valueOf(param.getResult()));
				result.setRequestRefNo(param.getRequestRefNo());
				result.setFailCode(param.getFailCode());
				result.setFailReason(param.getFailReason());

				JSONObject data = new JSONObject();
				data.put("fcpTrxNo", param.getFcpTrxNo());
				data.put("platformUserNo", param.getPlatformUserId());
				data.put("realName", param.getRealName());
				data.put("idCardNo", param.getIdNo());
				data.put("bankCardNo", param.getBankCardNo());
				data.put("bankCode", param.getBankCode());
				data.put("mobile", param.getMobile());
				data.put("accessType", param.getAccessType());
				data.put("auditStatus", param.getAuditStatus());
				result.setData(data.toJSONString());
				List<BasicNameValuePair> notifyParam = NotifyUtils.createNotifyParam(result);
				JSONObject jsonObject = NotifyUtils.httpNotify(notifyParam, param.getNotifyUrl());
				logger.info("异步通知返回参数-->", jsonObject.toJSONString());
				param.setNotifyCount(param.getNotifyCount() + 1);
				if (jsonObject != null && ResultCode.SUCCESS.equals(jsonObject.getString(Constants.NOTIFY_RESP_RESULT))) {
					param.setNotifyStatus(Constants.NOTIFY_STATUS_FINISH);
					processResult = NodeTaskResult.success;
				} else {
					processResult = NodeTaskResult.failretry;
				}
				changeCardFlowMapper.updateByPrimaryKey(param);
			} else {
				processResult = NodeTaskResult.fail;
			}
		} else {
			processResult = NodeTaskResult.success;
		}
		logger.info("ChangeCardTask执行结束processResult-->{}", processResult);
		return processResult;
	}
}
