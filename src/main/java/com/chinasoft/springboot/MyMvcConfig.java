package com.chinasoft.springboot;

import com.chinasoft.springboot.component.LoginHandlerInterceptor;
import com.chinasoft.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver(){
        MyLocaleResolver myLocaleResover = new MyLocaleResolver();
        return myLocaleResover;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/dashboard").setViewName("dashboard");
                registry.addViewController("/peisong").setViewName("peisong");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/index","/login","/signIn");
            }


        };
        return webMvcConfigurer;
    }


}
