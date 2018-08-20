package com.yuliyao.web.service.impl;

import com.yuliyao.web.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 无证户
 * @author yuliyao
 */
@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

}
