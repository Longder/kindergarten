package com.longder.kindergarten.service.impl;

import com.longder.kindergarten.entity.po.Course;
import com.longder.kindergarten.service.CourseManageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManageServiceImpl implements CourseManageService {


    /**
     * 添加或修改课程（每日所学）
     */
    @Override
    public void addOrUpdateCourse(Course course) {

    }

    /**
     * 每日所学列表（课程列表）
     */
    @Override
    public List<Course> listCourse() {
        return null;
    }

    /**
     * 根据id查询某个课程
     */
    @Override
    public Course getCourse(Long courseId) {
        return null;
    }
}
