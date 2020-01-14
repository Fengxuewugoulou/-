package com.lhxm.entity;

import java.util.Date;
import java.util.List;



public class Zhuying1class {
    private String head_img;
    private String nicheng;
    private Integer uid;
    private String show_time;
    private String show_time1;
    private List show_img;
    private Boolean like;
    private Integer comment_num;
    private Boolean follow;
    private Integer Like_num;
    private Integer mid;

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getNicheng() {
        return nicheng;
    }

    public void setNicheng(String nicheng) {
        this.nicheng = nicheng;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(Date show_time) {
        long now=new Date().getTime();
        long show = show_time.getTime();
        long time=now-show;
        if((time=time/1000)<60){
            String times=time+"秒前";
            this.show_time = times;
        }else{
            if((time=time/60)<60){
                String times=time+"分前";
                this.show_time = times;
            }else{
                if((time=time/60)<60){
            String times=time+"小时前";
            this.show_time = times;
                }else{
                    if((time=time/24)<7){
                        String times=time+"天前";
                        this.show_time = times;
                    }else{
                        int month = (show_time.getMonth()+1);
                        int date = show_time.getDate();
                        this.show_time=month+"月"+date+"日";
                    }
                }
            }
        }
    }

    public String getShow_time1() {
        return show_time1;
    }

    public void setShow_time1(String show_time1) {
        this.show_time1 = show_time1;
    }

    public List getShow_img() {
        return show_img;
    }

    public void setShow_img(List show_img) {
        this.show_img = show_img;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public Boolean getFollow() {
        return follow;
    }

    public void setFollow(Boolean follow) {
        this.follow = follow;
    }

    public Integer getLike_num() {
        return Like_num;
    }

    public void setLike_num(Integer like_num) {
        Like_num = like_num;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}
