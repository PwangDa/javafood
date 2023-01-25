package My_Page;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tts
 */
@WebServlet("/tts")
public class tts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbon db = new dbon();
		String[] link = (String[]) db.list().get(0).getLink().split("=");
		System.out.println(link[1]);
		for(vod a :db.listID()) {
			System.out.println(a.getId());
		}
		
	}
}
