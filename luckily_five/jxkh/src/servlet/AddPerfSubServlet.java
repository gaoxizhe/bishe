package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PerformanceBean;
import dao.PerfDAOImpl;

public class AddPerfSubServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddPerfSubServlet() {
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
		PerformanceBean perf=new PerformanceBean();
		int rs=0;
		String path="jxkhMG.jsp";
		request.setCharacterEncoding("UTF-8");
		
		perf.setPerfName(request.getParameter("perfName").toString());
		perf.setPerfClass(request.getParameter("perfClass").toString());
	
		PerfDAOImpl ud=new PerfDAOImpl();
		try {
			rs=ud.InsertPerf(perf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0){
			response.sendRedirect(path+"?e="+rs);
		}else{
			response.sendRedirect(path+"?e="+rs);
		}
	}

}
