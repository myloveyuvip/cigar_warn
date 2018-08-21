package com.yuliyao.web.controller;

import com.yuliyao.web.entity.Result;
import com.yuliyao.web.entity.Vendor;
import com.yuliyao.web.repository.VendorRepository;
import com.yuliyao.web.utils.ResultUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@Api(
        value = "无证户",
        tags = {"无证户管理"}
)
public class VendorController {


    @Autowired
    private VendorRepository vendorRepository;

    @PostMapping("/vendor")
    public Result<Vendor> vendorAdd(@RequestBody @Valid Vendor vendor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(vendorRepository.save(vendor));
    }

    @PostMapping("/vendors")
    public Result<Vendor> multiVendorAdd(@RequestBody @Valid List<Vendor> vendors, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(vendorRepository.save(vendors));
    }


    @GetMapping("vendors")
    public Result<Vendor> getVendorAll() {
        List<Vendor> all = vendorRepository.findAll();
        return ResultUtil.success(all);
    }

    @GetMapping("vendor/{id}")
    public Result<Vendor> getVendorById(@PathVariable("id") Long id) {
        Vendor vendor = vendorRepository.findOne(id);
        return ResultUtil.success(vendor);
    }

}
