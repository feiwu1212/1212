package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfo;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferInfoExample;
import java.util.List;

public interface LmVaccountTransferInfoMapper {
    int countByExample(LmVaccountTransferInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmVaccountTransferInfo record);

    int insertSelective(LmVaccountTransferInfo record);

    List<LmVaccountTransferInfo> selectByExample(LmVaccountTransferInfoExample example);

    LmVaccountTransferInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmVaccountTransferInfo record);

    int updateByPrimaryKey(LmVaccountTransferInfo record);
}