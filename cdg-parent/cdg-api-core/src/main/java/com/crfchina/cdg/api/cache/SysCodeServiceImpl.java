package com.crfchina.cdg.api.cache;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.crfchina.cdg.basedb.dao.SystemStatusCodeMapper;
import com.crfchina.cdg.basedb.dao.SystemStatusCodeMetadataMapper;
import com.crfchina.cdg.basedb.entity.SystemStatusCode;
import com.crfchina.cdg.basedb.entity.SystemStatusCodeExample;
import com.crfchina.cdg.basedb.entity.SystemStatusCodeMetadata;
import com.crfchina.cdg.basedb.entity.SystemStatusCodeMetadataExample;
import com.crfchina.cdg.common.enums.business.ChlInfoNoType;
/**
 * @ProjectName：cdg-api-core
 * @ClassName：CacheServiceImpl 
 * @Description:
 * @author: ghf
 * @date：2018年1月16日 下午1:11:11
 * @updateBy：ghf
 * @updateDate：2018年1月16日 下午1:11:11
 * @remarks：
 */
@Service("SysCodeCacheService")
public class SysCodeServiceImpl implements SysCodeService {

	
	  @Autowired
	  private CacheManager cacheManager;

	  @Autowired
	  SystemStatusCodeMetadataMapper systemStatusCodeMetadataMapper;
	  
	  @Autowired
	  SystemStatusCodeMapper systemStatusCodeMapper;
	  
	  @Autowired
	  SysCodeService sysCode;
	  
	@Cacheable(cacheNames = "systemStatusCodeMetadataCache")
	@Override
	public HashMap<String, SystemStatusCodeMetadata> loadSystemStatusCodeMetadataCache() {
		HashMap<String, SystemStatusCodeMetadata> result = new HashMap<String, SystemStatusCodeMetadata>();
		SystemStatusCodeMetadataExample example = new SystemStatusCodeMetadataExample();
		example.createCriteria().andChannelInfoNoEqualTo(ChlInfoNoType.LANMAO.getCode());
		List<SystemStatusCodeMetadata> resultList= systemStatusCodeMetadataMapper.selectByExample(example);
		for(SystemStatusCodeMetadata sysStaCodeMetadate:resultList){
			System.out.println(sysStaCodeMetadate.getStatusReport());
			result.put(sysStaCodeMetadate.getStatusReport(), sysStaCodeMetadate);
		}
		return result;
	}

	@Cacheable(cacheNames = "systemStatusCodeCache")
	@Override
	public HashMap<String, SystemStatusCode> loadSystemStatusCodeCache() {
		HashMap<String, SystemStatusCode> result = new HashMap<String, SystemStatusCode>();
		SystemStatusCodeExample example = new SystemStatusCodeExample();
		List<SystemStatusCode> resultList= systemStatusCodeMapper.selectByExample(example);
		for(SystemStatusCode sysStaCode:resultList){
			System.out.println(sysStaCode.getCodeNo());
			result.put(sysStaCode.getCodeNo(), sysStaCode);
		}
		return result;
	}
	 /**
	  * 
	  * @Title: getExplainByLm  
	  * @Description: 通过懒猫返回码获取内部返回码说明
	  * @param lmResCode
	  * @return
	  * String
	  * @throws
	  */
	 public  String getExplainByLm(String lmResCode) {
		 SystemStatusCodeMetadata lmSysCodeInfo = sysCode.loadSystemStatusCodeMetadataCache().get(lmResCode);
		 SystemStatusCode sysCodeInfo = sysCode.loadSystemStatusCodeCache().get(lmSysCodeInfo.getCodeNo());
		 if(null ==sysCodeInfo){
			 sysCodeInfo = new SystemStatusCode();
			 sysCodeInfo.setCodeExplain("未知返回码"); 
		 }
		return sysCodeInfo.getCodeExplain();
	 }
	 
	 /**
	  * 
	  * @Title: getResCodeByLm  
	  * @Description: 通过懒猫返回码获取内部返回码
	  * @param lmResCode
	  * @return
	  * String
	  * @throws
	  */
	 public String getResCodeByLm(String lmResCode) {
		 SystemStatusCodeMetadata lmSysCodeInfo = sysCode.loadSystemStatusCodeMetadataCache().get(lmResCode);
		 SystemStatusCode sysCodeInfo = sysCode.loadSystemStatusCodeCache().get(lmSysCodeInfo.getCodeNo());
		 if(null ==sysCodeInfo){
			 sysCodeInfo = new SystemStatusCode();
			 sysCodeInfo.setStatusCode("CDG99999"); 
		 }
		return sysCodeInfo.getStatusCode();
	 }
	 
	 
	 /**
	  * 
	  * @Title: getExplain  
	  * @Description: 通过内部返回码获取返回码说明
	  * @param resCode
	  * @return
	  * String
	  * @throws
	  */
	 public  String getExplain(String resCode) {
		 SystemStatusCode sysCodeInfo = sysCode.loadSystemStatusCodeCache().get(resCode);
		 if(null ==sysCodeInfo){
			 sysCodeInfo = new SystemStatusCode();
			 sysCodeInfo.setCodeExplain("未知返回码"); 
		 }
		return sysCodeInfo.getCodeExplain();
	 }
}
