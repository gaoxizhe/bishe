<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@include file="include/headadmin.jsp"%> 

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
	  	
			<form method="post" class="form-signin" action="RAdminpasswordServlet">
		        <p class="lead"> ID: <%=id %><br />姓名: <%=username %><br /></p>
		        <p> 原密码</p><input type="text" name="oldpw" class="input-block-level" placeholder="OldPassword">
		        <p> 新密码</p><input type="text" name="newpw" class="input-block-level" placeholder="NewPassword">
		        <input type="hidden" name="Sno" value="<%=id %>">
		        <input type="hidden" name="old" value="<%=userpw %>">
		    
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
 			    <button class="btn btn-primary" type="submit"> 提交 </button>
		    </form>
		    <jsp:include page="include/footer.jsp"></jsp:include>
		</div><!--/.well -->
	  </div>
	  
  </div>

</div>  
			
   
<!-- jQuery -->
	
	<script src="js/bootstrap.js"></script>
    <script src="js/google-code-prettify/prettify.js"></script>
    <script src="js/application.js"></script>
    <script>
   !function ($){
		
   }(window.jQuery)
    </script>
     	 
</body></html>