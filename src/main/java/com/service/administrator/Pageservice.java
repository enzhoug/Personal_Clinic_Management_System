package com.service.administrator;

import com.mapper.administrator_mapper;
import com.pojo.administrator.Doctor;
import com.pojo.administrator.pagemention;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Pageservice {
    //显示所有医生信息
    public List<Doctor> select()throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        List<Doctor> doctor=usermapper.selectdoctor();
        sqlSession.close();
        return doctor;
    }
    //添加医生
    public void adddoctor(Doctor doctor)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        usermapper.adddoctor(doctor);
        sqlSession.close();
    }
    //获取每页显示的条目
    //获取总条数
    public pagemention<Doctor> selectpagelist(int currentpage, int size)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        List<Doctor> doctorlist=usermapper.selectpagelist((currentpage-1)*size,size);
        //
        int num=usermapper.selecttotalpage();
        sqlSession.close();
        //封装
        pagemention pagemention=new pagemention();
        pagemention.setPagelist(doctorlist);
        pagemention.setTotalpage(num);
        return pagemention;
    }
    //搜索显示条目和条数
    public pagemention<Doctor> selectbycondition(Doctor doctor,int currentpage, int size)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        //数据库执行

        if(doctor.getDoctorname()!=null&&doctor.getDoctorname()!=""){
            doctor.setDoctorname("%"+doctor.getDoctorname()+"%");
        }
        //System.out.println(doctor);
        List<Doctor> doctorlist2=usermapper.selectbycondition(doctor,(currentpage-1)*size,size);
        int num=usermapper.selecttotalbycondition(doctor);

        //封装
        pagemention pagemention=new pagemention();
        pagemention.setTotalpage(num);
        pagemention.setPagelist(doctorlist2);
        sqlSession.close();
        return pagemention;
    }
    //修改医生信息
    public void updatedoctor(Doctor doctor)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        usermapper.updatedoctor(doctor);
        sqlSession.close();
    }
    //删除医生信息
    public void deletedoctor(int id)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        usermapper.deletedoctor(id);
    }
}
