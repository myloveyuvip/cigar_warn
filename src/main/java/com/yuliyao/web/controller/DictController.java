package com.yuliyao.web.controller;

import com.yuliyao.web.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yuliyao
 * @date 2018-08-17
 */
@RestController
public class DictController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("dict/allMap")
    public Map<String, Map<String,String>> queryAllDictForMap() {
        return dictionaryService.queryAllDictForMap();
    }

}
