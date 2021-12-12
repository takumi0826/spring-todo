package com.example.todo.form;

import lombok.Data;

@Data
public class TaskForm {
  private int id;

  private String title;

  private boolean done;
}
