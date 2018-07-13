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
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("input:eq(0)").click(function(){
			$.ajax({
				url:"<%=basePath%>user/${param.userId}",
				dataType:"json",
				type:"get",
				success:function(data){
					alert(JSON.stringify(data));
				},
				error:function(){
					alert("通信异常");
				}
			});
		});
	});
</script>
</head>
<body>
	保存成功<br>
	<input type="button" value="查询刚刚添加的用户信息" />
</body>
</html>