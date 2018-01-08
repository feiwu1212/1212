package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmVaccountTransferBatch;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferBatchExample;
import java.util.List;

public interface LmVaccountTransferBatchMapper {
    int countByExample(LmVaccountTransferBatchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmVaccountTransferBatch record);

    int insertSelective(LmVaccountTransferBatch record);

    List<LmVaccountTransferBatch> selectByExample(LmVaccountTransferBatchExample example);

    LmVaccountTransferBatch selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmVaccountTransferBatch record);

    int updateByPrimaryKey(LmVaccountTransferBatch record);
}