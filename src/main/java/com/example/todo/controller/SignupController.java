package com.example.todo.controller;

import com.example.todo.constant.UrlConst;
import com.example.todo.dto.UserInfoDto;
import com.example.todo.form.SignupForm;
import com.example.todo.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SignupController {

  private final UserService userService;

  private final ModelMapper modelMapper;

  @GetMapping(value = UrlConst.SIGNUP)
  public String init(SignupForm form, Model model) {
    model.addAttribute("signupForm", form);
    return "/user/signup";
  }

  @PostMapping(value = UrlConst.SIGNUP)
  public void signUp(@Validated SignupForm form, BindingResult error, Model model) {
    log.info(form.toString());
    UserInfoDto dto = modelMapper.map(form, UserInfoDto.class);
    userService.signup(dto);
  }
}
