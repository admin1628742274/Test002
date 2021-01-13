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
import java.util.List;

@WebServlet("/userQuery.do")
public class UserQueryAction extends HttpServlet {
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

        //1.获取当前页
        String sbqCurPageNo = req.getParameter("curPageNo");
        //2.默认设置为第一页
        int  curPageNo=1;
        //3.判断  sbqCurPageNo 是否有值，如果有值 把值赋给    curPageNo
        if(sbqCurPageNo!=null){
            curPageNo = Integer.parseInt(sbqCurPageNo);
        }
        //4.创建Page 对象  把获取到的值存入Page中
        Page page = new Page();
        page.setCurPageNo(curPageNo);//把上面所定义的当前页赋值给Page 中的  curPageNo
        page.setPageSize(2);//每页显示2条数据  可以在前端设置


        //5.调用分页查询方法
        UserService userServcie = new UserServiceImpl();
        List<User> list =  userServcie.getPageUser(page,null );

        //这里还没有写完的，等会写，需要调用总条数方法，然后设置值
        //获取总条数
        int totalCount = userServcie.getTotalCount(null);

        //必需把值设置到 Page 中的 totalCount 总条数
        page.setTotalCount(totalCount);

        //6.把 list 和 page  值存入  HttpServletRequest 中
        req.setAttribute("list",list);
        req.setAttribute("page",page);


        //7.必需使用转发
        req.getRequestDispatcher("/manage/user.jsp").forward(req,resp);
    }
}
