package com.yuliyao.web.manager.impl;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.yuliyao.web.config.SmsConfig;
import com.yuliyao.web.manager.SmsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author yuliyao
 * @date 2018/9/1
 */
@Component
public class SmsManagerImpl implements SmsManager {

    @Autowired
    private SmsConfig smsConfig;

    @Override
    public SmsSingleSenderResult sendWarnMsg(String staffName, String vendorName, String warnCondition) {

        String[] params = new String[]{staffName, vendorName, warnCondition};
        return sendMsg(smsConfig.getTemplateId(), params);
    }

    @Override
    public SmsSingleSenderResult sendMultiWarnMsg(String staffName, String vendorName) {
        return sendMsg(smsConfig.getMultiWarnTemplateId(), new String[]{staffName, vendorName});

    }

    private SmsSingleSenderResult sendMsg(Integer templateId, String[] params) {
        SmsSingleSender smsSingleSender = new SmsSingleSender(smsConfig.getAppId(), smsConfig.getAppKey());
        SmsSingleSenderResult result = null;
        try {
            result = smsSingleSender.sendWithParam("86", smsConfig.getPhone(),
                    templateId, params, smsConfig.getSmsSign(), "", "");
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
