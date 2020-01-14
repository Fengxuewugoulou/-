package com.lhxm.dao;

import com.lhxm.entity.Dine;
import com.lhxm.entity.ZBFood;
import com.lhxm.entity.Moments;

import java.util.List;
import java.util.Map;

public interface DineDao {

    //添加体重
    int addWeight(Map map);
    //查找每餐的具体食物
    List<Dine> findDine(Map map);
    //根据具体食物名称，查找食物的nourished,calorie
    ZBFood findByName(String foodname);
    //根据名称模糊查
    List<ZBFood> findFoodByName(Map map);
    //根据不同列查找食物
    List<ZBFood> findFood(String row);
    //添加食物
    int addUserFood(Map map);
    //发动态
    int addDynamic(Moments moments);
    //添加图片地址
    int addMompic(Map map);
}
