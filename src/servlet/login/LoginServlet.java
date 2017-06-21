package servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// tomcatĬ��ʹ��iso����iso��֧������
		/*
		 * ������Ҫ�������£�
		 * 1. ��tomcatʹ��utf-8���뷢�����ݣ�
		 * 2. �������������ʹ�õ���utf-8
		 * ����������һ���������ü��ɣ�����Content-Type�����Ӧͷ����
		 */
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		/*
		 * 1. ʹ��request��ȡ���������������username
		 * 2. �ж��Ƿ�Ϊitcast
		 *   3. ��itcast��ʹ��response����״̬��Ϊ404��ָ��������Ϣ��
		 *   4. ����itcast��ʹ��response������Ӧ��Ϊ��<h1>��¼�ɹ�</h1>
		 */
		// ʹ��request��ȡ�������
		String username = req.getParameter("username");
		if(username.equals("itcast")){
//			resp.setStatus(404);
			resp.sendError(404, "�û�������ȷ");
		}else {
			//������Ӧ��
			PrintWriter pw = resp.getWriter();//��ȡ�û���Ӧ�ַ����ݵ��������
			pw.print("<h1>��¼�ɹ�</h1>");
			pw.close();
		}
	}
}
