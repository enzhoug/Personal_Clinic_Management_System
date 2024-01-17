package com.mapper;

import com.pojo.medico.Case;
import com.pojo.medico.Client;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface medico_mapper {
    //查看所有客户信息
    List<Client> selectclient();
    //添加客户信息
    void addclient(Client client);
    //底部分页条，查找总条数，查找每页显示的条数
    int selecttotalpage();
    List<Client>selectpagelist(@Param("start")int start, @Param("num") int num);
    //按条件搜索客户信息
    List<Client>selectbycondition(@Param("client")Client client,@Param("start")int start,@Param("num") int num);
    int selecttotalbycondition(Client client);
    //修改客户信息
    void updateclient(Client client);
    //删除客户信息
    void deleteclient(int id);
    //添加病例
    void caseinsert(@Param("medicinename")String medicinename,@Param("casename")String casename,@Param("clientid") int clientid);
    //按条件搜索病例
    List<Case>selectbycondition2(@Param("caseol") Case caseol, @Param("start")int start, @Param("num") int num);
    int selecttotalbycondition2(Case caseol);
    //修改病例
    void updatecase(Case caseol);
    //删除病例
    void deletecase(int id);
}
