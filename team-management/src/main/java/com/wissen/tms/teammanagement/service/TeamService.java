package com.wissen.tms.teammanagement.service;



import com.wissen.tms.teammanagement.dto.TeamDto;

import java.util.List;

public interface TeamService {

    TeamDto createTeam(TeamDto teamDto);

    TeamDto updateTeam(TeamDto teamDto, Integer teamId);

    void deleteTeam(Integer teamId);

    TeamDto getTeam(Integer teamId);

    List<TeamDto> getTeams();

}
