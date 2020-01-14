package com.lhxm.controller;

import com.lhxm.dto.DineDTO;
import com.lhxm.service.RecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/record")
public class RecordController {
    @Resource
    private RecordService recordService;

    /**
     * 添加体重
     * @param userid
     * @param weight
     */
    @RequestMapping("/addWeight")
    public Map addWeight(int userid,double weight){
        int i = recordService.addWeight(userid, weight);
        Map map = new HashMap();
        if (i<=0) {
            map.put("msg",false);
            return map;
        }
        map.put("msg",true);
        return map;
    }

    /**
     * 记饮食运动展开
     * @param userid
     * @return
     */
    @RequestMapping("/findNow")
    public Map findNow(int userid,String date){
        return recordService.findNow(userid,date);
    }

    /**
     * 根据食物名称模糊查
     * @param name
     * @return
     */
    @RequestMapping("/findFoodByName")
    public List<DineDTO> findFoodByName(String name){
        return recordService.findFoodByName(name);
    }

    /**
     * 饮食分析
     * @param userid
     * @param date
     * @return
     */
    @RequestMapping("/findAllByDate")
    public Map findAllByDate(int userid,String date){
        return recordService.findAllByDate(userid, date);
    }

    /**
     * 添加食物，默认先查询
     * @param row
     * @return
     */
    @RequestMapping("/findFood")
    public List<DineDTO> findFood(@RequestParam(defaultValue = "0") String row){
        //根据分类查找食物
        return recordService.findFood(row);
    }

    /**
     * 添加食物
     * @param userid
     * @param date
     * @param dine
     * @param foodname
     * @param foodnum
     */
    @RequestMapping("/addUserFood")
    public Map addUserFood(int userid,String date,int dine,String foodname,String foodnum){
        int i = recordService.addUserFood(userid, date, dine, foodname, foodnum);
        Map map = new HashMap();
        if (i<=0){
            map.put("msg",false);
            return map;
        }
        map.put("msg",true);
        return map;
    }

    /**
     * 发布动态，图片和文字
     * @param userid
     * @param content
     * @param fileImg
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/addDynamic")
    public Map addDynamic(int userid, String content, MultipartFile fileImg,
                             HttpServletRequest request) throws IOException {
        //将文件上传到img目录下
        //转换服务器地址
        String realPath = request.getRealPath("/img");
        //得到文件名称
        String fileName = fileImg.getOriginalFilename();
        fileImg.transferTo(new File(realPath+"/"+fileName));
        //要放进数据库的图片路径
        String path = realPath+"/"+fileName;

        //存进数据库
        int i = recordService.addDynamic(userid, content, path);
        Map map = new HashMap();
        if (i<=0) {
            map.put("msg",false);
            return map;
        }
        map.put("msg",true);
        return map;
    }
}
