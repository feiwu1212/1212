package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetail;
import com.crfchina.cdg.basedb.entity.LmVaccountTransferDetailExample;
import java.util.List;

public interface LmVaccountTransferDetailMapper {
    int countByExample(LmVaccountTransferDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmVaccountTransferDetail record);

    int insertSelective(LmVaccountTransferDetail record);

    List<LmVaccountTransferDetail> selectByExample(LmVaccountTransferDetailExample example);

    LmVaccountTransferDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmVaccountTransferDetail record);

    int updateByPrimaryKey(LmVaccountTransferDetail record);
}