package com.lhxm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhxm.dao.ZhuyingDao;
import com.lhxm.entity.Zhuying1class;
import com.lhxm.entity.Zhuying2class;
import com.lhxm.service.ZhuyingSev;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ZhuyingService implements ZhuyingSev {
    @Resource
    private ZhuyingDao zhuyingDao;
    @Override
    public Map find(Integer page, Integer id,Integer size,String total,Integer ids) {
        if(total==null||"".equals(total)){
            total=zhuyingDao.total();
        }
        Map findall=new HashMap();
        PageHelper.startPage(page,size);
        Map map=new HashMap();
        map.put("id",id);
        map.put("total",total);
        map.put("ids",ids);
        List<Zhuying1class> find = zhuyingDao.find(map);
        PageInfo<Zhuying1class> finds = new PageInfo<Zhuying1class>(find);
        ArrayList<Zhuying1class> list = (ArrayList<Zhuying1class>) finds.getList();
        for(int i=0;i<list.size();i++){
            List showimg = zhuyingDao.showimg(list.get(i).getMid());
            list.get(i).setShow_img(showimg);
            Integer comment_num = zhuyingDao.comment_num(list.get(i).getMid());
            list.get(i).setComment_num(comment_num);
            Integer like_num = zhuyingDao.like_num(list.get(i).getMid());
            list.get(i).setLike_num(like_num);
            Map countlikes=new HashMap();
            countlikes.put("mid",list.get(i).getUid());
            countlikes.put("id",id);
            Integer countlike = zhuyingDao.countalike(countlikes);
            if(countlike==1){ list.get(i).setLike(true);
            }else{ list.get(i).setLike(false); }
            Map follows=new HashMap();
            follows.put("mid",list.get(i).getUid());
            follows.put("uid",id);
            Integer follow = zhuyingDao.follow(follows);
            if(follow==1){list.get(i).setFollow(true);
            }else{list.get(i).setFollow(false); }
        }
        findall.put("total",total);
        findall.put("data",list);
        findall.put("pages",finds.getPages());
        return findall;
    }

    @Override
    public Integer addlike(Integer mid, Integer id) {
        Map map=new HashMap();
        map.put("mid",mid);
        map.put("id",id);
        Integer add = zhuyingDao.countalike(map);
        if(add==0){
            zhuyingDao.addlike(map);
            return 1;
        }else{
            zhuyingDao.ppalike(map);
            return 0;
        }
    }

    @Override
    public Integer addguanzhu(Integer uid, Integer id) {
        Map map=new HashMap();
        map.put("mid",uid);
        map.put("uid",id);
        Integer follow = zhuyingDao.follow(map);
        if(follow==0){
zhuyingDao.addguanzhu(map);
            return 1;
        }else{
            zhuyingDao.ppaguanzhu(map);
            return 0;
        }

    }

    @Override
    public Map pinglun(Integer mid, Integer page, Integer size,String total) {
    if(total==null||"".equals(total)){
            total = zhuyingDao.total1(mid);
    }
    Map map=new HashMap();
    map.put("mid",mid);
    map.put("total",total);
        PageHelper.startPage(page,size);
        List<Zhuying2class> pinglun = zhuyingDao.pinglun(map);
        PageInfo<Zhuying2class> pingluns = new PageInfo<Zhuying2class>(pinglun);
        List<Zhuying2class> data = pingluns.getList();
        Map pingl=new HashMap();
        pingl.put("data",data);
        pingl.put("total1",total);
        pingl.put("page",page);
        pingl.put("pages",pingluns.getPages());
        return pingl;
    }

    @Override
    public void addpinglun(String content, Integer mid, Integer id) {
        Map map=new HashMap();
        map.put("content",content);
        map.put("mid",mid);
        map.put("id",id);
        zhuyingDao.addpinglun(map);
    }

    @Override
    public Integer addqiandao(Integer id,Integer fan) {
        Map map=new HashMap();
        map.put("id",id);
        Format format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(new Date());
        map.put("riqi",format1);
        map.put("fan",fan);
        Integer cqiandao = zhuyingDao.cqiandao(map);
        if(cqiandao==1){
            return 0;
        }else{
            zhuyingDao.addqiandao(map);
            return 1;
        }

    }
}
