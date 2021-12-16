package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.todo.dto.TaskInfoDto;
import com.example.todo.entity.TaskEntity;
import com.example.todo.repository.TaskMapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
  
  private final ModelMapper modelMapper;

  private final TaskMapper taskMapper;

  public int createTask(TaskInfoDto dto) {
    return taskMapper.insertTask(dto);
  }

  public List<TaskInfoDto> getTask() {
    List<TaskEntity> entity = taskMapper.getTask();
    List<TaskInfoDto> output = new ArrayList<>();
    if (entity.size() > 0) {
      for (TaskEntity v : entity) {
        TaskInfoDto dto = new TaskInfoDto();
        modelMapper.map(v, dto);
        output.add(dto);
      }
    }
    return output;
  };

  public int updateTask(TaskInfoDto dto) {
    return taskMapper.updateTask(dto);
  };
  
  public int deleteTask(int id) {
    return taskMapper.deleteTask(id);
  };
  
  public TaskInfoDto getOneTask(int id) {
    TaskEntity entity = taskMapper.getOneTask(id);
    TaskInfoDto dto = new TaskInfoDto();
    modelMapper.map(entity,dto);
    return dto;
  };

  public int doneTask(int id) {
    return taskMapper.doneTask(id);
  };
}
