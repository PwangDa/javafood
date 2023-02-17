package SecondProject;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/javafood/*")
public class javaFood_Filter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터 정상작동");
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("css")==null) {
			System.out.println("css예외처리");
			response.setContentType("text/html; charset=utf-8;");
		}
		chain.doFilter(request, response);
		
	}
}
