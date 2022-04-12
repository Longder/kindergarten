package com.longder.kindergarten.controller;


import com.longder.kindergarten.entity.dto.Response;
import com.longder.kindergarten.entity.po.SysRole;
import com.longder.kindergarten.entity.po.SysUser;
import com.longder.kindergarten.security.SecurityUtil;
import com.longder.kindergarten.service.ClassGradeManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Slf4j
@Controller
public class IndexController {

    @Resource
    private ClassGradeManageService classGradeManageService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 登录页
     */
    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 获取当前登录用户
     */
    @ResponseBody
    @GetMapping("/getCurrentUser")
    public Response getCurrentUser(){
        SysUser currentUser = SecurityUtil.getCurrentUser();
        if(ObjectUtils.isEmpty(currentUser)){
            return Response.error("未登录");
        }else{
            return Response.success(currentUser);
        }
    }

    /**
     * 获取当前登录教师的所有管理班级
     */
    @ResponseBody
    @GetMapping("/getCurrentTeacherClass")
    public Response getCurrentTeacherClass(){
        try{
            SysUser currentUser = SecurityUtil.getCurrentUser();
            assert currentUser != null;
            return Response.success(classGradeManageService.listByTeacher(currentUser.getId()));
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return Response.error("查询教师管理班级失败："+e.getMessage());
        }
    }
}
