package com.example.todo.service;

import java.util.List;

import com.example.todo.dto.TaskInfoDto;

public interface TaskService {
  
  void createTask(TaskInfoDto dto);

  List<TaskInfoDto> getTask();

  void updateTask(TaskInfoDto dto);

  void deleteTask(int id);
}
