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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Chart.SongDAO;
import javafood_DTO.AlbumDTO;
import javafood_DTO.CommentDTO;
import javafood_DTO.login_DTO;
import javafood_DTO.song_DTO;

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
		try {
			doHand(request, response);
		} catch (Exception e) {
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//post실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 실행");
		try {
			doHand(request, response);
		} catch (Exception e) {
			System.out.println("주소를 잘못입력하셨습니다.");
			System.out.println("javafood?javafood=m 을 입력해 주세요");
		} 
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					//실행은 이곳에서만!
//접속방법 : http://localhost:8080/javafood_team/javafood?javafood=[1~6]
	protected void doHand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("javafood").equals("1")) {
			///다영 javafood=1 로 접속했을 때 
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			JavaFood_DAO dao = new JavaFood_DAO();
			String sess = (String)request.getSession().getAttribute("login");
			System.out.println("세션id값 >> "+sess);

			List<login_DTO> login_dto = dao.session(sess);
			
			String nextPage = "";
			String command = request.getParameter("command");
			String artid = request.getParameter("artid");
			String alname = request.getParameter("alname");
			
			System.out.println("command : "+command);		
			System.out.println("artid : "+artid);
			
			List<AlbumDTO> listAlbum = new ArrayList<AlbumDTO>();
			List<AlbumDTO> listMusic = new ArrayList<AlbumDTO>();
			List<CommentDTO> commentList = new ArrayList<CommentDTO>();
			commentList = service.listComment(artid);
			listAlbum = service.Albumlist_artid(artid);

//			listMusic = service.Albumlist(alname);

			nextPage = "/artistinfo.jsp";
			
			for(int i=0; i<listAlbum.size(); i++) {
				System.out.println(listAlbum.get(i).getMusic_name());
			}
			if(alname != null) {
				listMusic = service.Albumlist(alname);
				nextPage = "/albumTest.jsp";
			}

			request.setAttribute("login_dto", login_dto);
			request.setAttribute("listAlbum", listAlbum);
			request.setAttribute("listMusic", listMusic);
			request.setAttribute("commentList", commentList);
			/*if("artistinfo.do".equals(command)) {
//				List<AlbumDTO> listAlbum = service.Albumlist();
				listAlbum = service.Albumlist();
//				commentList = service.listComment();
				request.setAttribute("listAlbum", listAlbum);
				request.setAttribute("commentList", commentList);
				nextPage = "/artistinfo.jsp";
				
			}else if("addcommnet.do".equals(command)) {
				System.out.println("addcomment 입장");
				String id_1 = request.getParameter("id");
				String cont_1 = request.getParameter("cont");
				String num = request.getParameter("num");
				
				System.out.println("댓글등록 num"+num);
				
				CommentDTO dto = new CommentDTO();
				dto.setComment_id(id_1);
				dto.setComment_cont(cont_1);
				dto.setArtistlist_num(Integer.parseInt(num));
				
				service.addcomment(dto);
//				nextPage = "/javafood?javafood=1&command=artistinfo.do";
				nextPage = "/javafood?javafood=ArtistList&num="+num;
				
			}else if("addReply.do".equals(command)) {
				String id = request.getParameter("id_2");
				String cont = request.getParameter("cont_2");
				String parentNO = request.getParameter("parentNO");
				String articleNO = request.getParameter("command_articleNO");
				
				System.out.println("id : "+ id);
				System.out.println("cont : "+ cont);
				System.out.println("parentNO : "+ parentNO);
				System.out.println("articleNO : "+ articleNO);
				
				CommentDTO dto = new CommentDTO();
				dto.setComment_id(id);
				dto.setComment_cont(cont);
				dto.setParentNO(Integer.parseInt(articleNO));
				
				service.addcomment(dto);
				nextPage = "/javafood?javafood=1&command=artistinfo.do";
				
			}else if("delcommnet.do".equals(command)) {
				
				  String id = request.getParameter("id");
				  System.out.println("delete id : "+id); service.delcomment(id);
				 
				int articleNO = Integer.parseInt(request.getParameter("articleNO"));
				System.out.println("articleNO : "+articleNO);
				List<Integer> articleNOList = service.removeComment(articleNO);
				
				nextPage = "/javafood?javafood=1&command=artistinfo.do";
			}else {
//				System.out.println("else action : "+action);
				listAlbum = service.Albumlist();
//				commentList = service.listComment();
				request.setAttribute("listAlbum", listAlbum);
				request.setAttribute("commentList", commentList);
				nextPage = "/artistinfo.jsp";
			}*/
			
			System.out.println("nextPage : "+nextPage);
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
		}//if문 ("1")종료
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
		}//if문 ("3_2")종료
		if(request.getParameter("javafood").equals("3_3") )
		{
			//주소에서 요청된 pl_id값을 받아오기
			int pl_id = Integer.parseInt(request.getParameter("PL_ID") );
			
			java3_3(request, response, pl_id);
		}//if문 ("3_3")종료
		if(request.getParameter("javafood").equals("3_4") )
		{
			//주소로 요청한 값들 받기.
			int pl_id = Integer.parseInt(request.getParameter("PL_ID") );
			int listNumber = Integer.parseInt(request.getParameter("listNumber") );
			
			//삭제 실행
			java3_4(pl_id, listNumber);
			
			//페이지 새로고침
			response.sendRedirect("javafood?javafood=3_3&PL_ID=" + pl_id);
		}//if문 ("3_4")종료
		if(request.getParameter("javafood").equals("3_5") )
		{
			//주소창에서 요청된 pl_id값을 받아오기
			int pl_id = Integer.parseInt(request.getParameter("pl_id") );
			String id = request.getParameter("id");
			
			//제거 실행
			java3_5(pl_id, id);
			
			//페이지 새로고침
			response.sendRedirect("javafood?javafood=3");
		}//if문 ("3_5")종료
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

		}//if문 ("m")종료
		if(request.getParameter("javafood").equals("7")) {
			java7(request,response);
		}
		if(request.getParameter("javafood").equals("3_6") )
		{
//			List<login_DTO> session_user = service.session_user( (String) request.getSession().getAttribute("login") );
			String c_id = (String)request.getSession().getAttribute("login");
			
			List playList = java3_6(c_id);
			request.setAttribute("playList", playList);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("playListAdd.jsp");
			dispatch.forward(request, response);
		}
		if(request.getParameter("javafood").equals("3_7") )
		{
			int pl_id = Integer.parseInt(request.getParameter("pl_id") );
			String addWhere = request.getParameter("addWhere");
			
			//추가할 곡이 한 곡일 때
			if(!request.getParameter("songNumber").equals("") )
			{
				int songNumber = Integer.parseInt(request.getParameter("songNumber") );
				
				java3_7(pl_id, songNumber, addWhere);
			}
			
			//추가할 곡이 여러 곡일 때
			if(!request.getParameter("songNumbers").equals("") )
			{
				String temp_songNumbers = request.getParameter("songNumbers");
				String[] temp_splited = temp_songNumbers.split(",");
				int[] songNumbers = new int[temp_splited.length];
				for(int i = 0; i < temp_splited.length; i++)
				{
					songNumbers[i] = Integer.parseInt(temp_splited[i]);
				}
				
				java3_7_1(pl_id, songNumbers, addWhere);
			}
			
//			System.out.println("addwhere : "+addWhere);
		
			RequestDispatcher dispatch = request.getRequestDispatcher("javafood?javafood=3_3&PL_ID="+pl_id);
			dispatch.forward(request, response);
		}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//아티스트 페이지로 넘어갈 때	
	if(request.getParameter("javafood").equals("ArtistList")) {
		//localhost:8080/javafood_team/javafood?javafood=ArtistList&num=1
		String num = request.getParameter("num"); //1이면 1테이블값들어감
		//int k = 1;

			JavaFood_DAO dao = new JavaFood_DAO();
			String sess = (String)request.getSession().getAttribute("login");
			System.out.println("세션id값 >> "+sess);
			List<login_DTO> login_dto = dao.session(sess);
			System.out.println("현재 순서 >>>>> "+num);
			List<AlbumDTO> album_list =  dao.album_add(num);
			String artist_num = album_list.get(0).getArtist_add();
			String detail="https://www.melon.com/artist/detail.htm?artistId="+artist_num;
			String song= "https://www.melon.com/artist/album.htm?artistId="+artist_num;
			
			org.jsoup.nodes.Document doc_detail = Jsoup.connect(detail).get();	
			org.jsoup.nodes.Document doc_song = Jsoup.connect(song).get();	
			
			String artistIMG = doc_detail.getElementsByAttributeValue("id", "artistImgArea").select("img").attr("src");
	//		Element artistINFO = doc_detail.getElementsByAttributeValue("id", "d_artist_intro").select("div").first();
	//		String artistName = doc_detail.getElementsByAttributeValue("class", "title_atist").attr("text");
			Elements artistALBUM = doc_song.getElementsByAttributeValue("class", "wrap_album04").select("img");
			Elements artistSONG = doc_song.getElementById("pageList").getElementsByAttributeValue("class", "atist_info").select("dt").select("a");
			Elements albumTitle = doc_song.getElementById("pageList").getElementsByAttributeValue("class", "songname12");
			Elements albumURL = doc_song.getElementsByAttributeValue("class", "atist_info").select("dt").select("a");
			
			//System.out.println("albumURL >>>> \n"+albumURL);
			
			//아티스트 이름
			Elements a = doc_detail.getElementsByClass("title_atist");
			String b = a.get(0).text();
	//		System.out.println(b);
			//아티스트 정보
			Elements aristi_info = doc_detail.getElementsByClass("atist_insdc");
			String artist_i = "";		
			if(aristi_info.size() == 1) {
				//num3 /하이포가 1임
				artist_i = aristi_info.get(0).text();
	//			System.out.println("aristi_info : "+aristi_info.get(0).text()); //num3은 인덱스가 한개여서 0으로 해야함
			}else if(aristi_info.size() >= 2) {
				artist_i = aristi_info.get(1).text();
	//			System.out.println("aristi_info : "+aristi_info.get(1).text());
			}
			
	//		String[] c = b.split("명");
	//		int target_num = b.indexOf(" "); //아티스트명 '명'에서 띄어쓰기까지만 나오게
			String artist_n = b.substring(5);
			System.out.println("아티스트 이미지 링크는 >>>>>"+artistIMG);
			System.out.println("아티스트 이름은 >>>>> "+artist_n);
			System.out.println("아티스트 정보는 >>>>> "+artist_i);
			System.out.println("------------------");
			
			//각 앨범 이름
			List<String> album_song = new ArrayList<String>();
			//앨범 이미지링크 리스트배열
			List<String> src = new ArrayList<String>();
			String[] artist_song = null;
			
			
				System.out.println("테이블에 넣어봅시다");
//				AlbumDTO dto = new AlbumDTO();
//				dto.setArtistname(artist_n);
//				dto.setArtist_img(artistIMG);
//				dto.setArtist_info(artist_i);
//				
//				dao.insertArtist(dto);
				

				
				//num으로 db에서 가져온 값이 있어서 다시 새 빈 리스트 선언해서 덮어주기
				album_list =  new ArrayList();
//				System.out.println("songnumber : "+num);
				for(int i=0; i<artistSONG.size(); i++) {
					AlbumDTO dto = new AlbumDTO();
					dto.setArtistname(artist_n);
					dto.setArtist_info(artist_i);
					dto.setArtist_img(artistIMG);
					dto.setSongnumber(num);
					String music_name = albumTitle.get(i).text();
//					System.out.println("music_name"+(i)+" : "+music_name);
					dto.setMusic_name(music_name);
					
					String artistsong = artistSONG.get(i).toString();
					int tempNum = artistsong.indexOf(">");
					artistsong = artistsong.substring(tempNum+1);
					artist_song= artistsong.split("<");
//					System.out.println("album_title"+(i)+" : "+artist_song[0]);
					dto.setAlbum_name(artist_song[0]);
//					album_song.add(artist_song[0]);
					
					
					String album_url = artistSONG.get(i).toString();
					String[] aart = album_url.split("'");
					System.out.println("각 앨범 숫자 : "+aart[1]);
					dto.setAlbum_add(aart[1]);
					
					String adg = artistALBUM.get(i).attr("src");
//					System.out.println((i+1)+"의앨범 이미지링크 : "+adg); 	
					dto.setAlbum_cover(adg);
//					src.add(adg);
					album_list.add(dto);
				}
				
				
				
				//댓글 추가 했을 때
				String command = request.getParameter("command");
				System.out.println("command를 받다 : "+command);
				List<CommentDTO> commentList = new ArrayList<CommentDTO>();
				List<AlbumDTO> artist =  dao.album_add(num);
				commentList = service.listComment(artist.get(0).getArtistname());
				System.out.println("artist : "+artist.get(0).getArtistname());
				if("addcommnet.do".equals(command) && command != null) {
					String id_1 = request.getParameter("id");	//아이디
					String cont_1 = request.getParameter("cont"); //댓글단 내용
					String num_1 = request.getParameter("songnum"); //댓글 단 아티스트페이지 값
					String myimg = request.getParameter("myimg"); //설정한 프로필 사진
					
					System.out.println("댓글등록 num : "+num_1);
					System.out.println("아이디아이디: "+id_1);
					System.out.println("마이 이미지>>>> : "+myimg);
					
					
					CommentDTO dto = new CommentDTO();
					dto.setComment_id(id_1);
					dto.setComment_cont(cont_1);
					dto.setArtistlist_num(Integer.parseInt(num));
					dto.setArtistname(artist.get(0).getArtistname());
					dto.setMyimg(myimg); //댓글 단 유저들의 프로필이미지도 보이게 세팅
					dto.setId(sess); //아이디 값도 세팅해야 누가 달았는 지 표시 가능
					
					service.addcomment(dto);
					//댓글의 댓글 달 때
				}else if("addReply.do".equals(command) && command != null) {
					String id = request.getParameter("id_2");
					String cont = request.getParameter("cont_2");
					String articleNO = request.getParameter("command_articleNO"); //답글단 그 댓글의 고유숫자를 가져옴
					String myimg = request.getParameter("command_myimg");
					
					System.out.println("id : "+ id);
					System.out.println("cont : "+ cont);
					System.out.println("대댓글 num : "+ num);
					System.out.println("articleNO : "+ articleNO);
					System.out.println("이이미미지 : "+ myimg);
					
					CommentDTO dto = new CommentDTO();
					dto.setComment_id(id);
					dto.setComment_cont(cont);
					dto.setParentNO(Integer.parseInt(articleNO)); //답글단 댓글의 숫자를 셋팅
					dto.setArtistlist_num(Integer.parseInt(num));
					dto.setArtistname(artist.get(0).getArtistname());
					dto.setMyimg(myimg);
					dto.setId(sess);
					
					service.addcomment(dto);

				}else if("delcommnet.do".equals(command) && command != null) {
					int articleNO = Integer.parseInt(request.getParameter("articleNO"));
					System.out.println("articleNO : "+articleNO);
					List<Integer> articleNOList = service.removeComment(articleNO);
				}
				commentList = service.listComment(artist.get(0).getArtistname());
				System.out.println("무한반복 살려줘");
				request.setAttribute("login_dto", login_dto);
				request.setAttribute("album_list", album_list); //아티스트 정보
				request.setAttribute("album_song", album_song); //각 앨범 이름 리스트
				request.setAttribute("src", src); //각 앨범 이름 리스트
				request.setAttribute("commentList", commentList);
				
		
		
		System.out.println("종료");
		
	}//if ("ArtistList") 종료
	if(request.getParameter("javafood").equals("AlbumInfo")) {
		//localhost:8080/javafood_team/javafood?javafood=AlbumInfo&albumId=10346650
		String albumID = request.getParameter("albumId");
		System.out.println("albumID : "+albumID);
		List<AlbumDTO> list = service.Albuminfo(albumID);
		
		request.setAttribute("album_info", list);
		RequestDispatcher dispatch = request.getRequestDispatcher("albumTest.jsp");
		dispatch.forward(request, response);
	}
	if(request.getParameter("javafood").equals("AlbumList")) {		
		//이제 for문돌면서 그 주소의 해당하는 값을 가져와서 dto에 저장해서 리스트로 가져옴
		//앨범 수록록 나오게 전달인자 값 받아서 forward
		//localhost:8080/javafood_team/javafood?javafood=AlbumList&num=1
		JavaFood_DAO dao = new JavaFood_DAO();
		String num = request.getParameter("num"); //1

		List<AlbumDTO> album_list =  dao.album_add(num);//1
		List<AlbumDTO> album_addURL = new ArrayList<AlbumDTO>();
		List list = new ArrayList();	
		String[] album_title = null;
		String url = album_list.get(0).getAlbum_add();
		System.out.println("album_url: "+url);
		org.jsoup.nodes.Document doc = Jsoup.connect(url).get();	
				
		Elements music_name = doc.getElementsByAttributeValue("class", "ellipsis").select("span").select("a");
		Elements album_info = doc.getElementsByAttributeValue("id", "d_video_summary").select("div");
		
		for(int i=0; i<music_name.size(); i++) {
			String music = music_name.get(i).toString();
			System.out.println(music);
			int tempNum = music.indexOf(">");
			music = music.substring(tempNum+1);
			album_title= music.split("<");
			System.out.println("album_title : "+album_title[0]);
			list.add(album_title[0]);
		}						
//				AlbumDTO dto = new AlbumDTO();
//				dto.setAlbum_cover(album_cover);
//				dto.setAlbum_name(null);
//				albumDTO.add(dto);
		request.setAttribute("album_list", album_list);
		request.setAttribute("album_title", list);
		RequestDispatcher dispatch = request.getRequestDispatcher("Album.jsp");
		dispatch.forward(request, response);
	}
//protected void doHand 종료 }
}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//귀범
	private void java2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = "";
		
		System.out.println("play : " + request.getParameter("play"));
		System.out.println("id : " + request.getParameter("id"));
		String country = request.getParameter("country");
		if(country == null ) {
			country = "대한민국";
		}
		System.out.println(country);
		if(request.getParameter("play") != null) {
//			System.out.println("전달인자 실행 test");
			service.addhit(request.getParameter("play"), request.getParameter("id"));
		}
		
		
		nextPage = "/javafood/listsong.do";
		String action = request.getPathInfo();
		
		try {
			
			if("/listsong.do".equals(action)) {
				
				
				
			}
			
		} catch (Exception e) {
			System.out.println("list불러오기 실패");
			e.printStackTrace();
		}
		

		// 페이징 변수
		int pageNum = 1;		// 현재 페이지
		int countPerPage = 50;	// 한 페이지당 표시 수 
		
		// 차트 페이징
		
				String show="페이지";
				if(request.getParameter("songnumber")!=null) {
					show = request.getParameter("songnumber");
				}
				String tmp_pageNum = request.getParameter("pageNum");
				if(tmp_pageNum != null) {
					pageNum = Integer.parseInt(tmp_pageNum);
				}
//				System.out.println("show  전: " + show);
//				System.out.println("pageNum : " + pageNum);
//				System.out.println("countPerPage : " + countPerPage);
		
		if(country.equals("일본")) {
			
			Map chart_list = service.javafood2(country, pageNum, countPerPage);
			
			request.setAttribute("list", chart_list.get("list"));
			request.setAttribute("totalCount", chart_list.get("totalCount"));
			
		}else if(country.equals("미국")) {
			Map chart_list = service.javafood2(country, pageNum, countPerPage);
			
			request.setAttribute("list", chart_list.get("list"));
			request.setAttribute("totalCount", chart_list.get("totalCount"));
		}else{
			Map chart_list = service.javafood2(country, pageNum, countPerPage);
			
			request.setAttribute("list", chart_list.get("list"));
			request.setAttribute("totalCount", chart_list.get("totalCount"));
		}
				
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("countPerPage", countPerPage);
		request.setAttribute("show", show);
		
		// 좋아요
		if(request.getParameter("good_like")!=null) {
			service.javafood5_4(request.getParameter("good_like"));
		}
		
		// 플레이 리스트 추가
//		if(request.getParameter("playlist")!=null) {
//			
//		}
		
//		RequestDispatcher dispatch = request.getRequestDispatcher("song.jsp");
//		Map list_login = service.javafood2(pageNum, countPerPage);
//		request.setAttribute("list_login", list_login);
		
//		System.out.println("list_login size : " + list_login.size());
		
//		list_login = service.javafood2();
		
		nextPage = "/song.jsp";
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
//		doGet(request, response);
		
		
				
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//범주 playList.jsp 접속+리스트 불러오기
	private void java3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JavaFood_Controller의 java3 메소드 실행됨."); //확인용
		System.out.println(request.getSession().getAttribute("login") );

		//세션에 저장된 id값 받아오기
//		List<login_DTO> session_user = service.session_user( (String) request.getSession().getAttribute("login") );
		String c_id = (String)request.getSession().getAttribute("login");
		
		System.out.println("java3의 c_id 값 : " + c_id);
//		String c_id = "testAdmin"; //플레이 리스트를 정상적으로 불러오는 지 확인하는 테스트용 아이디.
		
		//Service에서 플레이 리스트 불러오는 메서드 실행하기
		List playList = service.s_loadPL(c_id);
		

		request.setAttribute("playList", playList);
		request.setAttribute("id", c_id);
		
		String testId = (String)request.getAttribute("c_id");
		System.out.println("java3의 testId : " + testId);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("playList.jsp");

		dispatch.forward(request, response);
	}
	
	//범주 리스트 추가하기
	private void java3_2(String title, String explain, String id)
	{
		service.s_doAddList(title, explain, id);
	}
	
	
	//범주 플레이 리스트 내용 보기
	private void java3_3(HttpServletRequest request, HttpServletResponse response, int pl_id) throws ServletException, IOException
	{
		System.out.println("JavaFood_Controller의 java3_3 메서드 실행됨.");
		
		List<login_DTO> session_user = service.session_user((String) request.getSession().getAttribute("login"));
		String c_id = (String)session_user.get(0).getId();
//		String c_id = "testAdmin"; //플레이 리스트 내용을 정상적으로 불러오는 지 확인하는 테스트용 아이디.
		int c_pl_id = pl_id;
		
		//Service에서 플레이 리스트 내용을 가져올 메서드 실행하기.
		List c_list = service.s_loadPLC(c_pl_id, c_id);
		
		//Service에서 받아온 플레이 리스트 목록을 jsp에 dispatch하기
		request.setAttribute("playListContent", c_list);
		request.setAttribute("id", c_id);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("playListContent.jsp");
		
		dispatch.forward(request, response);
	}
	
	//범주 플레이 리스트 안의 곡 제거하기
	private void java3_4(int PL_ID, int listNumber)
	{
		service.s_doDeleteSong(PL_ID, listNumber);
	}
	
	//범주 리스트 제거하기
	private void java3_5(int PL_ID, String id)
	{
		service.s_doDeleteList(PL_ID, id);
	}
	
	//범주 곡을 추가할 리스트 선택하기.
	private List java3_6(String id)
	{
		System.out.println("JavaFood_Controller의 java3_6 메소드 실행됨."); //확인용
		
		List playList = service.s_loadPL(id);
		
		return playList;
	}
	
	//범주 플레이 리스트 안에 곡 추가하기.
	private void java3_7(int pl_id, int songNumber, String addWhere)
	{
		System.out.println("controller의 java3_7 메서드 실행됨."); //확인용
		
		service.s_addSongToPlayList(pl_id, songNumber, addWhere);
	}
	//범주 플레이 리스트 안에 곡 여러 개 추가하기.
	private void java3_7_1(int pl_id, int[] songNumbers, String addWhere)
	{
		System.out.println("controller의 java3_7 메서드 실행됨."); //확인용
		
		service.s_addSongsToPlayList(pl_id, songNumbers, addWhere);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//경용 로그인
	private void java4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("4번 로그인 실행");
		
		//회원가입 페이지 이동
		if(request.getParameter("membership") !=null) {
			map = service.javafood4(request.getParameter("membership"));
			request.setAttribute("membership", map.get("membership"));
		}
		//로그인
		if(request.getParameter("ID")!=null) {
			map = service.javafood4_1(request.getParameter("ID"), request.getParameter("PW"));
			request.setAttribute("login", (List<login_DTO>) map.get("login"));
			request.getSession().setAttribute("lo", (List<login_DTO>) map.get("login"));
			request.setAttribute("log", (int) map.get("log"));
			request.getSession().setAttribute("login", request.getParameter("ID"));
		}
		//회원가입
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
		//회원정보 수정
		if(request.getParameter("remove")!=null) {
			if("1".equals(request.getParameter("remove"))) {
				vo = new login_DTO();
				vo.setId((String)request.getSession().getAttribute("login"));
				vo.setPw(request.getParameter("PW1"));
				vo.setNic(request.getParameter("nic"));
				vo.setEmail(request.getParameter("mail"));
				vo.setMyimg(request.getParameter("img"));
				vo.setPhone(request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3"));
				service.javafood4_3(vo);
			}
			request.setAttribute("re", "re");
		}
		//계정찾기
		if(request.getParameter("user_search")!=null) {
		}
		request.getRequestDispatcher("Lky/login.jsp").forward(request, response);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//경용 마이페이지
	private void java5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("java5");
		map = service.javafood5();
		request.setAttribute("list",map.get("list") );
		//로그인 정보 확인 후에 로그인됬을떄 회원정보 보내주기.
		if(request.getSession().getAttribute("login")!=null) {
			List<login_DTO> session_user = service.session_user((String) request.getSession().getAttribute("login"));
			request.setAttribute("session_user", session_user.get(0));
		}
		//가수/노래 검색
		if(request.getParameter("option")!=null) {
			if(request.getParameter("text")!=null) {
				List<song_DTO> list = service.javafood5_1(request.getParameter("option"), request.getParameter("text"));
				if(list!=null) {
					request.setAttribute("song", list);
				}
			}
		}
		//링크 클릭시 링크값 전달
		if(request.getParameter("link")!=null) request.setAttribute("link", request.getParameter("link"));
		
		//노래 재생시에 조회수 증가
		if(request.getParameter("like")!=null) service.javafood5_2((String) request.getSession().getAttribute("login"), request.getParameter("like"));
		
		//회원 정보안에 재생기록 확인
		if(request.getParameter("usre")!=null) {
			
			//페이지 이동
			if(request.getParameter("page")==null) 
				request.setAttribute("page", 1);
			else 
				request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("usre" ,service.javafood5_3(request.getParameter("usre")));
		}
		
		//노래 좋아요 클릭
		if(request.getParameter("likes")!=null) service.javafood5_4(request.getParameter("likes"));
		
		//회원정보 수정
		if(request.getParameter("remove")!=null) request.setAttribute("remove", service.javafood5_5(request.getParameter("remove")));
		
		//회원 로그아웃
		if(request.getParameter("iid")!=null) request.getSession().invalidate();
		
		//회원 탈퇴
		if(request.getParameter("idd")!=null) {
			request.setAttribute("out", service.javafood5_6(request.getParameter("idd")));
			request.getSession().invalidate();
		}
		
		//마이페이지 이동
		request.getRequestDispatcher("Lky/My_page.jsp").forward(request, response);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//용준 장르
	private void java6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// 페이징
		int pageNum = 1;		// 현재 페이지
		int countPerPage = 10;	// 한 페이지당 표시 수 

		// 장르별 리스트
		String song="발라드";
		if(request.getParameter("genre")!=null) {
			song = request.getParameter("genre");
		}
		// 페이징 
		String tmp_pageNum = request.getParameter("pageNum");
		if(tmp_pageNum != null) {
			pageNum = Integer.parseInt(tmp_pageNum);
		}
		System.out.println("song  전: " + song);
		System.out.println("pageNum : " + pageNum);
		System.out.println("countPerPage : " + countPerPage);
		Map genre_list = service.javafood6(song, pageNum, countPerPage);
		request.setAttribute("genre", genre_list.get("list"));
		request.setAttribute("totalCount", genre_list.get("totalCount"));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("countPerPage", countPerPage);
		request.setAttribute("song", song);
//		request.setAttribute("genre", genre_list);
		System.out.println("song 후: " + song);

		// 좋아요
		if(request.getParameter("good")!=null) service.javafood5_4(request.getParameter("good"));
		RequestDispatcher dispatch = request.getRequestDispatcher("Genre/NewGenre.jsp");
		dispatch.forward(request, response);

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//용준 최신음악
	private void java7(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 장르별 리스트
		List music = service.javafood7();
		request.setAttribute("music", music);
		System.out.println("music : " + music.size());
		
		//좋아요
		if(request.getParameter("good1")!=null) service.javafood7(request.getParameter("good1"));
		RequestDispatcher dispatch = request.getRequestDispatcher("Genre/Popular_Music.jsp");
		dispatch.forward(request, response);
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//매뉴
	private void javam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List hitList = service.javafoodm();
		request.setAttribute("hitList", hitList);
		if(request.getParameter("opt")!=null) {
			List<song_DTO> list = service.javafood5_1(request.getParameter("opt"), request.getParameter("pot"));
			request.setAttribute("ls", list);
		}
			
		RequestDispatcher dispatch = request.getRequestDispatcher("one/main.jsp");
		dispatch.forward(request, response);

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
}
