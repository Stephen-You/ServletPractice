package servlet.servletContext;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletContextGetAttributeNames extends HttpServlet{
	@Override
	public void init() throws ServletException {
		ServletContext sc = this.getServletContext();
		Enumeration<String> en = sc.getAttributeNames();
		while (en.hasMoreElements()) {
			String string = (String) en.nextElement();
			System.out.println(string);
		}
		super.init();
	}
}
