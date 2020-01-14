package com.lhxm.service.impl;


import com.lhxm.dao.FoodMapper;
import com.lhxm.entity.Food;
import com.lhxm.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Resource
    private FoodMapper foodMapper;
    @Override
    public List<Food> findByFenlei(Integer fenlei) {

        return foodMapper.findByFenlei(fenlei);
    }
}
