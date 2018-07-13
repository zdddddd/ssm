<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript">
	function removeUser(userId) {
		$.ajax({
			url:"<%=basePath %>user/" + userId,
			type:"post",
			data:"_method=DELETE",
			success:function(data){
				if (data.code == 200) {
					window.location.reload();//重新加载当前页面
				}
			},
			error:function(){
				alert("通信异常");
			}
		});
	}
</script>
</head>
<body>
<table width="500" border="1">
	<tr>
		<th>用户ID</th>
		<th>用户名</th>
		<th>密码</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${requestScope.userList }" var="user">
		<tr>
			<td>${user.userId }</td>
			<td>${user.username }</td>
			<td>${user.password }</td>
			<td>
				<a href="<%=basePath %>user_update.jsp?userId=${user.userId}&page=${requestScope.currentPage}">更新</a>
				<a href="javascript:void(0)" onclick="removeUser(${user.userId })">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
<a
	<c:if test="${requestScope.currentPage > 1 }">
	href="<%=basePath %>user/list?page=${requestScope.currentPage - 1}"
	</c:if>
>上一页</a>
<a
	<c:if test="${requestScope.currentPage < requestScope.pageSum }">
	href="<%=basePath %>user/list?page=${requestScope.currentPage + 1}"
	</c:if>
>下一页</a>
第${requestScope.currentPage } / ${requestScope.pageSum }页
</body>
</html>