package com.zelin.wep.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do filter");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf8");
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
