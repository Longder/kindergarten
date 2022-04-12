package com.longder.kindergarten.service.impl;

import com.longder.kindergarten.entity.po.SysRole;
import com.longder.kindergarten.entity.po.SysUser;
import com.longder.kindergarten.repository.SysUserRepository;
import com.longder.kindergarten.service.UserManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理相关业务层
 */
@Service
public class UserManageServiceImpl implements UserManageService {

    @Resource
    private SysUserRepository sysUserRepository;

    /**
     * 查询所有系统用户
     */
    @Override
    public List<SysUser> listAllSysUser() {
        return sysUserRepository.findAll();
    }

    /**
     * 添加系统用户
     */
    @Transactional
    @Override
    public void addUser(SysUser sysUser) {
        sysUserRepository.save(sysUser);
    }

    /**
     * 根据角色查询用户
     *
     * @param role
     */
    @Override
    public List<SysUser> listByRole(SysRole role) {
        return sysUserRepository.listByRole(role);
    }
}
