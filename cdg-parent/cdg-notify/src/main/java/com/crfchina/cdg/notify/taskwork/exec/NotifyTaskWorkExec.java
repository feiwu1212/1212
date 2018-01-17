/**    
 * @Title：NotifyTaskWorkExec.java    
 * @Package com.crfchina.cdg.notify.taskwork.exec
 *     
 * @date 2018年1月17日 下午5:57:21 
 * @version V1.0
 */
package com.crfchina.cdg.notify.taskwork.exec;

import com.crfchina.csf.task.nodetask.BusinessContext;
import com.crfchina.csf.task.nodetask.NodeTask;
import com.crfchina.csf.task.nodetask.NodeTaskResult;
import com.crfchina.csf.task.nodetask.service.NodeTaskService;

/**    
 * 
 * @ProjectName：cdg-notify
 * @ClassName：NotifyTaskWorkExec 
 * @Description:
 * @author: William
 * @date：2018年1月17日 下午5:57:21
 * @updateBy：William
 * @updateDate：2018年1月17日 下午5:57:21
 * @remarks：
 */
public class NotifyTaskWorkExec extends NodeTask{

	public NotifyTaskWorkExec(NodeTaskService nodeTaskService) {
		super(nodeTaskService);
	}

	@Override
	protected NodeTaskResult process(BusinessContext context) {
		return null;
	}

}
