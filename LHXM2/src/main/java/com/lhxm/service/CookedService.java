package com.lhxm.service;

import com.lhxm.entity.Cookbz;
import com.lhxm.entity.Cooked;
import com.lhxm.entity.Cookxcl;


import java.util.List;

public interface CookedService {

    List<Cooked> findByType(String type);

    //根据id查询食谱材料
    List<Cookxcl> findById(Integer cookid);

    //根据id查询食谱步骤
    List<Cookbz> findBuZhouById(Integer cookid);
}
