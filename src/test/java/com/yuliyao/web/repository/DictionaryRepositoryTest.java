package com.yuliyao.web.repository;

import com.alibaba.fastjson.JSON;
import com.yuliyao.web.dto.DictDTO;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionaryRepositoryTest {

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Test
    public void queryAllDict() {
        List<DictDTO> dictDTOS = dictionaryRepository.queryAllDict();
        System.out.println(JSON.toJSONString(dictDTOS));
        Assert.notEmpty(dictDTOS);
    }
}