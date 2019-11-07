package com.ibm.course.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-11-06 10:36
 */

public enum StatusEnum {
    AVALIBLE("AVALIBLE", 0),
    INPROGRESS("INPROGRESS", 1),
    COMPLETE("COMPLETE", 2);
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int index;

    StatusEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (StatusEnum c : StatusEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
}
