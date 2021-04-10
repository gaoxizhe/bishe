<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@include file="include/head.jsp"%> 

<!-- MAIN BODY -->
<!-- Subhead
================================================== -->
<header class="jumbotron subhead" id="overview">
  <div class="container">
    <h1>绩效考核系统上线啦</h1>
    <p class="lead">请设置新密码</p>
  </div>
</header>
<div class="container">
	<div class="row-fluid"> 
	  <div class="span12 bs-docs-sidebar">
	  <div class="well sidebar-nav">
	  	
			<form method="post" class="form-signin" action="RpasswordServlet">
		        <p class="lead"> ID: <%=id %><br /> 姓名: <%=username %><br />性别: <%=usersex %><br />班级: <%=userclass %><br /></p>
		        <lable> 原密码</lable><input type="text" name="oldpw" class="input-block-level" placeholder="OldPassword">
		        <lable> 新密码</lable><input type="text" name="newpw" class="input-block-level" placeholder="NewPassword">
		        <input type="hidden" name="Sno" value="<%=id %>">
		        <input type="hidden" name="old" value="<%=userpw %>">
		        <button class="btn btn-primary" type="submit"> 提交 </button>
		    </form>
				<%
				if(request.getParameter("t")!=null){
				if(Integer.parseInt(request.getParameter("t").toString())==1){
		       %>
	       		<div class="text-center alert alert-error fade in">
	        		<button type="button" class="close in fade" data-dismiss="alert">&times;</button>
	        		<b>
	       			 原密码错误
	      			 </b>
	       		</div>
		       <% }else{ %>
		       <div class="text-center alert alert-success fade in">
	        		<button type="button" class="close in fade" data-dismiss="alert">&times;</button>
	        		<b>
	       			 修改成功
	      			 </b>
	       		</div>
 				<% }
 			} %>
		</div><!--/.well -->
	  </div>

<jsp:include page="include/footer.jsp"></jsp:include>
 	</div>  
 </div>
<!-- jQuery -->
	<script src="js/excanvas.min.js"></script>
            <script src="js/jquery.min.js"></script>
            <script src="js/jquery.ui.custom.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery.gritter.min.js"></script>
            <script src="js/jquery.peity.min.js"></script>
            <script src="js/jquery.uniform.js"></script>
            <script src="js/select2.min.js"></script>
            <script src="js/jquery.validate.js"></script>
            <script src="js/jquery.flot.min.js"></script>
            <script src="js/jquery.flot.pie.min.js"></script>
            <script src="js/jquery.flot.resize.min.js"></script>
            <script src="js/unicorn.js"></script>
           
            <script src="script/xheditor-1.1.14-zh-cn.min.js"></script>
    <script>
   !function ($){
		
   }(window.jQuery)
    </script>
     	 
</body></html>