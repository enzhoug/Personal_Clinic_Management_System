package com.web.administrator;

import com.service.administrator.Medicineservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/administrator/medicinedelete")
public class medicinedelete extends HttpServlet {
    private Medicineservice medicineservice=new Medicineservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收json数据id
        String s = req.getParameter("id");
        //System.out.println(Integer.parseInt(s));
        try {
            medicineservice.deletemedicine(Integer.parseInt(s));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
