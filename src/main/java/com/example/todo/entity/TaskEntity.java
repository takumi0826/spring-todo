package com.example.todo.entity;

import lombok.Data;

@Data
public class TaskEntity {
  private int id;

  private String title;

  private boolean done;
}
