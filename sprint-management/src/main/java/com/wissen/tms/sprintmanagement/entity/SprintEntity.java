package com.wissen.tms.sprintmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sprint_details")
public class SprintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer sprintId;

    @Column(name = "name")
    private String sprintName;

    @Column(name = "goal")
    private String sprintGoal;

    @Column(name = "startdate")
    private LocalDateTime sprintStartDate;

    @Column(name = "enddate")
    private LocalDateTime sprintEndDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "activeflag")
    private boolean activeFlag;

}
