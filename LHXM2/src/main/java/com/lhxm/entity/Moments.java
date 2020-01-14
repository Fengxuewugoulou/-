package com.lhxm.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Moments {
    private Integer id;
    private String content;
    private Date showTime;
    private Integer share;
    private Integer uid;
}
