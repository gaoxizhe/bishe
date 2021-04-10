package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.NoticeBean;
import dao.NoticeDAOImpl;

public class NoticeUpdataServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NoticeUpdataServlet() {
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
		NoticeBean perf=new NoticeBean();
		int rs=0;
		String path="NoticeMG.jsp";
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		perf.setId(id);
		perf.setTitle(request.getParameter("title").toString());
		perf.setIdent(request.getParameter("ident").toString());
		perf.setContent(request.getParameter("content").toString());
	
		NoticeDAOImpl ud=new NoticeDAOImpl();
		try {
			rs=ud._update(perf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0){
			response.sendRedirect(path);
		}else{response.sendRedirect(path+"?e="+rs);}
	}

}
