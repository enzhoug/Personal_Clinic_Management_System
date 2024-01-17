package com.service.medico;
import com.mapper.user2_mapper;
import com.pojo.medico.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Userservice2 {
    public com.pojo.medico.User login(String username, String password)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        user2_mapper usermapper=sqlSession.getMapper(user2_mapper.class);
        //System.out.println("login1");
        //实现登录功能
        User user=usermapper.selectBynamepassword(username,password);
        //System.out.println("login2");
        sqlSession.close();
        return user;
    }
    public int register(String username,String password)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        user2_mapper usermapper=sqlSession.getMapper(user2_mapper.class);
        //注册功能，先查找用户是否存在，不存在即可存入数据库
        User user=usermapper.selectByname(username);
        //若用户不存在，注册
        if(user==null){
            User user1=new User();
            user1.setUsername(username);
            user1.setPassword(password);
            usermapper.adduser(user1);
            sqlSession.close();
            return 1;
        }else{
            sqlSession.close();
        }
        return 0;
    }
}
