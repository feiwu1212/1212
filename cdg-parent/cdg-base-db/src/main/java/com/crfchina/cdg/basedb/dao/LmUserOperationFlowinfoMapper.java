package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfo;
import com.crfchina.cdg.basedb.entity.LmUserOperationFlowinfoExample;
import java.util.List;

public interface LmUserOperationFlowinfoMapper {
    int countByExample(LmUserOperationFlowinfoExample example);

    int deleteByPrimaryKey(Boolean id);

    int insert(LmUserOperationFlowinfo record);

    int insertSelective(LmUserOperationFlowinfo record);

    List<LmUserOperationFlowinfo> selectByExample(LmUserOperationFlowinfoExample example);

    LmUserOperationFlowinfo selectByPrimaryKey(Boolean id);

    int updateByPrimaryKeySelective(LmUserOperationFlowinfo record);

    int updateByPrimaryKey(LmUserOperationFlowinfo record);
}