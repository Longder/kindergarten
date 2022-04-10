package com.longder.kindergarten.controller;

import com.longder.kindergarten.entity.po.Course;
import com.longder.kindergarten.service.CourseManageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 每日所学管理
 */
@RestController
@RequestMapping("/admin/courseManage")
public class CourseManageController {

    @Resource
    private CourseManageService courseManageService;

    /**
     * 添加或修改课程
     */
    @RequestMapping("/addOrUpdateCourse")
    public void addOrUpdateCourse(Course course){
        courseManageService.addOrUpdateCourse(course);
    }

    /**
     * 查询某个课程详情
     */
    @RequestMapping("/getCourse")
    public Course getCourse(Long courseId){
        return courseManageService.getCourse(courseId);
    }

    /**
     * 查询课程列表
     * @return
     */
    @RequestMapping("/listCourse")
    public List<Course> listCourse(){
        return courseManageService.listCourse();
    }
}
