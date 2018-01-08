package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmProjectFlowinfo;
import com.crfchina.cdg.basedb.entity.LmProjectFlowinfoExample;
import java.util.List;

public interface LmProjectFlowinfoMapper {
    int countByExample(LmProjectFlowinfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmProjectFlowinfo record);

    int insertSelective(LmProjectFlowinfo record);

    List<LmProjectFlowinfo> selectByExample(LmProjectFlowinfoExample example);

    LmProjectFlowinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmProjectFlowinfo record);

    int updateByPrimaryKey(LmProjectFlowinfo record);
}