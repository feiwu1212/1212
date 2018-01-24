/**
 * @Title：
 * @Package com.crfchina.cdg.notify.taskwork.exec
 * @date 2018/1/22 17:03
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork.exec;

import com.alibaba.fastjson.JSONObject;
import com.crfchina.cdg.basedb.dao.LmBindCardFlowinfoMapper;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.common.enums.common.ResultCode;
import com.crfchina.cdg.notify.dto.BaseResultDTO;
import com.crfchina.cdg.notify.util.NotifyUtils;
import com.crfchina.csf.task.nodetask.BusinessContext;
import com.crfchina.csf.task.nodetask.NodeTask;
import com.crfchina.csf.task.nodetask.NodeTaskResult;
import com.crfchina.csf.task.nodetask.service.NodeTaskService;

import java.util.List;

import org.apache.http.message.BasicNameValuePair;
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

	public RechargeTask(NodeTaskService nodeTaskService) {
		super(nodeTaskService);
	}

	@Autowired
	LmBindCardFlowinfoMapper lmBindCardFlowinfoMapper;

	/**
	 * 充值异步通知task
	 * @param context
	 * @return
	 */
	@Override
	protected NodeTaskResult process(BusinessContext context) {
		LmVaccountTransferInfo param = (LmVaccountTransferInfo) context.getParam("param");
		if (Integer.valueOf(1).equals(param.getNotifyStatus())) {
			if (param.getNotifyCount() <= 3) {
				BaseResultDTO<String> resultDTO = new BaseResultDTO<>();
				resultDTO.setRequestRefNo(param.getRequestRefNo());
				resultDTO.setFailCode(param.getFailCode());
				resultDTO.setFailReason(param.getFailReason());
				// 结果落库以后插入taskWorker
				BaseResultDTO<String> result = new BaseResultDTO<>();
				result.setResult(ResultCode.valueOf(param.getResult()));
				result.setRequestRefNo(param.getRequestRefNo());

				JSONObject data = new JSONObject();
				data.put("fcpTrxNo", param.getFcpTrxNo());
				data.put("platformUserNo ", param.getInExternalAccount());
				data.put("amount", param.getTransferAmount());
//				data.put("commission", );
//				data.put("payCompany ", param.get);
//				data.put("mobile", param.getMobile());
//				data.put("idCardType", param.getIdType());
//				data.put("accessType", param.getAccessType());
//				data.put("userRole", param.getUserRole());
//				data.put("auditStatus", param.getAuditStatus());
				result.setData(data.toJSONString());
				resultDTO.setData(result.toString());
				List<BasicNameValuePair> notifyParam = NotifyUtils.createNotifyParam(result);
				JSONObject jsonObject = NotifyUtils.httpNotify(notifyParam, param.getNotifyUrl());
				param.setNotifyCount(param.getNotifyCount() + 1);
				//FIXME 通知返回参数结果还未定
				if (jsonObject != null && "SUCCESS".equals(jsonObject.getString("result"))) {
					param.setNotifyStatus(2);
//					lmBindCardFlowinfoMapper.updateByPrimaryKey(param);
					return NodeTaskResult.success;
				} else {
					return NodeTaskResult.failretry;
				}
			} else {
				return NodeTaskResult.failpause;
			}
		} else {
			return NodeTaskResult.successandquit;
		}
	}
}
