package com.yuliyao.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.yuliyao.web.service.DictionaryService;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @author yuliyao
 * @date 2018/8/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionaryServiceImplTest {

    @Autowired
    private DictionaryService dictionaryService;

    @Test
    public void queryDictForMap() {
        Map<String, Map<String, String>> dictForMap = dictionaryService.queryAllDictForMap();
        System.out.println(JSON.toJSONString(dictForMap));
        Assert.notEmpty(dictForMap);

    }
}