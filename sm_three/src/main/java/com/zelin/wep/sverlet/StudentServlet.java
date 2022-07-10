package com.zelin.wep.sverlet;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zelin.pojo.R;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentVo.StudentVo;
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

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        //1. 得到webapplicationcontext上下文
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        studentService = wac.getBean(StudentService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 得到请求参数
        String cmd = req.getParameter("cmd");
        //2. 判断参数获得方法
        if (StrUtil.isNotBlank(cmd)) {
            if ("list".equals(cmd)) {
                list(req, resp);
            }
        }
    }



    //1. 列表学生
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 得到所有学生
        List<Student> students = studentService.findAll();
        //2. 转换为字符串进行输出
        //因为vue-admin数据要统一所以需要拿到R对象
        R list = R.ok().data("list", students);
        resp.getWriter().println(JSON.toJSONString(list));
        resp.getWriter().flush();
    }

    //2. 分页查询学生


    //3. 添加学生

    //4. 修改学生
    //5. 删除学生

}
