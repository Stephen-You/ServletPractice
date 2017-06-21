package servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// tomcat默认使用iso，而iso不支持中文
		/*
		 * 我们需要做两件事：
		 * 1. 让tomcat使用utf-8编码发送数据！
		 * 2. 告诉浏览器我们使用的是utf-8
		 * 以上两件事一个方法调用即可，设置Content-Type这个响应头即可
		 */
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		/*
		 * 1. 使用request获取请求参数，参数名username
		 * 2. 判断是否为itcast
		 *   3. 是itcast：使用response设置状态码为404，指定错误信息；
		 *   4. 不是itcast：使用response设置响应体为：<h1>登录成功</h1>
		 */
		// 使用request获取请求参数
		String username = req.getParameter("username");
		if(username.equals("itcast")){
//			resp.setStatus(404);
			resp.sendError(404, "用户名不正确");
		}else {
			//设置响应体
			PrintWriter pw = resp.getWriter();//获取用户响应字符数据的输出流！
			pw.print("<h1>登录成功</h1>");
			pw.close();
		}
	}
}
