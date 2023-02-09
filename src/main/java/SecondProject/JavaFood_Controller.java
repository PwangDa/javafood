package SecondProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/javafood")
public class JavaFood_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void java1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void java2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("fdsjkfj;lewjfdfjsadjdsfas");
		doGet(request, response);
	}
	protected void java3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("java3 메소드 실행됨."); //확인용
		
		//요청된 id값 받아오기
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		//id값을 playList에 넘겨주기
		RequestDispatcher dispatch = request.getRequestDispatcher("PlayList");
		dispatch.forward(request, response);
	}
	protected void java4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void java5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void java6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
