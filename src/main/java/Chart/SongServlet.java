package Chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import My_Page.dbon;
import My_Page.vod;

/**
 * Servlet implementation class SongServlet
 */
@WebServlet("/song")
public class SongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static PreparedStatement pstmt;
	static Connection con;
	static DataSource dataFactory;
	
	public void dbon() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env"); 
			dataFactory = (DataSource) envContext.lookup("jdbc1/oracle2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	static List<vod> list () {
		List<vod> list = new ArrayList<>();
		
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM  song");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vod vo = new vod();
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setSongname(rs.getString("songname"));
				vo.setSongnumber(rs.getString("songnumber"));
				vo.setLink(rs.getString("link"));
				vo.setRanking(rs.getString("ranking"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
			//한글깨짐 방지
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8;");
			
			
			
			System.out.println("doPost 실행");
			
			//DB연결
			try {
				dbon db = new dbon();
				dbon();
				this.con = dataFactory.getConnection();
				
				//DB 테이블 정보 가져오기
				String query = "select * from song";
					   query += " where songnumber=?";
				
				
				List<vod> list = new ArrayList();
				
				//값 넣기
				pstmt = this.con.prepareStatement(query);
				//전달해서 해당 값을 뽑아오기
				pstmt.setString(1, "3");
				//to do : for문 안에 list get 값을 넣어서 자동화 시키기
//				for(int i=0; i<list.size(); i++) {
//					pstmt.setString(1,db.list().get(0).getSongnumber() );
//				}
				
				//결과 반환
				int result = pstmt.executeUpdate();
				System.out.println("result : " + result);
				
				ResultSet rs = pstmt.executeQuery();
//				((ServletRequest) request).getParameter("");
				
				
				
					
						
					//정보 가져오기
					while(rs.next()) {
							vod song = new vod();
							
							String songnumber = rs.getString("songnumber");
							String artistname = rs.getString("artistname");
							String songname = rs.getString("songname");
							System.out.println("artistname : "+ artistname);
							System.out.println("songname : "+ songname);
							String link = rs.getString("link");
							String bygenre = rs.getString("bygenre");
							String hits = rs.getString("hits");
							String likes = rs.getString("likes");
							String ranking = rs.getString("ranking");
							
//							System.out.println("songnumber : " + songnumber);
//							System.out.println("artistname : " + artistname);
//							System.out.println("songname : " + songname);
//							System.out.println("link : " + link);
//							System.out.println("bygenre : " + bygenre);
//							System.out.println("hits : " + hits);
//							System.out.println("likes : " + likes);
//							System.out.println("ranking : " + ranking);
							
							
							PrintWriter out = response.getWriter();
							
							
						}
					
							
				rs.close();
				this.pstmt.close();
				this.con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			}
	}


	

