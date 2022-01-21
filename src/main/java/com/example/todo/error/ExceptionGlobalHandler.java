package com.example.todo.error;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.example.todo.controller")
public class ExceptionGlobalHandler {

  /**
   * NullPointerExceptionが発生した場合のエラー処理を行う
   *
   * @param exception 発生した例外
   * @return NullPointerExceptionが発生した場合のエラー画面
   */
  @ExceptionHandler(NullPointerException.class)
  public String nullError(NullPointerException exception, Model model) {
    model.addAttribute("errMsg", exception.getMessage());
    return "null";
  }

  /**
   * FileNotFoundExceptionが発生した場合のエラー処理を行う
   *
   * @param exception 発生した例外
   * @return FileNotFoundExceptionが発生した場合のエラー画面
   */
  @ExceptionHandler(FileNotFoundException.class)
  public String noFileError(FileNotFoundException exception, Model model) {
    model.addAttribute("errMsg", exception.getMessage());
    return "file";
  }

  /**
   * 上記以外の例外が発生した場合のエラー処理を行う
   * 
   * @param exception 発生した例外
   * @return デフォルトのエラー画面
   */
  @ExceptionHandler(Exception.class)
  public String occurOtherException(Exception exception, Model model) {
    model.addAttribute("errMsg", exception.getMessage());
    return "exception";
  }
}
