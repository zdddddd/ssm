<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"<%=basePath%>user/${param.userId}",
			type:"get",
			dataType:"json",
			success:function(data){
				$("span:eq(0)").html(data.userId);
				$("input[name=userId]").val(data.userId);
				$("input[name=username]").val(data.username);
				$("input[name=password]").val(data.password);
			},
			error:function(){
				alert("通信异常");
			}
		});
	});
</script>
</head>
<body>
<form action="<%=basePath%>user/${param.page}" method="post">
	<input type="hidden" name="_method" value="PUT" />
	<table border="1" width="300">
	<tr>
		<td>用户ID</td>
		<td>
			<span></span>
			<input type="hidden" name="userId" value=""/>
		</td>
	</tr>
	<tr>
		<td>用户名</td>
		<td>
			<input type="text" value="" name="username"/>
		</td>
	</tr>
	<tr>
		<td>用户名</td>
		<td>
			<input type="password" name="password"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="重置" onclick="window.location.reload();" />
		</td>
		<td>
			<input type="submit" value="更新数据" />
		</td>
	</tr>
	</table>
</form>
</body>
</html>