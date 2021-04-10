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
<link rel="stylesheet" type="text/css" href="js/google-code-prettify/prettify.css">
<link href="src/rateit.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<!-- alternative styles -->
    
    <!-- syntax highlighter -->
    
<!--[if IE 7]>
    <link rel="stylesheet" type="text/css" href="css/ie7.css" />
<![endif]-->
<!--[if IE]>
    <link rel="stylesheet" type="text/css" href="css/ie.css" />
<![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->
</head>
<%

String teaid=request.getParameter("id").toString();
ArrayList<IndexTeacherBean> list = new ArrayList<IndexTeacherBean>();
RawDataDAOImpl rawdao=new RawDataDAOImpl();
list=rawdao.ByTeacherID(teaid);

 %>
<table class="table table-bordered table-hover table-striped">
	<tbody>
	<tr >
	<% 
	if(list.size() <= 0){
	%>
	<img src="./img/404.jpg" />
	
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
				
				}
				
				out.print("</tr>");
				
			k++;
			}
		}
		%>	
		</tbody>			
</table>

<!-- jQuery -->
	

    <script src="src/jquery.rateit.js" type="text/javascript"></script>
    <!-- syntax highlighter -->

    

   
    
</body></html>