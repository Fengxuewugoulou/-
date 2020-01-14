package com.lhxm.service;

import com.lhxm.entity.User;

import java.util.List;

public interface Myservices {
    User findall(int idCard);
    int likecount(int idCard);
    int gzcunt(int idCard);
    List<Integer> fansid(int idCard);
    List<User> fanszl(List list);
    public List<Integer> gzzl(int idCard);
    int uphead(User user);
    String selectphone (int userid);
}
