<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="bean.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">with(document.documentElement){className=className.replace(/\bno-js\b/, 'js');}</script>
<meta charset="utf-8" />
<title></title>

<!-- Meta data -->
<meta name="description" content="" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
 
</head>
<body>
<%

String id=request.getParameter("id").toString();
ArrayList list = new ArrayList();
UserDAOImpl rawdao=new UserDAOImpl();
list=rawdao.UserByID(id);

 %>
<table class="table table-bordered table-hover table-striped">
	<tbody>
	<tr >
	<% 
	if(list.size() <= 0){
	%>
	<td><img src="./img/404.jpg" />
	</td>
		<%
		}else{
			
		%>
		<th>学 号</th><th>姓 名</th><th>性 别</th><th>密 码</th><th>班 级</th><th>编 辑</th>
	
	</tr>			
	<%
			out.print("<tr>");
			out.print("<td>"+id+"</td>");
			out.print("<td>"+list.get(0).toString()+"</td>");
			out.print("<td>"+list.get(2).toString()+"</td>");
			out.print("<td>"+list.get(1).toString()+"</td>");
			out.print("<td>"+list.get(3).toString()+"</td>");
			out.print(" <td><a class='btn btn-info'"
							+" href='StudentEditServlet?id="+id+"'" 
							+" > "
							+"<i class='icon-pencil'></i> </a></td>");
			out.print("</tr>");	
		}
		%>	
		</tbody>			
</table>
<div id="myJxkh" class="modal hide fade">
			<div class="modal-header">
				<button data-dismiss="modal" class="close" type="button">×</button>
				<p><i class="icon-leaf"></i></p>
			</div>
			<div class="modal-body">
				<div id="modelbody"></div>
			</div>
			<div class="modal-footer">
			</div>
		  </div>
		  <jsp:include page="include/javascript.jsp"></jsp:include>
<script type="text/javascript">
function Edit(id){
		    	var url='StudentEditServlet?id='+id+'&t='+Math.random(1000);   			
		     		$.get(url,null,function(data){
		     			$('#myJxkh').modal('show').on('shown',function(){
							$('#modelbody').html(data);
		 				})
		     		})
		       }  
		       </script>
</body></html>