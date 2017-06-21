package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet{
	//设置个税起征点参数,初识值为0
	private static double bd;
	@Override
	public void init() throws ServletException {
		this.log("Servlet实例创建后,立即执行该方法,且每次服务器启动只执行一次只执行一次");
		ServletConfig sc = this.getServletConfig();
		String value = sc.getInitParameter("startPoint");
		this.log(value);
		//转换成BigDecimal类型,在实际开发中不使用double类型,存在精度问题,这里为了操作简单先暂时使用double类型
		bd = Double.parseDouble(value);
		
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		this.log("每次请求都会调用该方法,对业务的处理也放在该方法中!");
		super.service(arg0, arg1);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.log("对于查询操作一般采用doGet方法!");
		//设置响应字符编码和响应文档类型
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		//获取对请求响应的字符输出流
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>个人所得税计算器</title></head>");
//		pw.println("<link rel='stylesheet' type='text/css' href='../css/style.css'>");
		pw.println("<body>");
		pw.println("<div align='center' ></br><fieldset style='width:90%'><legend>个税计算器</legend></br>");
		pw.println("<form method='post'>");
		pw.println("<div style='line'>");
		pw.println("<div class='leftdiv'>您的工资为</div><div align='left' class='rightDiv'><input type='text' name='income'>单位 : 元</div>");
		pw.println("</div></br>");
		pw.println("<div class='leftdiv'></div><div align='left' class='rightDiv'><input type='submit' value='计算个税' class='button'></div>");
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</form>");
//		pw.println("<body>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.log("对于post请求执行该方法!");
		//设置响应的字符类型和文件类型
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		//获取响应用户的字符数据输出流
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>个人所得税计算器</title></head>");
		pw.println("<link rel='stylesheet' type='text/css' href='../css/style.css'>");
		pw.println("<body>");
		pw.println("<div align='center' ></br><fieldset style='width:90%'><legend>个税计算器</legend></br>");
		//获取工资数目
		String value = req.getParameter("income");
		double income = new Double(value);
		//计算应纳税的部分
		double charge = income - bd;
		//交税
		double tax = 0;
		if (charge<=0) {
			tax = 0;
		} else if(charge>=0&&charge<=5000){
			tax = charge*0.05;
		}else if (charge>5000&&charge<=20000) {
			tax = charge*0.1;
		}else if (charge>20000&&charge<=50000) {
			tax = charge*0.15;
		}else {
			tax = 50000;
		}
		pw.println("<div style='line'>");
		pw.println("<div class='leftDiv'>您的工资为</div><div class='rightDiv'>"+income+" 元</div>");
		pw.println("</div>");
		pw.println("<div style='line'>");
		pw.println("<div class='leftDiv'>你要纳的税为</div><div class='rightDiv'>"+tax+" 元</div>");
		pw.println("</div></br>");
		pw.println("<input type='button' onclick='history.go(-1);' value='纳税光荣 逃税可耻 点击返回' class='button'>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		
	}
	
	@Override
	public void destroy() {
		this.log("服务器关闭时调用该方法!");
		this.log(String.valueOf(bd));
		//将个税起征点重新设置为0
		bd = 0;
		this.log(String.valueOf(bd));
	}
	
}
