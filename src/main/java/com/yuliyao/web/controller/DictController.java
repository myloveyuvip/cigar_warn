package com.yuliyao.web.controller;

import com.yuliyao.web.entity.Result;
import com.yuliyao.web.service.DictionaryService;
import com.yuliyao.web.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuliyao
 * @date 2018-08-17
 */
@RestController
public class DictController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("dict/allMap")
    public Result queryAllDictForMap() {
        return ResultUtil.success(dictionaryService.queryAllDictForMap());
    }

}
