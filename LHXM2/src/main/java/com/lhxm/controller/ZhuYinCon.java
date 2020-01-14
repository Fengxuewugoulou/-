package com.lhxm.controller;

import com.lhxm.service.impl.ZhuyingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@Controller
public class ZhuYinCon {
    @Resource
    private ZhuyingService zhuyingService;
    @RequestMapping("/app/follow")
    @ResponseBody
    public Map find1(Integer page,Integer id,Integer size,String total,Integer ids){
        Map map = zhuyingService.find(page, id, size, total,ids);
        return map;
    }
   @RequestMapping("/app/addlike")
    @ResponseBody
    public Integer addlike(Integer mid,Integer id){
       Integer addlike = zhuyingService.addlike(mid, id);
       return addlike;
    }
    @RequestMapping("/app/addguanzhu")
    @ResponseBody
    public Integer addguanzhu(Integer uid,Integer id){
        Integer addguanzhu=zhuyingService.addguanzhu(uid,id);
        return addguanzhu;
    }
    @RequestMapping("app/pinglun")
    @ResponseBody
    public Map pinglun(Integer mid,Integer page,Integer size,String total){
        Map pinglun = zhuyingService.pinglun(mid, page, size, total);
        return pinglun;
    }
    @RequestMapping("app/addpinglun")
    @ResponseBody
    public Integer addpinglun(String content, Integer mid, Integer id){
        zhuyingService.addpinglun(content,mid,id);
        return 1;
    }
    @RequestMapping("app/addqiandao")
    @ResponseBody
    public Integer addqiandao(Integer id,Integer fan){
        Integer addqiandao = zhuyingService.addqiandao(id, fan);
        return addqiandao;
    }
}
