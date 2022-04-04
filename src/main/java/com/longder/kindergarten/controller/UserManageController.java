package com.longder.kindergarten.controller;


import com.longder.kindergarten.entity.dto.Response;
import com.longder.kindergarten.entity.po.SysUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制器
 */
@RestController
@RequestMapping("/userManage")
public class UserManageController {

    @PostMapping("/addUser")
    public Response addUser(@RequestBody SysUser sysUser){

        return Response.success("添加成功");
    }
}
