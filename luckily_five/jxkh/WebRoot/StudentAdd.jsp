<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">with(document.documentElement){className=className.replace(/\bno-js\b/, 'js');}</script>
<meta charset="utf-8" />
<title></title>

<!-- Meta data -->
<meta name="description" content="" />

<link id="xheCSS_vista" rel="stylesheet" type="text/css" href="script/xheditor_skin/vista/ui.css">
</head>
<body>
<!-- MAIN BODY -->
<form class="controls" action="StudentAddServlet" method="post">
<label for='n0' class="control-label">学号</label><div class="controls">
				<input type="text" id='n0' name="Sno" value=''/></div>
				<label for='n1' class="control-label">姓名</label><div class="controls">
				<input type="text" id='n1' name="Sname" value=''/></div>
		<label for='n2' class="control-label">密码</label><div class="controls">
				<input type="text" id='n2' name="Spw" value=''/></div>
		<label for='n3' class="control-label">性别</label><div class="controls">
				<input type="text" id='n3' name="Sex" value=''/></div>
		
		<label for='n4' class="control-label">班级</label><div class="controls">
				<input type="text" id='n4' name="Sclass" value=''/></div>
	
		
    <button type="submit" class="btn btn-primary">提交</button>
   	

</form>

<!-- jQuery -->

     
</body></html>