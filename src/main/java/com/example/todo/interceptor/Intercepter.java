package com.example.todo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.todo.service.UserService;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Intercepter implements HandlerInterceptor {
  
  private final UserService userService;

  @Override
  public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
    //true: コントローラへ。false: コントローラーへ行かせない。
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {
    // コントローラー後に行いたい共通処理を書く。
    System.out.println("コントローラー後に行いたい共通処理を書く。");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object Handler, 
      @Nullable Exception ex)
      throws Exception {
    System.out.println("リクエストの後に行いたい共通処理を書く。");
  }
}
