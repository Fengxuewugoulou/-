package com.lhxm.service;

import com.lhxm.entity.Food;


import java.util.List;


public interface FoodService {

    List<Food> findByFenlei(Integer fenlei);

}
