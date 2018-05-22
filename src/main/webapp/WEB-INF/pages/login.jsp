<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登陆</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
	function validate() {
		if (document.getElementById("username").value=="") {
			alert("请输入账号");
			document.getElementById("username").focus();
			return false;
		}else if(document.getElementById("password").value==""){
			alert("请输入密码");
			document.getElementById("password").focus();
			return false;
		}
		
		return true;
	}
</script>

</head>

<body>
	<div id="content">
		<div id="form">
			<h1>用户登陆</h1>
			<form action="<%=path %>/user/login.action" method="post" id="myform"
				onsubmit="return validate()">
				用户名<input type="text" id="username" name="userName"
					style="width:190px;height:26px;margin-left:39px;"><br>
				密码<input type="text" id="password" name="password"
					style="width:190px;height:26px;margin-left:55px;"><br>
				<input type="submit" value="登陆"
					style="width:50px;height:30px;margin-top:8px;"> <a
					href="registerPage.action">注册</a>
			</form>
		</div>
		
		<!-- 		显示错误信息-->
		<c:if test="${errorMsg!=null }">
			<font color="green">${errorMsg}</font>
		</c:if>

		<!-- 		显示提示 -->
		<c:if test="${noticeMsg!=null }">
			<font color="green">${noticeMsg}</font>
		</c:if>
	</div>
</body>
</html>
