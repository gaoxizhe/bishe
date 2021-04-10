package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import dao.*;

public class NoticeAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public NoticeAddServlet() {
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

		NoticeBean pe=new NoticeBean();
		int rs=0;
		String path="NoticeMG.jsp";
		request.setCharacterEncoding("UTF-8");
		pe.setTitle(request.getParameter("title").toString());
		pe.setIdent(request.getParameter("ident").toString());
		pe.setContent(request.getParameter("content").toString());
		NoticeDAOImpl ud=new NoticeDAOImpl();
		try {
			rs=ud._insert(pe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0){
			response.sendRedirect(path+"?e="+rs);
		}else{response.sendRedirect(path+"?e="+rs);}
	}
}
