package com.babyjuan.house.common.enums;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 8:03
 * @Description:
 */
public enum HouseSource {
    LIAN_JIA(1, "链家");

    private Integer id;
    private String name;

    HouseSource(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static HouseSource valueOf(int id) {
        for (HouseSource houseSource : values()) {
            if (houseSource.getId() == id) {
                return houseSource;
            }
        }
        return null;
    }
}
