package com.web.administrator;

import com.alibaba.fastjson.JSON;
import com.pojo.administrator.Doctor;
import com.pojo.administrator.Medicine;
import com.pojo.administrator.pagemention;
import com.service.administrator.Medicineservice;
import com.service.administrator.Pageservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
@WebServlet("/administrator/medicineselectbycondition")
public class medicineselectbycondition extends HttpServlet {
    private Medicineservice medicineservice=new Medicineservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        BufferedReader reader=req.getReader();
        String s = reader.readLine();
        Medicine medicine= JSON.parseObject(s, Medicine.class);
        String currentpage = req.getParameter("currentpage");
        String size = req.getParameter("size");
        //调用service包中的方法
        pagemention<Medicine> medicineselectbycondition=null;
        try {
            medicineselectbycondition = medicineservice.medicineselectbycondition(medicine, Integer.parseInt(currentpage), Integer.parseInt(size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //传回数据
        String jsonString = JSON.toJSONString(medicineselectbycondition);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
