/**
 * 
 */
package com.crfchina.cdg.core.service;

import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
import java.util.Map;

/**
 * @author WilliamWang
 *
 */
public interface LmAccountService {

	Map<String, Object> personBindCard(LmOpenAccountParamDTO loapDto);

}
