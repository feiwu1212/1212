package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.SystemStatusCodeMetadata;
import com.crfchina.cdg.basedb.entity.SystemStatusCodeMetadataExample;
import java.util.List;

public interface SystemStatusCodeMetadataMapper {
    int countByExample(SystemStatusCodeMetadataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemStatusCodeMetadata record);

    int insertSelective(SystemStatusCodeMetadata record);

    List<SystemStatusCodeMetadata> selectByExample(SystemStatusCodeMetadataExample example);

    SystemStatusCodeMetadata selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemStatusCodeMetadata record);

    int updateByPrimaryKey(SystemStatusCodeMetadata record);
}