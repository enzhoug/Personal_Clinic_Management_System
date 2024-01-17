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

@WebServlet("/medico/addpage")
public class addclient extends HttpServlet {
    private Clientservice clientservice=new Clientservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        Client client = null;
        //client.setId();
        //获取字符输入流
        BufferedReader bufferedReader = req.getReader();
        String s = bufferedReader.readLine();
        client = JSON.parseObject(s, Client.class);
        System.out.println(client);
        try {
            clientservice.addclient(client);
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
