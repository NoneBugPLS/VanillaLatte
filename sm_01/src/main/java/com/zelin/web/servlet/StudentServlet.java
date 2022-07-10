package com.zelin.web.servlet;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.zelin.pojo.Student;
import com.zelin.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ------------------------------
 * 功能：
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/9-10:57
 * ------------------------------
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        //1. 下面的工具类的作用：是建立tomcat与spring两者之间的桥梁
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        //2. 从spring容器中得到javabean
        studentService = wac.getBean(StudentService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //1. 得到参数，进行方法调用
        String cmd = req.getParameter("cmd");
        //2. 调用不同的方法
        if(StrUtil.isNotBlank(cmd)){
            list(req,resp);
        }
    }
    //1. 列表学生
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.1 查询 得到所有学生
        List<Student> students = studentService.findAll();
        //1.2 转换为json对象并输出
        resp.getWriter().println(JSON.toJSONString(students));
        resp.getWriter().flush();
    }
}
