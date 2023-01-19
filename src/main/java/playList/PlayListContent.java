package playList;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

@WebServlet({ "/playListContent", "/plc", "/playlistcontent" })
public class PlayListContent extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8;");
		
		//주소로 넘어온 값들 받기
//		String req_id = request.getParameter("id");
//		System.out.println("id : " + req_id); //확인용
		int req_PL_ID = Integer.parseInt(request.getParameter("PL_ID") );
		System.out.println("req_PL_ID : " + req_PL_ID); //확인용
		
		PrintWriter out = response.getWriter();
		
		//아래 쿼리는 DB가 정식적으로 만들어 졌을 때 다시 수정할 것.
		String query = "SELECT *"
				+ " FROM playList_Content pc"
				+ " JOIN playList pl ON (pc.PL_ID = pl.PL_ID)"
				+ " JOIN Song s ON (pc.SONGNUMBER = s.SONGNUMBER)"
				+ " ORDER BY LISTNUMBER";
		System.out.println("query : " + query); //확인용
		
		
		try
		{
			//커넥션 풀 작동 코드
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			DataSource dataFactory = (DataSource) envContext.lookup("jdbc/javafood");
			Connection con = dataFactory.getConnection();
			/////////////////////////////////////////////////////

			out.println
			(
					"<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>\uC81C\uBAA9\uC81C\uBAA9\uC81C\uBAA9</title>\r\n"
					+ "    \r\n"
					+ "    <style>\r\n"
					+ "        body\r\n"
					+ "        {\r\n"
					+ "            display:flex;\r\n"
					+ "            margin:0;\r\n"
					+ "            background-color: black;\r\n"
					+ "            color:white;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        div.album_info\r\n"
					+ "        {\r\n"
					+ "            /* border:1px solid black; */\r\n"
					+ "\r\n"
					+ "            display:inline-block;\r\n"
					+ "            width:20%;\r\n"
					+ "            height: 100%;\r\n"
					+ "            margin-top:7%;\r\n"
					+ "            vertical-align: top;\r\n"
					+ "\r\n"
					+ "            text-align: center;\r\n"
					+ "            font-size: 14px;\r\n"
					+ "            color:rgb(78, 78, 78);\r\n"
					+ "        }\r\n"
					+ "        div.album_explain\r\n"
					+ "        {\r\n"
					+ "            margin:5%;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        div.list_parent\r\n"
					+ "        {\r\n"
					+ "            /* border:1px solid red; */\r\n"
					+ "            \r\n"
					+ "            border-left:1px dotted gray;\r\n"
					+ "\r\n"
					+ "            /* display:inline-block; */\r\n"
					+ "\r\n"
					+ "            width:78%;\r\n"
					+ "            height: 100%;\r\n"
					+ "        }\r\n"
					+ "        div.list_child\r\n"
					+ "        {\r\n"
					+ "            /* border:1px solid blue; */\r\n"
					+ "            border-bottom: 1px solid gray;\r\n"
					+ "\r\n"
					+ "            margin:1%;\r\n"
					+ "            /* display:inline-block; */\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        img.list_thumnail\r\n"
					+ "        {\r\n"
					+ "            height: 85%;\r\n"
					+ "            width: 85%;\r\n"
					+ "            box-shadow: 2px 2px 2px 2px gray;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        img.album\r\n"
					+ "        {\r\n"
					+ "            width:100px;\r\n"
					+ "            height:100px;\r\n"
					+ "        }\r\n"
					+ "        div.list_number\r\n"
					+ "        {\r\n"
					+ "            /* border:1px solid green; */\r\n"
					+ "\r\n"
					+ "            display:inline-block;\r\n"
					+ "\r\n"
					+ "            vertical-align: top;\r\n"
					+ "        }\r\n"
					+ "        div.list_info\r\n"
					+ "        {\r\n"
					+ "            /* border:1px solid rebeccapurple; */\r\n"
					+ "\r\n"
					+ "            display:inline-block;\r\n"
					+ "            vertical-align: top;\r\n"
					+ "\r\n"
					+ "            /* line-height: 180%; */\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        span.song_title\r\n"
					+ "        {\r\n"
					+ "            /* border:1px solid red; */\r\n"
					+ "\r\n"
					+ "            font-size:20px;\r\n"
					+ "            font-weight: bold;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>"
			);
			
			//DB 접속 코드
			System.out.println("////////DB쿼리 : " + query);
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
//			System.out.println("rs.next() : " + rs.next() ); //확인용
			/////////////////////////////////////////////
			
			out.println("<body>");
			
			int PL_ID;
			int PL_listNumber;
			String songName;
			String PL_title;
			String PL_explain;
			String artistName;
			
			while(rs.next() )
			{
				System.out.println("while(rs.next() ) 실행됨."); //확인용
				
				PL_ID = rs.getInt("PL_ID");
				PL_listNumber = rs.getInt("LISTNUMBER");
				songName = rs.getString("SONGNAME");
				PL_title = rs.getString("PL_TITLE");
				PL_explain = rs.getString("PL_EXPLAIN");
				artistName = rs.getString("ARTISTNAME");
				
				
				if(req_PL_ID == PL_ID)
				{
					System.out.println("PL_ID : " + PL_ID); //확인용
					
					out.println
					("<div class=\"album_info\">\r\n"
							//이미지 주소 바꿀 것
							+ "        <img class=\"list_thumnail\" src=\"https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined\">\r\n"
							+ "        <br><br>\r\n"
							+ "        <h2 style=\"text-shadow:2px 2px 2px gray; color:whitesmoke;\">" + PL_title + "</h2>\r\n"
							+ "        <br>\r\n"
							+ "        <div class=\"album_explain\">\r\n"
							+ "            " + PL_explain + "\r\n"
							+ "        </div>\r\n"
							+ "    </div>"							
							+ "<div class=\"list_parent\">"
							+ "<div class=\"list_child\">\r\n"
//							+ "            <div class=\"list_number\">" + PL_listNumber + "</div>\r\n"
							+ "            <img class=\"album\" src=\"https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined\">\r\n"
							+ "            <div class=\"list_info\">\r\n"
							+ "                <span class=\"song_title\">" + songName + "</span><br><br>\r\n"
							+ "                " + artistName + "<br>\r\n"
							//아래 코드는 앨범명. 나중에 바꿀 것.
							+ "                \uC5D0\uC787\r\n"
							+ "            </div>\r\n"
							+ "        </div>"
					);
					
					break;
				}
			}
			
			while(rs.next() )
			{
				PL_ID = rs.getInt("PL_ID");
				PL_listNumber = rs.getInt("LISTNUMBER");
				songName = rs.getString("SONGNAME");
				PL_title = rs.getString("PL_TITLE");
				PL_explain = rs.getString("PL_EXPLAIN");
				artistName = rs.getString("ARTISTNAME");
				
				
				if(req_PL_ID == PL_ID)
				{
					System.out.println("PL_ID : " + PL_ID); //확인용
					
					out.println
					("		<div class=\"list_child\">\r\n"
//							+ "            <div class=\"list_number\">" + PL_listNumber + "</div>\r\n"
							+ "            <img class=\"album\" src=\"https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined\">\r\n"
							+ "            <div class=\"list_info\">\r\n"
							+ "                <span class=\"song_title\">" + songName + "</span><br><br>\r\n"
							+ "                " + artistName + "<br>\r\n"
							//아래 코드는 앨범명. 나중에 바꿀 것.
							+ "                \uC5D0\uC787\r\n"
							+ "            </div>\r\n"
							+ "        </div>"
					);
					
					continue;
				}
			}
			
			out.println("</body></html>");
		}
		catch (NamingException | SQLException e)
		{
			e.printStackTrace();
		}
		/////////////////////////////////////
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}