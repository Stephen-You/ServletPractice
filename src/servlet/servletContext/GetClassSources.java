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
//这个与web环境无关
public class GetClassSources extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取类加载器
		ClassLoader cl = this.getClass().getClassLoader();
		//通过类加载器,加载类路径下的资源,注意Tomcat下是没有src的,但是src下放的所有非.java文件都会原封不动的放到classes下,所以当问价放在src下时,可以直接获取
		InputStream is = cl.getResourceAsStream("白冰.jpg");
		//当然我们通过全路径也是可以的
//		InputStream input = cl.getResourceAsStream("cn/itcast/web/servlet/白冰.jpg");
		OutputStream os = new FileOutputStream("F://bai.jpg");
		IOUtils.copy(is, os);
		// 使用ServletContext加载应用下的资源
		// 它相应的是应用路径,即项目文档下
//		InputStream input = this.getServletContext().getResourceAsStream("/WEB-INF/classes/白冰.jpg");
				
		// 使用Class来获取类路径下资源
		// 它相应的是当前Class所在目录.接servlet.servletContext
//		InputStream input = this.getClass().getResourceAsStream("白冰.jpg");
		// 使用Class来获取类路径下资源
//		// 它相应的是classes目录
//		InputStream input = this.getClass().getResourceAsStream("/白冰.jpg");
//		
//		FileOutputStream output = new FileOutputStream("c:/a.jpg");	
		// 使用Class来获取类路径下资源
		// 它相应的是classes目录
		is.close();
		os.close();
		
	}
}
