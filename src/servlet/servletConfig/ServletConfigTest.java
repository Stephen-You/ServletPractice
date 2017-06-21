package servlet.servletConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest extends HttpServlet{
//	@Override
//	public void init() throws ServletException {
//		ServletConfig sc = this.getServletConfig();
//		System.out.println(sc.getServletName());
////		super.init();
//	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(config.getServletName());
		Enumeration<String> name = config.getInitParameterNames();
		while (name.hasMoreElements()) {
			String string = (String) name.nextElement();
			System.out.println(string);
		}
		super.init(config);
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		this.log("service....");
		super.service(arg0, arg1);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("get«Î«Û");
	}
}
