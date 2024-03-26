package com.wissen.tms.sprintmanagement.service;

import com.wissen.tms.sprintmanagement.dto.SprintDto;

import java.util.List;

public interface SprintService {

    SprintDto createSprint(SprintDto sprintDto);

    SprintDto updateSprint(SprintDto sprintDto, Integer sprintId);

    void deleteSprint(Integer sprintId);

    SprintDto getSprint(Integer sprintId);

    List<SprintDto> getSprints();

}
