package com.lhxm.entity;

/**
 * author: 张可
 * date: 2019/10/14 20:26
 * description:
 */
public class ZkUser {
    private Integer userid;
    private String username;
    private String password;
    private String nicheng;
    private String handimages;
    private String sex;
    private String addres;
    private String status;
    private String introduce;
    private String certificate;
    private String code;

    @Override
    public String toString() {
        return "ZkUser{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nicheng='" + nicheng + '\'' +
                ", handimages='" + handimages + '\'' +
                ", sex='" + sex + '\'' +
                ", addres='" + addres + '\'' +
                ", status='" + status + '\'' +
                ", introduce='" + introduce + '\'' +
                ", certificate='" + certificate + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public ZkUser() {
    }

    public ZkUser(Integer userid, String username, String password, String nicheng, String handimages, String sex, String addres, String status, String introduce, String certificate, String code) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.nicheng = nicheng;
        this.handimages = handimages;
        this.sex = sex;
        this.addres = addres;
        this.status = status;
        this.introduce = introduce;
        this.certificate = certificate;
        this.code = code;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNicheng() {
        return nicheng;
    }

    public void setNicheng(String nicheng) {
        this.nicheng = nicheng;
    }

    public String getHandimages() {
        return handimages;
    }

    public void setHandimages(String handimages) {
        this.handimages = handimages;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
