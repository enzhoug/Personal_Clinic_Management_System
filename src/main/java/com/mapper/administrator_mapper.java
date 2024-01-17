package com.mapper;

import com.pojo.administrator.Doctor;
import com.pojo.administrator.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface administrator_mapper {
    //查看所有医生信息
    List<Doctor> selectdoctor();
    //添加医生信息
    void adddoctor(Doctor doctor);
    //底部分页条，查找总条数，查找每页显示的条数
    int selecttotalpage();
    List<Doctor>selectpagelist(@Param("start")int start, @Param("num") int num);
    //按条件搜索医生信息
    List<Doctor>selectbycondition(@Param("doctor")Doctor doctor,@Param("start")int start,@Param("num") int num);
    int selecttotalbycondition(Doctor doctor);
    //修改医生信息
    void updatedoctor(Doctor doctor);
    //删除医生信息
    void deletedoctor(int id);
    //查询所有药品信息
    List<Medicine>selectmedicine();
    //添加药品信息
    void addmedicine(Medicine medicine);
    //底部分页条，查找总条数，查找每页显示的条数
    int selecttotalmedicine();
    List<Medicine>selectmedicinelist(@Param("start")int start, @Param("num") int num);
    //按条件搜索药品信息
    List<Medicine>medicineselectbycondition(@Param("medicine")Medicine medicine,@Param("start")int start,@Param("num") int num);
    int medicineselecttotalbycondition(Medicine medicine);
    //修改药品信息
    void updatemedicine(Medicine medicine);
    //删除药品
    void deletemedicine(int id);
}
