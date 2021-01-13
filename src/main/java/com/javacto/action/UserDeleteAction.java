package com.javacto.action;

import com.javacto.po.User;
import com.javacto.service.UserService;
import com.javacto.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/userDelete.do")
public class UserDeleteAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求编码格式 Request  从前端传递过来的参数
        req.setCharacterEncoding("UTF-8");
        //处理  Response 响映编码格式  就是值从后台需要传递到前端
        resp.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt( req.getParameter("id"));
        //创建业务层对象
        UserService userService = new UserServiceImpl();
        //调用业务层添加方法
        int i = userService.deleteUserById(id);
        if (i>0){
            //转发
            req.getRequestDispatcher("/manage/manage-result.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.println("修改失败");
        }

    }
}