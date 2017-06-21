package servlet.life;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeDemo extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		this.log("init....");
		super.init();
	}
	
	@Override
	public void destroy() {
		this.log("destory....");
		super.destroy();
	}
	@PostConstruct
	public void method(){
		System.out.println("在init方法前执行,构造函数后执行!");
//		this.log("在init方法前执行,构造函数后执行!");不支持
	}
//	public @PostConstruct void method1(){只能存在一个注解方法
//		System.out.println("在init方法前执行,构造函数后执行!");
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.log("doGet....");
	}
	
	@PreDestroy
	public void function(){
		this.log("destory方法之后执行!");
	}
//	public @PreDestroy void function1(){
//		this.log("destory方法之后执行!!");
//	}
}
