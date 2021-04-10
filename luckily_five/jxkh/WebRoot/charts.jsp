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
<script src="js/excanvas.min.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.gritter.min.js"></script>
<script src="js/jquery.peity.min.js"></script>
<script src="js/jquery.uniform.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/jquery.flot.min.js"></script>
<script src="js/jquery.flot.pie.min.js"></script>
<script src="js/jquery.flot.resize.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="js/google-code-prettify/prettify.css">
<link href="src/rateit.css" rel="stylesheet" type="text/css">
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
			}
		%>
		<td>
		
		
		<div class="pie"  style="height: 300px;width: 500px;"></div>
			</td></tr>	
		</tbody>			
</table>

<!-- jQuery -->
	

    <script src="src/jquery.rateit.js" type="text/javascript"></script>
    <!-- syntax highlighter -->
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