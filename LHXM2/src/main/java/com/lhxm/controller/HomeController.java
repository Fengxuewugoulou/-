package com.lhxm.controller;

import com.lhxm.dto.DineDTO;
import com.lhxm.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Resource
    private HomeService homeService;

    /**
     * 饮食定制,图片是返回的只是图片地址
     * @param userid
     * @param date
     * @return
     */
    @RequestMapping("/findDiet")
    @ResponseBody
    public Map findDiet(int userid, String date){
        return homeService.findDiet(userid, date);
    }
}
