package com.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter("*.html")
public class Filter implements jakarta.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //jakarta.servlet.Filter.super.init(filterConfig);
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        String url = req.getRequestURL().toString();
        //放行
        System.out.println(url);
        String urls[]={"/Login","/Register","/test.html","/jsp/","/js/","/img/","/css/","/fonts/"};
        for(String s:urls){
            if(url.contains(s)){
                filterChain.doFilter(servletRequest,servletResponse);
                System.out.println("1");
                return;}}
        HttpSession session= req.getSession();
        Object user = session.getAttribute("username11");
        Object pass=session.getAttribute("password11");
        if(user!=null){
            System.out.println("2");
            //若已经进行登录验证，放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //跳到登陆界面
            req.setAttribute("warn","没有登录，无操作权限");
            String context=req.getContextPath();
            System.out.println("3");
            req.getRequestDispatcher("/html/test.html").forward(req,servletResponse);
        }}
    @Override
    public void destroy() {
        jakarta.servlet.Filter.super.destroy();
    }}
