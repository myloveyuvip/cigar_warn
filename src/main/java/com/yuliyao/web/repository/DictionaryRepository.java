package com.yuliyao.web.repository;

import com.yuliyao.web.dto.DictDTO;
import com.yuliyao.web.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @author yuliyao
 */
public interface DictionaryRepository extends JpaRepository<Dictionary,String> {

    /**
     * 查询所有数据字典，以DictDTO展示
     */
    @Query("select new com.yuliyao.web.dto.DictDTO(d.name,i.name,i.value) from Dictionary d,DictItem i where d.uId=i.dictId order by i.dictId,i.sortIndex")
    public List<DictDTO> queryAllDict();

}
