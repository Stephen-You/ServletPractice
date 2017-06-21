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
		//获取资源流
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/安与骑兵-红山果.mp3");
		//获取一个输出流
		OutputStream os = new FileOutputStream("F://a.mp3");
		//把input中的流写入到OutputStream中
		IOUtils.copy(in, os);
	}
}
