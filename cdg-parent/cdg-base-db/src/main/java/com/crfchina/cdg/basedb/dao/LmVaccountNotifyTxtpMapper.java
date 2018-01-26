package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmVaccountNotifyTxtp;
import com.crfchina.cdg.basedb.entity.LmVaccountNotifyTxtpExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LmVaccountNotifyTxtpMapper {
    int countByExample(LmVaccountNotifyTxtpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmVaccountNotifyTxtp record);

    int insertSelective(LmVaccountNotifyTxtp record);

    List<LmVaccountNotifyTxtp> selectByExample(LmVaccountNotifyTxtpExample example);

    LmVaccountNotifyTxtp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmVaccountNotifyTxtp record);

    int updateByPrimaryKey(LmVaccountNotifyTxtp record);
}