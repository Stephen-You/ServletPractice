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

public class GetResourceAsStream extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ��Դ��
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/�������-��ɽ��.mp3");
		//��ȡһ�������
		OutputStream os = new FileOutputStream("F://a.mp3");
		//��input�е���д�뵽OutputStream��
		IOUtils.copy(in, os);
	}
}
