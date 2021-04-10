<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.sql.*"%>
<%@ page import="dao.*"%>
<%@ page import="util.DBConnection"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

  <!--[if lte IE 6]>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap-ie6.css">  
	<link rel="stylesheet" type="text/css" href="./css/ie.css">
   <![endif]-->
	 <!-- Le styles -->
	<!-- Bootstrap css file v2.2.1 -->
    <link href="./css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="./css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="./js/html5shiv.js"></script>
    <![endif]-->

  </head>

  
  <body>
	<%
TeacherDAOImpl teacher=new TeacherDAOImpl();
ArrayList a=teacher.TeacherByID("1321145518");

for(int i=0;i<a.size();i++){
	out.print(a.get(i).toString()+"<br>");
}


//链接数据库
//Connection conn=DBConnection.getConnection();
//PreparedStatement pstmt=null;

//for(int i=1;i<10;){

/**
String registerSQL ="insert into teacher(teaId,teaName,teaSex,teaSdept) values(?,?,?,?)";
	ResultSet rs = null;

	pstmt=conn.prepareStatement(registerSQL);
	pstmt.setString(1,"10120131"+i);
	pstmt.setString(2,"测试"+i);
	pstmt.setString(3,"女");
	pstmt.setString(4,"系别");
	if(pstmt.executeUpdate()==1){
		i++;
	}
	}
	**/
	
	
	 %>
  </body>
</html>
