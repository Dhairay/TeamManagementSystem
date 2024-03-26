package com.wissen.tms.projectmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class ProjectDto {

    private Integer id;
    private String name;
    private String discription;
    private Date startDate;
    private String type;
    private String estimate;
    private String createdBy;
    private LocalDateTime createdDate;
    private Boolean activeFlag;
}
