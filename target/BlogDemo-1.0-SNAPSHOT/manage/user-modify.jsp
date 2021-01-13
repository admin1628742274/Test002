<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" isErrorPage="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 博客网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js">/*
	function commit() {
		var oradio= document.getElementsByName("sex");
		for (let i = 0; i < oradio.length; i++) {
			if (oradio[i].checked()){
				alert("ssss");
					return true;
			}else {
				return false;
			}
		}
	}*/

</script>

</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="blog.jsp">文章</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">博客网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<jsp:include page="left-div.jsp"></jsp:include>
	<div class="main">
		<h2>修改用户 请根据自己情况添加  input标签，和删除input标签</h2>
		<div class="manage">
			<%--表单开始位置--%>
			<%--<form action="manage-result.jsp">--%>
			<form action="userUpdateCommit.do" method="post">
				<input type="hidden" name="userid" value=${user.buUserId}>
				<table class="form">
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="name" value=${user.buUserName} /></td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text" class="text" name="email" value=${user.buEmail} readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="passWord" value=${user.buPassword} /></td>
					</tr>

					<tr>
						<td class="field">性别：</td>
						<td><c:choose>
							<c:when test="${user.buSex==1}"><input type="radio" name="sex" value="1" checked="checked" />男<input type="radio" name="sex" value="2" />女</c:when>
							<c:when test="${user.buSex==2}"><input type="radio" name="sex" value="1"  />男<input type="radio" name="sex" value="2" checked="checked" />女</c:when>
							<c:otherwise><input type="radio" name="sex" value="1"  />男<input type="radio" name="sex" value="2" />女</c:otherwise>
						</c:choose>
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
						<%--切割字符串--%>
						<c:set value="${ fn:split(user.buBirthday,'-') }" var="strList" />
						<c:forEach items="${strList}" var="strname" varStatus="i">
							<c:choose>
								<c:when test="${i.index == 0}">
									<select name="birthyear">
										<option value="1999" selected="selected">${strname}</option>
									</select>年
								</c:when>
								<c:when test="${i.index == 1}">
									<select name="birthmonth">
										<option value="11" selected="selected">${strname}</option>
									</select>月
								</c:when>
								<c:otherwise>
									<select name="birthday">
										<option value="1" selected="selected">${strname}</option>
									</select>日
								</c:otherwise>
							</c:choose>
						</c:forEach>
						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="mobile" value=${user.buMobile} /></td>
					</tr>
					<tr>
						<td class="field">身份证号码：</td>
						<td><input type="text" class="text" name="buIdentityCode" value=${user.buIdentityCode} /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>
