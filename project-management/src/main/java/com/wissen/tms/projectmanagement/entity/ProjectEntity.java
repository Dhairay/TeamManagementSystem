package com.wissen.tms.projectmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "project_details")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer projectId;

    @Column(name = "name")
    private String projectName;

    @Column(name = "discription")
    private String projectDiscription;

    @Column(name = "startdate")
    private Date projectStartDate;

    @Column(name = "type")
    private String projectType;

    @Column(name = "estimate")
    private String projectEstimate;

    @Column(name = "cretaedby")
    private String createdBy;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "activeflag")
    private Boolean activeFlag;

}
