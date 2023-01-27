package My_Page;

import java.io.IOException;

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
		response.getWriter().println(id);
		response.getWriter().println(pw);
		response.getWriter().println(nic);
		response.getWriter().println(email);
		response.getWriter().println(pn);
		response.getWriter().println(phone);
	}
}
