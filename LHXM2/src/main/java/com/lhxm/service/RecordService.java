package com.lhxm.service;

import com.lhxm.dto.DineDTO;

import java.util.List;
import java.util.Map;

public interface RecordService {
    //添加体重
    int addWeight(int userid, double weight);
    //查找饮食运动展开
    Map findNow(int userid, String date);
    //根据食物名称模糊查
    List<DineDTO> findFoodByName(String name);
    //饮食分析
    Map findAllByDate(int userid, String date);
    //根据不同列查找食物
    List<DineDTO> findFood(String row);
    //添加食物
    int addUserFood(int userid, String date, int dine, String foodname, String foodnum);
    //发动态
    int addDynamic(int userid, String content, String path);
}
