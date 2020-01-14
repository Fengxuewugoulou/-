package com.lhxm.service.impl;


import com.lhxm.dao.ZKUserDao;
import com.lhxm.entity.ZkUser;
import com.lhxm.service.ZkUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * author: 张可
 * date: 2019/10/14 20:34
 * description:
 */
@Service
public class ZkUserServiceImpl implements ZkUserService {
    @Resource
    private ZKUserDao userDao;

    @Override
    @Transactional
    public int register(String phone,String password,String status) {
        ZkUser user = new ZkUser(null,phone,password,"用户"+(int)((Math.random()*9+1)*100000),
                null,"男","北京",status,"自我简介",null,null);
        return userDao.register(user);
    }

    @Override
    public ZkUser login(String username, String password) {

        Map map=new HashMap();
        map.put("username",username);
        map.put("password",password);

        ZkUser user = userDao.findbyusernameandpassword(map);

        return user;
    }

    @Override
    @Transactional
    public Integer update(String username, String password) {
        Map map=new HashMap();
        map.put("username",username);
        map.put("password",password);
        return userDao.update(map);
    }
}
