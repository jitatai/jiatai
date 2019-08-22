package com.jt.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jt.bbs.interceptor.LoginInterceptor;


@SpringBootApplication
@MapperScan("com.jt")
public class BbsApplication implements WebMvcConfigurer{
    public static void main(String[] args) {
        SpringApplication.run(BbsApplication.class, args);
    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/toedit").addPathPatterns("/comment");
	}
}
