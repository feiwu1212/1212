/**
 * @Title：
 * @Package com.crfchina.cdg.notify.taskwork
 * @date 2018/1/22 16:59
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfoExample;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.notify.taskwork.exec.RechargeTask;
import com.crfchina.csf.task.AbstractTaskWorker;
import com.crfchina.csf.task.TaskWorker;
import com.crfchina.csf.task.TaskWorkerManager;
import com.crfchina.csf.task.nodetask.BusinessContext;
import com.crfchina.csf.task.nodetask.NodeTaskResult;
import com.crfchina.csf.task.nodetask.NodeTaskSequenceQueue;

/**
 * @ProjectName：cdg-parent
 * @ClassName：BindCardTaskWorker
 * @Description:
 * @author: Administrator
 * @date：2018/1/22 16:59
 * @updateBy：但锐轩
 * @updateDate：2018/1/22 16:59
 * @remarks：
 */
@TaskWorker(namespace="cdg-api-core")
@Service
public class RechargeTaskWorker extends AbstractTaskWorker {

	@Autowired
	LmVaccountTransferInfoMapper txnInfoMapper;

	@Autowired
	private NodeTaskSequenceQueue taskQueue;

	@Autowired
	RechargeTask task;

	public RechargeTaskWorker(TaskWorkerManager taskWorkerManager) {
		super(taskWorkerManager);
	}

	/**
	 * 充值异步通知taskworker
	 * @param fcpTrxNo
	 * @return
	 */
	@Override
	protected NodeTaskResult execute(String fcpTrxNo) {
		LmVaccountTransferInfoExample flowinfoExample = new LmVaccountTransferInfoExample();
		flowinfoExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmVaccountTransferInfo> flowList = txnInfoMapper.selectByExample(flowinfoExample);
		LmVaccountTransferInfo flow = flowList.get(0);
		BusinessContext businessContext = new BusinessContext(Constants.CONTEXT_RECHARGE);
		businessContext.setParam("param", flow);
		taskQueue.addNodeTasks(task);
		NodeTaskResult result = taskQueue.execute(businessContext);
		return result;
	}
}
