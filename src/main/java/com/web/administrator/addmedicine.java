package com.web.administrator;

import com.alibaba.fastjson.JSON;
import com.pojo.administrator.Doctor;
import com.pojo.administrator.Medicine;
import com.service.administrator.Medicineservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/administrator/addmedicine")
public class addmedicine extends HttpServlet {
    private Medicineservice medicineservice=new Medicineservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Medicine medicine = null;
        //获取字符输入流
        BufferedReader bufferedReader=req.getReader();
        String s=bufferedReader.readLine();
        medicine= JSON.parseObject(s, Medicine.class);
        try {
            medicineservice.addmedicine(medicine);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
