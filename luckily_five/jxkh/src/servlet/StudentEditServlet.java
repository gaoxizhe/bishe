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

public class StudentEditServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StudentEditServlet() {
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
		out.println("<!DOCTYPE html>");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>Edit</TITLE></HEAD><meta charset='utf-8' />"
				+"<link rel='stylesheet' type='text/css' href='css/bootstrap.css' />"
				+"<link rel='stylesheet' type='text/css' href='css/bootstrap-responsive.css' />"+
				"<link rel='stylesheet' type='text/css' href='css/docs.css'>");
		out.println("  <BODY style=' background-image: url(img/temp.jpeg)'>");
		String id=request.getParameter("id").toString();
		ArrayList list = new ArrayList();
		UserDAOImpl rawdao=new UserDAOImpl();
		list=rawdao.UserByID(id);
		out.println("<div class='row-fluid'>");
		out.println("<div class=''>");
		out.println("<form style='color:red;margin-left:50px'  class=\"form-signin\" action=\"StudentUpdataServlet\" method=\"post\">");
		out.println("<input type=\"hidden\" name=\"id\" value='"+id+"'/>"+
				"<label for='n1' class=\"control-label\">姓名</label><div class=\"controls\">"+
				"<input type=\"text\" id='n1' name=\"Sname\" value='"+list.get(0)+"'/></div>"
		);
		out.println(
				"<label for='n2' class=\"control-label\">密码</label><div class=\"controls\">"+
				"<input type=\"text\" id='n2' name=\"Spw\" value='"+list.get(1).toString()+"'/></div>"
		);
		out.println(
				"<label for='n3' class=\"control-label\">性别</label><div class=\"controls\">"+
				"<input type=\"text\" id='n3' name=\"Sex\" value='"+list.get(2)+"'/></div>"
		);
		out.println("<label for='n4' class=\"control-label\">班级</label><div class=\"controls\">"+
				"<input type=\"text\" id='n4' name=\"Sclass\" value='"+list.get(3)+"'/></div>"
		);
		
		out.println("<button class='btn btn-primary' type='submit' id='submit'> 提 交 </button>");
		
		out.print("</form>");
		out.print("</div>");
		out.print("</div>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
