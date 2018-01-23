/**
 * @Title：
 * @Package com.crfchina.cdg.notify.taskwork
 * @date 2018/1/23 14:02
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork;

import com.crfchina.cdg.basedb.dao.LmChangeCardmobileFlowinfoMapper;
import com.crfchina.cdg.basedb.entity.LmChangeCardmobileFlowinfo;
import com.crfchina.cdg.basedb.entity.LmChangeCardmobileFlowinfoExample;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.notify.taskwork.exec.ChangeCardTask;
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

//import com.crfchina.cdg.notify.taskwork.exec.ChangeCardTask;

/**
 * @ProjectName：cdg-parent
 * @ClassName：ChangeCardTaskWorker
 * @Description:
 * @author: Administrator
 * @date：2018/1/23 14:02
 * @updateBy：但锐轩
 * @updateDate：2018/1/23 14:02
 * @remarks：
 */
@TaskWorker(namespace="cdg-api-core")
@Service
public class ChangeCardMobileTaskWorker extends AbstractTaskWorker {

	private static final Logger logger = LoggerFactory
			.getLogger(ChangeCardMobileTaskWorker.class);

	@Autowired
	private NodeTaskSequenceQueue taskQueue;

	@Autowired
	LmChangeCardmobileFlowinfoMapper changeCardFlowMapper;

	@Autowired
	ChangeCardTask task;

	public ChangeCardMobileTaskWorker(TaskWorkerManager taskWorkerManager) {
		super(taskWorkerManager);
	}

	/**
	 * 更换银行卡或预留手机TaskWorker
	 * @param fcpTrxNo
	 * @return
	 */
	@Override
	protected NodeTaskResult execute(String fcpTrxNo) {
		logger.info("ChangeCardTaskWorker添加任务队列开始fcpTrxNo-->{}", fcpTrxNo);
		LmChangeCardmobileFlowinfoExample flowinfoExample = new LmChangeCardmobileFlowinfoExample();
		flowinfoExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmChangeCardmobileFlowinfo> lmChangeCardFlowInfos = changeCardFlowMapper.selectByExample(flowinfoExample);
		LmChangeCardmobileFlowinfo flow = lmChangeCardFlowInfos.get(0);
		BusinessContext businessContext = new BusinessContext(Constants.CONTEXT_CHANGE_CARD_MOBILE);
		businessContext.setParam("param", flow);
		taskQueue.addNodeTasks(task);
		NodeTaskResult result = taskQueue.execute(businessContext);
		logger.info("ChangeCardTaskWorker添加任务队列结束");
		return result;
	}
}
