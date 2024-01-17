package com.web.medico;

import com.alibaba.fastjson.JSON;
import com.pojo.medico.Client;
import com.service.medico.Clientservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/medico/pageupdate")
public class clientupdate extends HttpServlet {
    private Clientservice clientservice=new Clientservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收axios发送的json数据
        //System.out.println("update");
        BufferedReader reader = req.getReader();
        String json=reader.readLine();
        Client client = JSON.parseObject(json, Client.class);
        //System.out.println(client);
        //调用方法，传入service层
        try {
            clientservice.updateclient(client);
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
