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
//		System.out.println("query : " + query); //확인용
		
		
		try
		{
			//커넥션 풀 작동 코드
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle2");
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
					+ "            color:thistle;\r\n"
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
					+ "\r\n"
					+ "        input.search_textbar\r\n"
					+ "        {\r\n"
					+ "            border:hidden;\r\n"
					+ "            border-radius: 5px;\r\n"
					+ "\r\n"
					+ "            margin:1% 0 1% 1%;\r\n"
					+ "\r\n"
					+ "            background-color: rgb(63, 63, 63);\r\n"
					+ "            color:rgb(247, 212, 147);\r\n"
					+ "            \r\n"
					+ "            width:80%;\r\n"
					+ "            height: 30px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        input.search_btn\r\n"
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
					+ "        div.noList\r\n"
					+ "        {\r\n"
					+ "            color:white;\r\n"
					+ "            padding:37%;\r\n"
					+ "            text-align:center;\r\n"
					+ "        }\r\n"
					+ "        button.add_btn\r\n"
					+ "        {\r\n"
					+ "            background-color: black;\r\n"
					+ "            color:white;\r\n"
					+ "            margin:2%;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        span.delete\r\n"
					+ "        {\r\n"
					+ "            color:white;\r\n"
					+ "            margin:2%;\r\n"
					+ "            height: 5%;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        .hidden\r\n"
					+ "        {\r\n"
					+ "           display: none;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>"
			);
			
			//DB 접속 코드
//			System.out.println("////////DB쿼리 : " + query); //확인용
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
//			System.out.println("rs.next() : " + rs.next() ); //확인용
			/////////////////////////////////////////////
			
			out.println("<body>");
			
			int PL_ID;
//			int PL_listNumber; //DB에선 필요하나, 자바에선 필요없음.
			String songName;
			String PL_title;
			String PL_explain;
			String artistName;
			
			boolean noList = true;
			
			while(rs.next() )
			{
//				System.out.println("while(rs.next() ) 실행됨."); //확인용
				
				PL_ID = rs.getInt("PL_ID");
//				PL_listNumber = rs.getInt("LISTNUMBER");
				songName = rs.getString("SONGNAME");
				PL_title = rs.getString("PL_TITLE");
				PL_explain = rs.getString("PL_EXPLAIN");
				artistName = rs.getString("ARTISTNAME");
				
				if(req_PL_ID == PL_ID)
				{
					System.out.println("PL_ID : " + PL_ID); //확인용
					
					noList = false;
					
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
							+ "<span class=\"delete\">\r\n"
							+ "        <form name=\"PLC_delete_list\">\r\n"
							+ "            <img class=\"delete_icon\" src=\"https://popcat.click/twitter-card.jpg\" width=\"50\">\r\n"
							+ "            <img class=\"delete_icon2 hidden\" src=\"https://play-lh.googleusercontent.com/ID5wHCs0FsgS018pX0e0My5z3u4cBG7dAYAr2owB9gwylWaNZTJ0pWAKl9It7ys5iEM\" width=\"50\">\r\n"
							+ "            <div style=\"font-size: 12px; text-align: center;\">\uC0AD\uC81C\uD558\uAE30</div>\r\n"
							+ "            <input type=\"hidden\" name=\"res.PL_title\" value=\"YoGiSeo JAVA CODE JJaGi\">\r\n"
							+ "        </form>\r\n"
							+ "    </span>"							
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
//				PL_listNumber = rs.getInt("LISTNUMBER");
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
				}
			}
			
			if(noList == true)
			{
				out.println("<div class='noList'>등록된 곡이 없습니다. 곡을 추가해주세요."
						+ "<a href='genre'>"
						+ "<button type='button' class='add_btn'>\uCD94\uAC00\uD558\uAE30</button></div>"
						+ "</a>");
			}
			
			out.println
			("</div><script>\r\n"
					+ "        window.onload = function()\r\n"
					+ "        {\r\n"
					+ "            document.querySelector(\"img.delete_icon\").addEventListener(\"mouseover\", ()=>\r\n"
					+ "            {\r\n"
					+ "                document.querySelector(\"img.delete_icon\").classList.toggle(\"hidden\");\r\n"
					+ "                document.querySelector(\"img.delete_icon2\").classList.toggle(\"hidden\");\r\n"
					+ "            });\r\n"
					+ "    \r\n"
					+ "            document.querySelector(\"img.delete_icon\").addEventListener(\"mouseout\", ()=>\r\n"
					+ "            {\r\n"
					+ "                document.querySelector(\"img.delete_icon\").classList.toggle(\"hidden\");\r\n"
					+ "                document.querySelector(\"img.delete_icon2\").classList.toggle(\"hidden\");\r\n"
					+ "            });\r\n"
					+ "    \r\n"
					+ "            document.querySelector(\"span.delete\").addEventListener('click', ()=>\r\n"
					+ "            {\r\n"
					+ "                if(confirm(\"\uC815\uB9D0\uB85C \uD574\uB2F9 \uD50C\uB808\uC774 \uB9AC\uC2A4\uD2B8\uB97C \uC0AD\uC81C\uD558\uACA0\uC2B5\uB2C8\uAE4C?\") )\r\n"
					+ "                {\r\n"
					+ "                    function fn_deleteList()\r\n"
					+ "                    {\r\n"
					+ "                        PLC_delete_list.method='get';\r\n"
					+ "                        PLC_delete_list.action='pl';\r\n"
					+ "                        PLC_delete_list.submit();\r\n"
					+ "                    }\r\n"
					+ "    \r\n"
					+ "                    fn_deleteList();\r\n"
					+ "                }\r\n"
					+ "            });\r\n"
					+ "        }\r\n"
					+ "    </script>");
			
			out.println("</body></html>");
			
			pstmt.close();
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
