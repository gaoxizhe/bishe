package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import dao.*;

public class EditPerfSubServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EditPerfSubServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PerformanceBean perf=new PerformanceBean();
		int rs=0;
		String path="jxkhMG.jsp";
		request.setCharacterEncoding("UTF-8");
		perf.setPerfID(Integer.parseInt(request.getParameter("id")));
		perf.setPerfName(request.getParameter("perfName").toString());
		perf.setPerfClass(request.getParameter("perfClass").toString());
	
		PerfDAOImpl ud=new PerfDAOImpl();
		try {
			rs=ud.EditPerf(perf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0){
			response.sendRedirect(path+"?e="+rs);
		}else{response.sendRedirect(path+"?e="+rs);}
	}

}
