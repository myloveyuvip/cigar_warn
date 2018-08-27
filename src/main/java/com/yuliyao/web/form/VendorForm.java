package com.yuliyao.web.form;

import lombok.Data;

/**
 * @author YuLiyao
 * @date 2018/8/27
 */
@Data
public class VendorForm extends PageForm{

    private String  vendorName;
    private Integer managerOffice;
    private String  address;
    private String  operatorName;
    private String  phone;
    private Integer isNeedWarn;
}
