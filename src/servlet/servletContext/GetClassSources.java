package servlet.servletContext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
//�����web�����޹�
public class GetClassSources extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ�������
		ClassLoader cl = this.getClass().getClassLoader();
		//ͨ���������,������·���µ���Դ,ע��Tomcat����û��src��,����src�·ŵ����з�.java�ļ�����ԭ�ⲻ���ķŵ�classes��,���Ե��ʼ۷���src��ʱ,����ֱ�ӻ�ȡ
		InputStream is = cl.getResourceAsStream("�ױ�.jpg");
		//��Ȼ����ͨ��ȫ·��Ҳ�ǿ��Ե�
//		InputStream input = cl.getResourceAsStream("cn/itcast/web/servlet/�ױ�.jpg");
		OutputStream os = new FileOutputStream("F://bai.jpg");
		IOUtils.copy(is, os);
		// ʹ��ServletContext����Ӧ���µ���Դ
		// ����Ӧ����Ӧ��·��,����Ŀ�ĵ���
//		InputStream input = this.getServletContext().getResourceAsStream("/WEB-INF/classes/�ױ�.jpg");
				
		// ʹ��Class����ȡ��·������Դ
		// ����Ӧ���ǵ�ǰClass����Ŀ¼.��servlet.servletContext
//		InputStream input = this.getClass().getResourceAsStream("�ױ�.jpg");
		// ʹ��Class����ȡ��·������Դ
//		// ����Ӧ����classesĿ¼
//		InputStream input = this.getClass().getResourceAsStream("/�ױ�.jpg");
//		
//		FileOutputStream output = new FileOutputStream("c:/a.jpg");	
		// ʹ��Class����ȡ��·������Դ
		// ����Ӧ����classesĿ¼
		is.close();
		os.close();
		
	}
}
