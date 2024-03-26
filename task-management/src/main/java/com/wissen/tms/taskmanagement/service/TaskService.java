package com.wissen.tms.taskmanagement.service;

import com.wissen.tms.taskmanagement.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskDto taskDto);

    TaskDto updateTask(TaskDto taskDto, Integer taskId);

    void deleteTask(Integer taskId);

    TaskDto getTask(Integer taskId);

    List<TaskDto> getAllTask();
}
