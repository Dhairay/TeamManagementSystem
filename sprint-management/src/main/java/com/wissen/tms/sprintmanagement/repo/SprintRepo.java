package com.wissen.tms.sprintmanagement.repo;

import com.wissen.tms.sprintmanagement.entity.SprintEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepo extends JpaRepository<SprintEntity,Integer> {


}
