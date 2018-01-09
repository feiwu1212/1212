package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.SystemStatusCode;
import com.crfchina.cdg.basedb.entity.SystemStatusCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemStatusCodeMapper {
    int countByExample(SystemStatusCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemStatusCode record);

    int insertSelective(SystemStatusCode record);

    List<SystemStatusCode> selectByExample(SystemStatusCodeExample example);

    SystemStatusCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemStatusCode record);

    int updateByPrimaryKey(SystemStatusCode record);
}