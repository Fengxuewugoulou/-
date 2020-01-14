package com.lhxm.dao;

import com.lhxm.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectlike(Integer userid);

    int gzcount(Integer userid);

    List<Integer> fansid(Integer userid);

    List<User> fanszl (List list);

    List<Integer> gzid(Integer userid);

    String selectphone (int userid);


}