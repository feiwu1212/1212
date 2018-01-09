package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmChangeCardmobileFlowinfo;
import com.crfchina.cdg.basedb.entity.LmChangeCardmobileFlowinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LmChangeCardmobileFlowinfoMapper {
    int countByExample(LmChangeCardmobileFlowinfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmChangeCardmobileFlowinfo record);

    int insertSelective(LmChangeCardmobileFlowinfo record);

    List<LmChangeCardmobileFlowinfo> selectByExample(LmChangeCardmobileFlowinfoExample example);

    LmChangeCardmobileFlowinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmChangeCardmobileFlowinfo record);

    int updateByPrimaryKey(LmChangeCardmobileFlowinfo record);
}