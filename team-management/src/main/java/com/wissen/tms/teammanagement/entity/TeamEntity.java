package com.wissen.tms.teammanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "team_details")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer teamId;

    @Column(name = "name")
    private String teamName;

    @Column(name = "description")
    private String teamDescription;

    @Column(name = "type")
    private String teamType;

    @Column(name = "creationdate")
    private LocalDateTime teamCreationDate;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "activeflag")
    private Boolean activeFlag;

}
