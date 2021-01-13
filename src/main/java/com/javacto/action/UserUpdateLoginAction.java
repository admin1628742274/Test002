package com.javacto.action;

import com.javacto.po.User;
import com.javacto.service.UserService;
import com.javacto.service.UserServiceImpl;
import com.javacto.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/userUpdate.do")
public class UserUpdateLoginAction extends HttpServlet {
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
        //获取buUserId
        int buUserId = Integer.parseInt(req.getParameter("buUserId")) ;
       //调用业务层查询用户
        UserService userService = new UserServiceImpl();
        //根据当前的id查询对象全部信息
        User user = userService.getUserById(buUserId);
        //把user值存入  HttpServletRequest 中
        req.setAttribute("user",user);
        //转发到修改页面
        req.getRequestDispatcher("/manage/user-modify.jsp").forward(req,resp);

    }
}