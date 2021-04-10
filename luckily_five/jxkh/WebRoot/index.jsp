<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%@ page import="bean.*" %>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="include/head.jsp"%> 
<%
ArrayList<IndexBean> list = new ArrayList<IndexBean>();
TeacherDAOImpl teacher=new TeacherDAOImpl();
list=teacher.TeacherByID(id);

RawDataDAOImpl rawdao=new RawDataDAOImpl();
SuggestDAOImpl suggest=new SuggestDAOImpl();
 %>
<!-- MAIN BODY -->
<!-- Subhead
================================================== -->
<header class="jumbotron subhead" id="overview">
  <div class="container">
    <h1>绩效考核系统上线啦</h1>
    <p class="lead">欢迎访问，请给你的老师打分O(∩_∩)O</p>
  </div>
</header>
<div class="container">
	<div class="row-fluid"> 
	  <div class="span12 bs-docs-sidebar">
	  <div class="well sidebar-nav">
	  	<table class="table table-bordered table-hover table-striped">
			<tbody>
			<tr >
			<% 
			if(list.size() <= 0){
			%>
				<h2>暂无信息</h2>
				<%
				}else{
					
				%>
				<th>选课名</th><th>任课老师</th><th>课程学分</th><th>评&nbsp;&nbsp;&nbsp;&nbsp;价</th>
			<th>建&nbsp;&nbsp;&nbsp;&nbsp;议</th>
			</tr>			
			<%
			//分页实现代码从此开始
			  int intPageSize;//一页显示的记录数
			  int intRowCount;//记录总数
			  int intPageCount;//总页
			  int intPage;//显示页码
			  String strPage="0";
			  int i;
			  intPageSize=5;//设置一页显示的记录数
			  strPage=request.getParameter("page");//取得待显示页码
			  if(strPage==null){//表明在ＱueryString中没有page这个参数，则显示第一页数据
			 	intPage=1;
			  }else{
			    //将字符串换成整型
			  	intPage=Integer.parseInt(strPage);
			  	if(intPage<1) intPage=1;
			  }
			  
				//记录指针指向查询结果集中最后一条记录
				intRowCount=list.size();//获取记录总数
				intPageCount=(intRowCount+intPageSize-1)/intPageSize;//记录总页数
				if(intPage>intPageCount)
			   		intPage=intPageCount;//调整待显示的页码
			 	//显示数据
			   if(intPageCount>0)
			   {//将记录指针定位到待显示页的第一条记录上．
				int k=0;
				for(i=(intPage-1)*intPageSize;k<intPageSize && i<intRowCount;i++){
						out.print("<tr>");
						out.print("<td>"+list.get(i).getCname()+"</td>");
						out.print("<td>"+list.get(i).getTeaName()+"</td>");
						out.print("<td>"+list.get(i).getScore()+"</td>");
						//判断是否已评
						boolean b= rawdao._SelectBystuID_steaID(id,list.get(i).getTeaId());
						if(!b){
							out.print("<td class='span2'>"
							+"<a class='btn btn-primary' data-toggle=\"modal\" href='javascript:void(0)' onclick='jxkh("
							+id+","+list.get(i).getTeaId()
							+")'><i class=\"icon-pencil icon-white\"></i> 评价</a></td>");
						}else{
							out.print("<td>"
							+"<a class='btn' href='#'><i class=\"icon-ok\"></i> 已评价</a></td>");
						}
						//判断是否已建议
						
						boolean bs= suggest._SelectBystuID_steaID(id,list.get(i).getTeaId());
						if(!bs){
							out.print("<td class='span2'><a class='btn btn-success' data-toggle=\"modal\" href='javascript:void(0)' onclick='suggest("
							+id+","+list.get(i).getTeaId()
							+")'><i class=\"icon-comment icon-white\"></i> 建议</a></td>");
						}else{
							out.print("<td>"
							+"<a class='btn' href='#'><i class=\"icon-ok\"></i> 已建议</a></td>");
						}
						
						out.print("</tr>");
						
					k++;
					}
				}
				%>	
				</tbody>			
		</table>
	  		<div>
		  		<!-- *************分页按钮 *****************-->
				<div class="pagination pagination-centered">
	              <ul><li><a href="index.jsp">首页</a></li>
	                <li><a href="index.jsp?page=<%= intPage-1 %>">&laquo;</a></li>
	                <li><a href="#">第<%= intPage %> 页</a></li>
	                <li><a href="#">共<%= intPageCount %> 页</a></li>
	                <li><a href="index.jsp?page=<%= intPage+1 %>">&raquo;</a></li>
	                <li><a href="index.jsp?page=<%= intPageCount %>">末页</a></li>
	             </ul>
	            </div>
	  		</div>
	  		<%} %>
	  	<%if(userpw.equals("12345")){//判断是否为初始密码  %>
		 <div id="myAlert" class="modal hide fade">
			<div class="modal-header">
				<button data-dismiss="modal" class="close" type="button">×</button>
				<i class="icon-warning-sign"></i><font color="red" size="5"> 警 告 </font>
			</div>
			<div class="modal-body">
				<p class="text-warning">您当前密码为初始密码，请及时修改！</p>
			</div>
			<div class="modal-footer">
				<a id="dell" class="btn btn-primary" href="rename.jsp">现在修改</a>
				<a data-dismiss="modal" class="btn" href="#">以后修改</a>
			</div>
		 </div>	
	    <%}%>
	    <!--绩效考核 -->
    	  <div id="myJxkh" class="modal hide fade">
			<div class="modal-header">
				<button data-dismiss="modal" class="close" type="button">×</button>
				<h3>绩效考核</h3>
			</div>
			<div class="modal-body">
				<div id="editbody"></div>
			</div>
			<div class="modal-footer">
			</div>
		  </div>
		  <!--给老师的建议 -->
	 	  <div id="mySuggest" class="modal hide fade">
			<div class="modal-header">
				<button data-dismiss="modal" class="close" type="button">×</button>
				<h3>给老师的建议</h3>
			</div>
			<div class="modal-body">
				<div id="sugbody"></div>
			</div>
			<div class="modal-footer">
			</div>
		  </div>
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
    function suggest(stuid,teaid){
   		var url='suggest.jsp?stuid='+stuid+'&teaid='+teaid+'&m='+Math.random(1000);
   		
     		$.get(url,null,function(data1){
     	     		$('#mySuggest').modal('show').on('shown',function(){
					$('#sugbody').html(data1);
 				})
     		})
     	} 
   function jxkh(stuid,teaid){
   		var url='jxkh.jsp?stuid='+stuid+'&teaid='+teaid+'&m='+Math.random(1000);
     		$.get(url,null,function(data){
     	     		$('#myJxkh').modal('show').on('shown',function(){
					$('#editbody').html(data);
 				})
     		})
     	} 
   
   !function ($){
		$('#myAlert').modal('show').on('shown',function(){})
		$('#myJxkh').on('hidden',function(){
			 window.location.reload();
		})
		$('#mySuggest').on('hidden',function(){
			 window.location.reload();
		})
   }(window.jQuery)
     	
     	
     	</script>
     	 
</body></html>