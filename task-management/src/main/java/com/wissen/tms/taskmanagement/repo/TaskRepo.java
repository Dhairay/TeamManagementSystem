package com.wissen.tms.taskmanagement.repo;

import com.wissen.tms.taskmanagement.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TaskEntity,Integer> {
}
