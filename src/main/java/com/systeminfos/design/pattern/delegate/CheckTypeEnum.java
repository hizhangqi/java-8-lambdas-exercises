package com.systeminfos.design.pattern.delegate;

import java.util.Objects;
import java.util.stream.Stream;

public enum CheckTypeEnum {

    FREE_CHECK(1, "免检"), SEND_CHECK(2, "送检");

    private Integer type;
    private String desc;

    CheckTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static CheckTypeEnum getEnumByType(Integer type) {
        return Stream.of(values()).filter(e -> Objects.equals(e.getType(), type)).findFirst().orElse(null);
    }

    public static boolean isFreeCheck(Integer type) {
        return Objects.equals(type, CheckTypeEnum.FREE_CHECK.getType());
    }

}
