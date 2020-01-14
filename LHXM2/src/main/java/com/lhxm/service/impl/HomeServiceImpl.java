package com.lhxm.service.impl;

import com.lhxm.dao.DineDao;
import com.lhxm.dto.DineDTO;
import com.lhxm.entity.Dine;
import com.lhxm.entity.ZBFood;
import com.lhxm.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    private DineDao dineDao;

    /**
     * 饮食定制
     * @param userid
     * @param date
     * @return
     */
    @Override
    public Map findDiet(int userid, String date) {
        //1.先查找每餐的具体食物
        Map map = new HashMap();
        map.put("userid",userid);
        map.put("date",date);
        List<Dine> dineList = dineDao.findDine(map);
        //封装
        List dineDTOList1 = new ArrayList();
        List dineDTOList2 = new ArrayList();
        List dineDTOList3 = new ArrayList();
        //2.根据具体食物名称，查找食物的calorie
        for (Dine dine : dineList) {
            DineDTO dineDTO = new DineDTO();
            if (dine.getDine() ==1){
                ZBFood food = dineDao.findByName(dine.getFoodname());
                dineDTO.setFoodname(dine.getFoodname());
                dineDTO.setFoodnum(dine.getFoodnum());
                dineDTO.setCalorie(food.getCalorie());
                dineDTO.setImg(food.getImg());
                dineDTOList1.add(dineDTO);
            }else if (dine.getDine() ==2){
                ZBFood food = dineDao.findByName(dine.getFoodname());
                dineDTO.setFoodname(dine.getFoodname());
                dineDTO.setFoodnum(dine.getFoodnum());
                dineDTO.setCalorie(food.getCalorie());
                dineDTO.setImg(food.getImg());
                dineDTOList2.add(dineDTO);
            }else if (dine.getDine() ==3){
                ZBFood food = dineDao.findByName(dine.getFoodname());
                dineDTO.setFoodname(dine.getFoodname());
                dineDTO.setFoodnum(dine.getFoodnum());
                dineDTO.setCalorie(food.getCalorie());
                dineDTO.setImg(food.getImg());
                dineDTOList3.add(dineDTO);
            }else {
                System.out.println(4);
            }
        }
        Map map1 = new HashMap();
        map1.put("早餐",dineDTOList1);
        map1.put("午餐",dineDTOList2);
        map1.put("晚餐",dineDTOList3);
        return map1;
    }
}
