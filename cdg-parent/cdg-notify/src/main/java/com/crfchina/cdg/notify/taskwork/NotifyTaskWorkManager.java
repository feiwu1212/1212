/**    
 * @Title：NotifyTaskWorkManager.java    
 * @Package com.crfchina.cdg.notify.taskwork
 *     
 * @date 2018年1月17日 下午5:54:59 
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crfchina.csf.task.AbstractTaskWorker;
import com.crfchina.csf.task.TaskWorker;
import com.crfchina.csf.task.TaskWorkerManager;
import com.crfchina.csf.task.nodetask.BusinessContext;
import com.crfchina.csf.task.nodetask.NodeTaskResult;
import com.crfchina.csf.task.nodetask.NodeTaskSequenceQueue;

/**    
 * 
 * @ProjectName：cdg-notify
 * @ClassName：NotifyTaskWorkManager 
 * @Description:异步通知业务系统加入task队列
 * @author: William
 * @date：2018年1月17日 下午5:54:59
 * @updateBy：William
 * @updateDate：2018年1月17日 下午5:54:59
 * @remarks：
 */
@TaskWorker(namespace="cdg-api-core")
@Service
public class NotifyTaskWorkManager extends AbstractTaskWorker {

	 private static Logger Logger = LoggerFactory.getLogger(NotifyTaskWorkManager.class);
	 @Autowired 
	private NodeTaskSequenceQueue taskQueue; 
	 
	 
	public NotifyTaskWorkManager(TaskWorkerManager taskWorkerManager) {
		super(taskWorkerManager);
	}

	@Override
	protected NodeTaskResult execute(String fcpTrxNo) {
		Logger.info("异步通知业务系统加入队列开始,taskworkd="+fcpTrxNo);
		

		Logger.info("异步通知业务系统加入队列结束,taskworkd="+fcpTrxNo);
		return null;
	}

}
