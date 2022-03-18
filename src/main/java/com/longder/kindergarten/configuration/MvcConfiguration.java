package com.longder.kindergarten.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

/**
 * MVC配置
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    /**
     * 映射 /static 的请求到 classpath 下的 static 目录
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/components/**")
                .addResourceLocations("classpath:/components/");
        registry.addResourceHandler("/views/**")
                .addResourceLocations("classpath:/views/");
    }

    /**
     * 模板映射处理 Bean
     */
    @Bean(name = "templateResolver")
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    /**
     * 模板引擎，加入SpringSecurityDialect
     *
     * @return
     */
    @Bean(name = "templateEngine")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }

}
