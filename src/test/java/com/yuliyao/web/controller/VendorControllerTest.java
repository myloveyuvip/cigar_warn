package com.yuliyao.web.controller;

import com.alibaba.fastjson.JSON;
import com.yuliyao.web.entity.Vendor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VendorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void vendorAdd() throws Exception {
        Vendor vendor = new Vendor();
        vendor.setAddress("中平花园");
        vendor.setCigarCode("123");
        vendor.setDistribution(1);
        vendor.setHasLicense(1);
        vendor.setIllegalTimes(1);
        vendor.setIndustryType(1);
        vendor.setIsNearSchool(1);
        vendor.setIsSpecialPlace(1);
        vendor.setLatitude(111.23);
        vendor.setLongitude(122.33);
        vendor.setManagerOffice(1);
        vendor.setVendorName("中平花园总店");
        vendor.setMonthlySales(2);
        vendor.setNativePlace("三明");
        vendor.setNoCertReason(1);
        vendor.setSaleKind("很多,wer");
        vendor.setPhone("18350027124");
        vendor.setOperateTime(new Date());
        vendor.setRegisterTime(new Date());
        vendor.setOperatorName("钟老板");
        vendor.setRemark("备注");
        System.out.println(JSON.toJSONString(vendor));
        mvc.perform(MockMvcRequestBuilders.post("/vendor").contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(vendor)));
    }

    @Test
    public void getVendorAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/vendors")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}