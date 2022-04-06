package com.longder.kindergarten.controller;


import com.longder.kindergarten.entity.dto.Response;
import com.longder.kindergarten.entity.po.SysUser;
import com.longder.kindergarten.service.UserManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户管理控制器
 */
@Slf4j
@RestController
@RequestMapping("/admin/userManage")
public class UserManageController {

    @Resource
    private UserManageService userManageService;

    /**
     * 查询所有用户
     */
    @GetMapping("/list")
    public Response listAllUser(){
        return Response.success(userManageService.listAllSysUser());
    }

    /**
     * 添加用户
     */
    @PostMapping("/addUser")
    public Response addUser(@RequestBody SysUser sysUser){
        try{
            userManageService.addUser(sysUser);
            return Response.success("添加成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return Response.error("添加失败："+e.getMessage());
        }
    }
}
