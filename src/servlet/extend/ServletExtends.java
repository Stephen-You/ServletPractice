package servlet.extend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class ServletExtends extends HttpServlet{
	
	//��дservice����
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("��дservice����,�˷�����ÿ�δ�������ʱ����");
	}
}
