package com.example.todo.controller;

import com.example.todo.constant.UrlConst;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMailController {

  @PostMapping(value = UrlConst.MAIL)
  public void init(Model model) {
    System.out.println("sendMail");
  }
}
