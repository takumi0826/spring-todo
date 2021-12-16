package com.example.todo.repository;

import java.util.List;

import com.example.todo.dto.TaskInfoDto;
import com.example.todo.entity.TaskEntity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {

  public int insertTask(TaskInfoDto dto);

  public List<TaskEntity> getTask();

  public int updateTask(TaskInfoDto dto);

  public int deleteTask(int id);

  public TaskEntity getOneTask(int id);

  public int doneTask (int id);
}
