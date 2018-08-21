package com.yuliyao.web.repository;

import com.yuliyao.web.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yuliyao
 * @date 2018-08-21
 */
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    /**
     * 查询所有记录，按ID倒序
     * @return
     */
    public List<Vendor> findAllByOrderByIdDesc();

}
