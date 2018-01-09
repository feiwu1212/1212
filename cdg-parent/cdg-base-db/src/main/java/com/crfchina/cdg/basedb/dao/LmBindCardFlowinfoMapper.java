package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfo;
import com.crfchina.cdg.basedb.entity.LmBindCardFlowinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LmBindCardFlowinfoMapper {
    int countByExample(LmBindCardFlowinfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmBindCardFlowinfo record);

    int insertSelective(LmBindCardFlowinfo record);

    List<LmBindCardFlowinfo> selectByExample(LmBindCardFlowinfoExample example);

    LmBindCardFlowinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LmBindCardFlowinfo record);

    int updateByPrimaryKey(LmBindCardFlowinfo record);
}