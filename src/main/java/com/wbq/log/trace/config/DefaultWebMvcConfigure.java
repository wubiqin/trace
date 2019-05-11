package com.wbq.log.trace.config;

import com.wbq.log.trace.intercept.TraceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: biqin.wu
 * @Date: 2019/5/11
 * @Time: 13:32
 * @Description:
 */

@Configuration
public class DefaultWebMvcConfigure implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TraceInterceptor());
    }
}
