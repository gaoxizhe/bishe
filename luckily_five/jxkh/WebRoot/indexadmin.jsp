<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%@ page import="bean.*" %>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="include/headadmin.jsp"%> 
<%
ArrayList<IndexAdminBean> list = new ArrayList<IndexAdminBean>();
RawDataDAOImpl rawdao=new RawDataDAOImpl();

list=rawdao.AllData();

 %>
<!-- MAIN BODY -->
<!-- Subhead
================================================== -->
<header class="jumbotron subhead" id="overview">
  <div class="container">
    <h1>绩效考核系统上线啦</h1>
    <p class="lead">欢迎访问O(∩_∩)O</p>
  </div>
</header>
<div class="container">
	<div class="row-fluid"> 
	  <div class="span12 bs-docs-sidebar">
	  
	  <div class="well sidebar-nav">
	  	<div class="form-search">
		  <input type="text" id="teacherID" placeholder="教师编号" class="input-medium search-query">
		  <button type="submit" onclick="search()" class="btn"> 搜索 </button>
		  <br><br>
		</div>
		
	  	<table class="table table-bordered table-hover table-striped">
			<tbody>
			<tr >
			<% 
			if(list.size() <= 0){
			%>
				<p><img src="img/404.jpg"></p>
				<%
				}else{
					
				%>
				<th>教师编号</th>
				<th>姓&nbsp;&nbsp;&nbsp;&nbsp;名</th><th>性&nbsp;&nbsp;&nbsp;&nbsp;别</th>
				<th>所在系别</th>
				<th>总&nbsp;&nbsp;&nbsp;&nbsp;分</th>
				<th> 查看详情</th>
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
						out.print("<td>"+list.get(i).getTeaId()+"</td>");
						out.print("<td>"+list.get(i).getTeaName()+"</td>");
						out.print("<td>"+list.get(i).getTeaSex()+"</td>");
						out.print("<td>"+list.get(i).getTeaSdept()+"</td>");
						out.print("<td>"+list.get(i).getScores()+"</td>");
						out.print("<td><a class='btn btn-success'"
							+" href='javascript:void(0)' data-toggle='modal'"
							+" onclick='look("+list.get(i).getTeaId()+")'> "
							+"<i class='icon-search'></i> </a>");
						out.print(" <a class='btn btn-info'"
							+" href='javascript:void(0)' data-toggle='modal'"
							+" onclick='charts("+list.get(i).getTeaId()+")'> "
							+"<i class='icon-signal'></i> </a></td>");
						k++;
						}
						
						out.print("</tr>");
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
	  	<%if(userpw.equals("12345")){//判断是否为初始密码  %>
		 <div id="myAlert" class="modal hide fade">
			<div class="modal-header">
				<button data-dismiss="modal" class="close" type="button">×</button>
				<font color="red" size="5"> 警 告 </font>
			</div>
			<div class="modal-body">
				<p>您当前密码为初始密码，请及时修改！</p>
			</div>
			<div class="modal-footer">
				<a id="dell" class="btn btn-primary" href="##">现在修改</a>
				<a data-dismiss="modal" class="btn" href="#">以后修改</a>
			</div>
		 </div>	
	    <%}%>
	    <!-- 查看绩效考核 -->
    	  <div id="myJxkh" class="modal hide fade">
			<div class="modal-header">
				<button data-dismiss="modal" class="close" type="button">×</button>
				<h3>绩效考核</h3>
			</div>
			<div class="modal-body">
				<div id="modelbody"></div>
			</div>
			<div class="modal-footer">
			</div>
		  </div>
		<jsp:include page="include/footer.jsp"></jsp:include>
		</div><!--/.well -->
	  </div>
	  
  </div>
</div>
	<jsp:include page="include/javascript.jsp"></jsp:include>
    <script>
    function search(){
	    var data = $('#teacherID').val();
	    data = $.trim(data);
	    var re=/^[1-9][0-9]{7}$/;
		if(!re.test(data)){
		   alert("请输入正确的教师编号");
		   return false;
		}else{
			var url='look.jsp?id='+data+'&m='+Math.random(1000);
			  		$.get(url,null,function(data){
			  	     		$('#myJxkh').modal('show').on('shown',function(){
					$('#modelbody').html(data);
				})
			 })
		}
     } 
   
   function look(teaid){
   		var url='look.jsp?id='+teaid+'&m='+Math.random(1000);
     		$.get(url,null,function(data){
     	     		$('#myJxkh').modal('show').on('shown',function(){
					$('#modelbody').html(data);
 				})
     		})
     	} 
   function charts(teaid){
   		var url='charts.jsp?id='+teaid+'&m='+Math.random(1000);
     		$.get(url,null,function(data){
     	     		$('#myJxkh').modal('show').on('shown',function(){
					$('#modelbody').html(data);
 				})
     		})
     	} 
   !function ($){
		$('#myAlert').modal('show').on('shown',function(){})
		$('#myJxkh').on('hidden',function(){
			 window.location.reload();
		})
		
   }(window.jQuery)
     	
     	
     	</script> 
</body></html>