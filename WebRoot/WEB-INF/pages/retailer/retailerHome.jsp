<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>零售商管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		*{
			margin: 0;
			padding: 0;
		}
		#menuContent a{
			text-decoration: none;
			color: #ffffff;
		}
	</style>
	
	<script type="text/javascript">
		function changeStatus(){
			var status = document.getElementById("indexStatus").value;		
			document.getElementById("status").value=status;
		}
	</script>
  </head>
  
  <body>
    <%@include file="../menu.jsp" %><br>
    
    <form action="<%=path %>/retailer/list.action" method="post">
    	姓名：<input type="text" name="name" style="width: 120px;" />
    	手机：<input type="text" name="telephone" style="width: 120px;" />
    	地址：<input type="text" name="address" style="width: 120px;" /><br><br>
    	状态：<select id="indexStatus" onchange="changeStatus()">
    			<option value="-1" selected="selected">全部</option>
    			<option value="1" selected="selected">启用</option>
    			<option value="0" selected="selected">停用</option>
    		</select>
    	<input type="hidden" id="status" name="status" value="-1" />
    	创建日期：<input type="text" name="createTime" />
    	<input type="submit" value="搜索" style="background-color: #173e65;color: #ffffff;width: 70px;" /><br>
    	
    	<!-- 显示错误信息 -->
    	<c:if test="${errorMsg }">
    		<font color="red">${errorMsg }</font><br>
    	</c:if>
    </form>
    
    <hr style="margin-top: 10px;">
    
    
    <c:if test="${list!=null }">
    	<table style="margin-top: 10px;width: 700px;text-align:center;" border=1 >    	
    		<tr>
    			<td>序号</td><td>姓名</td><td>手机号</td><td>地址</td>
    			<td>状态</td><td>创建时间</td><td>操作</td>
    		</tr>
    		<c:forEach items="${list }" var="item" varStatus="status">
    			<tr>
    				<td>${status.index+1 }</td>
    				<td>${item.name}</td>
    				<td>${item.telephone}</td>
    				<td>${item.address}</td>
    				<td><c:if test="${item.status==1 }">
    					<font color="blue">启用</font>
    				</c:if>
    				<c:if test="${item.status==0 }">
    					<font color="red">停用</font>
    				</c:if></td>
    				<td>${item.createTime}</td>
    				<td><a>编辑</a>|<a>删除</a></td>
    			</tr>
    		</c:forEach>
    	</table>
    	
    	 <c:if test="${list==null }">
    	 	<b>搜索结果为空！</b>
    	 </c:if>
    	 
    	 <dir style="margin-top: 10px;">
    	 	<a>上一页</a>|<a>下一页</a>
    	 	<input type="text" id="pageNumber" style="width: 50px"><button>go</button>
    	 </dir>
    </c:if>
  </body>
</html>
