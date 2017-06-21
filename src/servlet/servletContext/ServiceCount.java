package servlet.servletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceCount extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ�����
		ServletContext sc = this.getServletContext();
		//��ȡһ��������Ϊ���ʴ���
		Integer count =  (Integer) sc.getAttribute("count");
		//�ж�count�Ƿ�Ϊnull,�����,�����ǵ�һ�η���count��ֵΪ1,��֮�ǵ�n�η���,count++,ʱ��count��������,����ǰ��
		if(count == null){
			count = 1;
		}else {
			count++;
		}
		sc.setAttribute("count", count);
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		resp.getWriter().println("<h>��ҳ�汻���ʴ���:"+count+"</h>");
	}
}
