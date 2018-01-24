/**
 * @Title：
 * @Package com.crfchina.cdg.notify.taskwork
 * @date 2018/1/23 16:05
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork;

import com.crfchina.cdg.basedb.dao.LmUserOperationFlowinfoMapper;
import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfo;
import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfoExample;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.notify.taskwork.exec.UserOperationTask;
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
 * @ClassName：UserOperationTaskWoker
 * @Description:
 * @author: Administrator
 * @date：2018/1/23 16:05
 * @updateBy：但锐轩
 * @updateDate：2018/1/23 16:05
 * @remarks：
 */
@TaskWorker(namespace="cdg-api-core")
@Service
public class UserOperationTaskWoker extends AbstractTaskWorker {

	@Autowired
	LmUserOperationFlowinfoMapper lmUserOperationFlowinfoMapper;

	@Autowired
	private NodeTaskSequenceQueue taskQueue;

	@Autowired
	UserOperationTask task;

	private static final Logger logger = LoggerFactory
			.getLogger(UserOperationTaskWoker.class);

	public UserOperationTaskWoker(TaskWorkerManager taskWorkerManager) {
		super(taskWorkerManager);
	}

	/**
	 * 个人操作TaskWoker
	 * @param fcpTrxNo
	 * @return
	 */
	@Override
	protected NodeTaskResult execute(String fcpTrxNo) {
		logger.info("UserOperationTaskWoker添加任务队列开始fcpTrxNo-->{}", fcpTrxNo);
		LmUserOperationFlowinfoExample flowinfoExample = new LmUserOperationFlowinfoExample();
		flowinfoExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmUserOperationFlowinfo> lmChangeCardFlowInfos = lmUserOperationFlowinfoMapper.selectByExample(flowinfoExample);
		LmUserOperationFlowinfo flow = lmChangeCardFlowInfos.get(0);
		BusinessContext businessContext = new BusinessContext(Constants.CONTEXT_CHANGE_CARD_MOBILE);
		businessContext.setParam("param", flow);
		taskQueue.addNodeTasks(task);
		NodeTaskResult result = taskQueue.execute(businessContext);
		logger.info("UserOperationTaskWoker添加任务队列结束");
		return result;
	}
}
