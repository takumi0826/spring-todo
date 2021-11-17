package com.example.todo.controller;

import com.example.todo.constant.UrlConst;
import com.example.todo.form.SignupForm;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class TopController extends BaseController {

  @GetMapping(value = UrlConst.TOP)
  public String init(@CookieValue("SESSION") String cookie, SignupForm form, Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = auth.getName();
    return userId;
  }
}
