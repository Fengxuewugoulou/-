package com.lhxm.service;

import com.lhxm.dto.DineDTO;

import java.util.List;
import java.util.Map;

public interface HomeService {
    //饮食定制
    Map findDiet(int userid, String date);
}
