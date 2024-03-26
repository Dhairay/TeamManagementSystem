package com.wissen.tms.projectmanagement.controller;

import com.wissen.tms.projectmanagement.dto.ProjectDto;
import com.wissen.tms.projectmanagement.response.ApiResponse;
import com.wissen.tms.projectmanagement.service.ProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Project")
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // post
    @Operation(description = "You can create a new project.",summary = "Create Project")
    @PostMapping("/")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {
        ProjectDto createProject = this.projectService.createProject(projectDto);
        return new ResponseEntity<ProjectDto>(createProject, HttpStatus.CREATED);
    }

    // put
    @Operation(description = "You can update project details by using project-id.",summary = "Update Project")
    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto,
                                                    @PathVariable Integer projectId) {
        ProjectDto updateProject = this.projectService.updateProject(projectDto, projectId);
        return new ResponseEntity<ProjectDto>(updateProject, HttpStatus.OK);
    }

    // delete
    @Operation(description = "You can delete project details by using project-id.",summary = "Delete Project")
    @DeleteMapping("/{projectId}")
    public ApiResponse deleteProject(@PathVariable Integer projectId) {
        this.projectService.deleteProject(projectId);
        return new ApiResponse("Project Deleted Successfully", true);
    }

    // get
    @Operation(description = "You can get project details by using project-id.",summary = "Get Projects")
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable Integer projectId) {
        ProjectDto getProject = this.projectService.getProject(projectId);
        return new ResponseEntity<ProjectDto>(getProject, HttpStatus.OK);
    }

    //getAllProjects
    @Operation(description = "You can get all project details.",summary = "Get All Projects")
    @GetMapping("/")
    public ResponseEntity<List<ProjectDto>> getAllProject() {
        List<ProjectDto> getAllProject = this.projectService.getProjects();
        return new ResponseEntity<List<ProjectDto>>(getAllProject, HttpStatus.OK);
    }

}
