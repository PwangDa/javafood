package Chart;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import My_Page.vod;
import My_Page.dbon;

public class SongDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	
	public SongDAO(){
		Context ctx;
		try {
			ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc1/oracle2"); 
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<vod> listsong(){
		List<vod> list = listsong(null);
		return list;
	}
	public List<vod> listsong(String _songname){
		List<vod> list = new ArrayList<vod>();
		
		try {
			this.con = dataFactory.getConnection();
			
			   
			   String query = "SELECT * FROM SONG";
			   		 
			   System.out.println(query);
			   
			   pstmt = this.con.prepareStatement(query);
			   ResultSet rs = pstmt.executeQuery();
			   
			   while(rs.next()) {
				   String songnumber = rs.getString("songnumber");
				   String ranking = rs.getString("ranking");
				   String songname = rs.getString("songname");
				   String artistname = rs.getString("artistname");
				   String bygenre = rs.getString("bygenre");
				   String hits = rs.getString("hits");
				   String likes = rs.getString("likes");
				 //id당 클릭 조회수를 나타내야해서변수 생성되면 해당 변수명으로 추가
//				   String id = rs.getString("id");
				   
				   
				   
				   vod vo = new vod();
				   vo.setSongnumber(songnumber);
				   vo.setRanking(ranking);
				   vo.setSongname(songname);
				   vo.setArtistname(artistname);
				   vo.setBygenre(bygenre);
				   vo.setHits(hits);
				   vo.setLikes(likes);
				 //id당 클릭 조회수를 나타내야해서변수 생성되면 해당 변수명으로 추가
//				   vo.setId(id);
				   
				   list.add(vo);
			   }
			   
			   rs.close();
			   pstmt.close();
			   con.close();
			   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	//노래 추가
	public void addSong(vod vo) {
		try {
			String songname = vo.getSongname();
			String artistname = vo.getArtistname();
			
			con = dataFactory.getConnection();
			
			String query = " insert into song";
			query 		+= " (songname, artistname)"; 
			query 		+= " values (?, ?)";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, songname);
			pstmt.setString(2, artistname);
			
			int result = pstmt.executeUpdate();
			
			System.out.println("excuteUpdate 결과 : "+ result);
			
			pstmt.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//노래 지움
	public void delSong(String songname) {
		
		try {
			// DB 접속
			con = dataFactory.getConnection();
			
			// SQL 준비
			String query = " delete from song";
			query += 	   " where songname = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, songname);
			
			// SQL 실행
			int result = pstmt.executeUpdate();
			// 실행 결과 활용
			System.out.println("삭제 결과 : "+ result);
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//노래 업데이트
	public void updateSong(vod vo) {
		try {
			String songnumber = vo.getSongnumber();
			String songname = vo.getSongname();
			String artistname = vo.getArtistname();
			System.out.println("songnumber" + songnumber + "songname"+ songname +", artistname : "+ artistname);
			
			// db 접속
			con = dataFactory.getConnection();
			
			//곡 제목 업데이트
			String query = " UPDATE song ";
			query += 	   " SET songname = ?";
			query += 	   " 	,artistname = ?";
			query += 	   " WHERE songnumber = ?";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, songnumber);
			pstmt.setString(2, artistname);
			pstmt.setString(3, songname);

			// SQL 실행
			int result = pstmt.executeUpdate();
			System.out.println("excuteUpdate 결과 : "+ result);
			
			pstmt.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//노래 리스트
	public void songlist(vod vo) {
		try {
			this.con = dataFactory.getConnection();
			
			String songnumber = vo.getSongnumber();
			String ranking = vo.getRanking();
			String songname = vo.getSongname();
			String artistname = vo.getArtistname();
			String bygenre = vo.getBygenre();
			String hits = vo.getHits();
			String likes = vo.getLikes();
			//id당 클릭 조회수를 나타내야해서변수 생성되면 해당 변수명으로 추가
//			String id = vo.getId();
			
			
			String query = "SELECT * FROM SONG";
			
			System.out.println("query" + query);
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, songnumber);
			pstmt.setString(2, ranking);
			pstmt.setString(3, songname);
			pstmt.setString(4, artistname);
			pstmt.setString(5, bygenre);
			pstmt.setString(6, hits);
			pstmt.setString(7, likes);
			//id당 클릭 조회수를 나타내야해서변수 생성되면 해당 변수명으로 추가
//			pstmt.setString(8, id);
			
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
	

