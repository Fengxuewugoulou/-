package com.lhxm.controller;

import com.lhxm.entity.User;
import com.lhxm.service.Myservices;
import com.sun.tools.javac.jvm.Code;
import org.apache.ibatis.jdbc.Null;
import org.springframework.cache.interceptor.NamedCacheResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app/my")
public class My {
    @Resource
    private Myservices myservices;
    @RequestMapping("/profile")
    @ResponseBody
    public Map find1(int idCard){
        User user = new User();
        int like = -1 , gz = -1;
        user = myservices.findall(idCard);
        like = myservices.likecount(idCard);
        gz = myservices.gzcunt(idCard);
        user.setFans(like);
        user.setGz(gz);
        HashMap map = new HashMap();
        if (user!=null && like != -1 && gz != -1){
            map.put("code",true);
            map.put("profileInfo", user);
        }
        return map;
    }
    @RequestMapping("/fans")
    @ResponseBody
    public Map fans(int idCard){
        List<Integer> list = myservices.fansid(idCard);
        List<User> user = myservices.fanszl(list);
        HashMap map = new HashMap();
        if (user!=null){
            map.put("code",true);
            map.put("ms", "粉丝");
            map.put("profileInfo", user);
        }
        return map;
    }
    @RequestMapping("/follow")
    @ResponseBody
    public Map gz(int idCard){
        List<Integer> list = myservices.gzzl(idCard);
        List<User> user = myservices.fanszl(list);
        HashMap map = new HashMap();
        if (user!=null){
            map.put("code",true);
            map.put("ms", "关注");
            map.put("profileInfo", user);
        }
        return map;
    }
    @RequestMapping("/info")
    @ResponseBody
    public Map info(int idCard){
        User user = myservices.findall(idCard);
        HashMap map = new HashMap();
        if (user!=null){
            map.put("code",true);
            map.put("profileInfo", user);
        }
        return map;
    }
    @RequestMapping("/head_image")
    @ResponseBody
    public Map head(String head_image,int idCard){
        User user = new User();
        user.setUserid(idCard);
        user.setHandimages(head_image);
        int cg = myservices.uphead(user);
        user = myservices.findall(idCard);
        HashMap map = new HashMap();
        if (user!=null){
            map.put("code",true);
            map.put("msg", "修改成功");
            map.put("profileInfo", user);
        }
        return map;
    }
    @RequestMapping("/nickname")
    @ResponseBody
    public Map name(String username,int idCard){
        User user = new User();
        user.setUserid(idCard);
        user.setNicheng(username);
        int cg = myservices.uphead(user);
        user = myservices.findall(idCard);
        HashMap map = new HashMap();
        if (user!=null){
            map.put("code",true);
            map.put("msg", "修改成功");
            map.put("profileInfo", user);
        }
        return map;
    }
    @RequestMapping("/gender")
    @ResponseBody
    public Map gender(String gender,int idCard){
        User user = new User();
        user.setUserid(idCard);
        user.setSex(gender);
        int cg = myservices.uphead(user);
        user = myservices.findall(idCard);
        HashMap map = new HashMap();
        if (user!=null){
            map.put("code",true);
            map.put("msg", "修改成功");
            map.put("profileInfo", user);
        }
        return map;
    }
    @RequestMapping("/address")
    @ResponseBody
    public Map address(String address,int idCard){
        User user = new User();
        user.setUserid(idCard);
        user.setAddres(address);
        int cg = myservices.uphead(user);
        user = myservices.findall(idCard);
        HashMap map = new HashMap();
        if (user!=null){
            map.put("code",true);
            map.put("msg", "修改成功");
            map.put("profileInfo", user);
        }
        return map;
    }
    @RequestMapping("/introduce")
    @ResponseBody
    public Map introduce(@RequestParam(defaultValue = "") String introduce, int idCard){
        User user = new User();
        user.setUserid(idCard);
        user.setCertificate(introduce);
        int cg = myservices.uphead(user);
        user = myservices.findall(idCard);
        int fans = myservices.likecount(idCard);
        int gz = myservices.gzcunt(idCard);
        user.setFans(fans);
        user.setGz(gz);
        HashMap map = new HashMap();
        if (user!=null){
            map.put("code",true);
            map.put("msg", "修改成功");
            map.put("profileInfo", user);
        }
        return map;
    }
    @RequestMapping("/set")
    @ResponseBody
    public Map introduce(int idCard){
        String phonenumber = null;
        boolean code = false;
        phonenumber = myservices.selectphone(idCard);
        if (phonenumber != null){
            code = true;
        }
        HashMap map = new HashMap();
        map.put("code", code);
        map.put("phoneNumber", phonenumber);
        return map;
    }
    @RequestMapping("/user_info")
    @ResponseBody
    public Map zyimage(String zy_image,int idCard){
        User user = new User();
        user.setUserid(idCard);
        user.setCertificate(zy_image);
        int cg = myservices.uphead(user);
        user = myservices.findall(idCard);
        HashMap map = new HashMap();
        if (user!=null){
            map.put("code",true);
            map.put("msg", "修改成功");
            map.put("profileInfo", user);
        }
        return map;
    }

}
