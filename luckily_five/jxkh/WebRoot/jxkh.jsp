<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%
String pageurl=request.getRequestURL().toString();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
String stuid=request.getParameter("stuid").toString();
String teaid=request.getParameter("teaid").toString();
//调查问卷数据
List list = new ArrayList();
PerfDAOImpl performance=new PerfDAOImpl();
list=performance.Selectall();
//调查对象数据
ArrayList teacherList=new ArrayList();
TeacherDAOImpl teacher=new TeacherDAOImpl();
teacherList=teacher.TeacherByTeacherID(teaid);
String teaName=teacherList.get(0).toString();
String teaSex=teacherList.get(1).toString();
String teaSdept=teacherList.get(2).toString();
 %>
<!-- MAIN BODY -->
<!-- Subhead
================================================== -->


<form class="form-signin" action="JxkhSub" method="post">
  <fieldset>
    <legend><%=teaName %></legend>
    <input type="hidden" name="stuid" value='<%=stuid %>'/>
	<input type="hidden" name="teaid" value='<%=teaid%>'/>
	<input type="hidden" name="size" value='<%=list.size()%>'/>
    <%
    int i;
    for(i=0;i<list.size();i++){
    		out.println("<input name='l"+i+"' type='hidden' value='"
							+list.get(i)+"'>");
			out.println("<input name='n"+i+"' class='input-xlarge control-group info' id='disabledInput' type='text' placeholder='"
							+list.get(i+1)+"' disabled>");
			out.println("<input name='m"+i+"' type='range' min='0' max='10' value='0' step='1' style='display: none;' id='backing"+i+"'>");
			out.println("<div class='rateit' data-rateit-backingfld='#backing"+i+"'></div>");
			
			i++;
		}
     %>
     <label class="checkbox">
      <input type="checkbox" id="inc"> 我已认真填写
    </label>
     
    <button type="submit" class="btn" disabled="disabled" id="submint">提交</button>
  </fieldset>
</form>

<!-- jQuery -->
	

    <script src="src/jquery.rateit.js" type="text/javascript"></script>
    
	<script>
	function checkrange(){
         $('input[type=range]').each(function(){
    
         	if($(this).val()<1){
         		$('#submint').attr("disabled","disabled");
         		$('#inc').removeAttr("checked");
         		return false;
         		}
         	else{
         		$('#submint').removeAttr("disabled");
         		
         		}
         });
    }
      !function ($) {
	      $('#inc').click(function(){
	      	checkrange();
	      });
      	$('#submint').click(function(){
	      	
	      });
      }(window.jQuery)
    </script>    
    

   
    
</body></html>