/**
 * @Title：
 * @Package com.crfchina.cdg.notify.taskwork.exec
 * @date 2018/1/29 18:42
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork.exec;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferDetailMapper;
import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetail;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetailExample;
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
 * @ClassName：TransferTask
 * @Description:
 * @author: Administrator
 * @date：2018/1/29 18:42
 * @updateBy：但锐轩
 * @updateDate：2018/1/29 18:42
 * @remarks：
 */
@Component
public class TransferTask extends NodeTask {

	private static final Logger logger = LoggerFactory
			.getLogger(TransferTask.class);

	public TransferTask(NodeTaskService nodeTaskService) {
		super(nodeTaskService);
	}

	@Autowired
	LmVaccountTransferInfoMapper txnInfoMapper;

	@Autowired
	LmVaccountTransferDetailMapper txnDetailMapper;

	protected NodeTaskResult process(BusinessContext context) {
		logger.info("TransferTask开始执行-->{}", JSONObject.toJSONString(context.getParam(Constants.CONTEXT_RECHARGE)));
		LmVaccountTransferInfo transferInfo = (LmVaccountTransferInfo) context.getParam(Constants.CONTEXT_RECHARGE);
		LmVaccountTransferDetailExample detailExample = new LmVaccountTransferDetailExample();
		detailExample.createCriteria().andFcpTrxNoEqualTo(transferInfo.getFcpTrxNo());
		List<LmVaccountTransferDetail> detailList = txnDetailMapper.selectByExample(detailExample);
		NodeTaskResult processResult = null;
		if (Constants.NOTIFY_STATUS_WAIT.equals(transferInfo.getNotifyStatus())) {
			if (transferInfo.getNotifyCount() <= 3) {
				BaseResultDTO<String> result = new BaseResultDTO<>();
				result.setResult(ResultCode.valueOf(transferInfo.getResult()));
				result.setRequestRefNo(transferInfo.getRequestRefNo());
				result.setFailCode(transferInfo.getFailCode());
				result.setFailReason(transferInfo.getFailReason());

				JSONObject data = getNotifyData(transferInfo, detailList);
				result.setData(data.toJSONString());
				List<BasicNameValuePair> notifyParam = NotifyUtils.createNotifyParam(result);
				JSONObject jsonObject = NotifyUtils.httpNotify(notifyParam, transferInfo.getNotifyUrl());
				logger.info("异步通知返回参数-->", jsonObject.toJSONString());
				transferInfo.setNotifyCount(transferInfo.getNotifyCount() + 1);
				if (jsonObject != null && ResultCode.SUCCESS.equals(jsonObject.getString(Constants.NOTIFY_RESP_RESULT))) {
					transferInfo.setNotifyStatus(2);
					processResult = NodeTaskResult.success;
				} else {
					processResult = NodeTaskResult.failretry;
				}
				txnInfoMapper.updateByPrimaryKey(transferInfo);
			} else {
				processResult = NodeTaskResult.fail;
			}
		} else {
			processResult = NodeTaskResult.success;
		}
		logger.info("TransferTask执行结束processResult-->{}", processResult);
		return processResult;
	}

	/**
	 * 根据不同的操作类型拼装不同的返回参数
	 * @param transferInfo
	 * @param detailList
	 * @return
	 */
	private JSONObject getNotifyData(LmVaccountTransferInfo transferInfo, List<LmVaccountTransferDetail> detailList) {
		String transferType = transferInfo.getTransferType();
		JSONObject data = new JSONObject();
		switch (transferType) {
			case "CZ" : {
				data.put("fcpTrxNo", transferInfo.getFcpTrxNo());
				data.put("platformUserNo ", transferInfo.getInExternalAccount());
				data.put("amount", transferInfo.getTransferAmount());
				data.put("transactionTime", transferInfo.getFinishDate());
				data.put("commission", detailList.get(1));
				break;
			}
			case "TX" : {
				data.put("fcpTrxNo", transferInfo.getFcpTrxNo());
				data.put("platformUserNo ", transferInfo.getInExternalAccount());
				data.put("amount", transferInfo.getTransferAmount());
				data.put("transactionTime", transferInfo.getFinishDate());
				data.put("commission", detailList.get(1));
			}
			default: break;
		}
		return data;
	}
}
