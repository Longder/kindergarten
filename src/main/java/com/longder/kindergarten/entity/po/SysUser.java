package com.longder.kindergarten.entity.po;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * 系统用户实体
 */
@Getter
@Setter
@Entity
@Table(name = "SYS_USER")
@Proxy(lazy = false)
public class SysUser extends BaseIdEntity implements UserDetails {

    /**
     * 姓名
     */
    @Column(name = "name_")
    private String name;
    /**
     * 登录名
     */
    @Column(name = "login_name_")
    private String loginName;

    /**
     * 登陆密码
     */
    @Column(name = "password_")
    private String password;

    /**
     * 用户角色，每个用户一个角色
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role_")
    private SysRole role;

    /**
     * 头像，BASE64值
     */
    @Column(name = "avatar_")
    private String avatar;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(this.role);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.loginName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
