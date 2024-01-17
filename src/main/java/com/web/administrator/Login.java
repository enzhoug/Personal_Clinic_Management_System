package com.web.administrator;

import com.pojo.administrator.User;
import com.service.administrator.Userservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/administrator/Login")
public class Login extends HttpServlet {
    private Userservice userservice=new Userservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //调用service查询
        User user = null;
        try {
            user = userservice.login(username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //判断该用户用户名和密码是否正确
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
            resp.sendRedirect(context+"/html/administrator_page.html");
        }
        else{
               //回到登录界面并显示提示信息
            req.setAttribute("failure","用户名或密码错误");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
