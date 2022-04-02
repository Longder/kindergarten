package com.longder.kindergarten.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 性别枚举
 */
@Getter
@AllArgsConstructor
public enum Gender {
    MALE("MALE","男"),FEMALE("FEMALE","女");


    private final String name;


    private final String displayName;
}
