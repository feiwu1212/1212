/**
 * @Title：
 * @Package com.crfchina.cdg.notify.service
 * @date 2018/1/10 13:45
 * @version V1.0
 */
package com.crfchina.cdg.notify.service;

import com.crfchina.cdg.notify.dto.LmNotifyResult;

/**
 * @ProjectName：cdg-parent
 * @ClassName：LmNotifyService
 * @Description:
 * @author: Administrator
 * @date：2018/1/10 13:45
 * @updateBy：但锐轩
 * @updateDate：2018/1/10 13:45
 * @remarks：
 */
public interface LmNotifyService {

	void dealNotify(LmNotifyResult result);
}
