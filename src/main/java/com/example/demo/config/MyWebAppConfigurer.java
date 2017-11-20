package com.example.demo.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.example.demo.extend.DecryptEncryptFastJsonHttpMessageConverter;
import com.example.demo.extend.RequestDecryptResponseEncryptBodyMethodProcessor;
import com.example.demo.extend.RequestDecryptResponseEncryptBodyProcessor;
import com.example.demo.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
        //registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new FastJsonHttpMessageConverter4());
    }
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        RequestDecryptResponseEncryptBodyProcessor processor=new RequestDecryptResponseEncryptBodyProcessor();
        List<MediaType> types=new ArrayList<>();
        types.add(MediaType.APPLICATION_JSON_UTF8);
        types.add(MediaType.TEXT_PLAIN);
        types.add(MediaType.parseMediaType("application/*+json;charset=UTF-8"));
        DecryptEncryptFastJsonHttpMessageConverter converters=new DecryptEncryptFastJsonHttpMessageConverter();
        converters.setRequestDecryptResponseEncryptBodyProcessor(processor);
        converters.setSupportedMediaTypes(types);
        List<HttpMessageConverter<?>> list=new ArrayList<>();
        list.add(converters);
        argumentResolvers.add(new RequestDecryptResponseEncryptBodyMethodProcessor(list));
    }


    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        RequestDecryptResponseEncryptBodyProcessor processor=new RequestDecryptResponseEncryptBodyProcessor();
        List<MediaType> types=new ArrayList<>();
        types.add(MediaType.TEXT_PLAIN);
        types.add(MediaType.APPLICATION_JSON_UTF8);
        types.add(MediaType.parseMediaType("application/*+json;charset=UTF-8"));
        DecryptEncryptFastJsonHttpMessageConverter converters=new DecryptEncryptFastJsonHttpMessageConverter();
        converters.setRequestDecryptResponseEncryptBodyProcessor(processor);
        converters.setSupportedMediaTypes(types);
        List<HttpMessageConverter<?>> list=new ArrayList<>();
        list.add(converters);
        returnValueHandlers.add(new RequestDecryptResponseEncryptBodyMethodProcessor(list));
    }


}
