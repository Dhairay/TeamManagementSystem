package com.wissen.tms.taskmanagement.controller;

import com.wissen.tms.taskmanagement.dto.TaskDto;
import com.wissen.tms.taskmanagement.response.ApiResponse;
import com.wissen.tms.taskmanagement.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Tasks")
@RequestMapping("api/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Operation(description = "You can create a new task.", summary = "Create Task")
    @PostMapping("task")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto createTask = this.taskService.createTask(taskDto);
        return new ResponseEntity<TaskDto>(createTask, HttpStatus.CREATED);
    }

    @Operation(description = "You can update task details by using task-id.",summary = "Update Task")
    @PutMapping("task/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @RequestBody TaskDto taskDto,
            @PathVariable Integer taskId) {
        TaskDto UpdateTask = this.taskService.updateTask(taskDto, taskId);
        return new ResponseEntity<TaskDto>(UpdateTask, HttpStatus.OK);
    }

    @Operation(description = "You can delete task details by using task-id.",summary = "Delete Task")
    @DeleteMapping("task/{taskId}")
    public ApiResponse deleteTask(@PathVariable Integer taskId) {
        this.taskService.deleteTask(taskId);
        return new ApiResponse("Task deleted Successfully", true);
    }

    @Operation(description = "You can get task details by using task-id.",summary = "Get Task")
    @GetMapping("task/{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Integer taskId) {
        TaskDto getTask = this.taskService.getTask(taskId);
        return new ResponseEntity<TaskDto>(getTask, HttpStatus.OK);
    }

    @Operation(description = "You can get All Task details.",summary = "Get All Task")
    @GetMapping("/task")
    public ResponseEntity<List<TaskDto>> getAllTask() {
        List<TaskDto> getAllTask = this.taskService.getAllTask();
        return new ResponseEntity<List<TaskDto>>(getAllTask, HttpStatus.OK);
    }
}
