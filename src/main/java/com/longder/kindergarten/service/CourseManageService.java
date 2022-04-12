package com.longder.kindergarten.service;

import com.longder.kindergarten.entity.po.Course;

import java.util.List;

public interface CourseManageService {
    /**
     * 添加或修改课程（每日所学）
     */
    void addOrUpdateCourse(Course course);

    /**
     * 每日所学列表（课程列表）
     */
    List<Course> listCourse();

    /**
     * 根据id查询某个课程
     */
    Course getCourse(Long courseId);

    /**
     * 查询某班级下的所有课程内容
     */
    List<Course> listByClassId(Long classId);

}
