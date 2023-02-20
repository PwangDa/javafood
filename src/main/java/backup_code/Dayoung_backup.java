package backup_code;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import SecondProject.JavaFood_DAO;

public class Dayoung_backup {
	
	/*if(request.getParameter("javafood").equals("1")) {
		///다영 javafood=1 로 접속했을 때 
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String nextPage = "";
		String uri = request.getRequestURI();
		String command = request.getParameter("command");
		
		System.out.println("command : "+command);		
		System.out.println("uri : "+uri);
		List<AlbumDTO> listAlbum = new ArrayList<AlbumDTO>();
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		
		if("artistinfo.do".equals(command)) {
//			List<AlbumDTO> listAlbum = service.Albumlist();
			listAlbum = service.Albumlist();
//			commentList = service.listComment();
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
//			nextPage = "/javafood?javafood=1&command=artistinfo.do";
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
			/*
			 * String id = request.getParameter("id");
			 * System.out.println("delete id : "+id); service.delcomment(id);
			 *
			int articleNO = Integer.parseInt(request.getParameter("articleNO"));
			System.out.println("articleNO : "+articleNO);
			List<Integer> articleNOList = service.removeComment(articleNO);
			
			nextPage = "/javafood?javafood=1&command=artistinfo.do";
		}else {
//			System.out.println("else action : "+action);
			listAlbum = service.Albumlist();
//			commentList = service.listComment();
			request.setAttribute("listAlbum", listAlbum);
			request.setAttribute("commentList", commentList);
			nextPage = "/artistinfo.jsp";
		}
		
		System.out.println("nextPage : "+nextPage);
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}*/
	
	
////다영이것 건들면 큰1납니다. 말아주세요. 젭알. 부탁드립니다. (음악추가)
//http://localhost:8080/javafood_team/javafood?javafood=Albumadd
	/*if(request.getParameter("javafood").equals("Albumadd")) {
		JavaFood_DAO dao = new JavaFood_DAO();
		
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
		  
		  String TOP100 = "https://www.melon.com/chart/month/index.htm";
		  String J_POP100 = "https://www.melon.com/genre/song_list.htm?gnrCode=GN1900&steadyYn=Y";
		  org.jsoup.nodes.Document doc = Jsoup.connect(TOP100).get();
		 
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
			System.out.println((i+1)+ "번  : "+ artist_add);
			
			String albumurl = albumURL.get(i).toString();
			String[] albumNUM= albumurl.split("'");
			album_add="https://www.melon.com/album/detail.htm?albumId="+albumNUM[1];
			System.out.println((i+1) + " 송넘버: "+ album_add);
			
			dao.url_add(artist_add, album_add, (i+1)); //51번부터 넣을땐 i에 50넣고
		} 
				
	}//if ("Albumadd") 종료*/
	
}
