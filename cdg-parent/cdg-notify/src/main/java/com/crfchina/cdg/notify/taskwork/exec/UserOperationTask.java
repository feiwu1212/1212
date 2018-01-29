/**
 * @Title：
 * @Package com.crfchina.cdg.notify.taskwork.exec
 * @date 2018/1/23 16:10
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork.exec;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmUserOperationFlowinfoMapper;
import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfo;
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
 * @ClassName：UserOperationTask
 * @Description:
 * @author: Administrator
 * @date：2018/1/23 16:10
 * @updateBy：但锐轩
 * @updateDate：2018/1/23 16:10
 * @remarks：
 */
@Component
public class UserOperationTask extends NodeTask {

	private static final Logger logger = LoggerFactory
			.getLogger(UserOperationTask.class);

	@Autowired
	LmUserOperationFlowinfoMapper lmUserOperationFlowinfoMapper;

	public UserOperationTask(NodeTaskService nodeTaskService) {
		super(nodeTaskService);
	}

	/**
	 * 个人操作task
	 * @param context
	 * @return
	 */
	@Override
	protected NodeTaskResult process(BusinessContext context) {
		logger.info("UserOperationTask开始执行-->{}", JSONObject.toJSONString(context.getParam(Constants.CONTEXT_CHANGE_CARD_MOBILE)));
		LmUserOperationFlowinfo param = (LmUserOperationFlowinfo) context.getParam(Constants.CONTEXT_CHANGE_CARD_MOBILE);
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
				if (param.getOperType().equals(3)) {
					data.put("bizTypeDescription", param.getBizTypeDesc());
				}
				result.setData(data.toJSONString());
				List<BasicNameValuePair> notifyParam = NotifyUtils.createNotifyParam(result);
				JSONObject jsonObject = NotifyUtils.httpNotify(notifyParam, param.getNotifyUrl());
				param.setNotifyCount(param.getNotifyCount() + 1);
				if (jsonObject != null && ResultCode.SUCCESS.equals(jsonObject.getString(Constants.NOTIFY_RESP_RESULT))) {
					param.setNotifyStatus(Constants.NOTIFY_STATUS_FINISH);
					processResult = NodeTaskResult.success;
				} else {
					processResult = NodeTaskResult.failretry;
				}
				lmUserOperationFlowinfoMapper.updateByPrimaryKey(param);
			} else {
				processResult = NodeTaskResult.fail;
			}
		} else {
			processResult = NodeTaskResult.success;
		}
		logger.info("UserOperationTask执行结束processResult-->{}", processResult);
		return processResult;
	}
}
