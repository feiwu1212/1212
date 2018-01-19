package com.crfchina.cdg.api.cache;

import java.util.HashMap;

import com.crfchina.cdg.basedb.entity.SystemStatusCode;
import com.crfchina.cdg.basedb.entity.SystemStatusCodeMetadata;

public interface SysCodeService {
	
	HashMap<String,SystemStatusCodeMetadata> loadSystemStatusCodeMetadataCache();
	HashMap<String,SystemStatusCode> loadSystemStatusCodeCache();
	String getExplainByLm(String lmResCode);
	String getResCodeByLm(String lmResCode);
	String getExplain(String resCode);
	
	String getLmBankCode(String bankCode);
	
	String getSysPubKey(String sysNo);
	
	String getSysPriKey(String sysNo);
	
	String getSysSand(String sysNo);
}
