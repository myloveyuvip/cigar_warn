package com.yuliyao.web.service;


import java.util.Map;

/**
 * @author yuliyao
 * @date 2018/8/18
 */
public interface DictionaryService {

    /**
     * 用途：查询列表字典 值-名称 映射
     * @return
     */
    Map<String, Map<String, String>> queryAllDictForMap();
}
