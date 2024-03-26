package com.wissen.tms.taskmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {

    private Integer id;
    private String name;
    private String effort;
    private String stage;
    private String type;
    private String createdBy;
    private LocalDateTime createdDate;
    private Boolean activeFlag;

}
