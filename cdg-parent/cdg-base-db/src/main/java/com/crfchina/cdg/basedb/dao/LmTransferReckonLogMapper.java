package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmTransferReckonLog;
import com.crfchina.cdg.basedb.entity.LmTransferReckonLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LmTransferReckonLogMapper {
    int countByExample(LmTransferReckonLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmTransferReckonLog record);

    int insertSelective(LmTransferReckonLog record);

    List<LmTransferReckonLog> selectByExample(LmTransferReckonLogExample example);

    LmTransferReckonLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmTransferReckonLog record);

    int updateByPrimaryKey(LmTransferReckonLog record);
}