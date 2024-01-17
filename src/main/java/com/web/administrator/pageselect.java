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

import java.io.IOException;
@WebServlet("/administrator/pageselect")
public class pageselect extends HttpServlet {
    private Pageservice pageservice=new Pageservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String currentpage = req.getParameter("currentpage");
        String size = req.getParameter("size");
        //调用
        pagemention<Doctor> pagementions=null;
        try {
           pagementions=pageservice.selectpagelist(Integer.parseInt(currentpage), Integer.parseInt(size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(pagementions);
        //转为json传递
        String jsonString = JSON.toJSONString(pagementions);
        System.out.println(jsonString);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
