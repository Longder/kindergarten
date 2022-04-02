package com.longder.kindergarten.entity.po;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

/**
 * 系统角色枚举
 * 实现Security权限接口
 */
@Getter
@AllArgsConstructor
public enum SysRole implements GrantedAuthority {
    ROLE_ADMIN("ROLE_ADMIN","管理员"),
    ROLE_TEACHER("ROLE_TEACHER","教师"),
    ROLE_STUDENT("ROLE_STUDENT","学生");
    /**
     * 名称
     */
    private final String name;
    /**
     * 展示名
     */
    private final String displayName;

    @Override
    public String getAuthority() {
        return this.name;
    }

}
