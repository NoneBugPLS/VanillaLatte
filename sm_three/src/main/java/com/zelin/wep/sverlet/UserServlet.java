package com.zelin.wep.sverlet;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.zelin.pojo.R;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ------------------------------
 * 功能：
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/11-11:16
 * ------------------------------
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 得到请求参数
        String cmd = req.getParameter("cmd");
        //2. 根据参数调用不同的方法
        if(StrUtil.isNotBlank(cmd)){
            if("login".equals(cmd)){
                login(req,resp);
            }else if("info".equals(cmd)){
                info(req,resp);
            }
        }
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 处理登录数据
        R token = R.ok().data("token", 1);
        //2. 将数据输出
        resp.getWriter().println(JSON.toJSONString(token));
        resp.getWriter().flush();
    }
    private void info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 定义R对象
        R r = R.ok()
                .data("name","admin")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        //2. 将数据输出
        resp.getWriter().println(JSON.toJSONString(r));
        resp.getWriter().flush();
    }

}
