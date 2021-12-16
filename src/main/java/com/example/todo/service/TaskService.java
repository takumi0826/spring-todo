package com.example.todo.service;

import java.util.List;

import com.example.todo.dto.DoneTaskDto;
import com.example.todo.dto.TaskInfoDto;

import org.springframework.stereotype.Service;

@Service
public interface TaskService {
  
  int createTask(TaskInfoDto dto);

  List<TaskInfoDto> getTask();

  int updateTask(TaskInfoDto dto);
  
  int deleteTask(int id);
  
  TaskInfoDto getOneTask(int id);

  int doneTask(DoneTaskDto dto);
}
