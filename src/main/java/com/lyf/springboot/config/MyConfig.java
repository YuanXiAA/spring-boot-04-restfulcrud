package com.lyf.springboot.config;

import com.lyf.springboot.viewresolver.MyViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

@Configuration
public class MyConfig {

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }
}
