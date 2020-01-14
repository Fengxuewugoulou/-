package com.lhxm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DineDTO {
    private Integer dine;
    private String foodname;
    private Integer foodnum;
    private String calorie;
    private String intake;

    private String hot;
    private String carbohydrate;
    private String axunge;
    private String protein;

    private String img;

}
