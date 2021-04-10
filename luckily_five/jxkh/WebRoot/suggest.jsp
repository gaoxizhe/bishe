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
<link id="xheCSS_vista" rel="stylesheet" type="text/css" href="script/xheditor_skin/vista/ui.css">
</head>
<%
String stuid=request.getParameter("stuid").toString();
String teaid=request.getParameter("teaid").toString();

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


<form class="form-signin" action="SuggestSub" method="post" onsubmit="return checkPost()">
  <fieldset>
    <legend> <%=teaName %> </legend>
    <lable>性别： </lable><%=teaSex %><br/>
    <lable>系别： </lable><%=teaSdept %>
    <input type="hidden" name="stuid" value='<%=stuid %>'/>
	<input type="hidden" name="teaid" value='<%=teaid%>'/>
	     
	<textarea name="content" rows="6" id="elm1" style="width: 90%"></textarea>	
    <button type="submit" class="btn">提交</button>
  </fieldset>
</form>

<!-- jQuery -->

    <script>
     
      !function ($) {
        $(function(){

         $('#elm1').xheditor({skin:'vista',tools:'simple'});
        })
      }(window.jQuery);
      function checkPost(){
   		if($('#elm1').val()==""||$('#elm1').val()==null){alert("内容不能为空"); return false;}
     	} 
    </script>    
</body></html>