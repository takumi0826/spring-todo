package com.example.todo.error;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionGlobalHandler {
  @ExceptionHandler(Exception.class)
  public String handleException(Exception e, HttpServletResponse response, Model model) {
    response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    model.addAttribute("errorMessage", e.getMessage());

    return "foo/error";
  }
}
