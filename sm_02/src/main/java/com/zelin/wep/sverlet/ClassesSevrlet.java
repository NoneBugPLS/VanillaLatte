package com.zelin.wep.sverlet;

import com.alibaba.fastjson.JSON;
import com.zelin.pojo.Classes;
import com.zelin.service.ClassesService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/classes")
public class ClassesSevrlet extends HttpServlet {
    private ClassesService classesService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        classesService = wac.getBean(ClassesService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有班级
        List<Classes> classes = classesService.findAll();
        //转换并输出给前端
        resp.getWriter().println(JSON.toJSONString(classes));
        resp.getWriter().flush();
    }
}
