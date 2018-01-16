package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmVaccountTransferLog;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LmVaccountTransferLogMapper {
    int countByExample(LmVaccountTransferLogExample example);

    int deleteByPrimaryKey(@Param("id") Long id, @Param("partitionDate") Integer partitionDate);

    int insert(LmVaccountTransferLog record);

    int insertSelective(LmVaccountTransferLog record);

    List<LmVaccountTransferLog> selectByExample(LmVaccountTransferLogExample example);

    LmVaccountTransferLog selectByPrimaryKey(@Param("id") Long id, @Param("partitionDate") Integer partitionDate);

    int updateByPrimaryKeySelective(LmVaccountTransferLog record);

    int updateByPrimaryKey(LmVaccountTransferLog record);
}