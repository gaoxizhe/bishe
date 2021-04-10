package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SuggestDAOImpl;

public class SuggestSub extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SuggestSub() {
		super();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		
		
		
		request.setCharacterEncoding("UTF-8");
		SuggestDAOImpl suggest=new SuggestDAOImpl();
		String content = "";
		String stuid=request.getParameter("stuid").toString();
		String teaid=request.getParameter("teaid").toString();
		content=request.getParameter("content").toString();
		ArrayList list=new ArrayList();
		list.add(0, stuid);
		list.add(1, teaid);
		list.add(2, content);

		if(suggest._insert(list)!=0){
			out.println("<script>window.location.href='index.jsp'</script>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
