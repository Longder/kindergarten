package com.longder.kindergarten.controller;


import com.longder.kindergarten.entity.dto.Response;
import com.longder.kindergarten.entity.po.SysUser;
import com.longder.kindergarten.security.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

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
}
