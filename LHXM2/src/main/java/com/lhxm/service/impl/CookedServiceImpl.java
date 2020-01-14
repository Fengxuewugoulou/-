package com.lhxm.service.impl;


import com.lhxm.dao.CookedMapper;
import com.lhxm.entity.Cookbz;
import com.lhxm.entity.Cooked;
import com.lhxm.entity.Cookxcl;
import com.lhxm.service.CookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CookedServiceImpl implements CookedService {

    @Resource
    private CookedMapper cookedMapper;

    @Override
    public List<Cooked> findByType(String type) {
        List<Cooked> list = cookedMapper.findByType(type);
        return list;
    }

    @Override
    public List<Cookxcl> findById(Integer cookid) {
        return cookedMapper.findById(cookid);
    }

    @Override
    public List<Cookbz> findBuZhouById(Integer cookid) {
        return cookedMapper.findBuZhouById(cookid);
    }
}
