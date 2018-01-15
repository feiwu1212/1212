/**
 * 
 */
package com.crfchina.cdg.core.service;

import com.crfchina.cdg.core.dto.param.LmActiveAccountParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangeBankCardParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangeMobileParamDTO;
import com.crfchina.cdg.core.dto.param.LmChangePwdParamDTO;
import com.crfchina.cdg.core.dto.param.LmCheckPwdParamDTO;
import com.crfchina.cdg.core.dto.param.LmOpenAccountParamDTO;
import java.util.Map;

/**
 * @author WilliamWang
 *
 */
public interface LmAccountService {

	Map<String, Object> personBindCard(LmOpenAccountParamDTO loapDto);

	Map<String, Object> changeCard(LmChangeBankCardParamDTO lcbcDto);

	Map<String, Object> changePwd(LmChangePwdParamDTO lcpDto);

	Map<String, Object> checkPwd(LmCheckPwdParamDTO lcpDto);

	Map<String, Object> changeMobile(LmChangeMobileParamDTO lcmpDto);

	Map<String, Object> activeAccount(LmActiveAccountParamDTO laapDto);
}
