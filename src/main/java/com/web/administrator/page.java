package com.web.administrator;

import com.alibaba.fastjson.JSON;
import com.pojo.administrator.Doctor;
import com.service.administrator.Pageservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/administrator/page")
public class page extends HttpServlet {
    private Pageservice pageservice=new Pageservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        List<Doctor> doctors= null;
        System.out.println("try");
        try {
            doctors = pageservice.select();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //System.out.println(doctors);
        //resp.getWriter().print(doctors);
        //2. 转为JSON
        String jsonString = JSON.toJSONString(doctors);

        //3. 写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
        //resp.getWriter().write();
        //req.setAttribute("doctor",doctors);
        //req.getRequestDispatcher("/html/page.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }
}
