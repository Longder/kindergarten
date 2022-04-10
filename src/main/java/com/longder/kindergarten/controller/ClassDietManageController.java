package com.longder.kindergarten.controller;

import com.longder.kindergarten.entity.po.ClassDiet;
import com.longder.kindergarten.service.ClassDietManageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 餐饮管理控制器
 */
@RestController
@RequestMapping("/admin/classDietManage")
public class ClassDietManageController {

    @Resource
    private ClassDietManageService classDietManageService;

    /**
     * 添加班级饮食
     */
    @RequestMapping("/addDiet")
    public void addDiet(ClassDiet classDiet){
        classDietManageService.addClassDiet(classDiet);
    }
}
