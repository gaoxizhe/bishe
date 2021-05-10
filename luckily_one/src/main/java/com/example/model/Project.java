package com.example.model;

import lombok.Data;

@Data
public class Project {

  private Integer id;
  private String applicant;
  private String instructor;

  private String name;
  private String member;
  private Integer approvalStatus;
  private String year;
  private Integer completion;
  private String funding;
  /**
   * 级别
   */
  private String level;
  private String workload;



}
