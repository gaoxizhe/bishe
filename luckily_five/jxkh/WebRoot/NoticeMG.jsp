<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%@ page import="bean.*" %>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="include/headadmin.jsp"%> 
<%
ArrayList<NoticeBean> list = new ArrayList<NoticeBean>();
NoticeDAOImpl rawdao=new NoticeDAOImpl();

list=rawdao._select();

 %>
<!-- MAIN BODY -->
<!-- Subhead
================================================== -->

<header class="jumbotron subhead" id="overview">
  <div class="container">
    <h1>绩效考核系统上线啦</h1>
    <p class="lead">欢迎访问公告管理O(∩_∩)O</p>
  </div>
</header>
<div class="container">
	<div class="row-fluid">
	<div class="widget-title">
	  <div class="well sidebar-nav">	
	  <p>
	  	<a href="javascript:void(0)" onclick="Add()" data-toggle="modal" class="btn btn-primary">
	  		<i class="icon-plus-sign icon-white"></i> 增加新项
	  	</a>
	 </p>  			
	  	<table class="table table-bordered table-hover table-striped">
			
			<thead>
			<tr >
			<% 
			if(list.size() <= 0){
			%><p><img src="img/404.jpg"></p>
			<%}else{%>
			<th>公告标题</th><th class="span6">公告内容</th>
			<th>所属类别</th><th>更新时间</th><th>操作管理</th>
			</tr>
			</thead>
			<tbody>			
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
						int _id = list.get(i).getId(); 
						
						out.print("<td>"+list.get(i).getTitle()+"</td>");
						out.print("<td>"+
						"<div style='overflow: hidden;word-wrap: break-word;word-break: break-all;height: 1.7em; '>"
						+list.get(i).getContent()+"</div></td>");
						out.print("<td>"+list.get(i).getIdent()+"</td>");
						out.print("<td>"+list.get(i).getDates()+"</td>");
						out.print("<td> <a href='javascript:void(0)' onclick='Del("+_id+")'"
							+" data-toggle='modal' class='btn btn-danger'><i class='icon-remove icon-white'></i></a> ");
						out.print("<a href='javascript:void(0)' onclick='Edit("+_id+")'"
							+" data-toggle='modal' class='btn btn-success'><i class='icon-pencil icon-white'></i></a>");
						out.print("</td> ");
						k++;
						out.print("</tr>");
						}
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
	  		<div id="myAdd" class="modal hide fade">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button">×</button>
					<h3>公告添加</h3>
				</div>
				<div class="modal-body">
					<div id="addbody"></div>
				</div>
				<div class="modal-footer">
					
				</div>
			</div>
	  
			<div id="myDel" class="modal hide fade">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button">×</button>
					<h3>删除确认</h3>
				</div>
				<div class="modal-body">
					<p>您确认要删除此条吗？</p>
				</div>
				<div class="modal-footer">
					<button id="deleted" class="btn btn-primary">确认</button>
					<a data-dismiss="modal" class="btn" href="#">取消</a>
				</div>
			</div>
			<div id="myEdit" class="modal hide fade">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button">×</button>
					<h3>编辑用户</h3>
				</div>
				<div class="modal-body">
					<div id="editbody"></div>
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
		    function Add(){
		   		var url='NoticeAdd.jsp?t='+Math.random(1000);
		   		$.get(url,null,function(data){
		     			$('#myAdd').modal('show').on('shown',function(){
							$('#addbody').html(data);
		 				})
		     		})  
		       } 
		    function Edit(id){
		    	var url='NoticeEditServlet?id='+id+'&t='+Math.random(9999);   			
		     		$.get(url,null,function(data){
		     			$('#myEdit').modal('show').on('shown',function(){
							$('#editbody').html(data);
		 				})
		     		})
		       } 
		    
		    function Del(id){
		   		var url='NoticeDelServlet?id='+id+'&t='+Math.random(1000);
		   		
		     	$('#myDel').modal('show').on('shown',function(){
					$("#deleted").click(function () {//删除
				  		$.get(url,null,function(data){
				  		 window.location.reload();
				  		});	
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