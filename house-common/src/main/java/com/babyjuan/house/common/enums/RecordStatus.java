package com.babyjuan.house.common.enums;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/18 10:45
 * @Description:
 */
public enum RecordStatus {
    EXPIRED((byte) 0, "过期"), LATEST((byte) 1, "最新"), UPDATING((byte) 2, "正在更新");

    private Byte status;
    private String state;

    RecordStatus(Byte status, String state) {
        this.status = status;
        this.state = state;
    }

    public Byte getStatus() {
        return status;
    }


    public String getState() {
        return state;
    }

    public static RecordStatus valueOf(int id) {
        for (RecordStatus recordStatus : values()) {
            if (recordStatus.getStatus() == id) {
                return recordStatus;
            }
        }
        return null;
    }
}
