<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%@ page import="bean.*" %>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="include/headadmin.jsp"%> 
<%
ArrayList<Student> list = new ArrayList<Student>();
UserDAOImpl rawdao=new UserDAOImpl();

list=rawdao._select();

 %>
<!-- MAIN BODY -->
<!-- Subhead
================================================== -->
<header class="jumbotron subhead" id="overview">
  <div class="container">
    <h1>绩效考核系统上线啦</h1>
    <p class="lead">欢迎访问学生管理O(∩_∩)O</p>
  </div>
</header>
<div class="container">
	<div class="row-fluid"> 
	  <div class="span12 bs-docs-sidebar">
	   	
	  <div class="well sidebar-nav">
	  	<div class="form-search">
		  <input type="text" id="stuID" placeholder="学生编号" class="input-medium search-query">
		  <button type="submit" onclick="search()" class="btn"> 搜索 </button>
		  <a href="javascript:void(0)" onclick="Add()" data-toggle="modal" style="float: right" class="btn btn-primary">
	  		<i class="icon-plus-sign icon-white"></i> 增加新项
	  	 </a>
	  	 
		  <br><br>
		</div>
		
	  	<table class="table table-bordered table-hover table-striped">
			<tbody>
			<tr >
			<% 
			if(list.size() <= 0){
			%>
				
				<%
				}else{
					
				%>
				<th>学生编号</th>
				<th>姓&nbsp;&nbsp;&nbsp;&nbsp;名</th><th>性&nbsp;&nbsp;&nbsp;&nbsp;别</th>
				<th>密&nbsp;&nbsp;&nbsp;&nbsp;码</th><th>班级</th>
				<th>编辑</th>
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
	      					"<input type='checkbox' value='"+list.get(i).getSno()+"' name='sub'><b>"+
	      					list.get(i).getSno()+
	      					"</b>"+
	    				"</label>"
						+"</td>");
						
						out.print("<td>"+list.get(i).getSname()+"</td>");
						out.print("<td>"+list.get(i).getSex()+"</td>");
						out.print("<td>"+list.get(i).getSpw()+"</td>");
						out.print("<td>"+list.get(i).getSclass()+"</td>");

						out.print(" <td><a class='btn btn-info'"
							+" href='javascript:void(0)' data-toggle='modal'"
							+" onclick='Edit("+list.get(i).getSno()+")'> "
							+"<i class='icon-pencil'></i> </a></td>");
						k++;
						}
						
						out.print("</tr>");
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
	  	
	    <!-- 查看绩效考核 -->
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
		<jsp:include page="include/footer.jsp"></jsp:include>
		</div><!--/.well -->
	  </div>
	  
  </div>
</div>
	<jsp:include page="include/javascript.jsp"></jsp:include>
    <script type="text/javascript">
    function Add(){
		   		var url='StudentAdd.jsp?t='+Math.random(1000);
		   		$.get(url,null,function(data){
		     			$('#myJxkh').modal('show').on('shown',function(){
							$('#modelbody').html(data);
		 				})
		     		})  
		       } 
	function Edit(id){
		    	var url='StudentEditServlet?id='+id+'&t='+Math.random(1000);   			
		     		$.get(url,null,function(data){
		     			$('#myJxkh').modal('show').on('shown',function(){
							$('#modelbody').html(data);
		 				})
		     		})
		       }  

    function search(){
	    var data = $('#stuID').val();
	    data = $.trim(data);
	    var re=/^[1-9][0-9]{9}$/;
		if(!re.test(data)){
		   alert("请输入正确的学生编号");
		   return false;
		}else{
			var url='stuser.jsp?id='+data+'&m='+Math.random(1000);
			$.get(url,null,function(data){
			  	    $('#myJxkh').modal('show').on('shown',function(){
					$('#modelbody').html(data);
				})
			 })
		}
     } 
   
   
   !function ($){
		
		$('#myJxkh').on('hidden',function(){
			 window.location.reload();
		})
		$("#selectAll").on('click', function(){//全选
    		$("input[name='sub']").attr("checked", true); 
		});

       $("#unSelect").click(function () {//全不选  
           $("input[name='sub']").attr("checked", false);  
       });  

       $("#reverse").click(function () {//反选  
           $("input[name='sub']").each(function () {  
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
          if(k>0){ 
	          var r = confirm("确定删除这 "+k+" 项记录");
			  if (r==true)
			  {
			    for(var i=0;i<arr.length;i++){ 
			    	var id=arr[i];
			    	var url='StudentDelServlet?id='+id+'&m='+Math.random(1000);
				  		$.get(url,null,function(data){
				  		if(data!=null) window.location.reload();
				  		});	
				  }	
			   }
		   } 
       });  
   }(window.jQuery)
     	
     	
     	</script> 
</body></html>