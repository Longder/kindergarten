package com.longder.kindergarten.service;

import com.longder.kindergarten.entity.po.ClassGrade;

import java.util.List;

/**
 * 班级管理接口
 */
public interface ClassGradeManageService {

    /**
     * 查询所有班级
     * @return
     */
    List<ClassGrade> listClassGrade();

    /**
     * 新增班级
     */
    void addClassGrade(ClassGrade classGrade);

    /**
     * 查询某教师管理的所有班级
     */
    List<ClassGrade> listByTeacher(Long teacherId);
}
