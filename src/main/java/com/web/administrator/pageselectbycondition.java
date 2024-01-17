package com.web.administrator;

import com.alibaba.fastjson.JSON;
import com.pojo.administrator.Doctor;
import com.pojo.administrator.pagemention;
import com.service.administrator.Pageservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
@WebServlet("/administrator/pageselectbycondition")
public class pageselectbycondition extends HttpServlet {
    private Pageservice pageservice=new Pageservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        BufferedReader reader=req.getReader();
        String s = reader.readLine();
        Doctor doctor=JSON.parseObject(s, Doctor.class);
        String currentpage = req.getParameter("currentpage");
        String size = req.getParameter("size");
        System.out.println(doctor);
        System.out.println(size);
        //调用
        pagemention<Doctor> selectbycondition=null;
        try {
            selectbycondition = pageservice.selectbycondition(doctor, Integer.parseInt(currentpage), Integer.parseInt(size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //传回数据
        String jsonString = JSON.toJSONString(selectbycondition);
        System.out.println(jsonString);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
