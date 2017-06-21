package servlet.servletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextParamServlet extends HttpServlet {
	//重写doGet和dopost方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>获取上下文</title></head>");
		pw.println("<body>");
		//获取上下文
		ServletContext sc = this.getServletContext();
		String value1 = sc.getInitParameter("zhangsan");
		String value2 = sc.getInitParameter("lisi");
		pw.println("<p>"+value1+"</p>");
		pw.println("<p>"+value2+"</p>");		
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
