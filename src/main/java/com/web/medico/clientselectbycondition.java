package com.web.medico;

import com.alibaba.fastjson.JSON;
import com.pojo.administrator.Doctor;
import com.pojo.administrator.pagemention;
import com.pojo.medico.Client;
import com.service.medico.Clientservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/medico/pageselectbycondition")
public class clientselectbycondition extends HttpServlet {
    private Clientservice clientservice=new Clientservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        BufferedReader reader=req.getReader();
        String s = reader.readLine();
        Client client= JSON.parseObject(s, Client.class);
        String currentpage = req.getParameter("currentpage");
        String size = req.getParameter("size");
        //System.out.println(client);
        //System.out.println("hello");
        //System.out.println(size);
        //调用
        pagemention<Client> selectbycondition=null;
        try {
            selectbycondition = clientservice.selectbycondition(client, Integer.parseInt(currentpage), Integer.parseInt(size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //传回数据
        String jsonString = JSON.toJSONString(selectbycondition);
        //System.out.println(jsonString);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
