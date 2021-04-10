<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="dao.*"%>
<%@page import="bean.*"%>
<%
ArrayList<NoticeBean> listnotice = new ArrayList<NoticeBean>();
NoticeDAOImpl noticedao=new NoticeDAOImpl();
String ident="2",title="2",content="2";
int ls=0;
listnotice=noticedao._selectByIdent("教师");
ls=listnotice.size();

String id="";
String username="";
String userpw="";
String usersex="";
String userclass="";
ArrayList userList=new ArrayList();
if(session.getAttribute("id")==null){
	response.sendRedirect("login.jsp");
}else{
	id=session.getAttribute("id").toString();
	UserDAOImpl user=new UserDAOImpl();
	userList=user.UserByID(id);
	username=userList.get(0).toString();
	userpw=userList.get(1).toString();
	usersex=userList.get(2).toString();
	userclass=userList.get(3).toString();
}
%>

<!DOCTYPE html>
<html class="no-js top-block style-body dark orange-yellow pretty mdf simple-breaker">
<head>
<meta charset="utf-8" />
<title></title>

<!-- Meta data -->
<meta name="description" content="" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="js/google-code-prettify/prettify.css">
<link rel="stylesheet" type="text/css" href="css/docs.css" />
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
  
  
    <!-- Le fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="ico/favicon.png">
  
</head>
<body  style="background-image: url(img/temp.jpeg)">
<!-- Navbar
    ================================================== -->
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
          
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li>
                <a href=".">首页</a>
              </li>

              <li class="">
                <a href="./rename.jsp">修改密码</a>
              </li>
              <li class="">
                <a href="./notice.jsp">公告<b><%= ls%></b>条</a>
              </li>
            </ul>
            
          <a href="OutServlet" class="btn pull-right">退出</a>
            <button class="btn btn-primary pull-right"><%
				out.print(username );
          %></button>
          </div>
        </div>
      </div>
    </div>
    
    <div class="">
        
      </div>