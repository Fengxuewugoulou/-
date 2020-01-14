package com.lhxm.service.impl;

import com.lhxm.dao.UserMapper;
import com.lhxm.entity.User;
import com.lhxm.service.Myservices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Myservicesimpl implements Myservices {
    @Resource
    private UserMapper userMapper;
    @Override
    public User findall(int idCard) {
        return userMapper.selectByPrimaryKey(idCard);
    }

    @Override
    public int likecount(int idCard) {
        return userMapper.selectlike(idCard);
    }

    @Override
    public int gzcunt(int idCard) {
        return userMapper.gzcount(idCard);
    }

    @Override
    public List<Integer> fansid(int idCard) {
        return userMapper.fansid(idCard);
    }

    @Override
    public List<User> fanszl(List list) {
        return userMapper.fanszl(list);
    }

    @Override
    public List<Integer> gzzl(int idCard) {
        return userMapper.gzid(idCard);
    }

    @Override
    public int uphead(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public String selectphone(int userid) {
        return userMapper.selectphone(userid);
    }
}
