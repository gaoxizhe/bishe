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
<form class="controls" action="NoticeAddServlet" method="post" onsubmit="return checkPost()">
	
<p><label class="span2"><b>公告对象</b></label>
	<label class="span2">
	  <input type="radio" name="ident" id="op1" value="全体师生" checked>
	  全体师生
	</label>
	<label class="span2">
	  <input type="radio" name="ident" id="op2" value="教师">
	  教师
	</label>
    <label class="span6">
	  <input type="radio" name="ident" id="op3" value="学生">
	  学生
	</label>
	</p>
    
    <p><b>标 题 </b><input type="text" name="title" value=''/></p>
	<div class="controls"><b>内 容 </b>
	
		<textarea name="content" rows="8" id="elm1" style="width: 92%"></textarea>	
	</div>
	<br>
    <button type="submit" class="btn btn-primary">提交</button>
   	

</form>

<!-- jQuery -->

    <script>
     
      !function ($) {
        $(function(){

         $('#elm1').xheditor({skin:'vista',tools:'simple'});
        })
      }(window.jQuery);
      function checkPost(){
   		if($('#elm1').val()==""||$('#elm1').val()==null){alert("内容不能为空"); return false;}
     	} 
    </script>    
</body></html>