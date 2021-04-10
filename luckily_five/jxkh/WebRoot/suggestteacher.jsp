<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%@ page import="bean.*" %>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="include/headteacher.jsp"%> 
<%
ArrayList<SuggestBean> list = new ArrayList<SuggestBean>();
SuggestDAOImpl suggest=new SuggestDAOImpl();
list=suggest._ByTeacherID(id);

 %>
<!-- MAIN BODY -->
<!-- Subhead
================================================== -->
<header class="jumbotron subhead" id="overview">
  <div class="container">
    <h1>绩效考核系统上线啦</h1>
    <p class="lead">欢迎访问，请查看对您的建议和意见O(∩_∩)O</p>
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
				<th>学生学号</th><th class="span7" >建议内容</th><th colspan="2">提交时间</th>
			
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
						out.print("<td>"+list.get(i).getMstuID().substring(0,5)+"******"+"</td>");
						out.print("<td>"+list.get(i).getMess()+"</td>");
						out.print("<td>"+list.get(i).getMdate()+"</td>");
						
						}
						
						out.print("</tr>");
						
					k++;
					}
				
				%>	
				</tbody>			
		</table>
	  		<div>
	  		<!-- *************分页按钮 *****************-->
			<div class="pagination pagination-centered">
              <ul><li><a href="<%=pageurl %>">首页</a></li>
                <li><a href="<%=pageurl %>?page=<%= intPage-1 %>">&laquo;</a></li>
                <li><a href="#">第<%= intPage %> 页</a></li>
                <li><a href="#">共<%= intPageCount %> 页</a></li>
                <li><a href="<%=pageurl %>?page=<%= intPage+1 %>">&raquo;</a></li>
                <li><a href="<%=pageurl %>?page=<%= intPageCount %>">末页</a></li>
              </ul>
            </div>
	  		</div>
	  		<%} %>
	  	

		</div><!--/.well -->
	  </div><jsp:include page="include/footer.jsp"></jsp:include>
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