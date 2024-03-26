package com.wissen.tms.teammanagement.repo;

import com.wissen.tms.teammanagement.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepo extends JpaRepository<TeamEntity,Integer> {

}
