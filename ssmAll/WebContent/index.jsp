<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎使用SSM框架<br>
<hr>
<a href="<%=basePath %>user/list">用户列表</a>
<br>

<form action="<%=basePath%>user" method="post">
	<input type="text" name="username" placeholder="用户名" /><br>
	<input type="password" name="password" placeholder="密码" /><br>
	<input type="submit" value="保存用户" />
</form>
</body>
</html>