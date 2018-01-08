package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.BankInfo;
import com.crfchina.cdg.basedb.entity.BankInfoExample;
import java.util.List;

public interface BankInfoMapper {
	int countByExample(BankInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(BankInfo record);

	int insertSelective(BankInfo record);

	List<BankInfo> selectByExample(BankInfoExample example);

	BankInfo selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(BankInfo record);

	int updateByPrimaryKey(BankInfo record);
}