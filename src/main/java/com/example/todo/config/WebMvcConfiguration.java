package com.example.todo.config;

import com.example.todo.interceptor.Intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

  private final Intercepter intercepter;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(intercepter).addPathPatterns("/**").excludePathPatterns("/login", "/signup");

    // .addPathPatterns("/") で追加したパスにInterceptorが実行される。
    // .excludePathPatterns("/"); // 除外したいパス
  }
}
