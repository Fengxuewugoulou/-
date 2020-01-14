package com.lhxm.controller;

import com.aliyuncs.exceptions.ClientException;

import com.lhxm.entity.ZkUser;
import com.lhxm.service.ZkUserService;
import com.lhxm.util.R;
import com.lhxm.util.SendSms;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author: 张可
 * date: 2019/10/14 19:22
 * description:
 */
@RestController
@RequestMapping("/app/user")
public class zkController {
    @Resource
    private ZkUserService userService;

    @RequestMapping("/capture")
    public R phone(String phone){
        String capture=null;
        try {
            capture = SendSms.sendSms(phone);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return R.ok(capture);
    }


    @RequestMapping("/register")
    public R register(String phone,String password,String status){
        int i = userService.register(phone, password,status);
        if (i==0){
            return R.error("注册失败");
        }
        return R.ok("注册成功");
    }

    @RequestMapping("/login")
    public ZkUser login(String phone,String password){
        System.out.println(phone+" "+password);
        ZkUser user = userService.login(phone, password);

        if (user==null){
            return null;
        }
        return user;
    }
    @RequestMapping("/findout")
    public R findout(String phone,String password){
        Integer integer = userService.update(phone, password);
        if (integer==0){
            return R.error("修改失败");
        }
        return R.ok("修改成功");
    }

}
