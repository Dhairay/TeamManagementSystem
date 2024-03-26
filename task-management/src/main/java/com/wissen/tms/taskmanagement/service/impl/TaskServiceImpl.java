package com.wissen.tms.taskmanagement.service.impl;

import com.wissen.tms.taskmanagement.dto.TaskDto;
import com.wissen.tms.taskmanagement.entity.TaskEntity;
import com.wissen.tms.taskmanagement.exception.ResourceNotFoundException;
import com.wissen.tms.taskmanagement.repo.TaskRepo;
import com.wissen.tms.taskmanagement.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        TaskEntity taskEntity = this.modelMapper.map(taskDto, TaskEntity.class);

        taskEntity.setCreatedDate(LocalDateTime.now());
        TaskEntity createdTask = this.taskRepo.save(taskEntity);
        return this.modelMapper.map(createdTask, TaskDto.class);
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto, Integer taskId) {
        TaskEntity taskEntity = this.taskRepo.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task", "Id", taskId));

        taskEntity.setTaskName(taskDto.getName());
        taskEntity.setTaskEffort(taskDto.getEffort());
        taskEntity.setTaskStage(taskDto.getStage());
        taskEntity.setTaskType(taskDto.getType());
        taskEntity.setCreatedBy(taskDto.getCreatedBy());
        TaskEntity updatedTask = this.taskRepo.save(taskEntity);

        return this.modelMapper.map(updatedTask, TaskDto.class);
    }

    @Override
    public void deleteTask(Integer taskId) {
    TaskEntity taskEntity=this.taskRepo.findById(taskId).orElseThrow(()->new ResourceNotFoundException("Task","Id",taskId));

    this.taskRepo.delete(taskEntity);
    }

    @Override
    public TaskDto getTask(Integer taskId) {
        TaskEntity taskEntity=this.taskRepo.findById(taskId).orElseThrow(()->new ResourceNotFoundException("Task","Id",taskId));
        return this.modelMapper.map(taskEntity,TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTask() {
        List<TaskEntity> taskEntities=this.taskRepo.findAll();
        List<TaskDto> taskDtos=taskEntities.stream().map(taskEntity -> this.modelMapper.map(taskEntity,TaskDto.class)).collect(Collectors.toList());
        return taskDtos;
    }
}
