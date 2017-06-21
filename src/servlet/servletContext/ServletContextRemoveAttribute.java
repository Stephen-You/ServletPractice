package servlet.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletContextRemoveAttribute extends HttpServlet{
	@Override
	public void init() throws ServletException {
		ServletContext sc = this.getServletContext();
		sc.removeAttribute("message");
		System.out.println(sc.getAttribute("message"));
		super.init();
	}
}
