package pro05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	
	public FirstServlet() {
		super();
		System.out.println("������ ȣ��");
	}

	public void init() throws ServletException{
		System.out.println("init �޼��� ȣ��");
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("doGet �޼��� ȣ��");
	}
	
	/*
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("doPost �޼��� ȣ��");
	}*/
	
	public void destory() {
		System.out.println("destroy �޼��� ȣ��");
	}
	
}
