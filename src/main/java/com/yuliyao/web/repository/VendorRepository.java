package com.yuliyao.web.repository;

import com.yuliyao.web.entity.Vendor;
import com.yuliyao.web.form.VendorForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author yuliyao
 * @date 2018-08-21
 */
public interface VendorRepository extends JpaRepository<Vendor, Long>, JpaSpecificationExecutor<Vendor> {

    /**
     * 查询所有记录，按ID倒序
     * @return
     */
    public List<Vendor> findAllByOrderByIdDesc();


}
