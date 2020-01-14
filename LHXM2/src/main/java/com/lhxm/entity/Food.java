package com.lhxm.entity;

import lombok.Data;

@Data
public class Food {
    private Integer id;
    private String foodname;
    private Integer calorie;
    private String danwei;
    private Integer fenlei;
    private Integer pingji;

    private String foodllei;
}
