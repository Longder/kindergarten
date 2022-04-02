package com.longder.kindergarten.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 餐饮类型
 */
@AllArgsConstructor
@Getter
public enum DietType {
    BREAKFAST("BREAKFAST","早餐"),LUNCH("LUNCH","午餐"),SUPPER("SUPPER","晚餐");

    private final String name;


    private final String displayName;
}
