package servlet.servletConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*解决这么一个问题:
 * 某公司要在网站上颁布一个机密文件notice.html,我们都知道当文件放在webINF下面时,webINF下的
 * 文件时受保护的,那么我们可以通过程序实现访问
 * 我们要对公司职员进行登录验证
 * 在Web.xml中初始化参数,作为比较
 * 
 * */
public class InitParamServlet extends HttpServlet {
	//重写doget方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		//get请求后,返回页面登录页面
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>员工登录</title></head>");
		pw.println("<body>");
		//getRequestURL(),返回该请求消息的URL中HTTP协议第一行里从协议名称到请求字符串的部分 
		pw.println("<form action='"+req.getRequestURL()+"'method='post'>");
		pw.println("用户名:<input type='text' id='username' name='username'></br>");
		pw.println("密码:<input type='password' id='pass' name='pass'></br>");
		pw.println("<input type='submit' id='submit' value='登录'>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
	//重写post方法,作为表单提交的处理
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取用户名和密码
		String username = req.getParameter("username");
		String password = req.getParameter("pass");
		//获取配置文件中我们用于对比校验的参数
		ServletConfig sc = this.getServletConfig();
		Enumeration<String> en= sc.getInitParameterNames();
		while (en.hasMoreElements()) {
			String string = (String) en.nextElement();
			String pass = this.getServletConfig().getInitParameter(string);
			System.out.println(string+"  "+pass);
			if(username.equalsIgnoreCase(string)&&password.equals(pass)){
				//getRequestDispatcher(java.lang.String path) 
				//返回一个作为位于给定路径的资源资源的封装器的 RequestDispatcher 对象。 
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/notice.html");
				//内部跳转
				rd.forward(req, resp);
			}
		}
		//否则回到登录颜面,注意调用的是本实例的doGet方法
		this.doGet(req, resp);
	}
}
