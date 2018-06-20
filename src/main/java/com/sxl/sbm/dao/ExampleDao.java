package com.sxl.sbm.dao;

import com.sxl.sbm.entity.Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SxL
 *         Created on 2018/6/6.
 */
public interface ExampleDao {
    /**
     * 插入实体
     * @param example 实体
     * @return 结果
     */
    int insertExample(Example example);

    /**
     * 更新实体
     * @param example 实体
     * @return 结果
     */
    int updateExample(Example example);

    /**
     * 根据ID查找实体
     * @param exampleId ID
     * @return 实体
     */
    Example getExampleById(int exampleId);

    /**
     * 分页查询
     * @param exampleCondition 条件
     * @param rowIndex 每页显示的个数
     * @param pageSize 页数
     * @return 列表
     */
    List<Example> listExample(@Param("exampleCondition") Example exampleCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
}
