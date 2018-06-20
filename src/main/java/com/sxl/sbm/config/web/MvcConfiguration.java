package com.sxl.sbm.config.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author SxL
 *         Created on 2018/6/6.
 */
@Configuration
@EnableWebMvc
public class MvcConfiguration implements ApplicationContextAware, WebMvcConfigurer {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 静态资源路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
///        registry.addResourceHandler("/resource/**").addResourceLocations("classpath:/resource/");
///        registry.addResourceHandler("/upload/**").addResourceLocations("file:/root/upload/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 拦截器
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //目标URL
//        String examplePath = "/**/**";
//        //注册拦截器
//        InterceptorRegistration exampleInterceptorRegistry = registry.addInterceptor(new ExampleInterceptor());
//        //添加拦截路径
//        exampleInterceptorRegistry.addPathPatterns(examplePath);
//        //排除拦截路径
//        exampleInterceptorRegistry.excludePathPatterns("/**/**");
//    }

    /**
     * 页面解析
     * @return
     */
    @Bean(name = "viewResolver")
    public ViewResolver createViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setApplicationContext(this.applicationContext);
        viewResolver.setCache(false);
        //页面存放位置
        viewResolver.setPrefix("/WEB-INF/html/");
        //页面文件后缀
        viewResolver.setSuffix(".html");

        return viewResolver;
    }

    /**
     * 上传文件处理
     * @return
     */
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver createCommonsMultipartResolver(){
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//
//        commonsMultipartResolver.setDefaultEncoding("utf-8");
//        commonsMultipartResolver.setMaxUploadSize(20971520);
//        commonsMultipartResolver.setMaxInMemorySize(20971520);
//
//        return commonsMultipartResolver;
//    }

    /**
     * 注册Servlet
     * @return
     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(){
//        //注册一个新Servlet(T Servlet, String servletName)
//        ServletRegistrationBean  servlet = new ServletRegistrationBean();
//        //servlet属性
//        servlet.addInitParameter("name", "value");
//
//
//        return servlet;
//    }
}
