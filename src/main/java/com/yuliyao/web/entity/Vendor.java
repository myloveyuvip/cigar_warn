package com.yuliyao.web.entity;

import lombok.Data;
import org.hswebframework.web.commons.entity.SimpleGenericEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_vendor")
public class Vendor extends SimpleGenericEntity<Long> {


    @Id
    @GeneratedValue
    private Long id;
    private String  VendorName;
    private Integer managerOffice;
    private String  address;
    private Integer isNearSchool;
    private Double  longitude;
    private Double  latitude;
    private String  operatorName;
    private String  phone;
    private String  nativePlace;
    private Integer distribution;
    private Integer industryType;
    private Integer hasLicense;
    private Integer  illegalTimes;
    private Integer isSpecialPlace;
    private String  cigarCode;
    private String  saleKind;
    private Integer monthlySales;
    private Integer noCertReason;
    private Date operateTime;
    private Date    registerTime;
    private String  shopPic;
    private String  remark;
    /*private Date gmt_create;
    private Date gmt_update;*/

}
