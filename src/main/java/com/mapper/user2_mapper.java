package com.mapper;

import com.pojo.medico.User;
import org.apache.ibatis.annotations.Param;

public interface user2_mapper {
    //用户注册
    //void adduser(@Param("username")String username,@Param("password")String password);
    void adduser(User user);
    com.pojo.medico.User selectByname(String username);
    //用户登录
    public com.pojo.medico.User selectBynamepassword(@Param("username")String username, @Param("password")String password);
}
