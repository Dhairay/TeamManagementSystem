package com.wissen.tms.teammanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TeamDto {

    private Integer id;
    private String name;
    private String description;
    private String type;
    private LocalDateTime creationDate;
    private String createdBy;
    private LocalDateTime createdDate;
    private Boolean activeFlag;

}
