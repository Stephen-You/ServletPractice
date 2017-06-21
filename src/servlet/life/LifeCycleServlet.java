package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet{
	//���ø�˰���������,��ʶֵΪ0
	private static double bd;
	@Override
	public void init() throws ServletException {
		this.log("Servletʵ��������,����ִ�и÷���,��ÿ�η���������ִֻ��һ��ִֻ��һ��");
		ServletConfig sc = this.getServletConfig();
		String value = sc.getInitParameter("startPoint");
		this.log(value);
		//ת����BigDecimal����,��ʵ�ʿ����в�ʹ��double����,���ھ�������,����Ϊ�˲���������ʱʹ��double����
		bd = Double.parseDouble(value);
		
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		this.log("ÿ�����󶼻���ø÷���,��ҵ��Ĵ���Ҳ���ڸ÷�����!");
		super.service(arg0, arg1);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.log("���ڲ�ѯ����һ�����doGet����!");
		//������Ӧ�ַ��������Ӧ�ĵ�����
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		//��ȡ��������Ӧ���ַ������
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>��������˰������</title></head>");
//		pw.println("<link rel='stylesheet' type='text/css' href='../css/style.css'>");
		pw.println("<body>");
		pw.println("<div align='center' ></br><fieldset style='width:90%'><legend>��˰������</legend></br>");
		pw.println("<form method='post'>");
		pw.println("<div style='line'>");
		pw.println("<div class='leftdiv'>���Ĺ���Ϊ</div><div align='left' class='rightDiv'><input type='text' name='income'>��λ : Ԫ</div>");
		pw.println("</div></br>");
		pw.println("<div class='leftdiv'></div><div align='left' class='rightDiv'><input type='submit' value='�����˰' class='button'></div>");
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</form>");
//		pw.println("<body>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.log("����post����ִ�и÷���!");
		//������Ӧ���ַ����ͺ��ļ�����
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		//��ȡ��Ӧ�û����ַ����������
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title>��������˰������</title></head>");
		pw.println("<link rel='stylesheet' type='text/css' href='../css/style.css'>");
		pw.println("<body>");
		pw.println("<div align='center' ></br><fieldset style='width:90%'><legend>��˰������</legend></br>");
		//��ȡ������Ŀ
		String value = req.getParameter("income");
		double income = new Double(value);
		//����Ӧ��˰�Ĳ���
		double charge = income - bd;
		//��˰
		double tax = 0;
		if (charge<=0) {
			tax = 0;
		} else if(charge>=0&&charge<=5000){
			tax = charge*0.05;
		}else if (charge>5000&&charge<=20000) {
			tax = charge*0.1;
		}else if (charge>20000&&charge<=50000) {
			tax = charge*0.15;
		}else {
			tax = 50000;
		}
		pw.println("<div style='line'>");
		pw.println("<div class='leftDiv'>���Ĺ���Ϊ</div><div class='rightDiv'>"+income+" Ԫ</div>");
		pw.println("</div>");
		pw.println("<div style='line'>");
		pw.println("<div class='leftDiv'>��Ҫ�ɵ�˰Ϊ</div><div class='rightDiv'>"+tax+" Ԫ</div>");
		pw.println("</div></br>");
		pw.println("<input type='button' onclick='history.go(-1);' value='��˰���� ��˰�ɳ� �������' class='button'>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		
	}
	
	@Override
	public void destroy() {
		this.log("�������ر�ʱ���ø÷���!");
		this.log(String.valueOf(bd));
		//����˰��������������Ϊ0
		bd = 0;
		this.log(String.valueOf(bd));
	}
	
}
