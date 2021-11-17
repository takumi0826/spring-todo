package com.example.todo.service;

import java.util.List;

import com.example.todo.dto.TaskInfoDto;
import com.example.todo.repository.TaskMapper;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
  
  private final TaskMapper taskMapper;

  public void createTask(TaskInfoDto dto) {
    taskMapper.insertTask(dto);
  }

  public List<TaskInfoDto> getTask() {
    return taskMapper.getTask();
  };

  public void updateTask(TaskInfoDto dto) {
    taskMapper.updateTask(dto);
  };

  public void deleteTask(int id) {
    taskMapper.deleteOne(id);
  };
}
