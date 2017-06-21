package servlet.Interface;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletInterface implements Servlet{

	@Override
	public void destroy() {
		//Servlet销毁前会被调用
		System.out.println("Servlet销毁前调用!");
	}

	@Override
	public ServletConfig getServletConfig() {
		// 返回一个 ServletConfig对象,它包含了servlet的初始化和起始参数
		System.out.println("不是Servlet生命周期的方法,作用是创建一个Servlet容器!");
		return null;
	}

	@Override
	public String getServletInfo() {
		// 返回有关servlet的信息，例如作者、版本、版权。
		System.out.println("不是生命周期方法,不常用的方法!");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// 创建Servlet实例之后，马上调用,被servlet 容器调用以指明一个servlet被放进服务中。
		String name = arg0.getServletName();
		System.out.println("返回该servlet实例的名称。"+name);
		String str = arg0.getInitParameter("pName");
		System.out.println("返回一个包含给定名字的初始化参数，若此参数不存在就返回一个空值。"+str);
		String str1 = arg0.getInitParameter("pName2");
		System.out.println("返回一个包含给定名字的初始化参数，若此参数不存在就返回一个空值。"+str1);
		System.out.println("init方法是在服务器装入Servlet容器时执行的，负责初始化Servlet容器对象。可以配置服务器，以在启动服务器或客户机首次访问Servlet时装入Servlet。无论有多少客户机访问Servlet，都不会重复执行init（）。");
		Enumeration<String> en = arg0.getInitParameterNames();
		while (en.hasMoreElements()) {
			String string = (String) en.nextElement();
			System.out.println(string);
		}
		String message = (String) arg0.getServletContext().getAttribute("message");
		System.out.println(message);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// 被servlet container调用以允许servlet响应一个请求。
		System.out.println("每次处理请求时，tomcat都会调用这个方法。（请求处理方法）");
		
	}

}
