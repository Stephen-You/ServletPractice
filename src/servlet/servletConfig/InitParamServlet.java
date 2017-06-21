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

/*�����ôһ������:
 * ĳ��˾Ҫ����վ�ϰ䲼һ�������ļ�notice.html,���Ƕ�֪�����ļ�����webINF����ʱ,webINF�µ�
 * �ļ�ʱ�ܱ�����,��ô���ǿ���ͨ������ʵ�ַ���
 * ����Ҫ�Թ�˾ְԱ���е�¼��֤
 * ��Web.xml�г�ʼ������,��Ϊ�Ƚ�
 * 
 * */
public class InitParamServlet extends HttpServlet {
	//��дdoget����
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		//get�����,����ҳ���¼ҳ��
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>Ա����¼</title></head>");
		pw.println("<body>");
		//getRequestURL(),���ظ�������Ϣ��URL��HTTPЭ���һ�����Э�����Ƶ������ַ����Ĳ��� 
		pw.println("<form action='"+req.getRequestURL()+"'method='post'>");
		pw.println("�û���:<input type='text' id='username' name='username'></br>");
		pw.println("����:<input type='password' id='pass' name='pass'></br>");
		pw.println("<input type='submit' id='submit' value='��¼'>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
	//��дpost����,��Ϊ���ύ�Ĵ���
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ�û���������
		String username = req.getParameter("username");
		String password = req.getParameter("pass");
		//��ȡ�����ļ����������ڶԱ�У��Ĳ���
		ServletConfig sc = this.getServletConfig();
		Enumeration<String> en= sc.getInitParameterNames();
		while (en.hasMoreElements()) {
			String string = (String) en.nextElement();
			String pass = this.getServletConfig().getInitParameter(string);
			System.out.println(string+"  "+pass);
			if(username.equalsIgnoreCase(string)&&password.equals(pass)){
				//getRequestDispatcher(java.lang.String path) 
				//����һ����Ϊλ�ڸ���·������Դ��Դ�ķ�װ���� RequestDispatcher ���� 
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/notice.html");
				//�ڲ���ת
				rd.forward(req, resp);
			}
		}
		//����ص���¼����,ע����õ��Ǳ�ʵ����doGet����
		this.doGet(req, resp);
	}
}
