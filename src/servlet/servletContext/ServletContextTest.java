package servlet.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletContextTest extends HttpServlet{
	@Override
	public void init() throws ServletException {
		ServletContext sc = this.getServletContext();
		System.out.println(sc.getServerInfo());
		super.init();
	}
}
