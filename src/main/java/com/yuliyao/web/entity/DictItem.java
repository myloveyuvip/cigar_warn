package com.yuliyao.web.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "s_dict_item")
public class DictItem {

  @Id
  private String uId;
  private String dictId;
  private String name;
  private String value;
  private String text;
  private String valueType;
  private double status;
  private String describe;
  private String parentId;
  private String path;
  private String searchCode;
  private double sortIndex;
  private double level;
  private double ordinal;
  private String properties;
}
