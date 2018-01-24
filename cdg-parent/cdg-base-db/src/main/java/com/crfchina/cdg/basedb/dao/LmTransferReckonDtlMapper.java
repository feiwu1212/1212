package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmTransferReckonDtl;
import com.crfchina.cdg.basedb.entity.LmTransferReckonDtlExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LmTransferReckonDtlMapper {
    int countByExample(LmTransferReckonDtlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmTransferReckonDtl record);

    int insertSelective(LmTransferReckonDtl record);

    List<LmTransferReckonDtl> selectByExample(LmTransferReckonDtlExample example);

    LmTransferReckonDtl selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmTransferReckonDtl record);

    int updateByPrimaryKey(LmTransferReckonDtl record);
}