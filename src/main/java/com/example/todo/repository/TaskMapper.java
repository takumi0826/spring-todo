package com.example.todo.repository;

import java.util.List;

import com.example.todo.dto.TaskInfoDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {

  public int insertTask(TaskInfoDto dto);

  public List<TaskInfoDto> getTask();

  public int updateTask(TaskInfoDto dto);

  public int deleteTask(int id);
}
