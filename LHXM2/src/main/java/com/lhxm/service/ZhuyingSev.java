package com.lhxm.service;

import com.github.pagehelper.PageInfo;
import com.lhxm.entity.Zhuying1class;

import java.util.Map;

public interface ZhuyingSev {

    public Map find(Integer page, Integer id, Integer size,String total,Integer ids);
    public Integer addlike(Integer mid,Integer id);
    public Integer addguanzhu(Integer uid,Integer id);
    public Map pinglun(Integer mid,Integer page,Integer size,String total);
    public void addpinglun(String content, Integer mid, Integer id);
    public Integer addqiandao(Integer id,Integer fan);
}
