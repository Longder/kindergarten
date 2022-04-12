package com.longder.kindergarten.controller;

import com.longder.kindergarten.entity.dto.Response;
import com.longder.kindergarten.entity.po.ClassGrade;
import com.longder.kindergarten.entity.po.SysRole;
import com.longder.kindergarten.service.ClassGradeManageService;
import com.longder.kindergarten.service.UserManageService;
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
    private UserManageService userManageService;

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

    /**
     * 查询所有教师
     */
    @GetMapping("/listAllTeacher")
    public Response listAllTeacher(){
        try{
            return Response.success(userManageService.listByRole(SysRole.ROLE_TEACHER));
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return Response.error("查询教师列表失败："+e.getMessage());
        }
    }
}
