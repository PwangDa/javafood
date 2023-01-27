package playList;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
//import java.sql.Date;
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
		
		//리스트에 아무것도 추가된 것이 없을 때 쓸 표지.
//		String nullImage = "https://cdn.pixabay.com/photo/2015/11/03/09/10/question-mark-1020165_960_720.jpg";
		
		//주소로 넘어온 값을 받기
		String doAddList = request.getParameter("doAddList");
		String doDeleteList = request.getParameter("doDeleteList");
		/////////////////////////////////////////////
		
		//리스트 추가하기
		if("doAdd".equals(doAddList) )
		{
			//주소로 넘어온 값을 받기
			String addList_title = request.getParameter("addList_title");
			String addList_explain = request.getParameter("addList_explain");
			
			//쿼리문 작성
			String addList_query = "INSERT INTO playList(PL_ID, ID2, PL_Title, PL_Explain)"
					+ " VALUES("
					+ "seq_PL_ID.nextval, "
					+ "'testAdmin', " //회원 아이디. 회원가입 및 목록, 마이페이지가 완성되면 수정할 것.
					+ "'" + addList_title + "', "
					+ "'" + addList_explain + "'"
					+ ")";
//			System.out.println("addList_query : " + addList_query); //확인용
			//////////////////////////////////////////////////////////////
			
			//쿼리 실행
			try {
				//커넥션 풀 작동 코드
				Context ctx = new InitialContext();
				Context envContext = (Context) ctx.lookup("java:/comp/env");
				DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle2");
				Connection con = dataFactory.getConnection();
				/////////////////////////////////////
				
				//DB 접속 코드
				PreparedStatement pstmt = con.prepareStatement(addList_query);
				ResultSet rs = pstmt.executeQuery();
				
				//doAddList 초기화
//				doAddList = "don't do";
				/////////////////////////////////////////////
			}
			catch (NamingException | SQLException e)
			{
				e.printStackTrace();
			}
		}
		/////////////////////////////////////////////////////
		
		//리스트 삭제하기
		if("doDelete".equals(doDeleteList) )
		{
			//주소로 넘어온 값을 받기
			String res_PL_ID = request.getParameter("res.PL_ID");
			
			//쿼리문 작성
			String deleteList_query = "DELETE FROM PLAYLIST_CONTENT\r\n"
					+ " WHERE PL_ID = " + res_PL_ID;
			//////////////////////////////////////////////////////////////
			
			//쿼리 실행
			try {
				//커넥션 풀 작동 코드
				Context ctx = new InitialContext();
				Context envContext = (Context) ctx.lookup("java:/comp/env");
				DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle2");
				Connection con = dataFactory.getConnection();
				/////////////////////////////////////
				
				//DB 접속 코드
				PreparedStatement pstmt = con.prepareStatement(deleteList_query);
				ResultSet rs = pstmt.executeQuery();
				/////////////////////////////////////////////
			}
			catch (NamingException | SQLException e)
			{
				e.printStackTrace();
			}
			
			//쿼리문 작성
			deleteList_query = "DELETE FROM PLAYLIST\r\n"
					+ " WHERE PL_ID = " + res_PL_ID;
			//////////////////////////////////////////////////////////////
			
			//쿼리 실행
			try {
				//커넥션 풀 작동 코드
				Context ctx = new InitialContext();
				Context envContext = (Context) ctx.lookup("java:/comp/env");
				DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle2");
				Connection con = dataFactory.getConnection();
				/////////////////////////////////////
				
				//DB 접속 코드
				PreparedStatement pstmt = con.prepareStatement(deleteList_query);
				ResultSet rs = pstmt.executeQuery();
				/////////////////////////////////////////////
			}
			catch (NamingException | SQLException e)
			{
				e.printStackTrace();
			}
		}
		////////////////////////////////////////////////////////////////////////////////////
		
		PrintWriter out = response.getWriter();
		
		String query = "SELECT * FROM playList";
		
		try
		{
			//커넥션 풀 작동 코드
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle2");
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
					+ "\r\n"
					+ "        input.addList_textbar\r\n"
					+ "        {\r\n"
					+ "            border:hidden;\r\n"
					+ "            border-radius: 5px;\r\n"
					+ "\r\n"
					+ "            margin:0 0 1% 1%;\r\n"
					+ "\r\n"
					+ "            background-color: rgb(63, 63, 63);\r\n"
					+ "            color:rgb(247, 212, 147);\r\n"
					+ "            \r\n"
					+ "            width:50%;\r\n"
					+ "            height: 30px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        input.addList_ex_textbar\r\n"
					+ "        {\r\n"
					+ "            border:hidden;\r\n"
					+ "            border-radius: 5px;\r\n"
					+ "\r\n"
					+ "            margin:0 0 1% 1%;\r\n"
					+ "\r\n"
					+ "            background-color: rgb(63, 63, 63);\r\n"
					+ "            color:rgb(247, 212, 147);\r\n"
					+ "            \r\n"
					+ "            width:50%;\r\n"
					+ "            height: 150px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        input.addList_btn\r\n"
					+ "        {\r\n"
					+ "            border:hidden;\r\n"
					+ "\r\n"
					+ "            background-color:black;\r\n"
					+ "            color:white;\r\n"
					+ "\r\n"
					+ "            width:6%;\r\n"
					+ "            height: 32px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        .hidden\r\n"
					+ "        {\r\n"
					+ "            display:none;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        span.addList\r\n"
					+ "        {\r\n"
					+ "            vertical-align: top;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>");
			
			//DB 접속 코드
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			/////////////////////////////////////////////
			
			out.println
			("<body>\r\n"
					//회원목록이 생성되면 아래의 아이디 부분을 수정할 것.
					+ "    <div class=\"title\"><h1> " + "아직 회원목록DB에 연결을 해두지 않아서 쓰는 임시 아이디." + "님의 플레이 리스트 </h1></div><br><hr>\r\n"
					+ "<img class=\"addList\" src=\"https://cdn-icons-png.flaticon.com/512/7598/7598663.png\"> "
					+ "<span class=\"addList\">\uB9AC\uC2A4\uD2B8 \uCD94\uAC00</span><br>"
					+ "<div class=\"search hidden\">\r\n"
					+ "        <form name = \"PL_addList\">\r\n"
					+ "            <input type=\"text\" name=\"addList_title\" class=\"addList_textbar\" placeholder=\"\uD50C\uB808\uC774\uB9AC\uC2A4\uD2B8 \uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.\"> <br>\r\n"
					+ "            <input type=\"text\" name=\"addList_explain\" class=\"addList_ex_textbar\" placeholder=\"\uD50C\uB808\uC774\uB9AC\uC2A4\uD2B8 \uC124\uBA85\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.\"> <br>\r\n"
					+ "            <input type=\"button\" name=\"addList_btn\" class=\"addList_btn\" value=\"\uCD94\uAC00\">\r\n"
					+ "            <input type=\"hidden\" name=\"doAddList\" value=\"doAdd\"> \r\n"
					+ "        </form>\r\n"
					+ "    <br><br></div>");
			
			out.println
			("<script>\r\n"
					+ "        document.querySelector(\"img.addList\").addEventListener('click', ()=>\r\n"
					+ "        {\r\n"
					+ "            document.querySelector(\"div.search\").classList.toggle(\"hidden\");\r\n"
					+ "        });\r\n"
					+ "        document.querySelector(\"span.addList\").addEventListener('click', ()=>\r\n"
					+ "        {\r\n"
					+ "            document.querySelector(\"div.search\").classList.toggle(\"hidden\");\r\n"
					+ "        });\r\n"
					+ "\r\n"
					+ "        function fn_addList()\r\n"
					+ "        {\r\n"
					+ "            let title = PL_addList.addList_title.value;\r\n"
					+ "            let explain = PL_addList.addList_explain.value;\r\n"
					+ "\r\n"
					+ "            if(title.length == 0 || title == \"\")\r\n"
					+ "            {\r\n"
					+ "                alert(\"\uD50C\uB808\uC774\uB9AC\uC2A4\uD2B8 \uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.\")\r\n"
					+ "            }\r\n"
					+ "            else\r\n"
					+ "            {\r\n"
					+ "                PL_addList.method='post';\r\n"
					+ "                PL_addList.action='pl';\r\n"
					+ "                PL_addList.submit();\r\n"
					+ "            }\r\n"
					+ "        }\r\n"
					+ "        document.querySelector(\"input.addList_btn\").addEventListener('click', ()=>\r\n"
					+ "        {\r\n"
					+ "            fn_addList();\r\n"
					+ "        });\r\n"
					+ "    </script>");
			
			rs.next();
//			
			String ID2 = rs.getString("ID2");
			int PL_ID = rs.getInt("PL_ID");
			String PL_Title = rs.getString("PL_TITLE");
//			Date PL_Date = rs.getDate("PL_DATE"); //자바에선 필요없음.
//			String PL_Explain = rs.getString("PL_EXPLAIN"); //이 서블릿에선 필요없음.
			
			//html 작성하기
			out.println
			//a 태그의 주소 수정하기.
			("<a href=\"plc?PL_ID=" + PL_ID + "\">\r\n"
					+ "        <div class=\"playList\">\r\n"
					//다음 코드는 앨범 표지를 표시하는 곳임. 나중에 src 수정이 필요함.
					+ "            <img class=\"album\" src=\"https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined\">\r\n"
					
					+ "            <div class=\"plText\">" + PL_Title + "</div></div></a>");
			
			
			
			
			while(rs.next() )
			{
				//테이블에서 값 가져오기
				
				PL_ID = rs.getInt("PL_ID");
				PL_Title = rs.getString("PL_TITLE");
//				PL_Date = rs.getDate("PL_DATE");
//				PL_Explain = rs.getString("PL_EXPLAIN");
				/////////////////////////////////
				
				//html 작성하기
				out.println
				//a 태그의 주소 수정하기.
				("<a href=\"plc?id=" + ID2 + "&PL_ID=" + PL_ID + "\">\r\n"
						+ "        <div class=\"playList\">\r\n"
						//다음 코드는 앨범 표지를 표시하는 곳임. 나중에 src 수정이 필요함.
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
		doGet(request, response);
	}

}