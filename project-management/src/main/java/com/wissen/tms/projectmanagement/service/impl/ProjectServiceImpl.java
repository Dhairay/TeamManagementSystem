package com.wissen.tms.projectmanagement.service.impl;

import com.wissen.tms.projectmanagement.dto.ProjectDto;
import com.wissen.tms.projectmanagement.entity.ProjectEntity;
import com.wissen.tms.projectmanagement.exceptions.ResourceNotFoundException;
import com.wissen.tms.projectmanagement.repo.ProjectRepo;
import com.wissen.tms.projectmanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {

        ProjectEntity projectEntity=this.modelMapper.map(projectDto, ProjectEntity.class);
        projectEntity.setProjectStartDate(new Date());
        projectEntity.setCreatedDate(LocalDateTime.now());
        ProjectEntity createdProject=this.projectRepo.save(projectEntity);

        return this.modelMapper.map(createdProject,ProjectDto.class);
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto, Integer projectId) {

        ProjectEntity projectEntity=this.projectRepo.findById(projectId).orElseThrow(()->new ResourceNotFoundException("Project","Id",projectId));
        projectEntity.setProjectName(projectDto.getName());
        projectEntity.setProjectDiscription(projectDto.getDiscription());
        projectEntity.setProjectType(projectDto.getType());
        projectEntity.setProjectEstimate(projectDto.getEstimate());
        projectEntity.setCreatedBy(projectDto.getCreatedBy());
        projectEntity.setActiveFlag(projectEntity.getActiveFlag());

        ProjectEntity updateProject=this.projectRepo.save(projectEntity);

        return this.modelMapper.map(updateProject,ProjectDto.class);
    }

    @Override
    public ProjectDto getProject(Integer projectId) {

        ProjectEntity projectEntity=this.projectRepo.findById(projectId).orElseThrow(()->new ResourceNotFoundException("Project","Id",projectId));

        return this.modelMapper.map(projectEntity,ProjectDto.class);
    }

    @Override
    public void deleteProject(Integer projectId) {
        ProjectEntity projectEntity=this.projectRepo.findById(projectId).orElseThrow(()->new ResourceNotFoundException("Project","Id",projectId));
         this.projectRepo.delete(projectEntity);
    }

    @Override
    public List<ProjectDto> getProjects()
    {
        List<ProjectEntity> projectEntities=this.projectRepo.findAll();
        List<ProjectDto> projectDtos=projectEntities.stream().map((projectEntity)->this.modelMapper.map(projectEntity,ProjectDto.class)).collect(Collectors.toList());
        return projectDtos;
    }
}
