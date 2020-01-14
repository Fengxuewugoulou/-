package com.lhxm.service.impl;

import com.lhxm.dao.DineDao;
import com.lhxm.dto.DineDTO;
import com.lhxm.entity.Dine;
import com.lhxm.entity.ZBFood;
import com.lhxm.entity.Moments;
import com.lhxm.service.RecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.*;

@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    private DineDao dineDao;

    /**
     * 添加体重
     * @param userid
     * @param weight
     * @return
     */
    @Override
    @Transactional
    public int addWeight(int userid,double weight) {
        Map map = new HashMap();
        map.put("userid",userid);
        map.put("weight",weight);
        return dineDao.addWeight(map);
    }

    /**
     * 查找饮食运动展开
     * @param userid
     * @param date
     * @return
     */
    @Override
    public Map findNow(int userid,String date) {
       //1.先查找每餐的具体食物
        Map map = new HashMap();
        map.put("userid",userid);
        map.put("date",date);
        List<Dine> dineList = dineDao.findDine(map);

        //封装
        List dineDTOList1 = new ArrayList();
        List dineDTOList2 = new ArrayList();
        List dineDTOList3 = new ArrayList();
        List dineDTOList4 = new ArrayList();
        //2.根据具体食物名称，查找食物的calorie
        //摄入
        Integer f1 = 0;
        Integer f2 = 0;
        Integer f3 = 0;
        Integer f4 = 0;
        //总卡路里
        Integer c1 = 0;
        Integer c2 = 0;
        Integer c3 = 0;
        for (Dine dine : dineList) {
            DineDTO dineDTO = new DineDTO();
            if (dine.getDine() ==1){
                ZBFood food = dineDao.findByName(dine.getFoodname());
                dineDTO.setFoodname(dine.getFoodname());
                String calorie = food.getCalorie();
                dineDTO.setCalorie(calorie);
                dineDTOList1.add(dineDTO);
                f1+=dine.getFoodnum();
                c1+=Integer.parseInt(calorie);
                dineDTOList1.add(c1);
            }else if (dine.getDine() ==2){
                ZBFood food = dineDao.findByName(dine.getFoodname());
                dineDTO.setFoodname(dine.getFoodname());
                String calorie = food.getCalorie();
                dineDTO.setCalorie(calorie);
                dineDTOList2.add(dineDTO);
                f2+=dine.getFoodnum();
                c2+=Integer.parseInt(calorie);
                dineDTOList2.add(c2);
            }else if (dine.getDine() ==3){
                ZBFood food = dineDao.findByName(dine.getFoodname());
                dineDTO.setFoodname(dine.getFoodname());
                String calorie = food.getCalorie();
                dineDTO.setCalorie(calorie);
                dineDTOList3.add(dineDTO);
                f3+=dine.getFoodnum();
                c3+=Integer.parseInt(calorie);
                dineDTOList3.add(c3);
            }else {
                dineDTO.setFoodname(dine.getFoodname());
                dineDTO.setFoodnum(dine.getFoodnum());
                dineDTOList4.add(dineDTO);
                f4+=dine.getFoodnum();
                dineDTOList4.add(f4);
            }
        }
        Map map1 = new HashMap();
        map1.put("早餐",dineDTOList1);
        map1.put("午餐",dineDTOList2);
        map1.put("晚餐",dineDTOList3);
        map1.put("运动",dineDTOList4);
        map1.put("食物摄入",f1+f2+f3);
        map1.put("还可摄入",c1+c2+c3);
        map1.put("运动消耗",f4);
        return map1;
    }

    /**
     * 根据名称模糊查
     * @param name
     * @return
     */
    @Override
    public List<DineDTO> findFoodByName(String name) {
        //模糊查询
        Map map = new HashMap();
        map.put("name",name);
        List<ZBFood> foodList = dineDao.findFoodByName(map);
        //封装
        List<DineDTO> dineDTOList = new ArrayList();
        for (ZBFood food : foodList) {
            DineDTO dineDTO = new DineDTO();
            dineDTO.setFoodname(food.getFoodname());
            dineDTO.setCalorie(food.getCalorie());
            dineDTOList.add(dineDTO);
        }
        return dineDTOList;
    }

    //饮食分析，去查dine表中的三餐食物和运动消耗，
    // 并根据食物名称查各自的卡路里，脂肪，蛋白质，热量，营养值，碳水化合物
    @Override
    public Map findAllByDate(int userid, String date) {
        //1.去查dine表中的三餐食物和运动消耗
        Map map = new HashMap();
        map.put("userid",userid);
        map.put("date",date);
        List<Dine> dineList = dineDao.findDine(map);

        //封装
        //2.根据具体食物名称，查找食物的calorie
        //摄入,运动消耗
        Integer intake1 = 0;Integer intake2 = 0;Integer intake3 = 0;Integer intake4 = 0;
        //卡路里
        double calorie1=0;double calorie2=0;double calorie3=0;
        //热量
        double hot1=0; double hot2=0; double hot3=3;
        //碳水化合物
        double carbohydrate1=0; double carbohydrate2=0; double carbohydrate3=0;
        //脂肪
        double axunge1=0;double axunge2=0;double axunge3=0;
        //蛋白质
        double protein1=0; double protein2=0; double protein3=3;
        for (Dine dine : dineList) {
            DineDTO dineDTO = new DineDTO();
            //把每餐的卡路里，脂肪。。全都算出总数
            if (dine.getDine() ==1){
                ZBFood food = dineDao.findByName(dine.getFoodname());
                double calorie = Double.valueOf(food.getCalorie());
                calorie1+=calorie;
                hot1+=calorie*0.8;
                carbohydrate1+=calorie*0.75;
                axunge1+=calorie*0.86;
                protein1+=calorie*0.76;
                intake1+=dine.getFoodnum();
            }else if (dine.getDine() ==2){
                ZBFood food = dineDao.findByName(dine.getFoodname());
                double calorie = Double.valueOf(food.getCalorie());
                calorie2+=calorie;
                hot2+=calorie*0.8;
                carbohydrate2+=calorie*0.75;
                axunge2+=calorie*0.86;
                protein2+=calorie*0.76;
                intake2+=dine.getFoodnum();
            }else if (dine.getDine() ==3){
                ZBFood food = dineDao.findByName(dine.getFoodname());
                double calorie = Double.valueOf(food.getCalorie());
                calorie3+=calorie;
                hot3+=calorie*0.8;
                carbohydrate3+=calorie*0.75;
                axunge3+=calorie*0.86;
                protein3+=calorie*0.76;
                intake3+=dine.getFoodnum();
            }else {
                intake4+=dine.getFoodnum();
            }
        }
        Map map1 = new HashMap();
        //格式化
        DecimalFormat format = new DecimalFormat("#.00");
        map1.put("食物摄入",format.format(intake1+intake2+intake3));
        map1.put("运动消耗",format.format(intake4));
        map1.put("热量预算",format.format(hot1+hot2+hot3));
        map1.put("碳水化合物",format.format(carbohydrate1+calorie2+calorie3));
        map1.put("脂肪",format.format(axunge1+axunge2+axunge3));
        map1.put("蛋白质",format.format(protein1+protein2+protein3));
        map1.put("早餐",calorie1);
        map1.put("午餐",calorie2);
        map1.put("晚餐",calorie3);
        return map1;
    }

    /**
     * 根据不同列查找食物
     * @param row
     * @return
     */
    @Override
    public List<DineDTO> findFood(String row) {
        //查询分类里的食物
        List<ZBFood> foodList = dineDao.findFood(row);
        //封装数据
        List<DineDTO> dineDTOList = new ArrayList();
        for (ZBFood food : foodList) {
            DineDTO dineDTO = new DineDTO();
            dineDTO.setFoodname(food.getFoodname());
            dineDTO.setCalorie(food.getCalorie());
            dineDTOList.add(dineDTO);
        }
        return dineDTOList;
    }

    /**
     * 添加食物
     * @param userid
     * @param date
     * @param dine
     * @param foodname
     * @param foodnum
     * @return
     */
    @Override
    @Transactional
    public int addUserFood(int userid, String date, int dine, String foodname, String foodnum) {
       //处理添加多种食物
        int k = 0;
        String[] split = foodname.split(",");
        String[] split1 = foodnum.split(",");
        for (int i = 0; i < split.length; i++) {
            Map map = new HashMap();
            map.put("tcid",1);
            map.put("date",date);
            map.put("dine",dine);
            map.put("foodname",split[i]);
            map.put("foodnum",split1[i]);
            map.put("userid",userid);
            dineDao.addUserFood(map);
        }
        k++;
        return k;
    }

    /**
     * 添加动态内容进数据库
     * @param userid
     * @param content
     * @param path
     * @return
     */
    @Override
    @Transactional
    public int addDynamic(int userid, String content,String path) {
        //先添加动态，用实体类接受好接受返回的新增id
        Moments moments = new Moments();
        moments.setContent(content);
        moments.setShowTime(new Date());
        moments.setShare(0);
        moments.setUid(userid);

        int i = dineDao.addDynamic(moments);
        if (i<=0){
            throw new RuntimeException("插入数据错误");
        }
        //保存图片地址
        Map map = new HashMap();
        map.put("mid",moments.getId());
        map.put("path",path);
        int i1 = dineDao.addMompic(map);
        return i1;
    }
}
