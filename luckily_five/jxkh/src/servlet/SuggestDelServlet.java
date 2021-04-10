package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SuggestDAOImpl;

public class SuggestDelServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SuggestDelServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id= Integer.parseInt(request.getParameter("id"));
		
		SuggestDAOImpl suggest=new SuggestDAOImpl();
		
		try{
			int del=suggest._deleted(id);
			if(del==1){
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
				out.println("<HTML>");
				out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
				out.println("  <BODY>");
				out.println("  </BODY>");
				out.println("</HTML>");
				out.flush();
				out.close();
				
			}else {
				
				
			}
		}catch (Exception e) {
			
		}
	}

}
