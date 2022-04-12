package com.longder.kindergarten.service;

import com.longder.kindergarten.entity.po.ClassDiet;

import java.util.List;

public interface ClassDietManageService {

    /**
     * 添加每日饮食
     */
    void addClassDiet(ClassDiet classDiet);

    /**
     * 查询某个某个班级下的餐饮情况
     */
    List<ClassDiet> listByClassId(Long classId);
}
