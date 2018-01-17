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

import com.crfchina.csf.task.AbstractTaskWorker;
import com.crfchina.csf.task.TaskWorkerManager;
import com.crfchina.csf.task.nodetask.NodeTaskResult;

/**    
 * 
 * @ProjectName：cdg-notify
 * @ClassName：NotifyTaskWorkManager 
 * @Description:
 * @author: William
 * @date：2018年1月17日 下午5:54:59
 * @updateBy：William
 * @updateDate：2018年1月17日 下午5:54:59
 * @remarks：
 */
public class NotifyTaskWorkManager extends AbstractTaskWorker {

	 private static Logger Logger = LoggerFactory.getLogger(NotifyTaskWorkManager.class);
	
	public NotifyTaskWorkManager(int workerNum, TaskWorkerManager taskWorkerManager) {
		super(workerNum, taskWorkerManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected NodeTaskResult execute(String taskId) {
		Logger.info("异步通知业务系统加入开始,taskworkd="+taskId);
		
		Logger.info("异步通知业务系统加入结束,taskworkd="+taskId);
		return null;
	}

}
