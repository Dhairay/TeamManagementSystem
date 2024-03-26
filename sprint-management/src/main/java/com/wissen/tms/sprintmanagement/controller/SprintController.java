package com.wissen.tms.sprintmanagement.controller;

import com.wissen.tms.sprintmanagement.dto.SprintDto;
import com.wissen.tms.sprintmanagement.response.ApiResponse;
import com.wissen.tms.sprintmanagement.service.SprintService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Sprint")
@RequestMapping("api/")
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @Operation(description = "You can create a new Sprint.",summary = "Create Sprint")
    @PostMapping("sprint/")
    public ResponseEntity<SprintDto> createSprint(
            @RequestBody SprintDto sprintDto) {
        SprintDto createSprint = this.sprintService.createSprint(sprintDto);
        return new ResponseEntity<SprintDto>(createSprint, HttpStatus.CREATED);
    }

    @Operation(description = "You can update sprint details by using sprint-id.",summary = "Update Sprint")
    @PutMapping("sprint/{sprintId}")
    public ResponseEntity<SprintDto> updateSprint(
            @RequestBody SprintDto sprintDto,
            @PathVariable Integer sprintId) {
        SprintDto updateSprint = this.sprintService.updateSprint(sprintDto, sprintId);
        return new ResponseEntity<SprintDto>(updateSprint, HttpStatus.OK);
    }

    @Operation(description = "You can delete sprint details by using sprint-id.",summary = "Delete Sprint")
    @DeleteMapping("sprint/{sprintId}")
    public ApiResponse deleteSprint(@PathVariable Integer sprintId) {
        this.sprintService.deleteSprint(sprintId);
        return new ApiResponse("Sprint Deleted Successfully", true);
    }

    @Operation(description = "You can get sprint details by using sprint-id.",summary = "Get Sprint")
    @GetMapping("sprint/{sprintId}")
    public ResponseEntity<SprintDto> getSprint(@PathVariable Integer sprintId) {
        SprintDto getSprint = this.sprintService.getSprint(sprintId);
        return new ResponseEntity<SprintDto>(getSprint, HttpStatus.OK);
    }

    @Operation(description = "You can get all sprint details.",summary = "Get All Sprint")
    @GetMapping("sprint/")
    public ResponseEntity<List<SprintDto>> getSprint() {
        List<SprintDto> getAllSprints = this.sprintService.getSprints();
        return ResponseEntity.ok(getAllSprints);
    }
}
