package com.yuliyao.web.service.impl;

import com.google.common.base.Strings;
import com.yuliyao.web.constant.VendorConstant;
import com.yuliyao.web.entity.Vendor;
import com.yuliyao.web.form.VendorForm;
import com.yuliyao.web.repository.VendorRepository;
import com.yuliyao.web.service.VendorService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;


/**
 * 无证户
 *
 * @author yuliyao
 */
@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;


    @Override
    public Vendor save(Vendor vendor) {
        //判断是否需要预警
        deduceWarn(vendor);
        vendorRepository.save(vendor);
        return null;
    }

    @Override
    public List<Vendor> save(List<Vendor> vendors) {
        List<Vendor> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(vendors)) {
            for (Vendor vendor : vendors) {
                result.add(this.save(vendor));
            }
        }
        return result;
    }

    @Override
    public Page<Vendor> findVendorPage(VendorForm vendorForm, Pageable pageable) {
        return vendorRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            //专管所
            if (vendorForm.getManagerOffice() != null) {
                predicates.add(criteriaBuilder.equal(root.<String>get("managerOffice"), vendorForm.getManagerOffice()));
            }
            return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
    }

    /**
     * 根据规则判断是否需要预警
     *
     * @param vendor
     * @return
     */
    private void deduceWarn(Vendor vendor) {
        // 以下条件之一就不预警
        if (noWarn(vendor)) {
            vendor.setIsNeedWarn(0);
            return;
        }
        // 满足以下条件之一就预警
        vendor.setIsNeedWarn(1);
        // 1、有工商执照
        if (Objects.equals(vendor.getHasLicense(), VendorConstant.YES)) {
            vendor.setWarnReason("有工商执照");
            return;
        }
        // 2、卷烟喷码超过3家不一样

        // 3、主销品种超过5个
        // 4、月销量超过50条
        if (vendor.getMonthlySales() != null && vendor.getMonthlySales() == VendorConstant.MONTHLY_SALES_MT_50) {
            vendor.setWarnReason("月销量超过50条");
            return;
        }
        // 5、卷烟时间超过半年
        Calendar halfYearAgo = Calendar.getInstance();
        halfYearAgo.add(Calendar.MONTH, -6);
        if (vendor.getOperateTime() != null && vendor.getOperateTime().before(halfYearAgo.getTime())) {
            vendor.setWarnReason("卷烟时间超过半年");
            return;
        }
        // 6、登记时间超过半年
        if (vendor.getRegisterTime() != null && vendor.getRegisterTime().before(halfYearAgo.getTime())) {
            vendor.setWarnReason("卷烟时间超过半年");
            return;
        }
        // 7、特营场所：『是』
        if (Objects.equals(vendor.getIsSpecialPlace(), VendorConstant.YES)) {
            vendor.setWarnReason("特营场所");
            return;
        }
        vendor.setIsNeedWarn(0);
    }

    private boolean noWarn(Vendor vendor) {
        //  1、名称带『早餐店』
        if (VendorConstant.BREAK_FAST_VENDOR.equals(vendor.getVendorName())) {
            return true;
        }
        //  2、经营地址是学校周边
        boolean addressNearSchool = !Strings.isNullOrEmpty(vendor.getAddress()) && (vendor.getAddress().contains
                ("小学") || vendor.getAddress().contains("中学"));
        if (Objects.equals(VendorConstant.NEAR_SCHOOL, vendor.getIsNearSchool()) || addressNearSchool) {
            return true;
        }

        //  3、经纬度为空
        if (vendor.getLatitude() == null && vendor.getLongitude() == null) {
            return true;
        }
        //  4、经营者姓名为空
        if (Strings.isNullOrEmpty(vendor.getOperatorName())) {
            return true;
        }
        //  5、籍贯带有『云霄』
        if (VendorConstant.NATIVE_YUNXIAO.equals(vendor.getNativePlace())) {
            return true;
        }
        //  7、位置分布是『工地』
        if (Objects.equals(VendorConstant.DISTRIBUTION_CONSTRUCT, vendor.getDistribution())) {
            return true;
        }
        //  8、业态是『其他』
        if (Objects.equals(VendorConstant.INDUSTRY_TYPE_OTHER, vendor.getIndustryType())) {
            return true;
        }
        //  9、违规『是』
        if (vendor.getIllegalTimes() != null && vendor.getIllegalTimes() > 0) {
            return true;
        }
        //  10、未办证原因：『中小周边』、『临时工地』不预警
        if (Objects.equals(VendorConstant.NO_CERT_CONSTRUCT, vendor.getNoCertReason()) || Objects.equals(VendorConstant.NO_CERT_SCHOOL, vendor.getNoCertReason())) {
            return true;
        }
        return false;
    }
}
