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
		//Servlet����ǰ�ᱻ����
		System.out.println("Servlet����ǰ����!");
	}

	@Override
	public ServletConfig getServletConfig() {
		// ����һ�� ServletConfig����,��������servlet�ĳ�ʼ������ʼ����
		System.out.println("����Servlet�������ڵķ���,�����Ǵ���һ��Servlet����!");
		return null;
	}

	@Override
	public String getServletInfo() {
		// �����й�servlet����Ϣ���������ߡ��汾����Ȩ��
		System.out.println("�����������ڷ���,�����õķ���!");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// ����Servletʵ��֮�����ϵ���,��servlet ����������ָ��һ��servlet���Ž������С�
		String name = arg0.getServletName();
		System.out.println("���ظ�servletʵ�������ơ�"+name);
		String str = arg0.getInitParameter("pName");
		System.out.println("����һ�������������ֵĳ�ʼ�����������˲��������ھͷ���һ����ֵ��"+str);
		String str1 = arg0.getInitParameter("pName2");
		System.out.println("����һ�������������ֵĳ�ʼ�����������˲��������ھͷ���һ����ֵ��"+str1);
		System.out.println("init�������ڷ�����װ��Servlet����ʱִ�еģ������ʼ��Servlet�������󡣿������÷�����������������������ͻ����״η���Servletʱװ��Servlet�������ж��ٿͻ�������Servlet���������ظ�ִ��init������");
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
		// ��servlet container����������servlet��Ӧһ������
		System.out.println("ÿ�δ�������ʱ��tomcat����������������������������");
		
	}

}
