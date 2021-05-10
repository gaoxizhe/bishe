package com.example.model;

import lombok.Data;

@Data
public class StudentCompetition {
  private Integer id;
  private String host;
  private String team;
  private String teacher;
  private String competitionName;
  private Integer projectId;
  private String projectName;
  private String date;
  private String level;
  private String awards;
  private String workload;
}
