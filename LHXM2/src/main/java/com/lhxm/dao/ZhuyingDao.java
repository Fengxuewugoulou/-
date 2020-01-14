package com.lhxm.dao;


import com.lhxm.entity.Zhuying1class;
import com.lhxm.entity.Zhuying2class;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

public interface ZhuyingDao {
    //follow
    public String total();
    public List<Zhuying1class> find(Map map);
    public List showimg(Integer mid);
    public Integer like_num(Integer mid);
    public Integer countalike(Map map);
    public Integer comment_num(Integer mid);
    public Integer follow(Map map);
    //addlike
    public void addlike(Map map);
    public void ppalike(Map map);
    //addgunzhu
    public void addguanzhu(Map map);
    public void ppaguanzhu(Map map);
    //pinglun
    public String total1(Integer mid);
    public List<Zhuying2class> pinglun(Map map);
    //addpinglun
    public void addpinglun(Map map);
    //addqiandao
    public void addqiandao(Map map);
    //qiandaos
    public List qiandaos(Map map);
    //cqindao
    public Integer cqiandao(Map map);
    //cqiandaos
    public Integer cqiandaos(Map map);
}
