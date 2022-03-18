package com.longder.kindergarten.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SpringSecurity配置
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 配置静态资源不被Security拦截
     *
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/static/**", "/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").authenticated()//所有以admin开头的请求 都需要进行认证（就是登陆之后才能访问）
                .and()
                .formLogin().loginPage("/toLogin").loginProcessingUrl("/login_check").permitAll()//登录页面的url是“/toLogin” 登陆请求执行的url是"/login_check"
//                .successHandler(formLoginSuccessHandler())//配置了一个登陆成功后的Handler 这个Handler是自己定义的
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/toLogin")//登出的url是"/logout" 登出成功后访问"/toLogin"
                .and().csrf().disable().headers().cacheControl();

    }

//    /**
//     * 登录成功后的后置处理
//     *
//     * @return
//     */
//    @Bean
//    public FormLoginSuccessHandler formLoginSuccessHandler() {
//        FormLoginSuccessHandler handler = new FormLoginSuccessHandler();
//        handler.setDefaultTargetUrl("/admin/index");
//        handler.setAlwaysUseDefaultTargetUrl(true);
//        return handler;
//    }

}
