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

@WebServlet("/manage/userAdd.do")
public class UserAddAction extends HttpServlet {
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


        //获取值
        String email = req.getParameter("email");//邮箱
        String name = req.getParameter("name");//用户名
        String passWord = req.getParameter("passWord");//密码
        String sex = req.getParameter("sex");//性别
        String mobile = req.getParameter("mobile");//手机号码
        String birthyear = req.getParameter("birthyear");//年
        String birthmonth = req.getParameter("birthmonth");//月
        String birthday = req.getParameter("birthday");//日
        //生日拼接
        StringBuffer sr = new StringBuffer();
        sr.append(birthyear).append("-").append(birthmonth).append("-").append(birthday);
        sr.toString();
        //字符串转换为日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(String.valueOf(sr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String buIdentityCode = req.getParameter("buIdentityCode");//身份证号码
        //创建一个用户
        User user = new User();
        //赋值
        user.setBuUserName(name);
        user.setBuSex(sex);
        user.setBuEmail(email);
        user.setBuPassword(passWord);
        user.setBuBirthday(date);
        user.setBuMobile(mobile);
        user.setBuIdentityCode(buIdentityCode);
        //创建业务层对象
        UserService userService = new UserServiceImpl();
        //调用业务层添加方法
        int i = userService.addUser(user);
        if (i>0){
            //转发
            req.getRequestDispatcher("/manage/manage-result.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.println("修改失败");
        }

    }
}