package servlet.servletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceCount extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取域对象
		ServletContext sc = this.getServletContext();
		//获取一个属性作为访问次数
		Integer count =  (Integer) sc.getAttribute("count");
		//判断count是否为null,如果是,代表是第一次访问count赋值为1,反之是第n次访问,count++,时候将count放入域中,覆盖前面
		if(count == null){
			count = 1;
		}else {
			count++;
		}
		sc.setAttribute("count", count);
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		resp.getWriter().println("<h>该页面被访问次数:"+count+"</h>");
	}
}
