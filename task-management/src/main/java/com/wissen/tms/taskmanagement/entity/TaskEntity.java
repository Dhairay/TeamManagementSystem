package com.wissen.tms.taskmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "task_details")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer teamId;

    @Column(name= "name")
    private String taskName;

    @Column(name = "effort")
    private String taskEffort;

    @Column(name = "stage")
    private String taskStage;

    @Column(name = "type")
    private String taskType;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "activeflag")
    private boolean activeFlag;
}
