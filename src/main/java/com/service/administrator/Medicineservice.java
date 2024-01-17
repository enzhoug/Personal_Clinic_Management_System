package com.service.administrator;

import com.mapper.administrator_mapper;
import com.pojo.administrator.Doctor;
import com.pojo.administrator.Medicine;
import com.pojo.administrator.pagemention;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Medicineservice {
    //显示所有药品信息
    public List<Medicine> select()throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        List<Medicine> medicines=usermapper.selectmedicine();
        sqlSession.close();
        return medicines;
    }
    //添加药品
    public void addmedicine(Medicine medicine)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        usermapper.addmedicine(medicine);
        sqlSession.close();
    }
    //获取每页显示的条目，获取总条数
    public pagemention<Medicine> selectpagelist(int currentpage, int size)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        List<Medicine> medicinelist=usermapper.selectmedicinelist((currentpage-1)*size,size);
        //
        int num=usermapper.selecttotalpage();
        sqlSession.close();
        //封装
        pagemention pagemention=new pagemention();
        pagemention.setPagelist(medicinelist);
        pagemention.setTotalpage(num);
        return pagemention;
    }
    //按条件搜索药品，显示条目和条数
    public pagemention<Medicine> medicineselectbycondition(Medicine medicine,int currentpage, int size)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        //数据库执行
        if(medicine.getMedicinename()!=null&&medicine.getMedicinename()!=""){
            medicine.setMedicinename("%"+medicine.getMedicinename()+"%");
        }
        List<Medicine> medicinelist2=usermapper.medicineselectbycondition(medicine,(currentpage-1)*size,size);
        int num=usermapper.medicineselecttotalbycondition(medicine);
        //封装
        pagemention pagemention=new pagemention();
        pagemention.setTotalpage(num);
        pagemention.setPagelist(medicinelist2);
        sqlSession.close();
        return pagemention;
    }
    //修改药品信息
    public void updatemedicine(Medicine medicine)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        usermapper.updatemedicine(medicine);
        sqlSession.close();
    }
    //删除药品信息
    public void deletemedicine(int id)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        administrator_mapper usermapper=sqlSession.getMapper(administrator_mapper.class);
        usermapper.deletemedicine(id);
    }
}
