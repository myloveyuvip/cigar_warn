package com.yuliyao.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.yuliyao.web.entity.Vendor;
import com.yuliyao.web.form.VendorForm;
import com.yuliyao.web.service.VendorService;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author yuliyao
 * @date 2018/8/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorServiceImplTest {

    @Autowired
    private VendorService vendorService;


    @Test
    public void findVendorPage() {
        VendorForm vendorForm = new VendorForm();
        vendorForm.setManagerOffice(1);
        vendorForm.setAddress("闽侯");
        vendorForm.setIsNeedWarn(0);
        vendorForm.setOperatorName("林");
        vendorForm.setPhone("1");
        vendorForm.setVendorName("工");
        PageRequest request = new PageRequest(0, 20);
        Page<Vendor> vendorPage = vendorService.findVendorPage(vendorForm, request);
        System.out.println(JSON.toJSONString(vendorPage));
        Assert.notEmpty(vendorPage.getContent());
    }
}