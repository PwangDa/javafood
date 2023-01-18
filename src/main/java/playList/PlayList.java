package playList;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet({ "/PlayList", "/playlist", "/pl" })
public class PlayList extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8;");
		
		PrintWriter out = response.getWriter();
		
		String query = "SELECT * FROM playList";
		
		try
		{
			//커넥션 풀 작동 코드
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			DataSource dataFactory = (DataSource) envContext.lookup("jdbc/javafood");
			Connection con = dataFactory.getConnection();
			/////////////////////////////////////
			
			out.println
			("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>\uC81C\uBAA9\uC81C\uBAA9</title>\r\n"
					+ "    <style>\r\n"
					+ "        body\r\n"
					+ "        {\r\n"
					+ "            background-color: black;\r\n"
					+ "            color:white;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        div.title\r\n"
					+ "        {\r\n"
					+ "            text-align:center;\r\n"
					+ "            margin:5% 0% 0% 0%;\r\n"
					+ "            text-shadow:2px 2px 2px gray;\r\n"
					+ "            color:whitesmoke;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "\r\n"
					+ "        img.addList\r\n"
					+ "        {\r\n"
					+ "            width: 30px;\r\n"
					+ "            height: 30px;\r\n"
					+ "            /* border-right:1px solid rgb(184, 184, 184); */\r\n"
					+ "            margin-bottom: 1%;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "        div.playList\r\n"
					+ "        {\r\n"
					+ "            font-size:100%;\r\n"
					+ "            text-align:center;\r\n"
					+ "\r\n"
					+ "            display:inline-block;\r\n"
					+ "\r\n"
					+ "            /* border:1px solid black; */\r\n"
					+ "            width:19%;\r\n"
					+ "            margin:0% 3% 10% 2%;\r\n"
					+ "        }\r\n"
					+ "        div.plText\r\n"
					+ "        {\r\n"
					+ "            display:block;\r\n"
					+ "            margin-top:3%;\r\n"
					+ "            /* border-top:1px solid rgb(184, 184, 184); */\r\n"
					+ "        }\r\n"
					+ "        img.album\r\n"
					+ "        {\r\n"
					+ "            height: 100%;\r\n"
					+ "            width: 100%;\r\n"
					+ "            box-shadow: 5px 5px 5px 5px gray;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        a\r\n"
					+ "        {\r\n"
					+ "            text-decoration: none; /* \uB9C1\uD06C\uC758 \uBC11\uC904 \uC81C\uAC70 */\r\n"
					+ "            color: inherit; /* \uB9C1\uD06C\uC758 \uC0C9\uC0C1 \uC81C\uAC70 */\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>");
			
			//DB 접속 코드
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			/////////////////////////////////////////////
			
			rs.next();
			
			String ID2 = rs.getString("ID2");
			int PL_ID = rs.getInt("PL_ID");
			String PL_Title = rs.getString("PL_TITLE");
			Date PL_Date = rs.getDate("PL_DATE");
			String PL_Explain = rs.getString("PL_EXPLAIN");
			/////////////////////////////////
			
			//html 작성하기
			out.println
			("<body>\r\n"
					+ "    <div class=\"title\"><h1> " + ID2 + "님의 플레이 리스트 </h1></div><br><hr>");
			out.println
			//a 태그의 주소 수정하기.
			("<a href=\"/jf/plc?PL_ID=" + PL_ID + "\">\r\n"
					+ "        <div class=\"playList\">\r\n"
					//다음 코드는 앨범 표지를 표시하는 곳임. 나중에 주소쪽 수정이 필요함.
					+ "            <img class=\"album\" src=\"https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined\">\r\n"
					
					
					+ "            <div class=\"plText\">" + PL_Title + "</div></div></a>");
			
			
			
			
			while(rs.next() )
			{
				//테이블에서 값 가져오기
				
				PL_ID = rs.getInt("PL_ID");
				PL_Title = rs.getString("PL_TITLE");
				PL_Date = rs.getDate("PL_DATE");
				PL_Explain = rs.getString("PL_EXPLAIN");
				/////////////////////////////////
				
				//html 작성하기
				out.println
				//a 태그의 주소 수정하기.
				("<a href=\"/jf/plc?id=" + ID2 + "&PL_ID=" + PL_ID + "\">\r\n"
						+ "        <div class=\"playList\">\r\n"
						//다음 코드는 앨범 표지를 표시하는 곳임. 나중에 주소쪽 수정이 필요함.
						+ "            <img class=\"album\" src=\"https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined\">\r\n"
						
						
						+ "            <div class=\"plText\">" + PL_Title + "</div></div></a>");
			}
			
			out.println("</body></html>");
		}
		catch (NamingException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}
