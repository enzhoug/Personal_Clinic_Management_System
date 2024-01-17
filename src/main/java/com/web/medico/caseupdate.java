package com.web.medico;

import com.alibaba.fastjson.JSON;
import com.pojo.medico.Case;
import com.pojo.medico.Client;
import com.service.medico.Caseservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
@WebServlet("/medico/caseupdate")
public class caseupdate extends HttpServlet {
    private Caseservice caseservice =new Caseservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收axios发送的json数据
        //System.out.println("update");
        BufferedReader reader = req.getReader();
        String json=reader.readLine();
        Case cases= JSON.parseObject(json, Case.class);
        //System.out.println(client);
        //调用方法，传入service层
        try {
            caseservice.updatecase(cases);
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
