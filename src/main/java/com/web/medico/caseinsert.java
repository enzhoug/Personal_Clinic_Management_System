package com.web.medico;

import com.service.medico.Caseservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/medico/caseinsert")
public class caseinsert extends HttpServlet {
    private Caseservice caseservice=new Caseservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String medicinename = req.getParameter("medicinename");
        String casename = req.getParameter("casename");
        String clientid = req.getParameter("clientid");
        try {
            caseservice.insertcase(medicinename,casename,Integer.parseInt(clientid));
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
