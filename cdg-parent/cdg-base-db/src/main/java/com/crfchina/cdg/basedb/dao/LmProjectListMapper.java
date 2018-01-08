package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmProjectList;
import com.crfchina.cdg.basedb.entity.LmProjectListExample;
import java.util.List;

public interface LmProjectListMapper {
    int countByExample(LmProjectListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmProjectList record);

    int insertSelective(LmProjectList record);

    List<LmProjectList> selectByExample(LmProjectListExample example);

    LmProjectList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmProjectList record);

    int updateByPrimaryKey(LmProjectList record);
}