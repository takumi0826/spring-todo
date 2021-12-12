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

  public int createTask(TaskInfoDto dto) {
    return taskMapper.insertTask(dto);
  }

  public List<TaskInfoDto> getTask() {
    return taskMapper.getTask();
  };

  public int updateTask(TaskInfoDto dto) {
    return taskMapper.updateTask(dto);
  };

  public int deleteTask(int id) {
    return taskMapper.deleteTask(id);
  };
}
