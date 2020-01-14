package com.lhxm.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Dine {
    private Integer id;
    private Date date;
    private Integer dine;
    private String foodname;
    private Integer foodnum;
    private Integer userid;
}
