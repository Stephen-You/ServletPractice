package servlet.servletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author Yorick
 *2017��6��16��
 */
public class ServletContextGetAttribute extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������Ӧ��������
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		//��ȡServletContext
		ServletContext sc = this.getServletContext();
		//��ȡ����
		String message = (String) sc.getAttribute("message");
		//����һ�������������ֵ�context-wide ��ʼ�����������˲��������ھͷ���һ����ֵ��
		String str = sc.getInitParameter("Content-Type");
		System.out.println(message);
		System.out.println(str);
		//��ȡ��Ӧ�û����ַ����ݵ��������
		PrintWriter pw = resp.getWriter();
		pw.print(message);
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
