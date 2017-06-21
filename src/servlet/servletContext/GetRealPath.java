package servlet.servletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetRealPath extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取真实路径,把真实路径返回到页面
		ServletContext sc = this.getServletContext();
		String path = sc.getRealPath("/WEB_INF/notice.html");
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>员工登录</title></head>");
		pw.println("<body>");
		pw.println("<p>"+path+"</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
