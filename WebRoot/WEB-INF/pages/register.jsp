<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		function validate(){
		
			if(document.getElementById("username").value==""){
				alert("用户名不能为空");
				document.getElementById("username").focus();
				return false;
			}else if(document.getElementById("password").value==""){
				alert("密码不能为空");
				document.getElementById("password").focus();
				return false;
			}else if(document.getElementById("name").value==""){
				alert("姓名不能为空");
				document.getElementById("name").focus();
				return false;
			}else if(document.getElementById("telephone").value==""){
				alert("手机号不能为空");
				document.getElementById("telephone").focus();
				return false;
			}
			return true;
		}
	</script>

  </head>
  
  <body>
    <div id="content">
    	<div id="form">
    		<h1>用户注册</h1>
    		<form action="<%=path %>/user/register.action" method="post" id="myform" onsubmit="return validate()">
    			用户名：<input type="text" id="username" name="username" style="width:190px;height:26px;margin-left:39px; " /><br/>
    			密&nbsp;&nbsp;&nbsp;码：<input type="text" id="password" name="password" style="width:190px;height:26px;margin-left:41px; " /><br/>
    			姓&nbsp;&nbsp;&nbsp;名：<input type="text" id="name" name="name" style="width:190px;height:26px;margin-left:41px; " /><br/>
    			手机号：<input type="text" id="telephone" name="telephone" style="width:190px;height:26px;margin-left:39px; " /><br/>
    			<input type="submit" value="注册" style="width:50px;height:30px;margin-top:8px;" />
    			<a href="<%=path %>/user/toLogin.action">返回登陆</a>
    		</form>
    		
    		<c:if test="${errorMsg!=null }">
    			<font color="red">${errorMsg}</font>
    		</c:if>
    	</div>
    </div>
  </body>
</html>
