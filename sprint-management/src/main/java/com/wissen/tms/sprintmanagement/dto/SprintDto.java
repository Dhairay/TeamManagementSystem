package com.wissen.tms.sprintmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SprintDto {

    private Integer id;
    private String name;
    private String goal;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String createdBy;
    private LocalDateTime createdDate;
    private Boolean activeFlag;
}
