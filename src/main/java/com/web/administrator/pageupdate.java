package com.web.administrator;

import com.alibaba.fastjson.JSON;
import com.pojo.administrator.Doctor;
import com.service.administrator.Pageservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
@WebServlet("/administrator/pageupdate")
public class pageupdate extends HttpServlet {
    private Pageservice pageservice=new Pageservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收axios发送的json数据
        System.out.println("update");
        BufferedReader reader = req.getReader();
        String json=reader.readLine();
        Doctor doctor = JSON.parseObject(json, Doctor.class);
        System.out.println(doctor);
        //调用方法，传入service层
        try {
            pageservice.updatedoctor(doctor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.getWriter().write("sucess");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
