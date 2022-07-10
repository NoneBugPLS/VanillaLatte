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
            } else if ("search".equals(cmd)) {
                search(req, resp);
            } else if ("add".equals(cmd)){
                add(req, resp);
            }else if("update".equals(cmd)){
                update(req,resp);
            }else if ("delete".equals(cmd)){
                delete(req,resp);
            }
        }
    }



    //1. 列表学生
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 得到所有学生
        List<Student> students = studentService.findAll();
        //2. 转换为字符串进行输出
        resp.getWriter().println(JSON.toJSONString(students));
        resp.getWriter().flush();
    }

    //2. 分页查询学生
    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2.1得到分页参数
        int page = Integer.parseInt(req.getParameter("page"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        //2.2 得到分页查询参数  就是你输入的学生信息的值
        String stud = req.getParameter("stud");
        //2.2.1 把他转换成存放查询学生信息的对象
        StudentVo studentVo = JSON.parseObject(stud, StudentVo.class);
        //3. 开始条件查询带分页
        PageInfo<Student> studentPageInfo = studentService.search(page, pageSize, studentVo);   //这一步要自己写pageinfo
        //4. 把结果输出
        R put = R.ok().put("total", studentPageInfo.getTotal()).put("rows", studentPageInfo.getList());
        //5. 放入json对象并输出
        resp.getWriter().println(JSON.toJSONString(put));
        resp.getWriter().flush();
    }

    //3. 添加学生
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1. 得到学生信息字符串
        String stud = req.getParameter("stud");
        //2. 将学生信息转换为学生对象
        Student student = JSON.parseObject(stud, Student.class);
        //3. 添加学生
        studentService.insert(student);
        //4. 给前端输出成功信息
        resp.getWriter().println(JSON.toJSONString(R.ok()));
        resp.getWriter().flush();
    }

    //4. 修改学生
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1. 得到学生信息字符串
        String stud = req.getParameter("stud");
        //2. 将学生信息转换为学生对象
        Student student = JSON.parseObject(stud, Student.class);
        //3. 添加学生
        studentService.update(student);
        //4. 给前端输出成功信息
        resp.getWriter().println(JSON.toJSONString(R.ok()));
        resp.getWriter().flush();
    }
    //删除学生
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1. 得到删除学生信息
        String stud = req.getParameter("ids");
        String[] split = stud.split(",");
        for (String id : split) {
            studentService.delete(id);
        }
        //5.2 转换为字符串并输出
        resp.getWriter().println(JSON.toJSONString(R.ok()));
        resp.getWriter().flush();
    }
}
