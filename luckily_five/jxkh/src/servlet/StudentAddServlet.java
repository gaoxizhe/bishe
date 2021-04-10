package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;

import dao.SuggestDAOImpl;
import dao.UserDAOImpl;

public class StudentAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StudentAddServlet() {
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
		request.setCharacterEncoding("UTF-8");
		Student perf=new Student();
		int rs=0;
		String path="studentMG.jsp";
		
		perf.setSno(request.getParameter("Sno").toString().trim());
		perf.setSname(request.getParameter("Sname").toString());
		perf.setSpw(request.getParameter("Spw").toString());
		perf.setSex(request.getParameter("Sex").toString());
		perf.setSclass(request.getParameter("Sclass").toString());
		UserDAOImpl ud=new UserDAOImpl();
		try {
			rs=ud._insert(perf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0){
			response.sendRedirect(path);
		}else{response.sendRedirect(path+"?e="+rs+request.getParameter("Sname").toString()+request.getParameter("Sex"));}
	}

}
