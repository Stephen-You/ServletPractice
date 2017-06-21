package servlet.servletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextSetAttribute extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ��ȡһ��ServletContext����,�洢����
		/*ServletContext,��һ��ȫ�ֵĴ�����Ϣ�Ŀռ䣬��������ʼ����ʹ��ڣ��������رգ�����ͷš�
		 * request��һ���û����ж����session��һ���û�һ������servletContext��
		 * �����û�����һ�������ԣ�Ϊ�˽�ʡ�ռ䣬���Ч�ʣ�ServletContext�У�
		 * Ҫ�ű���ġ���Ҫ�ġ������û���Ҫ������߳����ǰ�ȫ��һЩ��Ϣ��*/
		ServletContext sc = this.getServletContext();
		//�������
		sc.setAttribute("message", "��ServletContext�д������,����Servlet���Թ���,ǰ���Ƿ�����δ�ر�!");
		sc.setAttribute("message1", "ServletContext�����");
	}
}
