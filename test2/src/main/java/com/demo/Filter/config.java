package com.demo.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 靖鸿宣
 * @version \
 * @since 2021/3/27
 */
@Configuration
public class config implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new test()).addPathPatterns("/**").excludePathPatterns("/css/**");
    }
}
