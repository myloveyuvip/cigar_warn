package com.yuliyao.web.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 数据字典DTO
 * @author yuliyao
 */
@Data
@AllArgsConstructor
public class DictDTO {

    private String dictName;

    private String itemName;

    private String itemValue;
}
