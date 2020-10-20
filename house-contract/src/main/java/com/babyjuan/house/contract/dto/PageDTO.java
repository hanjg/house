package com.babyjuan.house.contract.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: hjg
 * @Date: Create in 2018/2/28 17:39
 */
public class PageDTO<T> implements Serializable {

    private static final long serialVersionUID = 368276725139229332L;

    private long total;

    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
