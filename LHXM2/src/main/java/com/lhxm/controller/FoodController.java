package com.lhxm.controller;


import com.lhxm.entity.Food;
import com.lhxm.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {
    @Resource
    private FoodService foodService;

    @ResponseBody
    @RequestMapping("/foodlei")
    public List<Food> findByFenlei(@RequestParam(defaultValue = "1") Integer fenlei){
        List<Food> foods = foodService.findByFenlei(fenlei);

        return foods;
    }
}
