package SecondProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Chart.SongDAO;
import My_Page.vod;

@WebServlet("/javafood")
public class JavaFood_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SongDAO songDAO;
	vod vo;

	public void init(ServletConfig config) throws ServletException {
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("javafood").equals(1)) {
			java1(request,response);
		}
		if(request.getParameter("javafood").equals(2)) {
			java2(request,response);
		}
		if(request.getParameter("javafood").equals(3)) {
			java3(request,response);
		}
		if(request.getParameter("javafood").equals(4)) {
			java4(request,response);
		}
		if(request.getParameter("javafood").equals(5)) {
			java5(request,response);
		}
		if(request.getParameter("javafood").equals(6)) {
			java6(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("javafood").equals(1)) {
			java1(request,response);
		}
		if(request.getParameter("javafood").equals(2)) {
			java2(request,response);
		}
		if(request.getParameter("javafood").equals(3)) {
			java3(request,response);
		}
		if(request.getParameter("javafood").equals(4)) {
			java4(request,response);
		}
		if(request.getParameter("javafood").equals(5)) {
			java5(request,response);
		}
		if(request.getParameter("javafood").equals(6)) {
			java6(request,response);
		}
	}
	
	protected void java1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void java2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String songchart = request.getParameter("songchart");
		request.setAttribute("songchart", songchart);

		RequestDispatcher dispatch = request.getRequestDispatcher("Song.jsp");
		dispatch.forward(request, response);
	}
	protected void java3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("java3 메소드 실행됨."); //확인용
		
		//요청된 id값 받아오기
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		//id값을 playList에 넘겨주기
		RequestDispatcher dispatch = request.getRequestDispatcher("PlayList");
		dispatch.forward(request, response);
		doGet(request, response);
	}
	protected void java4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void java5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void java6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String song = request.getParameter("genre");
		request.setAttribute("genre", song);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("NewGenre.jsp");
		dispatch.forward(request, response);
		doGet(request, response);
		
	}

}
