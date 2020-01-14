package com.lhxm.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Weight {
    private Integer id;
    private Double weight;
    private Date date;
    private Integer userid;
}
