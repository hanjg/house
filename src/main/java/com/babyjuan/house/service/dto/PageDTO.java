package com.babyjuan.house.service.dto;

import java.util.List;

/**
 * @Author: hjg
 * @Date: Create in 2018/2/28 17:39
 */
public class PageDTO<T> {

    private long total;

    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
