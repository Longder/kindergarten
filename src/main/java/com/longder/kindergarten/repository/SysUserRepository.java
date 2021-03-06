package com.longder.kindergarten.repository;


import com.longder.kindergarten.entity.po.SysRole;
import com.longder.kindergarten.entity.po.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    @Query("select s from SysUser s where s.loginName = :loginName")
    SysUser getByLoginName(@Param("loginName") String loginName);

    /**
     * 通过角色查询
     */
    @Query("select s from SysUser s where s.role = :role")
    List<SysUser> listByRole(@Param("role")SysRole role);

}
