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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		//음악추가
//		if(request.getParameter("javafood").equals("add")) {
//
//			String url = "https://www.melon.com/genre/song_list.htm?gnrCode=GN0900&steadyYn=Y";
//			org.jsoup.nodes.Document doc = Jsoup.connect(url).get();		
//			Elements e1 = doc.getElementsByAttributeValue("class", "checkEllipsis");
//			Elements e2 = doc.getElementsByAttributeValue("class", "ellipsis rank01").select("a");
//			Elements e3 = doc.getElementsByAttributeValue("class", "ellipsis rank03").select("a");
//			Elements e4 =  doc.getElementsByAttributeValue("class", "wrap").select("a").select("img");
//			JavaFood_DAO dao = new JavaFood_DAO();
//			int z=351;
//			for(int i=0; i<e1.size(); i++) {
//				System.out.println("제목 : "+(String)e2.get(i).text());
//				System.out.println("앨범 : "+(String)e3.get(i).text());
//				System.out.println("이미지 주소 : "+(String)e4.get(i).attr("src"));
//				System.out.println();
//				
//				
//				
//				
//				String b = (String)e2.get(i).text().replace("'", "").trim();
//				String c = (String)e3.get(i).text().replace("'", "").trim();
//				String d = (String)e4.get(i).attr("src").trim();
//				dao.addsong1(z,b, c, d);
//				z++;
//			}
			////////////////
//			z=51;
//			List list = new ArrayList();
//				for(int i=0; i<e1.size(); i++) {
//				System.out.println("가수 : "+(String)e1.get(i).text());
//				String a = (String)e1.get(i).text().replace("'", "").trim();

//				String a = e1.get(i).toString();
//				System.out.println(a);
//				String result = "";
//				
//				while(true)
//				{
//					if(a.indexOf("<a") != -1)
//					{
//						int startNum = a.indexOf("이동\">") + 4;
//						int endNum = a.indexOf("</a>");
//						
//						if(result.equals("") )
//						{
//							result += a.substring(startNum, endNum);
//						}
//						else
//						{
//							result += ", " + a.substring(startNum, endNum);
//						}
//						a = a.substring(endNum + 4);
//					}
//					else
//					{
//						break;
//					}
//				}
//				System.out.println("가수 : " + result);
//				a=result;
//				list.add(a);
//				System.out.println((z)+"  "+a);
//			}
//				System.out.println("sldfhsladfhsakjdhfkjsadf : "+list.size());
//				for(int i=0; i<list.size(); i++) {
//					list.get(i)
//				}
//				dao.addsong2(a,z);
//				z++;
//		}//if문 ("add")종료
			////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////다영이것 건들면 큰1납니다. 말아주세요. 젭알. 부탁드립니다. (음악추가)
//http://localhost:8080/javafood_team/javafood?javafood=Albumadd
	if(request.getParameter("javafood").equals("Albumadd")) {
		/*JavaFood_DAO dao = new JavaFood_DAO();
		
		//1단계 : 일단 주소 가져오려면 한번은 실행해서 db에 넣어주기 
		//(장르로 따지면 발라드 주소 한번 실행/ pop주소 한번 실행)	
		//url에 db에 넣을 주소 가져오기
		String album_add, artist_add;
		
		  String url = "https://www.melon.com/genre/song_list.htm?gnrCode=GN0100&steadyYn=Y"; 
		  String dance = "https://www.melon.com/genre/song_list.htm?gnrCode=GN0200&steadyYn=Y"; 
		  String rap = "https://www.melon.com/genre/song_list.htm?gnrCode=GN0300&steadyYn=Y";
		  String RaB = "https://www.melon.com/genre/song_list.htm?gnrCode=GN0400&steadyYn=Y"; 
		  String indi = "https://www.melon.com/genre/song_list.htm?gnrCode=GN0500&steadyYn=Y";
		  String rock = "https://www.melon.com/genre/song_list.htm?gnrCode=GN0600&steadyYn=Y"; 
		  String trott = "https://www.melon.com/genre/song_list.htm?gnrCode=GN0700&steadyYn=Y"; 
		  String POP = "https://www.melon.com/genre/song_list.htm?gnrCode=GN0900&steadyYn=Y";
		  org.jsoup.nodes.Document doc = Jsoup.connect(POP).get();
		 
		//아티스트용
		Elements artistURL_1 = doc.getElementsByAttributeValue("class", "ellipsis rank02").select("span").select("a");
		Elements artistURL = doc.getElementsByAttributeValue("class", "ellipsis rank02").select("span");
		//앨범용
		Elements albumURL = doc.getElementsByAttributeValue("class", "ellipsis rank03").select("a");
		System.out.println(artistURL_1);
		for(int i=0; i<albumURL.size(); i++) {
			String artisturl = artistURL.get(i).toString();
			int tempNum = artisturl.indexOf(";");
			artisturl = artisturl.substring(0, tempNum);
			String[] artistNUM= artisturl.split("'");
			artist_add=artistNUM[1];
			System.out.println(350+(i+1) + "번  : "+ artist_add);
			
			String albumurl = albumURL.get(i).toString();
			String[] albumNUM= albumurl.split("'");
			album_add="https://www.melon.com/album/detail.htm?albumId="+albumNUM[1];
			System.out.println(350+(i+1) + " 송넘버: "+ album_add);
			
			dao.url_add(artist_add, album_add, 350+(i+1)); //51번부터 넣을땐 i에 50넣고
		} */
				
	}//if ("Albumadd") 종료
	if(request.getParameter("javafood").equals("ArtistList")) {
		//localhost:8080/javafood_team/javafood?javafood=ArtistList&num=1
		JavaFood_DAO dao = new JavaFood_DAO();
		String num = request.getParameter("num"); //1이면 1테이블값들어감
		List<AlbumDTO> album_list =  dao.album_add(num);
		String artist_num = album_list.get(0).getArtist_add();
		String detail="https://www.melon.com/artist/detail.htm?artistId="+artist_num;
		String song= "https://www.melon.com/artist/album.htm?artistId="+artist_num;
		
		org.jsoup.nodes.Document doc_detail = Jsoup.connect(detail).get();	
		org.jsoup.nodes.Document doc_song = Jsoup.connect(song).get();	
		
		String artistIMG = doc_detail.getElementsByAttributeValue("id", "artistImgArea").select("img").attr("src");
		Element artistINFO = doc_detail.getElementsByAttributeValue("id", "d_artist_intro").select("div").first();
		String artistName = doc_detail.getElementsByAttributeValue("class", "title_atist").attr("text");
		Elements artistALBUM = doc_song.getElementsByAttributeValue("class", "wrap_album04").select("img");
		Elements artistSONG = doc_song.getElementsByAttributeValue("class", "atist_info").select("dt").select("a");
		
		
		Elements a = doc_detail.getElementsByClass("title_atist");
		Elements aristi_info = doc_detail.getElementsByClass("atist_insdc");
		String b = a.get(0).text();
		String artist_i = "";
		
		if(aristi_info.size() == 0) {
			System.out.println("00");
		}else if(aristi_info.size() == 1) {
			System.out.println("11"); //num3 /하이포가 1임
			artist_i = aristi_info.get(0).text();
			System.out.println("aristi_info : "+aristi_info.get(0).text()); //num3은 인덱스가 한개여서 0으로 해야함
		}else if(aristi_info.size() >= 2) {
			System.out.println("22");
			artist_i = aristi_info.get(1).text();
			System.out.println("aristi_info : "+aristi_info.get(1).text());
		}
		
//		System.out.println("artistINFO: "+artistINFO);
		

//		String[] c = b.split("명");
//		int target_num = b.indexOf(" "); //아티스트명 '명'에서 띄어쓰기까지만 나오게
		String artist_n = b.substring(5);
		System.out.println("아티스트이름 : "+artist_n);
		/*if(aristi_info.get(0).text().length() == 1) {
			 artist_i = aristi_info.get(0).text();
			System.out.println("아티스트 설명 : "+artist_i);
		}else {
			 artist_i = aristi_info.get(1).text();
			System.out.println("아티스트 설명 : "+artist_i);
		}*/
//		System.out.println("아티스트 이미지 : "+artistIMG); 
//		System.out.println("------------------");
//		System.out.println(artistName);
//		System.out.println("------------------");
//		System.out.println("앨범이미지 : "+artistALBUM);
		System.out.println("------------------");
//		System.out.println("대표곡 : "+artistSONG);
		
		
		//각 앨범 이름
		List<String> album_song = new ArrayList<String>();
		//앨범 이미지링크 리스트배열
		List<String> src = new ArrayList<String>();
		String[] artist_song = null;	
		for(int i=0; i<artistSONG.size(); i++) {
			AlbumDTO dto = new AlbumDTO();
			dto.setArtistname(artist_n);
			dto.setArtist_info(artist_i);
			dto.setArtist_img(artistIMG);
			
			String artistsong = artistSONG.get(i).toString();
			int tempNum = artistsong.indexOf(">");
			artistsong = artistsong.substring(tempNum+1);
			artist_song= artistsong.split("<");
//			System.out.println("album_title"+(i+1)+" : "+artist_song[0]);
			dto.setAlbum_name(artistsong);
//			album_song.add(artist_song[0]);
			
			String adg = artistALBUM.get(i).attr("src");
//			System.out.println((i+1)+"의앨범 이미지링크 : "+adg); 	
			dto.setAlbum_cover(adg);
//			src.add(adg);
			album_list.add(dto);
		}
		
		String command = request.getParameter("command");
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		commentList = service.listComment();
		
		request.setAttribute("album_list", album_list); //아티스트 정보
		request.setAttribute("album_song", album_song); //각 앨범 이름 리스트
		request.setAttribute("src", src); //각 앨범 이름 리스트
		request.setAttribute("commentList", commentList);
		String nextPage = "/artist.jsp";
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		
		
	}//if ("ArtistList") 종료
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
		List<song_DTO> list_login = service.javafood2();
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
		

		//세션에 저장된 id값 받아오기
		List<login_DTO> session_user = service.session_user( (String) request.getSession().getAttribute("login") );
		String c_id = (String)session_user.get(0).getId();
//		String c_id = "testAdmin"; //플레이 리스트를 정상적으로 불러오는 지 확인하는 아이디.
		
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
//		RequestDispatcher dispatch = request.getRequestDispatcher("PlayList");
		request.setAttribute("playList", playList);
		request.setAttribute("id", c_id);
//		request.setAttribute("doAddList", doAddList);
//		request.setAttribute("doDeleteList", doDeleteList);
		
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
		
		//요청된 값 받아오기
//		HttpSession session = request.getSession();
		List<login_DTO> session_user = service.session_user((String) request.getSession().getAttribute("login"));
		String c_id = (String)session_user.get(0).getId();
//		String c_id = "testAdmin"; //플레이 리스트 내용을 정상적으로 불러오는 지 확인하는 아이디.
		int c_pl_id = pl_id;
		
		//Service에서 플레이 리스트 내용을 가져올 메서드 실행하기.
		List c_list = service.s_loadPLC(c_pl_id, c_id);
		
		//Service에서 받아온 플레이 리스트 목록을 jsp에 dispatch하기
//		RequestDispatcher dispatch = request.getRequestDispatcher("PlayListContent");
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
			request.getSession().setAttribute("lo", (List<login_DTO>) map.get("login"));
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
		if(request.getParameter("remove")!=null) {
			vo = new login_DTO();
			vo.setId((String)request.getSession().getAttribute("login"));
			vo.setPw(request.getParameter("PW1"));
			vo.setNic(request.getParameter("nic"));
			vo.setEmail(request.getParameter("mail"));
			vo.setMyimg(request.getParameter("img"));
			vo.setPhone(request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3"));
			service.javafood4_3(vo);
			request.setAttribute("re", "re");
		}
		request.getRequestDispatcher("Lky/login.jsp").forward(request, response);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//경용 마이페이지
	private void java5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("5번 my페이지 실행");
		map = service.javafood5();
		request.setAttribute("list",map.get("list") );
		System.out.println("map : "+map.get("list"));
		if(request.getSession().getAttribute("login")!=null) {
			System.out.println("login : !=null");
			List<login_DTO> session_user = service.session_user((String) request.getSession().getAttribute("login"));
			request.setAttribute("session_user", session_user.get(0));
		}
		if(request.getParameter("option")!=null) {
			System.out.println("option : "+request.getParameter("option"));
			if(request.getParameter("text")!=null) {
				System.out.println("text : "+request.getParameter("text"));
				List<song_DTO> list = service.javafood5_1(request.getParameter("option"), request.getParameter("text"));
				if(list!=null) {
					request.setAttribute("song", list);
					System.out.println("!=null lsit : "+list);
				}
			}
		}
		System.out.println("useradsfsadfasdfasdf "+request.getParameter("usre"));
		if(request.getParameter("link")!=null) request.setAttribute("link", request.getParameter("link"));
		if(request.getParameter("like")!=null) service.javafood5_2((String) request.getSession().getAttribute("login"), request.getParameter("like"));
		if(request.getParameter("usre")!=null) request.setAttribute("usre" ,service.javafood5_3(request.getParameter("usre")));
		if(request.getParameter("likes")!=null) service.javafood5_4(request.getParameter("likes"));
		if(request.getParameter("remove")!=null) request.setAttribute("remove", service.javafood5_5(request.getParameter("remove")));
		
		request.getRequestDispatcher("Lky/My_page.jsp").forward(request, response);
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//용준 장르
	private void java6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 장르별 리스트
		String song="발라드";
		if(request.getParameter("genre")!=null) {
			song = request.getParameter("genre");
		}
		System.out.println("song  전: " + song);
		List genre_list = service.javafood6(song);
		request.setAttribute("genre", genre_list);
		request.setAttribute("song", song);
		System.out.println("song 후: " + song);
		
		//좋아요
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
	//태연
	private void javam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("메인 실행");
		
		List hitList = service.javafoodm();
		request.setAttribute("hitList", hitList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("one/main.jsp");
		dispatch.forward(request, response);
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
}
