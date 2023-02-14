package album.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlbumServlet
 */
@WebServlet("/albumregi")
public class AlbumServlet extends HttpServlet {
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
		
		AlbumDAO dao = new AlbumDAO();
		String command = request.getParameter("command");
		String commanding = request.getParameter("commanding");
		
		System.out.println("command >>" + command);
		System.out.println("commanding >>" + commanding);
		
		if("addAlbum".equals(command)) {
			String cover = request.getParameter("cover");
			String name = request.getParameter("name");
			String into = request.getParameter("into");
			String info = request.getParameter("info");
			
			AlbumVO vo = new AlbumVO();
			vo.setAlbum_cover(cover);
			vo.setAlbum_name(name);
			vo.setAlbum_into(into);
			vo.setArtist_info(info);
			
			dao.addAlbum(vo);
		}
		
		if("addMusic".equals(commanding)) {
			String music_name = request.getParameter("music_name");
			String link = request.getParameter("link");
			String time = request.getParameter("time");
			
			AlbumVO vo = new AlbumVO();
			vo.setMusic_name(music_name);
			vo.setMusic_link(link);
			vo.setMusic_time(time);
			
			dao.addMusic(vo);
		}
		
		out.write("\r\n");
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Insert title here</title>\r\n");
	      out.write("</head>\r\n");
	      out.write("<script>\r\n");
	      out.write("	function fn_sendComment(){\r\n");
	      out.write("		frmComment.method = \"post\";\r\n");
	      out.write("		frmComment.action = \"albumregi\";\r\n");
	      out.write("		frmComment.submit();\r\n");
	      out.write("	}\r\n");
	      out.write("	\r\n");
	      out.write("	function fn_sendCommend(){\r\n");
	      out.write("		frmCommend.method = \"post\";\r\n");
	      out.write("		frmCommend.action = \"albumregi\";\r\n");
	      out.write("		frmCommend.submit();\r\n");
	      out.write("	}\r\n");
	      out.write("</script>\r\n");
	      out.write("<style>\r\n");
	      out.write("	textarea{\r\n");
	      out.write("            width: 300px;\r\n");
	      out.write("            height: 110px;\r\n");
	      out.write("    }\r\n");
	      out.write("</style>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("	<form name=\"frmComment\">\r\n");
	      out.write("		<div>\r\n");
	      out.write("			<h2>앨범정보등록</h2>\r\n");
	      out.write("			<textarea name=\"cover\" placeholder=\"앨범표지링크\"></textarea>\r\n");
	      out.write("			<input type=\"text\" name=\"name\" placeholder=\"앨범이름\">\r\n");
	      out.write("			<textarea name=\"into\" placeholder=\"앨범소개글\"></textarea>\r\n");
	      out.write("			<input type=\"text\" name=\"artist\" placeholder=\"가수이름\">\r\n");
	      out.write("			<input type =\"button\" value=\"등록\" onclick=\"fn_sendComment()\">\r\n");
	      out.write("			<input type =\"hidden\" name=\"command\" value=\"addAlbum\">\r\n");
	      out.write("		</div>\r\n");
	      out.write("	</form>\r\n");
	      out.write("		<br>\r\n");
	      out.write("	<form name=\"frmCommend\">\r\n");
	      out.write("		<div>\r\n");
	      out.write("			<h2>그 앨범의 수록곡 등록</h2>\r\n");
	      out.write("			<input type=\"text\" name=\"music_name\" placeholder=\"음악이름\">\r\n");
	      out.write("			<textarea name=\"link\" placeholder=\"음악링크\"></textarea>\r\n");
	      out.write("			<input type=\"text\" name=\"time\" placeholder=\"음악런타임\">\r\n");
	      out.write("			<input type =\"button\" value=\"등록\" onclick=\"fn_sendCommend()\">\r\n");
	      out.write("			<input type =\"hidden\" name=\"commanding\" value=\"addMusic\">\r\n");
	      out.write("		</div>\r\n");
	      out.write("	</form>\r\n");
	      out.write("</html>");
	    
	}
}
