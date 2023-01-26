package My_Page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class tts
 */
@WebServlet("/tts")
public class tts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		dbon db = new dbon();
//		String[] link = (String[]) db.list().get(0).getLink().split("=");
//		System.out.println(link[1]);
//		for(vod a :db.listID()) {
//			System.out.println(a.getId());
//		}
		
		
		//브라우저에 처음 들어오면 세션생성됨
//		HttpSession session = request.getSession(false);		//널값이 나온다.  기존에 세션이 있으면 기존값이 나온다
		HttpSession session = request.getSession();
		session.isNew();  		//트루 펄스트가 나옴
		
		
		if(session.isNew()) {
			System.out.println("신규 session");
		}
		
		
		if(session == null) {
			System.out.println("null session");
		}
		
		session.setAttribute("key1", "test");
		
		String key1=(String) session.getAttribute("key1");		
		System.out.println(key1);
		
		System.out.println(session.getId());
		
		
		
	}
}
