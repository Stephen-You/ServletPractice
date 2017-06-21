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
		System.out.println("��init����ǰִ��,���캯����ִ��!");
//		this.log("��init����ǰִ��,���캯����ִ��!");��֧��
	}
//	public @PostConstruct void method1(){ֻ�ܴ���һ��ע�ⷽ��
//		System.out.println("��init����ǰִ��,���캯����ִ��!");
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.log("doGet....");
	}
	
	@PreDestroy
	public void function(){
		this.log("destory����֮��ִ��!");
	}
//	public @PreDestroy void function1(){
//		this.log("destory����֮��ִ��!!");
//	}
}
