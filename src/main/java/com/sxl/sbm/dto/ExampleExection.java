package com.sxl.sbm.dto;

import com.sxl.sbm.entity.Example;
import com.sxl.sbm.enums.ExampleStateEnum;

import java.util.List;

/**
 * @author SxL
 * Created on 6/6/2018 18:33.
 */
public class ExampleExection {
    /** 结果状态
     *
     */
    private int state;

    /** 状态标识
     *
     */
    private String stateInfo;

    /** 店铺数量
     *
     */
    private int count;

    /** 操作的实体
     *
     */
    private Example example;

    /** 获取的实体列表
     *
     */
    private List<Example> exampleList;

    public ExampleExection() {
    }

    /** 失败的构造器
     *
     * @param stateEnum 状态
     */
    public ExampleExection(ExampleStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /** 成功的构造器
     *
     * @param stateEnum 状态
     * @param example 实体
     */
    public ExampleExection(ExampleStateEnum stateEnum, Example example) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.example = example;
    }

    /** 成功的构造器
     *
     * @param stateEnum 状态
     * @param exampleList 实体列表
     */
    public ExampleExection(ExampleStateEnum stateEnum, List<Example> exampleList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.exampleList = exampleList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    public List<Example> getExampleList() {
        return exampleList;
    }

    public void setExampleList(List<Example> exampleList) {
        this.exampleList = exampleList;
    }
}
