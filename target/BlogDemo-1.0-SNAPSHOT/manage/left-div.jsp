<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--后台页面左边Div--%>
<div id="menu-mng" class="lefter">
    <div class="box">
        <dl>
            <dt>用户管理test</dt>
            <dd><em><a href="/manage/user-add.jsp">新增</a></em><a href="${pageContext.request.contextPath}/userQuery.do">用户管理</a></dd>
            <dt>博文管理</dt>
            <dd><em><a href="blogClass-add.jsp">新增</a></em><a href="blogClass.jsp">分类管理</a></dd>
            <dd><em><a href="blog-add.jsp">新增</a></em><a href="blog.jsp">文章管理</a></dd>
            <dt>留言管理</dt>
            <dd><a href="guestbook.jsp">留言管理</a></dd>
        </dl>
    </div>
</div>
</body>
</html>
