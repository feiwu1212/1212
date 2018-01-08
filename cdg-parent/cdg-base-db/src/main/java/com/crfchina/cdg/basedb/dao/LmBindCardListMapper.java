package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmBindCardList;
import com.crfchina.cdg.basedb.entity.LmBindCardListExample;
import java.util.List;

public interface LmBindCardListMapper {
    int countByExample(LmBindCardListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmBindCardList record);

    int insertSelective(LmBindCardList record);

    List<LmBindCardList> selectByExample(LmBindCardListExample example);

    LmBindCardList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmBindCardList record);

    int updateByPrimaryKey(LmBindCardList record);
}