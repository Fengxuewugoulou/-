package com.lhxm.dao;

import com.lhxm.entity.Food;


import java.util.List;

public interface FoodMapper {

    List<Food> findByFenlei(Integer fenlei);
}
