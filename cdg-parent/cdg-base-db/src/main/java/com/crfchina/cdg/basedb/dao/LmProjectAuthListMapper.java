package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmProjectAuthList;
import com.crfchina.cdg.basedb.entity.LmProjectAuthListExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LmProjectAuthListMapper {
    int countByExample(LmProjectAuthListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmProjectAuthList record);

    int insertSelective(LmProjectAuthList record);

    List<LmProjectAuthList> selectByExample(LmProjectAuthListExample example);

    LmProjectAuthList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmProjectAuthList record);

    int updateByPrimaryKey(LmProjectAuthList record);
}