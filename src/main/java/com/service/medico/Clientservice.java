package com.service.medico;

import com.mapper.medico_mapper;
import com.pojo.administrator.pagemention;
import com.pojo.medico.Client;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Clientservice {
    //显示所有医生信息
    public List<Client> select()throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        medico_mapper usermapper=sqlSession.getMapper(medico_mapper.class);
        List<Client> client=usermapper.selectclient();
        sqlSession.close();
        return client;
    }
    //添加医生
    public void addclient(Client client)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        medico_mapper usermapper=sqlSession.getMapper(medico_mapper.class);
        usermapper.addclient(client);
        sqlSession.close();
    }
    //获取每页显示的条目
    //获取总条数
    public pagemention<Client> selectpagelist(int currentpage, int size)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        medico_mapper usermapper=sqlSession.getMapper(medico_mapper.class);
        List<Client> clientlist=usermapper.selectpagelist((currentpage-1)*size,size);
        //
        int num=usermapper.selecttotalpage();
        sqlSession.close();
        //封装
        pagemention pagemention=new pagemention();
        pagemention.setPagelist(clientlist);
        pagemention.setTotalpage(num);
        return pagemention;
    }
    //搜索显示条目和条数
    public pagemention<Client> selectbycondition(Client client,int currentpage, int size)throws Exception{
        ///加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        medico_mapper usermapper=sqlSession.getMapper(medico_mapper.class);
        //数据库执行

        if(client.getClientname()!=null&&client.getClientname()!=""){
            client.setClientname("%"+client.getClientname()+"%");
        }
        //System.out.println(doctor);
        List<Client> clientlist2=usermapper.selectbycondition(client,(currentpage-1)*size,size);
        int num=usermapper.selecttotalbycondition(client);

        //封装
        pagemention pagemention=new pagemention();
        pagemention.setTotalpage(num);
        pagemention.setPagelist(clientlist2);
        sqlSession.close();
        return pagemention;
    }
    //修改医生信息
    public void updateclient(Client client)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        medico_mapper usermapper=sqlSession.getMapper(medico_mapper.class);
        usermapper.updateclient(client);
        sqlSession.close();
    }
    //删除医生信息
    public void deleteclient(int id)throws Exception{
        //加载mybatis核心配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//获取sqlsession对象，让他执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
//获取usermapper接口的代理对象
        medico_mapper usermapper=sqlSession.getMapper(medico_mapper.class);
        usermapper.deleteclient(id);
    }
}
