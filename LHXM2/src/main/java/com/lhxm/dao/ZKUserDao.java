package com.lhxm.dao;


import com.lhxm.entity.ZkUser;

import java.util.Map;

/**
 * author: 张可
 * date: 2019/10/14 20:32
 * description:
 */
public interface ZKUserDao {
    public int register(ZkUser user);
    public ZkUser findbyusernameandpassword(Map map);
    public Integer update(Map map);
}
