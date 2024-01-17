package com.mapper;

import com.pojo.administrator.User;
import org.apache.ibatis.annotations.Param;

public interface user_mapper {
    //用户注册
    void adduser(User user);
    User selectByname(String username);
    //用户登录
    public User selectBynamepassword(@Param("username")String username, @Param("password")String password);
    //医生

}
