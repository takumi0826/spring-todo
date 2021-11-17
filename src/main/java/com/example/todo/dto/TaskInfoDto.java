package com.example.todo.dto;

import lombok.Data;

@Data
public class TaskInfoDto {

  private int id;

  private String title;

  private boolean done;
}
