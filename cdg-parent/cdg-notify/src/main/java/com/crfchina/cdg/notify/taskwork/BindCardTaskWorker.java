/**
 * @Title：
 * @Package com.crfchina.cdg.notify.taskwork
 * @date 2018/1/22 16:59
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork;

import com.crfchina.cdg.basedb.dao.LmBindCardFlowinfoMapper;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfoExample;
import com.crfchina.cdg.common.constants.Constants;
import com.crfchina.cdg.notify.taskwork.exec.BindCardTask;
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
public class BindCardTaskWorker extends AbstractTaskWorker {

	private static final Logger logger = LoggerFactory
			.getLogger(BindCardTaskWorker.class);

	@Autowired
	LmBindCardFlowinfoMapper lmBindCardFlowinfoMapper;

	@Autowired
	private NodeTaskSequenceQueue taskQueue;

	@Autowired
	BindCardTask task;

	public BindCardTaskWorker(TaskWorkerManager taskWorkerManager) {
		super(taskWorkerManager);
	}

	/**
	 * 绑卡异步通知taskworker
	 * @param fcpTrxNo
	 * @return
	 */
	@Override
	protected NodeTaskResult execute(String fcpTrxNo) {
		logger.info("BindCardTaskWorker添加任务队列开始fcpTrxNo-->{}", fcpTrxNo);
		LmBindCardFlowinfoExample flowinfoExample = new LmBindCardFlowinfoExample();
		flowinfoExample.createCriteria().andFcpTrxNoEqualTo(fcpTrxNo);
		List<LmBindCardFlowinfo> lmBindCardFlowinfos = lmBindCardFlowinfoMapper.selectByExample(flowinfoExample);
		LmBindCardFlowinfo flow = lmBindCardFlowinfos.get(0);
		BusinessContext businessContext = new BusinessContext(fcpTrxNo);
		businessContext.setParam(Constants.CONTEXT_BIND_CARD, flow);
		taskQueue.addNodeTasks(task);
		NodeTaskResult result = taskQueue.execute(businessContext);
		logger.info("BindCardTaskWorker添加任务队列结束");
		return result;
	}
}
