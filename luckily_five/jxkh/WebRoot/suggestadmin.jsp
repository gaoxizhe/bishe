<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%@ page import="bean.*" %>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="include/headadmin.jsp"%> 

<%
ArrayList<SuggestBean> list = new ArrayList<SuggestBean>();
SuggestDAOImpl suggest=new SuggestDAOImpl();
list=suggest._ALLTeacher();

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
			<tbody id="playList">
			<tr >
			<% 
			if(list.size() <= 0){
			%>
				<p><img src="img/404.jpg"/></p>
				<%
				}else{
					
				%>
    			<th>教师编号</th>
	    		<th>学生学号</th>
	    		<th class="span6" >建议内容</th>
	    		<th colspan="2">提交时间</th>
			
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
						
						out.print("<td>"+
						"<label class='checkbox'>"+
	      					"<input type='checkbox' value='"+list.get(i).getmID()+"' name='sub'><b>"+
	      					list.get(i).getMteaID()+
	      					"</b>"+
	    				"</label>"
						+"</td>");
						out.print("<td>"+list.get(i).getMstuID()+""+"</td>");
						out.print("<td>"+list.get(i).getMess()+"</td>");
						out.print("<td>"+list.get(i).getMdate()+"</td>");
						k++;
						out.print("</tr>");
						}
					}	
				%>	
				</tbody>			
		</table>
		<div class="btn-group" data-toggle="buttons-checkbox">
			<button id="selectAll" class="btn btn-primary">全选</button>
			<button id="unSelect" class="btn btn-warning">全不选</button>
			<button id="reverse" class="btn btn-inverse" />反选</button>
  			<button id="deleted" class="btn btn-danger"  />删除</button>
  		</div>
		
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
	  	
<jsp:include page="include/footer.jsp"></jsp:include>
		</div><!--/.well -->
	  </div>
	  
  </div>
</div>
			
   
<!-- jQuery -->
	<jsp:include page="include/javascript.jsp"></jsp:include>
    <script type="text/javascript">
	 $(function () { 
	 	$("#selectAll").on('click', function(){//全选
    		$("input[name='sub']").attr("checked", true); 
		});

       $("#unSelect").click(function () {//全不选  
           $("#playList :checkbox").attr("checked", false);  
       });  

       $("#reverse").click(function () {//反选  
           $("#playList :checkbox").each(function () {  
               $(this).attr("checked", !$(this).attr("checked"));  
           });  
       }); 
       $("#deleted").click(function () {//删除
       	  var arr=new Array(); 
          var k = 0;
           $("input[name='sub']").each(function () {
           	  if($(this).attr("checked")){ 
           	    arr[k]=$(this).val();
           	  	k=k+1;
           	  } 
           });  
          var r = confirm("确定删除这 "+k+" 项记录");
		  if (r==true)
		  {
		    for(var i=0;i<arr.length;i++){ 
		    	var id=arr[i];
		    	var url='SuggestDelServlet?id='+id+'&m='+Math.random(1000);
			  		$.get(url,null,function(data){
			  		if(data!=null) window.location.reload();
			  		});	
			  }	
		   } 
       });  
 });  
</script>
     	 
</body></html>