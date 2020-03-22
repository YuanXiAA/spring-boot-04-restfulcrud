package com.lyf.springboot.config;

import com.lyf.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用WebMvcConfigurer可以来扩展SpringMVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //注册视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("success");
    }

//    //注册拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//            .excludePathPatterns("/login", "/", "/user/login", "/asserts/**", "/webjars/**");
//    }

    //第二种方法：所有的WebMvcConfigurer组件都会一起起作用
    @Bean   //将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/dashboard").setViewName("dashboard");
                registry.addViewController("/hello1").setViewName("hello");
            }
        };
        return webMvcConfigurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
