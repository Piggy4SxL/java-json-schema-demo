package com.sxl.sbm.enums;

/**
 * @author SxL
 * Created on 6/6/2018 18:39.
 */
public enum ExampleStateEnum {
    /**
     * 操作成功
     */
    SUCCESS(0, "操作成功"),
    /**
     * 操作失败
     */
    INNER_ERROR(-1001, "操作失败");

    private int state;

    private String stateInfo;

    ExampleStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ExampleStateEnum stateOf(int index) {
        for (ExampleStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
