/**
 * @Title：
 * @Package com.crfchina.cdg.basedb.dao
 * @date 2018/1/8 11:25
 * @version V1.0
 */
package com.crfchina.cdg.basedb.dao;

import com.crfchina.cdg.basedb.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ProjectName：cdg-parent
 * @ClassName：TestDao
 * @Description:
 * @author: Administrator
 * @date：2018/1/8 11:25
 * @updateBy：但锐轩
 * @updateDate：2018/1/8 11:25
 * @remarks：
 */
@Mapper
public interface TestDao {

	TestEntity query(String id);
}
