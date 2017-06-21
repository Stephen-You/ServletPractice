package servlet.extend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	/*��get��ʽ����ҳ��ʱִ�иú���
	 * ִ��doGet()����֮ǰ����ִ��getLastModified()����,�����������ַ��ص���ֵ,���ϴη��ص���ֵ��ͬ,����Ϊ���ĵ�û�и���,��������û������ִ��doGet()
	 * ���getLastModified()����-1,����Ϊ��ʱ�̸��µ�,����ִ�иú���*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*void log(java.lang.String msg) 
          	��ָ������Ϣд��һ��servlet��־�ļ�����servlet������Ԥ�ȹ���  */
		this.log("ִ��doGet()....");
		this.execute(req, resp);
	}
	//��post��ʽ����ҳ��ʱ,ִ�и÷���,ִ��ǰ����ִ��getLastModified()
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.log("ִ��doPost()....");
		this.execute(req, resp);
	}
	/*���ظ�servlet���ɵ��ĵ��ĸ���ʱ��,��get���ʷ�ʽ��Ч,���ص�ʱ�������1970��1��1��08:00:00�ĺ�����,�����-1��Ĭ��Ϊ��ʵʱ����,Ĭ�Ϸ��ص���-1*/
	@Override
	protected long getLastModified(HttpServletRequest req) {
		this.log("getLastModified()....");
		return -1;
	}
	//ִ�з���
	private void execute(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//�����������Ӧ�ı��뷽ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//��ȡ���ʸ�servlet��URL
		String url = request.getRequestURI();
		//��ȡ���ʸ�servlet�ķ��ʷ�ʽ
		String method = request.getMethod();
		//�ͻ����ύ��ָ��������ֵ,����һ������������ַ���ֵ�����ò��������ڣ��򷵻�һ����ֵ��
		String value = request.getParameter("param");
		//������Ӧ���ĵ�����
		response.setContentType("text/html");
		//������Ӧ��
		PrintWriter pw = response.getWriter();//��ȡ�û���Ӧ�ַ����ݵ��������
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>Servlet����</title></head>");
		pw.println("<body>");
		pw.println("<form action = '"+url+"' method = 'get'>"
				+"<input type = 'text' name='param' value='param string'>"
				+"<input type='submit' value='��Get��ʽ��ѯҳ��'"+url+">"
				+"</form>");
		pw.println("<form action = '"+url+"' method = 'post'>"
				+"<input type = 'text' name='param' value='param string'>"
				+"<input type='submit' value='��Post��ʽ��ѯҳ��'"+url+">"
				+"</form>");
		//�ɿͻ����������ȡ���ĵ��ĸ���ʱ��
		pw.println("<script>document.write('��ҳ�����ķ���ʱ��:'+document.lastModified);</script>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
