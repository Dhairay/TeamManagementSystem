package com.wissen.tms.projectmanagement.service;

import com.wissen.tms.projectmanagement.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

    ProjectDto createProject(ProjectDto projectDto);

    ProjectDto updateProject(ProjectDto projectDto,Integer projectId);

    ProjectDto getProject(Integer projectId);

    void deleteProject(Integer projectId);

    List<ProjectDto> getProjects();
}
