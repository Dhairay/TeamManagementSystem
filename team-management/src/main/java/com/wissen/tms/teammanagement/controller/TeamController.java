package com.wissen.tms.teammanagement.controller;

import com.wissen.tms.teammanagement.dto.TeamDto;
import com.wissen.tms.teammanagement.response.ApiResponse;
import com.wissen.tms.teammanagement.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Operation(description = "You can creating a new team.", summary = "Create Team",tags = {"Team"})
    @PostMapping("/teams")
    public ResponseEntity<TeamDto> createTeam(
            @RequestBody TeamDto teamDto) {
        TeamDto createTeamDto = this.teamService.createTeam(teamDto);
        return new ResponseEntity<TeamDto>(createTeamDto, HttpStatus.CREATED);
    }

    @Operation(description = "You can update team details by using team-id.", summary = "Updating Team")
    @PutMapping("/teams/{teamId}")
    public ResponseEntity<TeamDto> updateTeam(
            @RequestBody TeamDto teamDto,
            @PathVariable Integer teamId) {
        TeamDto updateTeamDto = this.teamService.updateTeam(teamDto, teamId);
        return new ResponseEntity<TeamDto>(updateTeamDto, HttpStatus.OK);
    }

    @Operation(description = "You can delete team details by using team-id.",summary = "Deleting Team")
    @DeleteMapping("teams/{teamId}")
    public ApiResponse deleteTeam(@PathVariable Integer teamId) {
        this.teamService.deleteTeam(teamId);
        return new ApiResponse("Team Deleted Successfully", true);
    }

    @Operation(description = "You can get team details by using team-id.",summary = "Get Team")
    @GetMapping("/teams/{teamId}")
    public ResponseEntity<TeamDto> getTeam(@PathVariable Integer teamId) {
        TeamDto getTeam = this.teamService.getTeam(teamId);
        return new ResponseEntity<TeamDto>(getTeam, HttpStatus.OK);
    }

    @Operation(description = "You can get all team details.",summary = "Get All Teams")
    @GetMapping("/teams/")
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        List<TeamDto> getAllTeams=this.teamService.getTeams();
        return ResponseEntity.ok(getAllTeams);
    }

}
