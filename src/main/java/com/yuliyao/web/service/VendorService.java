package com.yuliyao.web.service;

import com.yuliyao.web.entity.Vendor;
import com.yuliyao.web.form.VendorForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author yuliyao
 * @date 2018/8/23
 */
public interface VendorService {

    /**
     * 保存，根据预警规则判断是否需要预警
     * @param vendor
     * @return
     */
    Vendor save(Vendor vendor);

    /**
     * 批量新增
     * @param vendor
     * @return
     */
    List<Vendor> save(List<Vendor> vendor);

    /**
     * 查询无证户分页信息
     * @param vendorForm
     * @param pageable
     * @return
     */
    Page<Vendor> findVendorPage(VendorForm vendorForm, Pageable pageable);

}
