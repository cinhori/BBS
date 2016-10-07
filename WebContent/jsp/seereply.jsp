<%@ page language="java" import="java.util.*, com.bbs.bean.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<title>回复</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<base href="<%= basePath %>">
</head>

<body>
	<div class="chatMain">
		<ul class="ulSet">
			<li class="li1">回复者</li>
			<li class="li1">回复时间</li>
			<li class="li3" style="width:800px">回复内容</li>
		</ul>
	</div>
	<div class="chatMain">
		<%
			List<Comment> commentList = (List<Comment>)session.getAttribute("commentList");
			for(Comment c : commentList){
		%>
			<ul class="ulSet">
			<li class="li1"><%= c.getUserid() %></li>
			<li class="li1"><%= c.getCommenttime() %></li>
			<li class="li3" style="width:800px"><%= c.getCommenttext() %></li>
		</ul>
		
		<%  
			}
		%>
	</div>
	
	<a href="jsp/show.jsp">返回列表</a>
	
</body>
</html>
