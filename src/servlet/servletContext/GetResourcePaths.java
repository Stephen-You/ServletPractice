package servlet.servletContext;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetResourcePaths extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取指定目录下所有文件的路径
		Set<String> set = this.getServletContext().getResourcePaths("/WEB-INF");
		System.out.println(set);
	}
}
