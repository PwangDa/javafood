package Chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import My_Page.vod;

/**
 * Servlet implementation class SongServlet
 */
@WebServlet("/song")
public class SongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
			//한글깨짐 방지
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8;");
			
			
			
			//out 변수에 값 입력하여 출력
			PrintWriter out = response.getWriter();
			
			SongDAO dao = new SongDAO();
			vod vo = new vod();
			
			String command = request.getParameter("command");
			System.out.println("command : "+ command);
			
			// 추가
			if(command != null && "addSong".equals(command)) {
				// 전달 받음
				String number = request.getParameter("songnumber");
				String artistname = request.getParameter("artistname");
				String songname = request.getParameter("songname");
				String bygenre = request.getParameter("bygenre");
				String hits = request.getParameter("hits");
				String likes = request.getParameter("likes");
				String link = request.getParameter("link");
				String ranking = request.getParameter("ranking");
				
				
				vo.setSongnumber(number);
				vo.setArtistname(artistname);
				vo.setSongname(songname);
				vo.setBygenre(bygenre);
				vo.setHits(hits);
				vo.setLikes(likes);
				vo.setLink(link);
				vo.setRanking(ranking);
				
				// 추가 메소드 실행
				dao.addSong(vo);
			} else if(command != null && command.equals("delSong")){
				
				String songnumber = request.getParameter("songnumber");
				System.out.println("delSong : songnumber : "+ songnumber);
				
				dao.delSong(songnumber);
				
			} else if("updateSong".equals(command)){
				
				// 전달 받음
				String number = request.getParameter("songnumber");
				String artistname = request.getParameter("artistname");
				String songname = request.getParameter("songname");
				String bygenre = request.getParameter("bygenre");
				String hits = request.getParameter("hits");
				String likes = request.getParameter("likes");
				String link = request.getParameter("link");
				String ranking = request.getParameter("ranking");
				
				// vo 클래스에 저장
				
				vo.setSongnumber(number);
				vo.setArtistname(artistname);
				vo.setSongname(songname);
				vo.setBygenre(bygenre);
				vo.setHits(hits);
				vo.setLikes(likes);
				vo.setLink(link);
				vo.setRanking(ranking);
				
				// 수정 메소드 실행
				dao.updateSong(vo);
				
			} else if(command != null && command.equals("fixSong")){
				
				// 전달 받음
				String number = request.getParameter("songnumber");
				String artistname = request.getParameter("artistname");
				String songname = request.getParameter("songname");
				String bygenre = request.getParameter("bygenre");
				String hits = request.getParameter("hits");
				String likes = request.getParameter("likes");
				String link = request.getParameter("link");
				String ranking = request.getParameter("ranking");
				
				

				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset='UTF-8'>");
				out.println("<title>Insert title here</title>");
				out.println("<script>");
				out.println("	function fn_send(){");
				out.println("		document.frmMember.method = 'post';");
				out.println("		document.frmMember.action = 'javafood_team/song';");
				out.println("		document.frmMember.submit();");
				out.println("	}");
				out.println("</script>");
				out.println("</head>");
				out.println("<body>");
				out.println("	<form name='frmMember'>");
				out.println("		<table>");
				out.println("			<th>차트</th>");
				out.println("			<tr>");
				out.println("				<td>노래번호</td>");
				out.println("				<td>");
				out.println("					<input type='text' name='songnumber' value='"+ number +"'>");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("			<tr>");
				out.println("				<td>아티스트명</td>");
				out.println("				<td>");
				out.println("					<input type='text' name='artistname' value='"+ artistname +"'>");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("			<tr>");
				out.println("				<td>노래제목</td>");
				out.println("				<td>");
				out.println("					<input type='text' name='songname' value='"+ songname +"'>");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("			<tr>");
				out.println("			<tr>");
				out.println("				<td>장르</td>");
				out.println("				<td>");
				out.println("					<input type='text' name='bygenre' value='"+ bygenre +"'>");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("			<tr>");
				out.println("			<tr>");
				out.println("				<td>조회수</td>");
				out.println("				<td>");
				out.println("					<input type='text' name='hits' value='"+ hits +"'>");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("			<tr>");
				out.println("			<tr>");
				out.println("				<td>좋아요</td>");
				out.println("				<td>");
				out.println("					<input type='text' name='likes' value='"+ likes +"'>");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("			<tr>");
				out.println("			<tr>");
				out.println("				<td>링크</td>");
				out.println("				<td>");
				out.println("					<input type='text' name='link' value='"+ link +"'>");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("			<tr>");
				out.println("			<tr>");
				out.println("				<td>순위</td>");
				out.println("				<td>");
				out.println("					<input type='text' name='ranking' value='"+ ranking +"'>");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("			<tr>");
				out.println("		</table>");
				out.println("		<input type='button' value='클릭' onclick='fn_send()'>");
				out.println("		<input type='hidden' name='command' value='updateSong'>");
				out.println("	</form>");
				out.println("</body>");
				out.println("</html>");
				return;
			} else if ("fixSong2".equals(command)) {
				
				String songnumber = request.getParameter("songnumber");
				System.out.println(songnumber);
			List<vod> list = (List<vod>) dao.getSong(songnumber);
			if(list !=null && list.size() > 0) {
				vo = list.get(0);
			}
			
			String number = vo.getSongnumber();
			String artistname = vo.getArtistname();
			String songname = vo.getSongname();
			String bygenre = vo.getBygenre();
			String hits = vo.getHits();
			String likes = vo.getLikes();
			String link = vo.getLink();
			String ranking = vo.getRanking();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Insert title here</title>");
			out.println("<script>");
			out.println("	function fn_send(){");
			out.println("		document.frmMember.method = 'post';");
			out.println("		document.frmMember.action = 'javafood_team/song';");
			out.println("		document.frmMember.submit();");
			out.println("	}");
			out.println("</script>");
			out.println("</head>");
			out.println("<body>");
			out.println("	<form name='frmMember'>");
			out.println("		<table>");
			out.println("			<th>차트</th>");
			out.println("			<tr>");
			out.println("				<td>노래번호</td>");
			out.println("				<td>");
			out.println("					<input type='text' name='songnumber' value='"+ number +"'>");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("				<td>아티스트명</td>");
			out.println("				<td>");
			out.println("					<input type='text' name='artistname' value='"+ artistname +"'>");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("				<td>노래제목</td>");
			out.println("				<td>");
			out.println("					<input type='text' name='songname' value='"+ songname +"'>");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("			<tr>");
			out.println("				<td>장르</td>");
			out.println("				<td>");
			out.println("					<input type='text' name='bygenre' value='"+ bygenre +"'>");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("			<tr>");
			out.println("				<td>조회수</td>");
			out.println("				<td>");
			out.println("					<input type='text' name='hits' value='"+ hits +"'>");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("			<tr>");
			out.println("				<td>좋아요</td>");
			out.println("				<td>");
			out.println("					<input type='text' name='likes' value='"+ likes +"'>");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("			<tr>");
			out.println("				<td>링크</td>");
			out.println("				<td>");
			out.println("					<input type='text' name='link' value='"+ link +"'>");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("			<tr>");
			out.println("				<td>순위</td>");
			out.println("				<td>");
			out.println("					<input type='text' name='ranking' value='"+ ranking +"'>");
			out.println("				</td>");
			out.println("			</tr>");
			out.println("			<tr>");
			out.println("		</table>");
			out.println("		<input type='button' value='클릭' onclick='fn_send()'>");
			out.println("		<input type='hidden' name='command' value='updateSong'>");
			out.println("	</form>");
			out.println("</body>");
			out.println("</html>");
			
			}else {
				System.out.println("null");
			}
	
	}
}