package com.sxl.sbm.service;

import com.sxl.sbm.dto.ExampleExection;
import com.sxl.sbm.entity.Example;
import com.sxl.sbm.exception.ExampleOperatorException;

import java.util.List;

/**
 * @author SxL
 * Created on 6/6/2018 18:43.
 */
public interface ExampleService {
    /**
     *  新增
     * @param example 实体
     * @return 执行状态
     * @throws ExampleOperatorException 异常
     */
    ExampleExection saveExample(Example example) throws ExampleOperatorException;

    /**
     * 修改，删除（假删除）
     * @param example 实体
     * @return 执行状态
     * @throws ExampleOperatorException 异常
     */
    ExampleExection updateExample(Example example) throws ExampleOperatorException;

    /**
     * 主键查询
     * @param exampleId 主键
     * @return 实体
     */
    Example getExampleById(int exampleId);

    /**
     * 列表查询
     * @param exampleCondition 条件
     * @return 实体列表
     */
    List<Example> listExample(Example exampleCondition);
}
