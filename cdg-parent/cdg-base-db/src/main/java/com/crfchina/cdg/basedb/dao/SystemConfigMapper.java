package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.SystemConfig;
import com.crfchina.cdg.basedb.entity.SystemConfigExample;
import java.util.List;

public interface SystemConfigMapper {
    int countByExample(SystemConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemConfig record);

    int insertSelective(SystemConfig record);

    List<SystemConfig> selectByExample(SystemConfigExample example);

    SystemConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemConfig record);

    int updateByPrimaryKey(SystemConfig record);
}