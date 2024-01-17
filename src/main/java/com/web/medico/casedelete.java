package com.web.medico;

import com.service.medico.Caseservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/medico/casedelete")
public class casedelete extends HttpServlet {
    private Caseservice caseservice=new Caseservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收json数据id
        String s = req.getParameter("id");
        //System.out.println(Integer.parseInt(s));
        try {
            caseservice.deletecase(Integer.parseInt(s));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
