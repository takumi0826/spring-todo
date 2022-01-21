package com.example.todo.controller;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionTestController {

  @GetMapping("/null")
  public void nullPo() throws NullPointerException {
    throw new NullPointerException("えらー");
  }

  @GetMapping("/file")
  public void file() throws FileNotFoundException {
    throw new FileNotFoundException("えらー");
  }

  @GetMapping("/exception")
  public void exception() throws Exception {
    throw new Exception("えらー");
  }
}
