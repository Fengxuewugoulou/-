package com.lhxm.entity;

import java.util.Date;

public class Zhuying2class {
    private Integer uid;
    private String avatar;
    private String author;
    private String show_time1;
    private String datetime;
    private String content;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAuthor () {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShow_time1() {
        return show_time1;
    }

    public void setShow_time1(String show_time1) {
        this.show_time1 = show_time1;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        long now=new Date().getTime();
        long show = datetime.getTime();
        long time=now-show;
        if((time=time/1000)<60){
            String times=time+"秒前";
            this.datetime = times;
        }else{
            if((time=time/60)<60){
                String times=time+"分前";
                this.datetime = times;
            }else{
                if((time=time/60)<60){
                    String times=time+"小时前";
                    this.datetime = times;
                }else{
                    if((time=time/24)<7){
                        String times=time+"天前";
                        this.datetime = times;
                    }else{
                        int month = (datetime.getMonth()+1);
                        int date = datetime.getDate();
                        this.datetime=month+"月"+date+"日";
                    }
                }
            }
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
