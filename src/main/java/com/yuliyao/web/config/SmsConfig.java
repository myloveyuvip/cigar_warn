package com.yuliyao.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yuliyao
 * @date 2018/9/1
 */
@Component
@ConfigurationProperties(prefix = "sms")
@Data
public class SmsConfig {

    private Integer appId;
    private String appKey;
    private String phone;
    private String smsSign;
    private Integer templateId;
    private Integer multiWarnTemplateId;


}
