package com.zelin.web;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.zelin.pojo.Companyinfo;
import com.zelin.service.CompanyinfoService;
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
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@WebServlet("/company")
public class CompanyInfoServlet extends HttpServlet {
    private CompanyinfoService companyinfoService;

    @Override
    public void init() throws ServletException {
        //1. 得到上下文文件
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        //2. 得到companyservice对象
        wac.getBean(CompanyinfoService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 得到请求参数
        String cmd = req.getParameter("cmd");
        //2. 判断
        if (StrUtil.isNotBlank(cmd)){
            if ("list".equals(cmd)){
                list(req,resp);
            }
        }
    }


    //列表客户信息
    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1. 得到客户信息
        List<Companyinfo> companyinfoList = companyinfoService.findall();
        //2. 转换成字符串进行输出
        resp.getWriter().println(JSON.toJSONString(companyinfoList));
        resp.getWriter().flush();
    }
}
