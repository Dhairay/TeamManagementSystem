package com.wissen.tms.projectmanagement.repo;

import com.wissen.tms.projectmanagement.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<ProjectEntity,Integer> {
}
