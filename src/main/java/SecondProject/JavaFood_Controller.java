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

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import Chart.SongDAO;
import My_Page.test;
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
			///다영 javafood=1 로 접속했을 때 
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			String nextPage = "";
			String uri = request.getRequestURI();
			String command = request.getParameter("command");
			
			System.out.println("command : "+command);		
			System.out.println("uri : "+uri);
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
				
			}else if("addReply.do".equals(command)) {
				String id = request.getParameter("id_2");
				String cont = request.getParameter("cont_2");
				String parentNO = request.getParameter("parentNO");
				
				System.out.println("id : "+ id);
				System.out.println("cont : "+ cont);
				System.out.println("parentNO : "+ parentNO);
				
				CommentDTO dto = new CommentDTO();
				dto.setComment_id(id);
				dto.setComment_cont(cont);
				dto.setParentNO(Integer.parseInt(parentNO));
				
				service.addcomment(dto);
				nextPage = "/javafood?javafood=1&command=artistinfo.do";
				
			}else if("delcommnet.do".equals(command)) {
				/*
				 * String id = request.getParameter("id");
				 * System.out.println("delete id : "+id); service.delcomment(id);
				 */
				int articleNO = Integer.parseInt(request.getParameter("articleNO"));
				System.out.println("articleNO : "+articleNO);
				List<Integer> articleNOList = service.removeComment(articleNO);
				
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
		if(request.getParameter("javafood").equals("3_2") )
		{
			String addList_title = request.getParameter("addList_title");
			String addList_explain = request.getParameter("addList_explain");
			String id = request.getParameter("id");
			
			java3_2(addList_title, addList_explain, id);
			
			//페이지 새로고침
			response.sendRedirect("javafood?javafood=3");
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
		//음악추가
//		if(request.getParameter("javafood").equals("add")) {
//			String url = "https://www.melon.com/chart/index.htm";
//			org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
//			Elements e1 = doc.getElementsByAttributeValue("class", "ellipsis rank02").select("a");
//			Elements e2 = doc.getElementsByAttributeValue("class", "ellipsis rank01").select("a");
//			Elements e3 = doc.getElementsByAttributeValue("class", "ellipsis rank03").select("a");
//			Elements e4 =  doc.getElementsByAttributeValue("class", "wrap").select("a").select("img");
//			System.out.println("da1");
//			JavaFood_DAO dao = new JavaFood_DAO();
//			System.out.println("da2");
//			for(int i=0; i<e4.size(); i++) {
//				System.out.println("가수 : "+(String)e1.get(i).text());
//				System.out.println("제목 : "+(String)e2.get(i).text());
//				System.out.println("앨범 : "+(String)e3.get(i).text());
//				System.out.println("이미지 주소 : "+(String)e4.get(i).attr("src"));
//				
//				String a = (String)e1.get(i).text().replace("'", "");
//				String b = (String)e2.get(i).text().replace("'", "");
//				String c = (String)e3.get(i).text().replace("'", "");
//				String d = (String)e4.get(i).attr("src");
//				
//				System.out.println("가수 : "+a);
//				System.out.println("제목 : "+b);
//				System.out.println("앨범 : "+c);
//				System.out.println("이미지 주소 : "+d);
//				dao.addsong1(b,c,a,d);
//			}
//		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//다영 (빨간줄 뜨는거 아직 vo랑 메소드 안만들어서 에러뜨는거임! 정상임!)
/*	private void java1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			int articleNO = Integer.parseInt(request.getParameter("articleNO"));
			System.out.println("articleNO : "+articleNO);
			List<Integer> articleNOList = service.removeComment(articleNO);
			
			nextPage = "/javafood/artistinfo.do";
		}else {
			listAlbum = service.Albumlist();
			request.setAttribute("listAlbum", listAlbum);
			nextPage = "/artistinfo.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		
	}*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//귀범
	private void java2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = "";
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		nextPage = "/javafood/listsong.do";
		String action = request.getPathInfo();
		
		try {
			
			if("/listsong.do".equals(action)) {
				
				
				
			}
			
		} catch (Exception e) {
			System.out.println("list불러오기 실패");
			e.printStackTrace();
		}
		

		RequestDispatcher dispatch = request.getRequestDispatcher("song.jsp");
		List<login_DTO> list_login = service.javafood2();
		request.setAttribute("list_login", list_login);
		nextPage = "/song.jsp";
		System.out.println("list_login size : " + list_login.size());
		
//		list_login = service.javafood2();
		
		
		dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
//		doGet(request, response);
		
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//범주 playList.jsp 접속+리스트 불러오기
	private void java3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JavaFood_Controller의 java3 메소드 실행됨."); //확인용
		

		//주소에 요청된 id값 받아오기
//		HttpSession session = request.getSession();
//		String c_id = (String)session.getAttribute("id");
		String c_id = "testAdmin"; //플레이 리스트를 정상적으로 불러오는 지 확인하는 아이디.
		
//		//주소에 요청된 명령어 받아오기
//		String doAddList = request.getParameter("doAddList");
//		String doDeleteList = request.getParameter("doDeleteList");
		
		
		//Service에서 플레이 리스트 불러오는 메서드 실행하기
		List playList = service.s_loadPL(c_id);
		
		//페이징 테스트
//		int pageNum = 1;
//		int countPerPage = 8;
//		
//		String temp_pageNum = request.getParameter("pageNum");
//		if(temp_pageNum != null)
//		{
//			pageNum = Integer.parseInt(temp_pageNum);
//		}
//		
//		Map map = service.pl_getPagingList(pageNum, countPerPage, c_id);
//		
//		request.setAttribute("articleList", map.get("list") );
//		request.setAttribute("totalCount", map.get("totalCount") );
//		request.setAttribute("pageNum", pageNum);
//		request.setAttribute("countPerPage", countPerPage);
//		
		//Service에서 받아온 플레이 리스트 목록을 jsp에 dispatch하기
		RequestDispatcher dispatch = request.getRequestDispatcher("PlayList");
		request.setAttribute("playList", playList);
		request.setAttribute("id", c_id);
//		request.setAttribute("doAddList", doAddList);
//		request.setAttribute("doDeleteList", doDeleteList);
		
		dispatch = request.getRequestDispatcher("playList.jsp");

		dispatch.forward(request, response);
	}
	
	//범주 리스트 추가하기
	private void java3_2(String title, String explain, String id)
	{
		service.s_doAddList(title, explain, id);
	}
	
	//범주 리스트 제거하기
	private void java3_3(String PL_ID, String id)
	{
		service.s_doDeleteList(PL_ID, id);
	}
	
	//범주 플레이 리스트 내용 보기
	private void java3_3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("JavaFood_Controller의 java3_3 메서드 실행됨.");
		
		//요청된 값 받아오기
//		HttpSession session = request.getSession();
//		String c_id = (String)session.getAttribute("id");
		String c_id = "testAdmin"; //플레이 리스트 내용을 정상적으로 불러오는 지 확인하는 아이디.
		int c_pl_id = Integer.parseInt(request.getParameter("pl_id") );
		
		//Service에서 플레이 리스트 내용을 가져올 메서드 실행하기.
		List list = service.s_loadPLC(c_pl_id, c_id);
		
		//Service에서 받아온 플레이 리스트 목록을 jsp에 dispatch하기
		
		
		
		//여기부터 내일하기
//		RequestDispatcher dispatch = request.getRequestDispatcher("PlayList");
//		request.setAttribute("playList", playList);
//		request.setAttribute("id", c_id);
	}
	
	//범주 플레이 리스트 안의 곡 제거하기
	private void java3_4(int PL_ID, int listNumber)
	{
		service.s_doDeleteSong(PL_ID, listNumber);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//경용 로그인
	private void java4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("4번 로그인 실행");

		service.javafood4(request.getParameter("membership"));
		if(map!=null) {
			System.out.println("map1"+map);
			System.out.println("map2"+map.get("membership"));
		}
		if(request.getParameter("membership") !=null) {
			System.out.println("membership");
			map = service.javafood4(request.getParameter("membership"));
		}
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
		if(request.getSession().getAttribute("login")!=null) {
			System.out.println("login : !=null");
			List<login_DTO> session_user = service.session_user((String) request.getSession().getAttribute("login"));
			System.out.println("session 아이디 : "+session_user.get(0).getId());
			System.out.println("session 닉네임: "+session_user.get(0).getNic());
			request.setAttribute("session_user", session_user.get(0));
		}
		if(request.getParameter("option")!=null) {
			System.out.println("option : "+request.getParameter("option"));
			if(request.getParameter("text")!=null) {
				System.out.println("text : "+request.getParameter("text"));
				List<login_DTO> list = service.javafood5_1(request.getParameter("option"), request.getParameter("text"));
				if(list!=null) {
					request.setAttribute("song", list);
					System.out.println("!=null lsit : "+list);
				}
			}
		}
		request.getRequestDispatcher("Lky/My_page.jsp").forward(request, response);
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//용준
	private void java6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String song = request.getParameter("genre");
		System.out.println("song  전: " + song);
		List genre_list = service.javafood6(song);
		request.setAttribute("genre", genre_list);
		request.setAttribute("song", song);
		System.out.println("song 후: " + song);
		RequestDispatcher dispatch = request.getRequestDispatcher("Genre/NewGenre.jsp");
		dispatch.forward(request, response);
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//태연
	private void javam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("메인 실행");
		
		
		RequestDispatcher dispatch = request.getRequestDispatcher("one/main.jsp");
		dispatch.forward(request, response);
		
			
		
		
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
}
