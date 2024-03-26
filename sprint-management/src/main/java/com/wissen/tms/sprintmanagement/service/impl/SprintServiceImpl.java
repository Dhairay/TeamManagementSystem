package com.wissen.tms.sprintmanagement.service.impl;

import com.wissen.tms.sprintmanagement.dto.SprintDto;
import com.wissen.tms.sprintmanagement.entity.SprintEntity;
import com.wissen.tms.sprintmanagement.exceptions.ResourceNotFoundException;
import com.wissen.tms.sprintmanagement.repo.SprintRepo;
import com.wissen.tms.sprintmanagement.service.SprintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepo sprintRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public SprintDto createSprint(SprintDto sprintDto) {

        SprintEntity sprintEntity = this.modelMapper.map(sprintDto, SprintEntity.class);
        sprintEntity.setSprintStartDate(LocalDateTime.now());
        sprintEntity.setSprintEndDate(LocalDateTime.now());
        sprintEntity.setCreatedDate(LocalDateTime.now());

        SprintEntity createSprint = this.sprintRepo.save(sprintEntity);
        return this.modelMapper.map(createSprint, SprintDto.class);
    }

    @Override
    public SprintDto updateSprint(SprintDto sprintDto, Integer sprintId) {
        SprintEntity sprintEntity = this.sprintRepo.findById(sprintId).orElseThrow(() -> new ResourceNotFoundException("Sprint", "Id", sprintId));

        sprintEntity.setSprintName(sprintDto.getName());
        sprintEntity.setSprintGoal(sprintDto.getGoal());
        sprintEntity.setCreatedBy(sprintDto.getCreatedBy());
        sprintEntity.setActiveFlag(sprintDto.getActiveFlag());

        SprintEntity updateSprint = this.sprintRepo.save(sprintEntity);

        return this.modelMapper.map(updateSprint, SprintDto.class);
    }

    @Override
    public void deleteSprint(Integer sprintId) {
        SprintEntity sprintEntity = this.sprintRepo.findById(sprintId).orElseThrow(() -> new ResourceNotFoundException("Sprint", "Id", sprintId));
        this.sprintRepo.delete(sprintEntity);
    }

    @Override
    public SprintDto getSprint(Integer sprintId) {
        SprintEntity sprintEntity=this.sprintRepo.findById(sprintId).orElseThrow(()->new ResourceNotFoundException("Sprint","Id",sprintId));
        return this.modelMapper.map(sprintEntity,SprintDto.class);
    }

    @Override
    public List<SprintDto> getSprints() {
        List<SprintEntity> sprintEntities =this.sprintRepo.findAll();
        List<SprintDto> sprintDtos=sprintEntities.stream().map(sprintEntity -> this.modelMapper.map(sprintEntity,SprintDto.class)).collect(Collectors.toList());
        return sprintDtos;
    }

}
