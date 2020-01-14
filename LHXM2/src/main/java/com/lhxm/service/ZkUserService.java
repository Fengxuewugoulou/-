package com.lhxm.service;

import com.lhxm.entity.ZkUser;

/**
 * author: 张可
 * date: 2019/10/14 20:33
 * description:
 */
public interface ZkUserService {
    public int register(String phone, String password, String status);

    public ZkUser login(String username, String password);

    public Integer update(String username, String password);
}
