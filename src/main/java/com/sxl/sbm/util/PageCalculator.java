package com.sxl.sbm.util;

/**
 * @author SxL
 *         Created on 2017/11/5.
 */
public class PageCalculator {
    /**
     * 页数转换成行数
     * @param pageIndex 页数（第一页为1）
     * @param pageSize 每页显示的数量
     * @return 行数
     */
    public static int calculatorRowIndex(int pageIndex, int pageSize){
        return (pageIndex > 1) ? (pageIndex - 1) * pageSize : 0;
    }
}
