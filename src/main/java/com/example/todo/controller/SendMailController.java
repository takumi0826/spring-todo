package com.example.todo.controller;

import com.example.todo.constant.UrlConst;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SendMailController {

  private final MailSender mailSender;

  @PostMapping(value = UrlConst.MAIL)
  public void init(Model model) {
    System.out.println("sendMail");
    SimpleMailMessage msg = new SimpleMailMessage();
    // msg.setTo("");
    // msg.setCc("送信先メールアドレス2", "送信先メールアドレス3");
    // msg.setBcc("送信先メールアドレス4");
    msg.setSubject("件名: テストだよ");
    msg.setText("本文: テストだよ");

    // メール送信
    mailSender.send(msg);
  }
}
