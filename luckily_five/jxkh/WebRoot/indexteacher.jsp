<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%@ page import="bean.*" %>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="include/headteacher.jsp"%> 
<%
ArrayList<IndexTeacherBean> list = new ArrayList<IndexTeacherBean>();
RawDataDAOImpl rawdao=new RawDataDAOImpl();
list=rawdao.ByTeacherID(id);

SuggestDAOImpl suggest=new SuggestDAOImpl();
 %>
<!-- MAIN BODY -->
<!-- Subhead
================================================== -->
<header class="jumbotron subhead" id="overview">
  <div class="container">
    <h1>绩效考核系统上线啦</h1>
    <p class="lead">欢迎访问，请查看你的评分O(∩_∩)O</p>
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
				<th>任课老师</th><th>评价项名</th><th colspan="2">总&nbsp;&nbsp;&nbsp;&nbsp;分</th>
			
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
						out.print("<td>"+list.get(i).getTeaName()+"</td>");
						out.print("<td>"+list.get(i).getPerfname()+"</td>");
						out.print("<td>"+list.get(i).getScore()+"</td>");
						k++;
						out.print("</tr>");
						}
					
					}
				
				%>	
				<tr>
				<td colspan="3">
					
				</td>
				</tr>
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
	  		<table class="table">
	  		<tr class="success">
	  		<td>
				<h4 >
					<i class="icon-signal"></i>
					绩效项所占比重分析图
				</h4>
				<div class="widget-content" >
					<div class="pie"  style="height: 500px;width: 700px;"></div>
				</div>
			</td>
			</tr>
			</table>
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
				<a id="dell" class="btn btn-primary" href="renameteacher.jsp">现在修改</a>
				<a data-dismiss="modal" class="btn" href="#">以后修改</a>
			</div>
		 </div>	
	    <%}%>
	   
		</div><!--/.well -->
	  </div><jsp:include page="include/footer.jsp"></jsp:include>
  </div>
</div>
			
   
<!-- jQuery -->
	
    <script>
   
   !function ($){
   var data = [];
	
	<%
	int RowCount=list.size();
	int ii=0;
	
	while(ii<RowCount){
		out.print("data["+ii+"] = { label: '"+list.get(ii).getPerfname()
		+"', data:"+ Integer.parseInt(list.get(ii).getScore())+" };");
		ii++;
	} 
	%>
	
	
	//for( var i = 0; i<series; i++)
	//{
	///	data[i] = { label: "Series"+(i+1), data: Math.floor(Math.random()*100)+1 }
	//}
	
    var pie = $.plot($(".pie"), data,{
        series: {
            pie: {
                show: true,
                radius: 3/4,
                label: {
                    show: true,
                    radius: 3/4,
                    formatter: function(label, series){
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'+label
                        +'<br/>'+Math.round(series.percent)+'%</div>';
                    },
                    background: {
                        opacity: 0.5,
                        color: '#000'
                    }
                },
                innerRadius: 0.2
            },
			legend: {
				show: false
			}
		}
	});
		
		$('#myAlert').modal('show').on('shown',function(){})
		
   }(window.jQuery)
     	
     	
     	</script>
     	 
</body></html>