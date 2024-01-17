package com.service.medico;

import com.mapper.medico_mapper;
import com.pojo.administrator.pagemention;
import com.pojo.medico.Case;
import com.pojo.medico.Client;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Caseservice {
    //添加病例
    public void insertcase(String medicinename, String casename, int clientid)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        medico_mapper usermapper=sqlSession.getMapper(medico_mapper.class);
        //添加病例
        System.out.println(medicinename);
        System.out.println(casename);
        System.out.println(clientid);
        usermapper.caseinsert(medicinename,casename,clientid);
    }
    //按条件搜索病例
    public pagemention<Case> selectbycondition(Case cases, int currentpage, int size)throws Exception{
        ///加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        medico_mapper usermapper=sqlSession.getMapper(medico_mapper.class);
        //数据库执行

        if(cases.getClientname()!=null&&cases.getClientname()!=""){
            cases.setClientname("%"+cases.getClientname()+"%");
        }
        //System.out.println(doctor);
        List<Case> clientlist2=usermapper.selectbycondition2(cases,(currentpage-1)*size,size);
        int num=usermapper.selecttotalbycondition2(cases);

            System.out.println(clientlist2);
        //封装
        pagemention pagemention=new pagemention();
        pagemention.setTotalpage(num);
        pagemention.setPagelist(clientlist2);
        sqlSession.close();
        return pagemention;
    }
    //修改病例
    public void updatecase(Case cases)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        medico_mapper usermapper=sqlSession.getMapper(medico_mapper.class);
        usermapper.updatecase(cases);
        sqlSession.close();
    }
    public void deletecase(int id)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        medico_mapper usermapper=sqlSession.getMapper(medico_mapper.class);
        usermapper.deletecase(id);
    }
}
