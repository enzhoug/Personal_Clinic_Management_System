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

@WebServlet("/administrator/addpage")
public class addpage extends HttpServlet {
    private Pageservice pageservice=new Pageservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        Doctor doctor = null;
        //doctor.setId();
        //获取字符输入流
        BufferedReader bufferedReader=req.getReader();
        String s=bufferedReader.readLine();
        doctor= JSON.parseObject(s, Doctor.class);
        try {
            pageservice.adddoctor(doctor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        this.doGet(req,resp);
    }
}
