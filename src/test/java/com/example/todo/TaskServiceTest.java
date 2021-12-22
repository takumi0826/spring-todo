package com.example.todo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.example.todo.dto.TaskInfoDto;
import com.example.todo.repository.TaskMapper;
import com.example.todo.service.TaskService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class TaskServiceTest {

  @Autowired
  private TaskService taskService;

  @Autowired
  private TaskMapper taskMapper;

  @BeforeEach
  void init() {
    TaskInfoDto dto = new TaskInfoDto();
    dto.setId(1);
    dto.setTitle("test");
    dto.setDone(false);
    taskMapper.insertTask(dto);
  }

  @Test
  void 登録処理() {
    TaskInfoDto dto = new TaskInfoDto();
    int result = taskService.createTask(dto);
    assertTrue(result == 1);
  }

  @Test
  void 削除処理() {
    int result = taskService.deleteTask(1);
    assertTrue(result == 1);
  }

  @Test
  void 取得処理() {
    List<TaskInfoDto> result = taskService.getTask();
    assertTrue(result.size() >= 1);
  }

  @Test
  void 更新処理() {
    TaskInfoDto dto = new TaskInfoDto();
    dto.setId(1);
    int result = taskService.updateTask(dto);
    assertTrue(result == 1);
  }
}
