package com.yuliyao.web.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author yuliyao
 */
@Data
@Entity
@Table(name = "t_vendor")
public class Vendor{


    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "零售户名称不能为空")
    private String  vendorName;
    @NotNull(message = "专管所不能为空")
    private Integer managerOffice;
    @NotBlank(message = "地址不能为空")
    private String  address;
    @NotNull(message = "是否中小学周边不能为空")
    private Integer isNearSchool;
    private Double  longitude;
    private Double  latitude;
    @NotBlank(message = "经营者姓名不能为空")
    private String  operatorName;
    @NotBlank(message = "联系电话不能为空")
    private String  phone;
    private String  nativePlace;
    private Integer distribution;
    private Integer industryType;
    @NotNull(message = "是否有工商执照不能为空")
    private Integer hasLicense;
    private Integer  illegalTimes;
    private Integer isSpecialPlace;
    @NotBlank(message = "卷烟喷码不能为空")
    private String  cigarCode;
    @NotBlank(message = "主销品种不能为空")
    private String  saleKind;
    @NotNull(message = "月销量不能为空")
    private Integer monthlySales;
    @NotNull(message = "未办证原因不能为空")
    private Integer noCertReason;
    private Date operateTime;
    private Date    registerTime;
    private String  shopPic;
    private String  remark;
    private Integer isNeedWarn;
    private String warnReason;
    /*private Date gmt_create;
    private Date gmt_update;*/

}
