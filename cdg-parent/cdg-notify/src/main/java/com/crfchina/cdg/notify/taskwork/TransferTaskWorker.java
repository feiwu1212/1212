/**
 * @Title：
 * @Package com.crfchina.cdg.notify.taskwork
 * @date 2018/1/29 15:48
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork;

import com.crfchina.cdg.basedb.dao.LmVaccountTransferInfoMapper;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfoExample;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.notify.taskwork.exec.TransferTask;
import com.crfchina.csf.task.AbstractTaskWorker;
import com.crfchina.csf.task.TaskWorker;
import com.crfchina.csf.task.TaskWorkerManager;
import com.crfchina.csf.task.nodetask.BusinessContext;
import com.crfchina.csf.task.nodetask.NodeTaskResult;
import com.crfchina.csf.task.nodetask.NodeTaskSequenceQueue;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName：cdg-parent
 * @ClassName：TransferTaskWorker
 * @Description:
 * @author: Administrator
 * @date：2018/1/29 15:48
 * @updateBy：但锐轩
 * @updateDate：2018/1/29 15:48
 * @remarks：
 */
@TaskWorker(namespace="cdg-api-core")
@Service
public class TransferTaskWorker extends AbstractTaskWorker {

	private static final Logger logger = LoggerFactory
			.getLogger(TransferTaskWorker.class);

	@Autowired
	LmVaccountTransferInfoMapper txnInfoMapper;

	@Autowired
	private NodeTaskSequenceQueue taskQueue;

	@Autowired
	TransferTask task;

	public TransferTaskWorker(TaskWorkerManager taskWorkerManager) {
		super(taskWorkerManager);
	}

	/**
	 * 交易异步通知
	 * @param fcpTrxNo
	 * @return
	 */
	@Override
	protected NodeTaskResult execute(String fcpTrxNo) {
		logger.info("TransferTaskWorker添加任务队列开始fcpTrxNo-->{}", fcpTrxNo);
		LmVaccountTransferInfoExample flowinfoExample = new LmVaccountTransferInfoExample();
		flowinfoExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmVaccountTransferInfo> flowList = txnInfoMapper.selectByExample(flowinfoExample);
		LmVaccountTransferInfo flow = flowList.get(0);
		BusinessContext businessContext = new BusinessContext(fcpTrxNo);
		businessContext.setParam(Constants.CONTEXT_TRANSFER_INFO, flow);
		taskQueue.addNodeTasks(task);
		NodeTaskResult result = taskQueue.execute(businessContext);
		logger.info("RechargeTaskWorker添加任务队列结束");
		return result;
	}
}
