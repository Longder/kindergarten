package com.longder.kindergarten.service;

import com.longder.kindergarten.entity.po.SysRole;
import com.longder.kindergarten.entity.po.SysUser;

import java.util.List;

public interface UserManageService {


    List<SysUser> listAllSysUser();

    /**
     * 添加系统用户
     */
    void addUser(SysUser sysUser);

    /**
     * 根据角色查询用户
     */
    List<SysUser> listByRole(SysRole role);




}
