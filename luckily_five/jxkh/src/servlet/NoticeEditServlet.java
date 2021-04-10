package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import dao.*;

public class NoticeEditServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NoticeEditServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>"
				+"<link id='xheCSS_vista' rel='stylesheet' type='text/css' href='script/xheditor_skin/vista/ui.css'>");
		out.println("  <BODY>");
		int id=Integer.parseInt(request.getParameter("id"));
		ArrayList<NoticeBean> list = new ArrayList<NoticeBean>();
		NoticeDAOImpl rawdao=new NoticeDAOImpl();
		list=rawdao._selectById(id);
		for(int i=0;i<list.size();i++){
		out.println("<form class=\"form-signin\" action=\"NoticeUpdataServlet\" method=\"post\">");
		out.println("<input type=\"hidden\" name=\"id\" value='"+list.get(i).getId()+"'/>"+
				"<label for='name' class=\"control-label\">公告标题</label><div class=\"controls\">"+
				"<input type=\"text\" id='name' name=\"title\" value='"+list.get(0).getTitle()+"'/></div>"
		);
		out.println("<label for='pclass' class=\"control-label\">公告内容</label><div class=\"controls\">"+
				"<textarea name='content' rows='8' id='elm1' style='width: 92%'>"+list.get(0).getContent()+"</textarea></div>"
		);
		out.println("<label>公告对象</label>"
		);
		String ident=list.get(0).getIdent().toString();
		if(ident.equals("全体师生")){
			out.println("<label>"+
					"<input type='radio' name='ident' id='op1' value='全体师生' checked>全体师生"+
					"</label>");
		}else{
			out.println("<label>"+
					"<input type='radio' name='ident' id='op1' value='全体师生'>全体师生"+
					"</label>");
		}
		if(ident.equals("教师")){
			out.println("<label>"+
					"<input type='radio' name='ident' id='op2' value='教师' checked> 教师"+
					"</label>");
		}else{
			out.println("<label>"+
					"<input type='radio' name='ident' id='op2' value='教师'> 教师"+
					"</label>");
		}
		if(ident.equals("学生")){
			out.println("<label>"+
					"<input type='radio' name='ident' id='op3'value='学生' checked> 学生"+
					"</label>");
		}else{
			out.println("<label>"+
					"<input type='radio' name='ident' id='op3'value='学生'> 学生"+
					"</label>");
		}
		out.println("<button class='btn' type='submit' name='submit'> 提交 </button>");
		
		out.print("</form>");
		}
		out.println(
		"<script>"+
	     "!function ($) {"+
	        "$(function(){"+

	         "$('#elm1').xheditor({skin:'vista',tools:'simple'});"+
	        "})"+
	      "}(window.jQuery);"+
	      
	    "</script>");    
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
