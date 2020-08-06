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
		System.out.println("생성자 호출");
	}

	public void init() throws ServletException{
		System.out.println("init 메서드 호출");
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("doGet 메서드 호출");
	}
	
	/*
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("doPost 메서드 호출");
	}*/
	
	public void destory() {
		System.out.println("destroy 메서드 호출");
	}
	
}
