package Chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SecondProject.JavaFood_DAO;
import javafood_DTO.song_DTO;

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
		
		JavaFood_DAO dao;
		dao = new JavaFood_DAO();
		
		List<javafood_DTO.song_DTO> list = dao.listSong();
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
		out.println("		<th>순위</th>");
		out.println("		<th>인기점수</th>");
		out.println("		<th>노래제목</th>");
		out.println("		<th>아티스트 명</th>");
		out.println("		<th>장르</th>");
		out.println("		<th>조회수</th>");
		out.println("		<th>좋아요</th>");
		out.println("		<th>재생 시간</th>");
		out.println("	</tr>");
		
		
	      for(int i= 0; i<list.size(); i++) {
	    	  song_DTO vo = list.get(i);
	    	  
	    	  String songnumber = vo.getSongnumber();
	    	  String ranking = vo.getRanking();
	    	  String famous = vo.getFamous();
			  String songname = vo.getSongname();
			  String artistname = vo.getArtistname();
			  String bygenre = vo.getBygenre();
			  String hits = vo.getHits();
			  String likes = vo.getLikes();
			  String playtime = vo.getPlaytime();
			
	          
			  out.println("<tr>");
			  out.println("		<td>"+ songnumber +"</td>");
			  out.println("		<td>"+ ranking+"</td>");
			  out.println("		<td>"+ famous +"</td>");
			  out.println("		<td>"+ songname +"</td>");
			  out.println("		<td>"+ artistname +"</td>");
			  out.println("		<td>"+ bygenre +"</td>");
			  out.println("		<td>"+ hits +"</td>");
			  out.println("		<td>"+ likes +"</td>");
			  out.println("		<td>"+ playtime +"</td>");
			  out.println("</tr>");
	      }
	      out.println("</table>");
			
	      out.println("<a href='/javafood_team/song.jsp'>인기 차트</a>");
	      out.println("<div id='hour'>");
	      out.println("<input type='text' size='10' id='timebox'> 현재시각 기준");
	      out.println("</div>");
		
	      out.println("</body>");
	      out.println("</html>");
	     
	     
	     
	      
	      
	}
}