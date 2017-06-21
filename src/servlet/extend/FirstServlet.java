package servlet.extend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	/*以get方式访问页面时执行该函数
	 * 执行doGet()函数之前会先执行getLastModified()方法,如果浏览器发现返回的数值,与上次返回的数值相同,则认为该文档没有更新,浏览器采用缓存而不执行doGet()
	 * 如果getLastModified()返回-1,则认为是时刻更新的,总是执行该函数*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*void log(java.lang.String msg) 
          	将指定的消息写到一个servlet日志文件，由servlet的名字预先挂起。  */
		this.log("执行doGet()....");
		this.execute(req, resp);
	}
	//以post方式访问页面时,执行该方法,执行前不会执行getLastModified()
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.log("执行doPost()....");
		this.execute(req, resp);
	}
	/*返回该servlet生成的文档的更新时间,对get访问方式有效,返回的时间相对于1970年1月1日08:00:00的毫秒数,如果是-1则默认为是实时更新,默认返回的是-1*/
	@Override
	protected long getLastModified(HttpServletRequest req) {
		this.log("getLastModified()....");
		return -1;
	}
	//执行方法
	private void execute(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//设置请求和响应的编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取访问该servlet的URL
		String url = request.getRequestURI();
		//获取访问该servlet的访问方式
		String method = request.getMethod();
		//客户端提交的指定参数的值,返回一个请求参数的字符串值。若该参数不存在，则返回一个空值。
		String value = request.getParameter("param");
		//设置响应的文档类型
		response.setContentType("text/html");
		//设置响应体
		PrintWriter pw = response.getWriter();//获取用户响应字符数据的输出流！
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>Servlet入门</title></head>");
		pw.println("<body>");
		pw.println("<form action = '"+url+"' method = 'get'>"
				+"<input type = 'text' name='param' value='param string'>"
				+"<input type='submit' value='以Get方式查询页面'"+url+">"
				+"</form>");
		pw.println("<form action = '"+url+"' method = 'post'>"
				+"<input type = 'text' name='param' value='param string'>"
				+"<input type='submit' value='以Post方式查询页面'"+url+">"
				+"</form>");
		//由客户端浏览器读取该文档的更新时间
		pw.println("<script>document.write('本页面最后的访问时间:'+document.lastModified);</script>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
