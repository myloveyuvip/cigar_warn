package com.yuliyao.web.manager.impl;

import com.alibaba.fastjson.JSON;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.yuliyao.web.manager.SmsManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yuliyao
 * @date 2018/9/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SmsManagerImplTest {

    @Autowired
    private SmsManager smsManager;

//    @Test
    public void sendWarnMsg() {

        SmsSingleSenderResult smsSingleSenderResult =
                smsManager.sendWarnMsg("张三", "那一家休闲食品", "卷烟时间超过半年");
        log.info(JSON.toJSONString(smsSingleSenderResult));
        Assert.assertEquals(0, smsSingleSenderResult.result);

    }
}