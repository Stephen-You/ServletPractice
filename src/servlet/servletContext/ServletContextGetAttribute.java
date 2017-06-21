package servlet.servletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author Yorick
 *2017年6月16日
 */
public class ServletContextGetAttribute extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理响应乱码问题
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		//获取ServletContext
		ServletContext sc = this.getServletContext();
		//获取数据
		String message = (String) sc.getAttribute("message");
		//返回一个包含给定名字的context-wide 初始化参数，若此参数不存在就返回一个空值。
		String str = sc.getInitParameter("Content-Type");
		System.out.println(message);
		System.out.println(str);
		//获取响应用户的字符数据的输出流！
		PrintWriter pw = resp.getWriter();
		pw.print(message);
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
