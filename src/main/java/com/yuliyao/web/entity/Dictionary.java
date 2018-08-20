package com.yuliyao.web.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "s_dictionary")
public class Dictionary {

  @Id
  private String uId;
  private String name;
  private String classifiedId;
  private String describe;
  private double createTime;
  private String creatorId;
  private double status;
}
