package com.spring.boot.mybatisplusreview.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 23:22
 */
public enum SexEnum {
    MALE(1,"男"),
    FEMALE(0,"女");
    @EnumValue//通用枚举
    private Integer sex;
    private String sexEnum;

    SexEnum(Integer sex, String sexEnum) {
        this.sex = sex;
        this.sexEnum = sexEnum;
    }
}
