package com.longder.kindergarten.controller;

import com.longder.kindergarten.entity.po.ClassGrade;
import com.longder.kindergarten.service.ClassGradeManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 班级管理，控制器
 */
@Slf4j
@RestController
@RequestMapping("/admin/classGradeManage")
public class ClassGradeManageController {

    @Resource
    private ClassGradeManageService classGradeManageService;
    /**
     * 添加班级
     */
    @PostMapping("/addCLassGrade")
    public void addClassGrade(@RequestBody ClassGrade classGrade){
        classGradeManageService.addClassGrade(classGrade);
    }

    /**
     * 查询班级列表
     */
    @GetMapping("/listCLassGrade")
    public List<ClassGrade> listCLassGrade(){
        return classGradeManageService.listClassGrade();
    }
}
