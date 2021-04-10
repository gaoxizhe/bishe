package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PerformanceBean;
import dao.PerfDAOImpl;

public class AddPerformanceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddPerformanceServlet() {
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
		out.println("  <HEAD><TITLE></TITLE></HEAD>");
		out.println("  <BODY>");
		
		out.println("<form class=\"form-signin\" action=\"AddPerfSubServlet\" method=\"post\">");
		out.println(
				"<label for='name' class=\"control-label\">项目名称</label><div class=\"controls\">"+
				"<input type=\"text\" id='name' name=\"perfName\" value=''/></div>"
		);
		out.println("<label for='pclass' class=\"control-label\">项目类别</label><div class=\"controls\">"+
				"<input type=\"text\" id='pclass' name=\"perfClass\" value=''/></div>"
		);
		out.println("<button class='btn' type='submit' name='submit'> 提 交 </button>");
		
		out.print("</form>");
	
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
