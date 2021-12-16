package com.example.todo.controller;

import java.util.List;

import com.example.todo.constant.UrlConst;
import com.example.todo.dto.DoneTaskDto;
import com.example.todo.dto.TaskInfoDto;
import com.example.todo.service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class TopController extends BaseController {

  private final TaskService taskService;

  @GetMapping(value = UrlConst.GET_TASK)
  public List<TaskInfoDto> getTask() {
    List<TaskInfoDto> taskInfo = taskService.getTask();
    return taskInfo;
  }

  @PostMapping(value = UrlConst.INSERT_TASK)
  public int createTask(@RequestBody TaskInfoDto dto) {
    int result = taskService.createTask(dto);
    return result;
  }

  @PutMapping(value = UrlConst.UPDATE_TASK)
  public int updateTask(@RequestBody TaskInfoDto dto) {
    int result = taskService.updateTask(dto);
    return result;
  }

  @DeleteMapping(value = UrlConst.DELETE_TASK + "/{id}")
  public int deleteTask(@PathVariable int id) {
    int result = taskService.deleteTask(id);
    return result;
  }

  @GetMapping(value = UrlConst.GET_ONE_TASK)
  public TaskInfoDto getOneTask(@RequestParam int id) {
    TaskInfoDto taskInfo = taskService.getOneTask(id);
    return taskInfo;
  }

  @PutMapping(value = UrlConst.DONE_TASK)
  public int doneTask(@RequestBody DoneTaskDto dto) {
    int result = taskService.doneTask(dto);
    return result;
  }
}
