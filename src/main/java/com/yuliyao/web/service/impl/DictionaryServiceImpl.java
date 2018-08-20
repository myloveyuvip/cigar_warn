package com.yuliyao.web.service.impl;

import com.yuliyao.web.dto.DictDTO;
import com.yuliyao.web.repository.DictionaryRepository;
import com.yuliyao.web.service.DictionaryService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuliyao
 * @date 2018/8/18
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryRepository repository;


    @Override
    public Map<String, Map<String, String>> queryAllDictForMap() {
        Map<String, Map<String, String>> result = new HashMap<>();
        List<DictDTO> dictDTOS = repository.queryAllDict();
        if (CollectionUtils.isEmpty(dictDTOS)) {
            return null;
        }
        for (DictDTO dictDTO : dictDTOS) {
            Map<String, String> itemMap = new HashMap<>();
            if (!result.containsKey(dictDTO.getDictName())) {
                itemMap.put(dictDTO.getItemValue(), dictDTO.getItemName());
                result.put(dictDTO.getDictName(), itemMap);
            } else {
                result.get(dictDTO.getDictName()).put(dictDTO.getItemValue(), dictDTO.getItemName());
            }

        }
        return result;
    }


}
