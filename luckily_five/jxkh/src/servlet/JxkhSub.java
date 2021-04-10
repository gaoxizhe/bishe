package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

public class JxkhSub extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public JxkhSub() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RawDataDAOImpl rawdao=new RawDataDAOImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String PerfID="",Score = "";
		String stuid=request.getParameter("stuid").toString();
		String teaid=request.getParameter("teaid").toString();
		int size=Integer.parseInt(request.getParameter("size").toString());
		ArrayList list=new ArrayList();
		list.add(0, stuid);
		list.add(1, teaid);
		list.add(2,PerfID);
		list.add(3,Score);
		for(int i=0;i<size;i++)
		{
			PerfID=request.getParameter("l"+i).toString();
			Score =request.getParameter("m"+i).toString();
			list.set(2,PerfID);
			list.set(3,Score);
			if(rawdao._insert(list)!=0){
				out.println("<script>window.location.href='index.jsp'</script>");
			}
			i++;
			out.println("<br>"+stuid+"%"+teaid+"%"+PerfID+"%"+Score+"<br>");
			for(Object tmp:list.toArray()){

				out.println(tmp.toString());

			}
		}

		out.flush();
		out.close();
	}

}
