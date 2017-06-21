package servlet.servletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextSetAttribute extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取一个ServletContext对象,存储数据
		/*ServletContext,是一个全局的储存信息的空间，服务器开始，其就存在，服务器关闭，其才释放。
		 * request，一个用户可有多个；session，一个用户一个；而servletContext，
		 * 所有用户共用一个。所以，为了节省空间，提高效率，ServletContext中，
		 * 要放必须的、重要的、所有用户需要共享的线程又是安全的一些信息。*/
		ServletContext sc = this.getServletContext();
		//存放数据
		sc.setAttribute("message", "向ServletContext中存放数据,整个Servlet可以共享,前提是服务器未关闭!");
		sc.setAttribute("message1", "ServletContext域对象");
	}
}
