package servlet;

import dao.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RpasswordServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RpasswordServlet() {
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
		String oldpw="",password="",Sno="",old="";
		boolean b=false;
		oldpw= request.getParameter("oldpw");
		password= request.getParameter("newpw");
		Sno= request.getParameter("Sno");
		old= request.getParameter("old");
		UserDAOImpl userdao=new UserDAOImpl();
		
		if(!old.equals(oldpw)){
			response.sendRedirect("rename.jsp?t=1");
			
		}else{
		
		b=userdao._repassword(password, Sno);
		if(b)response.sendRedirect("rename.jsp?t=0");
		}
	}

}
