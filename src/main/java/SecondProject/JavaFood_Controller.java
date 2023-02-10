package SecondProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Chart.SongDAO;
import javafood_DTO.AlbumDTO;
import javafood_DTO.CommentDTO;
import javafood_DTO.login_DTO;

@WebServlet("/javafood/*")
public class JavaFood_Controller extends HttpServlet {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//필드 공통으로 쓰는거 아니면 필드선언 자제해주세요~
	private static final long serialVersionUID = 1L;
	SongDAO songDAO;
	JavaFood_Service service;
	login_DTO vo;
	Map map;
	List list;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//공통으로 사용하는 메소드 선언은 이곳에다가
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 실행");
		service = new JavaFood_Service();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//doget실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 실행");
		doHand(request, response);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//post실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 실행");
		doHand(request, response);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					//실행은 이곳에서만!
//접속방법 : http://localhost:8080/javafood_team/javafood?javafood=[1~6]
	protected void doHand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("javafood").equals("1")) {
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			System.out.println("java1로 들어왔습니다");
			
			String nextPage = "";
			String action = request.getPathInfo();
			String uri = request.getRequestURI();
			String command = request.getParameter("command");
			
			StringBuffer url = request.getRequestURL();
			System.out.println("action : "+action);
			System.out.println("command : "+command);
			
			System.out.println("uri : "+uri);
			System.out.println("url : "+url);
			List<AlbumDTO> listAlbum = new ArrayList<AlbumDTO>();
			List<CommentDTO> commentList = new ArrayList<CommentDTO>();
			
			if("artistinfo.do".equals(command)) {
//				List<AlbumDTO> listAlbum = service.Albumlist();
				listAlbum = service.Albumlist();
				commentList = service.listComment();
				request.setAttribute("listAlbum", listAlbum);
				request.setAttribute("commentList", commentList);
				nextPage = "/artistinfo.jsp";
				
			}else if("addcommnet.do".equals(command)) {
				System.out.println("addcomment 입장");
				String id_1 = request.getParameter("id");
				String cont_1 = request.getParameter("cont");
				
				CommentDTO dto = new CommentDTO();
				dto.setComment_id(id_1);
				dto.setComment_cont(cont_1);
				
				service.addcomment(dto);
				nextPage = "/javafood?javafood=1&command=artistinfo.do";
				
			}else if("delcommnet.do".equals(command)) {
				String id = request.getParameter("id");
				System.out.println("delete id : "+id);
				service.delcomment(id);
				nextPage = "/javafood?javafood=1&command=artistinfo.do";
			}else {
//				System.out.println("else action : "+action);
				listAlbum = service.Albumlist();
				commentList = service.listComment();
				request.setAttribute("listAlbum", listAlbum);
				request.setAttribute("commentList", commentList);
				nextPage = "/artistinfo.jsp";
			}
			
			System.out.println("nextPage : "+nextPage);
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		}
		if(request.getParameter("javafood").equals("2")) {
			java2(request,response);
		}
		if(request.getParameter("javafood").equals("3")) {
			java3(request,response);
		}
		if(request.getParameter("javafood").equals("4")) {
			System.out.println("4번진입");
			java4(request,response);
		}
		if(request.getParameter("javafood").equals("5")) {
			System.out.println("5번진입");
			java5(request,response);
		}
		if(request.getParameter("javafood").equals("6")) {
			java6(request,response);
		}
		if(request.getParameter("javafood").equals("m")) {
			javam(request,response);
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//다영 (빨간줄 뜨는거 아직 vo랑 메소드 안만들어서 에러뜨는거임! 정상임!)
	private void java1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("java1로 들어왔습니다");
		
		String nextPage = "";
		String action = request.getPathInfo();
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		System.out.println("action : "+action);
		System.out.println("uri : "+uri);
		System.out.println("url : "+url);
		List<AlbumDTO> listAlbum = new ArrayList<AlbumDTO>();
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		
		if("/artistinfo.do".equals(action)) {
//			List<AlbumDTO> listAlbum = service.Albumlist();
			listAlbum = service.Albumlist();
			commentList = service.listComment();
			request.setAttribute("listAlbum", listAlbum);
			request.setAttribute("commentList", commentList);
			nextPage = "/artistinfo.jsp";
			
		}else if("/addcommnet.do".equals(action)) {
			System.out.println("addcomment 입장");
			String id_1 = request.getParameter("id");
			String cont_1 = request.getParameter("cont");
			
			CommentDTO dto = new CommentDTO();
			dto.setComment_id(id_1);
			dto.setComment_cont(cont_1);
			
			service.addcomment(dto);
			nextPage = "/javafood/artistinfo.do";
			
		}else if("/delcommnet.do".equals(action)) {
			String id = request.getParameter("id");
			System.out.println("delete id : "+id);
			service.delcomment(id);
			nextPage = "/javafood/artistinfo.do";
		}else {
			System.out.println("action : "+action);
			listAlbum = service.Albumlist();
			commentList = service.listComment();
			request.setAttribute("listAlbum", listAlbum);
			request.setAttribute("commentList", commentList);
			nextPage = "/artistinfo.jsp";
		}
		
		System.out.println("nextPage : "+nextPage);
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//귀범
	private void java2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String nextPage = "";
		String action = request.getPathInfo();
		List<javafood_DTO.login_DTO> chart = new ArrayList<javafood_DTO.login_DTO>();

		RequestDispatcher dispatch = request.getRequestDispatcher("Chart/Song2.jsp");
		dispatch.forward(request, response);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//범주
	private void java3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("java3 메소드 실행됨."); //확인용
		
		String c_id = "testAdmin"; //플레이 리스트를 정상적으로 불러오는 지 확인 중.
		
//		HttpSession session = request.getSession();
//		String c_id = (String)session.getAttribute("id");
		
		//Service에서 플레이 리스트 불러오는 메서드 실행하기
		List playList = service.s_loadPL(c_id);
		
		//Service에서 받아온 플레이 리스트 목록을 jsp에 dispatch하기
		request.setAttribute("playList", playList);
		request.setAttribute("id", c_id);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("playList.jsp");
		dispatch.forward(request, response);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//경용 로그인
	private void java4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("4번 로그인 실행");
		if(request.getParameter("membership") !=null) {
			System.out.println("membership");
			map = service.javafood4(request.getParameter("membership"));
			request.setAttribute("membership", map.get("membership"));
		}
		if(request.getParameter("ID")!=null) {
			System.out.println("ID");
			map = service.javafood4_1(request.getParameter("ID"), request.getParameter("PW"));
			request.setAttribute("login", (List<login_DTO>) map.get("login"));
			request.setAttribute("log", (int) map.get("log"));
			request.getSession().setAttribute("login", request.getParameter("ID"));
		}
		if(request.getParameter("Id1")!=null) {
			vo = new login_DTO();
			vo.setId(request.getParameter("Id1"));
			vo.setPw(request.getParameter("PW1"));
			vo.setNic(request.getParameter("nic"));
			vo.setEmail(request.getParameter("mail"));
			vo.setPn(request.getParameter("pn1")+"-"+request.getParameter("pn2"));
			vo.setPhone(request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3"));
			request.setAttribute("good",service.javafood4_2(vo));
		}
		request.getRequestDispatcher("Lky/login.jsp").forward(request, response);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//경용 마이페이지
	private void java5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("5번 my페이지 실행");
		map = service.javafood5();
		request.setAttribute("list",map.get("list") );
		request.getRequestDispatcher("Lky/My_page.jsp").forward(request, response);
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//용준
	private void java6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String song = request.getParameter("genre");
		
//		list = service.javafood6(song);
		request.setAttribute("genre", "한글1");
//		request.setAttribute("genre", list);
//		request.setAttribute("song", song);
		RequestDispatcher dispatch = request.getRequestDispatcher("Genre/NewGenre.jsp");
		dispatch.forward(request, response);
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void javam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("메인 실행");
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
