package servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				boolean logins=false;
				String path="";
				String username= request.getParameter("username");
				String password= request.getParameter("password");
				String auth_code=request.getParameter("auth_code").replaceAll("\\s*","");
				String roles=request.getParameter("roles");
				String authcode=request.getSession().getAttribute("Val").toString();
				if(!authcode.equalsIgnoreCase(auth_code)){
					request.setAttribute("err", "验证码错误,请重新登录");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				try{
					if(roles.equalsIgnoreCase("roles1"))
					{
						UserDAOImpl userdao=new UserDAOImpl();
						logins=userdao.login(username,password);
					}else if(roles.equalsIgnoreCase("roles2"))
					{
						TeacherDAOImpl userdao=new TeacherDAOImpl();
						logins=userdao.login(username,password);
					}else if(roles.equalsIgnoreCase("roles3"))
					{
						AdminDAOImpl userdao=new AdminDAOImpl();
						logins=userdao.login(username,password);
					}

					if(logins){
						request.getSession().setAttribute("id",username);
						if(request.getParameter("remember")!= null){
							request.getSession().setMaxInactiveInterval(60*60*72);
						}
						if(roles.equalsIgnoreCase("roles1"))
						{
							path="index.jsp";
						}else if(roles.equalsIgnoreCase("roles2"))
						{
							path="indexteacher.jsp";
						}else if(roles.equalsIgnoreCase("roles3"))
						{
							path="indexadmin.jsp";
						}
						response.sendRedirect(path);
					}else {
						request.setAttribute("err", "密码错误,请重新登录");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}catch (Exception e) {
					//response.sendRedirect(path);
				}
				
				//request.getRequestDispatcher(path).forward(request, response);
			}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
