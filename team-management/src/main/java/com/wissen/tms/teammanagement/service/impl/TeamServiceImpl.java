package com.wissen.tms.teammanagement.service.impl;

import com.wissen.tms.teammanagement.dto.TeamDto;
import com.wissen.tms.teammanagement.entity.TeamEntity;
import com.wissen.tms.teammanagement.exceptions.ResourceNotFoundException;
import com.wissen.tms.teammanagement.repo.TeamRepo;
import com.wissen.tms.teammanagement.service.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TeamDto createTeam(TeamDto teamDto) {


        TeamEntity teamEntity=this.modelMapper.map(teamDto,TeamEntity.class);
        teamEntity.setTeamCreationDate(LocalDateTime.now());
        teamEntity.setCreatedDate(LocalDateTime.now());

        TeamEntity createdTeam=this.teamRepo.save(teamEntity);
        return this.modelMapper.map(createdTeam,TeamDto.class);
    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto, Integer teamId) {

        TeamEntity teamEntity=this.teamRepo.findById(teamId).orElseThrow(()-> new ResourceNotFoundException("Team","Id",teamId));

        teamEntity.setTeamName(teamDto.getName());
        teamEntity.setTeamDescription(teamDto.getDescription());
        teamEntity.setTeamType(teamDto.getType());
        teamEntity.setCreatedBy(teamDto.getCreatedBy());
        teamEntity.setActiveFlag(teamDto.getActiveFlag());

        TeamEntity updateTeam=this.teamRepo.save(teamEntity);

        return this.modelMapper.map(updateTeam,TeamDto.class);
    }

    @Override
    public void deleteTeam(Integer teamId) {
        TeamEntity teamEntity=this.teamRepo.findById(teamId).orElseThrow(()->new ResourceNotFoundException("Team","id",teamId));
        this.teamRepo.delete(teamEntity);
    }

    @Override
    public TeamDto getTeam(Integer teamId)
    {
        TeamEntity teamEntity=this.teamRepo.findById(teamId).orElseThrow(()->new ResourceNotFoundException("team","id",teamId));

        return this.modelMapper.map(teamEntity,TeamDto.class);
    }

    @Override
    public List<TeamDto> getTeams() {
        List<TeamEntity> teamEntities=this.teamRepo.findAll();
        List<TeamDto> teamDtos=teamEntities.stream().map((teamEntity) -> this.modelMapper.map(teamEntity,TeamDto.class)).collect(Collectors.toList());
        return teamDtos;
    }

}
