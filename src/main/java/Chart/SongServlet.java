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
		
		String command = request.getParameter("command");
		
		if("listcomment".equals(command)) {
			String songname = request.getParameter("songname");
			String artistname = request.getParameter("artistname");
			
			vod vo = new vod();
			vo.setSongname(songname);
			vo.setArtistname(artistname);
			
			dao.listsong().add(vo);
		}else if("notlistcomment".equals(command)) {
			
			String songname2 = request.getParameter("songname");
			System.out.println("리스트에 없습니다"+songname2);
			dao.songlist(null);
		}
		
		List<vod> list = dao.listsong();
		
	      out.write("\r\n");
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Song list</title>\r\n");
	      out.write(" <script>\r\n");
	      out.write(" </script>\r\n");
	      out.write("  <style>\r\n");
	      out.write("    </style>\r\n");
	      out.write("</head>\r\n");
	      out.write("</html>\r\n");
	      
	      for(int i= 0; i<list.size(); i++) {
	    	  vod vo = list.get(i);
	    	  
	    	  String songnumber = vo.getSongnumber();
			  String ranking = vo.getRanking();
			  String songname = vo.getSongname();
			  String artistname = vo.getArtistname();
			  String bygenre = vo.getBygenre();
			  String hits = vo.getHits();
			  String likes = vo.getLikes();
			  String playtime = vo.getPlaytime();
			 

			  out.write("                    <div class=\"songlist\">\r\n");
	          out.write("                            <div class='song'>"+songnumber+"</div>\r\n");
	          out.write("                            <div class='song'>"+ranking+"</div>\r\n");
	          out.write("                            <div class='song'>"+songname+"</div>\r\n");
	          out.write("                            <div class='song'>"+artistname+"</div>\r\n");
	          out.write("                            <div class='song'>"+bygenre+"</div>\r\n");
	          out.write("                            <div class='song'>"+hits+"</div>\r\n");
	          out.write("                            <div class='song'>"+likes+"</div>\r\n");
	          out.write("                            <div class='song'>"+playtime+"</div>\r\n");
	          out.write("                    </div>\r\n");
	         
	         
	      
	      }
	      out.write("            </div>\r\n");
	      out.write("        </div>\r\n");
	      out.write("\r\n");
	      out.write("    </div>\r\n");
	      out.write("\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>");
	}
}