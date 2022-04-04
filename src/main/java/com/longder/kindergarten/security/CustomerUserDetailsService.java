package com.longder.kindergarten.security;


import com.longder.kindergarten.entity.po.SysUser;
import com.longder.kindergarten.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;


/**
 * 自定义的SpringSecurity用来做用户认证的service
 */
@Slf4j
@Component
public class CustomerUserDetailsService implements UserDetailsService {

    @Resource
    private SysUserRepository sysUserRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.debug("进入自定义的UserDetails");
        log.debug(s);
        SysUser sysUser = sysUserRepository.getByLoginName(s);
        if(ObjectUtils.isEmpty(sysUser)){
            throw new BadCredentialsException("用户名或密码错误");
        }
        return sysUser;
    }
}
