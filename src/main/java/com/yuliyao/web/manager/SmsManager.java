package com.yuliyao.web.manager;

import com.github.qcloudsms.SmsSingleSenderResult;

/**
 * @author yuliyao
 * @date 2018/9/1
 */
public interface SmsManager {


    /**
     * 调用腾讯云发送短信，单个零售户预警
     * @param staffName 创建员工姓名
     * @param vendorName 零售户名称
     * @param warnCondition 触发预警条件
     * @return
     */
    SmsSingleSenderResult sendWarnMsg(String staffName, String vendorName, String warnCondition);

    /**
     * 多个零售户预警
     * @param staffName
     * @param vendorName
     */
    SmsSingleSenderResult sendMultiWarnMsg(String staffName, String vendorName);
}
