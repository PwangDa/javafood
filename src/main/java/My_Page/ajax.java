package My_Page;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/aj")
public class ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String pn = request.getParameter("pn");
		String phone = request.getParameter("phone");
		dbon db = new dbon();
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		int a4 = 0;
		int a5 = 0;
		int a6 = 0;
		
		List<vod> vo = db.listID();
		for(int i=0; i<vo.size();i++) {
			if(id.equals(vo.get(i).getId())) {
				System.out.println(vo.get(i).getId());
				a1=1;
			}
			if(id.equals(vo.get(i).getNic())) {
				System.out.println(vo.get(i).getNic());
				a1=1;
			}
			if(id.equals(vo.get(i).getEmail())) {
				System.out.println(vo.get(i).getEmail());
				a1=1;
			}
			if(id.equals(vo.get(i).getPn())) {
				System.out.println(vo.get(i).getPn());
				a1=1;
			}
			if(id.equals(vo.get(i).getPhone())) {
				System.out.println(vo.get(i).getPhone());
				a1=1;
			}
		}
		response.getWriter().print(a1);
		
	}
}
