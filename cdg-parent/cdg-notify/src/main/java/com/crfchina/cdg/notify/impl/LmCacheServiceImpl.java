package com.crfchina.cdg.notify.impl; /**
 * @Title：
 * @Package com.crfchina.cdg.core.impl
 * @date 2018/1/9 15:09
 * @version V1.0
 */

import com.crfchina.cdg.basedb.dao.BankInfoMapper;
import com.crfchina.cdg.basedb.dao.SystemMerchantInfoMapper;
import com.crfchina.cdg.basedb.entity.BankInfo;
import com.crfchina.cdg.basedb.entity.BankInfoExample;
import com.crfchina.cdg.notify.service.LmCacheService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service("LmCacheService")
public class LmCacheServiceImpl implements LmCacheService {
	public static final Logger logger = LoggerFactory
			.getLogger(LmCacheServiceImpl.class);


	@Autowired
	SystemMerchantInfoMapper sysMerInfoMapper;

	@Autowired
	BankInfoMapper bankInfoMapper;


	@Cacheable(cacheNames = "lmBankInfoCache")
	@Override
	public String getLmBankCode(String bankCode) {
		System.out.println("123123123");
		String lmbankCode = null;
		BankInfo bankinfo = new BankInfo();
		BankInfoExample example = new BankInfoExample();
		example.createCriteria().andBankCodeEqualTo(bankCode);
		List<BankInfo> list = bankInfoMapper.selectByExample(example);
		if(list.size()>0){
			bankinfo = list.get(0);
			lmbankCode = bankinfo.getLmBankCode();
		}
		return lmbankCode;
	}

	@Cacheable(cacheNames = "bankInfoCache")
	@Override
	public String getBankCode(String lmBankCode) {
		String bankCode = null;
		BankInfo bankinfo = new BankInfo();
		BankInfoExample example = new BankInfoExample();
		example.createCriteria().andLmBankCodeEqualTo(lmBankCode);
		List<BankInfo> list = bankInfoMapper.selectByExample(example);
		if(list.size()>0){
			bankinfo = list.get(0);
			bankCode = bankinfo.getBankCode();
		}
		return bankCode;
	}
}
