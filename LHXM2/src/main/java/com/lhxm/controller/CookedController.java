package com.lhxm.controller;



import com.lhxm.entity.Cookbz;
import com.lhxm.entity.Cooked;
import com.lhxm.entity.Cookxcl;
import com.lhxm.service.CookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cooked")
public class CookedController {

    @Resource
    private CookedService cookedService;

    //三餐分类
    @RequestMapping("/sancan")
    @ResponseBody
    public List<Cooked> findByType(@RequestParam String type){
        List<Cooked> cookedList = cookedService.findByType(type);

        return  cookedList;
    }
    @RequestMapping("/cai")
    @ResponseBody
    public Map findBylei(@RequestParam Integer cookid ){
        List<Cookxcl> cailiao = cookedService.findById(cookid);
        List<Cookbz> buzhou = cookedService.findBuZhouById(cookid);
        Map map = new HashMap();
        map.put("cailiao", cailiao);
        map.put("buzhou", buzhou);

        return map;
    }


}
