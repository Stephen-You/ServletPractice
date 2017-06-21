package servlet.extend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletExtendsDemo extends HttpServlet{
	//重写doGet方法,被server调用 (通过service方法) 以允许一个 servlet处理一个 GET请求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("重写doGet方法");
	}
	
}
