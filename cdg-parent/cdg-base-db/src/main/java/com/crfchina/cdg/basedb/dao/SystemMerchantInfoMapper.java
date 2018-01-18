package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.SystemMerchantInfo;
import com.crfchina.cdg.basedb.entity.SystemMerchantInfoExample;
import java.util.List;

public interface SystemMerchantInfoMapper {
    int countByExample(SystemMerchantInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemMerchantInfo record);

    int insertSelective(SystemMerchantInfo record);

    List<SystemMerchantInfo> selectByExampleWithBLOBs(SystemMerchantInfoExample example);

    List<SystemMerchantInfo> selectByExample(SystemMerchantInfoExample example);

    SystemMerchantInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemMerchantInfo record);

    int updateByPrimaryKeyWithBLOBs(SystemMerchantInfo record);

    int updateByPrimaryKey(SystemMerchantInfo record);
}