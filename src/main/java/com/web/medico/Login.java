package com.web.medico;

import com.pojo.medico.User;
import com.service.medico.Userservice2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/medico/Login")
public class Login extends HttpServlet {
    private Userservice2 userservice2 =new Userservice2();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //System.out.println(password);
        //调用service查询
        User user = null;
        try {
            user = userservice2.login(username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //判断
        if (user!=null){
            //若用户勾选了记住我
            String i=req.getParameter("remember");
            if("1".equals(i)){
                //创建cookie并发送cookie
                Cookie cookie=new Cookie("username",username);
                Cookie cookie1=new Cookie("password",password);
                cookie.setMaxAge(60*60*24*7);
                cookie1.setMaxAge(60*60*24*7);
                resp.addCookie(cookie);
                resp.addCookie(cookie1);
            }
            //Session
            HttpSession httpSession=req.getSession();
            httpSession.setAttribute("username11",username);
            httpSession.setAttribute("password11",password);
            //重定向至其它页面
            String context=req.getContextPath();
            resp.sendRedirect(context+"/html/medico_page.html");
        }else{
            //回到登录界面并显示提示信息
            req.setAttribute("failure","用户名或密码错误");
            req.getRequestDispatcher("/jsp/login2.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);

    }
}
