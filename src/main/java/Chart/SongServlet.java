package Chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import My_Page.vod;
import My_Page.dbon;

@WebServlet("/song")
public class SongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		SongDAO dao = new SongDAO();
		
//		String command = request.getParameter("command");
//		
//		if(command != null && "listcomment".equals(command)) {
//			//DB table값 전달받음
//			String songnumber = request.getParameter("songnumber");
//			String ranking = request.getParameter("ranking");
//			String songname = request.getParameter("songname");
//			String artistname = request.getParameter("artistname");
//			String bygenre = request.getParameter("bygenre");
//			String hits = request.getParameter("hits");
//			String likes = request.getParameter("likes");
//			String playtime = request.getParameter("playtime");
//			
//			//vod 클래스에 저장
//			vod vo = new vod();
//			vo.setSongnumber(songnumber);
//			vo.setRanking(ranking);
//			vo.setSongname(songname);
//			vo.setArtistname(artistname);
//			vo.setBygenre(bygenre);
//			vo.setHits(hits);
//			vo.setLikes(likes);
//			vo.setPlaytime(playtime);
//			
//			dao.listsong().add(vo);
//			//노래 지움
//		}else if(command != null && command.equals("DelSong")) {
//			
//			String songname = request.getParameter("id");
//			System.out.println("DelSong : id : "+ songname);
//			
//			
//			dao.delSong(songname);
			
//			//노래 업데이트
//		}else if("UpdateSong".equals(command)){
//			
//			// 전달 받음
//			String songname = request.getParameter("songname");
//			String artistname = request.getParameter("artistname");
//			String link = request.getParameter("link");
//			// vo 클래스에 저장
//			vod vo = new vod();
//			vo.setSongname(songname);
//			vo.setArtistname(artistname);
//			vo.setLink(link);
//
//			dao.updateSong(vo);
			
//			//노래 추가
//		}else if("AddSong".equals(command)){
//			
//			//전달 받음
//			String songname = request.getParameter("songname");
//			String artistname = request.getParameter("artistname"); 
//			String link = request.getParameter("link");
//			
//			//// vo 클래스에 저장
//			vod vo = new vod();
//			vo.setSongname(songname);
//			vo.setArtistname(artistname);
//			vo.setLink(link);
//			
//			dao.addSong(vo);
			
//		}else if(command != null && command.equals("SongDetail")){
//			
//			// 전달 받음
//			String songnumber = request.getParameter("songnumber");
//			String ranking = request.getParameter("ranking");
//			String songname = request.getParameter("songname");
//			String artistname = request.getParameter("artistname");
//			String bygenre = request.getParameter("bygenre");
//			String hits = request.getParameter("hits");
//			String likes = request.getParameter("likes");
//			String playtime = request.getParameter("playtime");
//			
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<meta charset='UTF-8'>");
//			out.println("<title>Insert title here</title>");
//			out.println("<script>");
//			out.println("	function fn_sendSong(){");
//			out.println("		document.frmSong.method = 'post';");
//			out.println("		document.frmSong.action = 'javafood_team/song';");
//			out.println("		document.frmSong.submit();");
//			out.println("	}");
//			out.println("</script>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("	<form name='frmSong'>");
//			out.println("		<table>");
//			out.println("			<th>인기차트</th>");
//			out.println("			<tr>");
//			out.println("				<td>번호</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='songnumber' value='"+ songnumber +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>순위</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='ranking' value='"+ ranking +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>노래제목</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='songname' value='"+ songname +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>아티스트 명</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='artistname' value='"+ artistname +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>장르</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='bygenre' value='"+ bygenre +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>조회수</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='hits' value='"+ hits +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>좋아요</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='likes' value='"+ likes +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>재생 시간</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='playtime' value='"+ playtime +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("		</table>");
////			out.println("		<input type='button' value='수정하기' onclick='fn_sendSong()'>");
////			out.println("		<input type='hidden' name='command' value='UpdateSong'>");
//			out.println("	</form>");
//			out.println("</body>");
//			out.println("</html>");
//			return;
//		} else if ("SongDetail3".equals(command)) {
//			
//			String songname2 = request.getParameter("songname");
//			
//			vod vo = new vod();
//			
//			List<vod> list = dao.listsong();
//			if(list != null && list.size() > 0) {
//				vo = list.get(0);
//			}
//			
//		    String songnam3 = vo.getSongname();
//		    if(songnam3 == null) {
//		    	out.println("<script>");
//				out.println("	alert('올바른 노래제목을 입력해주세요')");
//				out.println("</script>");
//				return;
//		    }
//		    String songnumber = vo.getSongnumber();
//		    String ranking = vo.getRanking();
//		    String songname = vo.getSongname();
//		    String artistname = vo.getArtistname();
//		    String bygenre = vo.getBygenre();
//		    String hits = vo.getHits();
//		    String likes = vo.getLikes();
//		    String playtime = vo.getPlaytime();
//		    
//		    out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<meta charset='UTF-8'>");
//			out.println("<title>Insert title here</title>");
//			out.println("<script>");
//			out.println("	function fn_sendSong(){");
//			out.println("		document.frmSong.method = 'post';");
//			out.println("		document.frmSong.action = 'javafood_team/song';");
//			out.println("		document.frmSong.submit();");
//			out.println("	}");
//			out.println("</script>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("	<form name='frmSong'>");
//			out.println("		<table>");
//			out.println("			<th>인기차트</th>");
//			out.println("			<tr>");
//			out.println("				<td>번호</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='songnumber' value='"+ songnumber +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>순위</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='ranking' value='"+ ranking +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>노래제목</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='songname' value='"+ songname +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>아티스트 명</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='artistname' value='"+ artistname +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>장르</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='bygenre' value='"+ bygenre +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>조회수</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='hits' value='"+ hits +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>좋아요</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='likes' value='"+ likes +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("			<tr>");
//			out.println("				<td>재생 시간</td>");
//			out.println("				<td>");
//			out.println("					<input type='text' name='playtime' value='"+ playtime +"'>");
//			out.println("				</td>");
//			out.println("			</tr>");
//			out.println("		</table>");
////			out.println("		<input type='button' value='수정하기' onclick='fn_sendSong()'>");
////			out.println("		<input type='hidden' name='command' value='UpdateSong'>");
//			out.println("	</form>");
//			out.println("</body>");
//			out.println("</html>");
//			return;
//		}
		
		List<vod> list = dao.listsong();
		out.println("<html>");
		out.println("<head>");
		out.println("<script>");
		out.println("function refresh(){");
		out.println("setTimeout('location.reload()',300000);");
		out.println("}");
		out.println("function nowtime() {");
		out.println("let now = new Date();");
		out.println("let hour = now.getHours();");
		out.println("let minute = now.getMinutes();");
		out.println("let second = now.getSeconds();");
		out.println("if (hour < 10) {");
		out.println("hour = '0' + hour;");
		out.println("}");
		out.println("if (minute < 10) {");
		out.println("minute = '0' + minute;");
		out.println("}");
		out.println("if (second < 10) {");
		out.println("second = '0' + second;");
		out.println("}");
		out.println("document.getElementById('timebox').value = hour + ':' + minute + ':'");
		out.println("+ second;");
		out.println("}");
		out.println("window.onload = function() {");
		out.println("nowtime();");
		out.println("setInterval(function() {");
		out.println("nowtime();");
		out.println("}, 1000);");
		out.println("refresh();");
		out.println("}");
		out.println("</script>");
		out.println("	<style>");
		out.println("		th, td { ");
		out.println("			border: 1px solid black;");
		out.println("			text-align: center;");
		out.println("		}");
		out.println("	</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("	<tr>");
		out.println("		<th>번호</th>");
		out.println("		<th>좋아요+조회수 합산</th>");
		out.println("		<th>순위</th>");
		out.println("		<th>노래제목</th>");
		out.println("		<th>아티스트 명</th>");
		out.println("		<th>장르</th>");
		out.println("		<th>조회수</th>");
		out.println("		<th>좋아요</th>");
		out.println("		<th>재생 시간</th>");
		out.println("	</tr>");
		
		
	      for(int i= 0; i<list.size(); i++) {
	    	  vod vo = list.get(i);
	    	  
	    	  String songnumber = vo.getSongnumber();
	    	  String rank2 = vo.getRank2();
			  String ranking = vo.getRanking();
			  String songname = vo.getSongname();
			  String artistname = vo.getArtistname();
			  String bygenre = vo.getBygenre();
			  String hits = vo.getHits();
			  String likes = vo.getLikes();
			  String playtime = vo.getPlaytime();
			
	          
			  out.println("<tr>");
			  out.println("		<td>"+ songnumber +"</td>");
			  out.println("		<td>"+ rank2 +"</td>");
			  out.println("		<td>"+(i+1)+"</td>");
			  out.println("		<td>"+ songname +"</td>");
			  out.println("		<td>"+ artistname +"</td>");
			  out.println("		<td>"+ bygenre +"</td>");
			  out.println("		<td>"+ hits +"</td>");
			  out.println("		<td>"+ likes +"</td>");
			  out.println("		<td>"+ playtime +"</td>");
			
//			  out.println("		<td><a href='/javafood_team/song?command=SongDetail&songnumber="+ songnumber +"&ranking="+ ranking +"&songname="+ songname +"&artistname="+ artistname +"&bygenre="+ bygenre +"&hits="+ hits +"&likes="+ likes+"'>전체수정</a></td>");
//			  out.println("		<td><a href=\"/javafood_team/song?command=SongDetail3&songname="+ songname +"\">수정</a></td>");
//			  out.println("		<td><a href=\"/javafood_team/song?command=Delsong&songname="+ songname +"\">삭제</a></td>");
			  out.println("</tr>");
	      }
	      out.println("</table>");
			
	      out.println("<a href='/javafood_team/Song.jsp'>인기 차트</a>");
	      out.println("<div id='hour'>");
	      out.println("<input type='text' size='10' id='timebox'> 현재시각 기준");
	      out.println("</div>");
//	      out.println("<br><a href='/javafood_team/UpdateSong.jsp'>음악리스트 수정하기</a>");
		
	      out.println("</body>");
	      out.println("</html>");
	     
	     
	     
	      
	      
	}
}