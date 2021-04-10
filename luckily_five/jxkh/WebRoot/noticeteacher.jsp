<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@include file="include/headteacher.jsp"%> 

<!-- MAIN BODY -->
<!-- Subhead
================================================== -->
<header class="jumbotron subhead" id="overview">
  <div class="container">
    <h1>绩效考核系统上线啦</h1>
    <p class="lead">请关注公告栏</p>
  </div>
</header>
<div class="container">
	<div class="row-fluid"> 
	  <div class="span12 bs-docs-sidebar">
	  <div class="well sidebar-nav">
	  	<%
		if(ls==0)
		{
 				out.println("<div class='text-center alert alert-warning fade in'>"+
					"<button type='button' class='close in fade' data-dismiss='alert'>&times;</button>"+
					"<h3>暂无公告</h3>"+
					"<h4></h4>"+
					"</div>");	
 			
		}
		
		for(int ii=0;ii<ls;ii++){
			ident=listnotice.get(ii).getIdent();
			title=listnotice.get(ii).getTitle();
			content=listnotice.get(ii).getContent();
			
				out.println("<div class='text-center alert alert-warning fade in'>"+
					"<button type='button' class='close in fade' data-dismiss='alert'>&times;</button>"+
					"<h3>公告《"+title+"》</h3>"+
					"<div>"+content+"</div>"+
					"</div>");
 			
	     } %>
		</div><!--/.well -->
	  </div>
	  <jsp:include page="include/footer.jsp"></jsp:include>
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