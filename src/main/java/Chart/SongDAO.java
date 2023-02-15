package Chart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import javafood_DTO.login_DTO;
import javafood_DTO.song_DTO;

public class SongDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	//DB접속
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
	
	//listsong값이 null인 메소드 생성
	public List<song_DTO> listsong(){
		List<song_DTO> list = listsong(null);
		return list;
	}
	//listsong 초기화 후 query문으로 값들 불러와서 출력
	public List<song_DTO> listsong(String _songname){
		List<song_DTO> list = new ArrayList<song_DTO>();
		
		try {
			this.con = dataFactory.getConnection();
			
			   //song1 table과 좋아요+조회수 합산 나타내주는 table 합쳐서 출력(famous 변수)
			String query = " SELECT RANK() OVER (ORDER BY FAMOUS desc) AS RANKING, a.* FROM ( SELECT (HITS *1) + (LIKES * 1.5) AS FAMOUS, s.* FROM song1 s ) a ";
			   		 
			   		  
			   		
			   //query문 확인용	 
			   System.out.println(query);
			   
			   pstmt = this.con.prepareStatement(query);
			   ResultSet rs = pstmt.executeQuery();
			   
			   while(rs.next()) {
				   String songnumber = rs.getString("songnumber");
				   String ranking = rs.getString("ranking");
				   String famous = rs.getString("famous");
				   String songname = rs.getString("songname");
				   String artistname = rs.getString("artistname");
				   String bygenre = rs.getString("bygenre");
				   String hits = rs.getString("hits");
				   String likes = rs.getString("likes");
				   String playtime = rs.getString("playtime");
				   
				   
				   
				   song_DTO vo = new song_DTO();
				   vo.setSongnumber(songnumber);
				   vo.setRanking(ranking);
				   vo.setFamous(famous);
				   vo.setSongname(songname);
				   vo.setArtistname(artistname);
				   vo.setBygenre(bygenre);
				   vo.setHits(hits);
				   vo.setLikes(likes);
				   vo.setPlaytime(playtime);
				   
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
	
//	//노래 추가
//	public void addSong(vod vo) {
//		try {
//			String songname = vo.getSongname();
//			String artistname = vo.getArtistname();
//			String link = vo.getLink();
//			
//			con = dataFactory.getConnection();
//			
//			String query = " insert into song";
//			query 		+= " (songname, artistname, link)"; 
//			query 		+= " values (?, ?, ?)";
//			
//			pstmt = con.prepareStatement(query);
//			
//			pstmt.setString(1, songname);
//			pstmt.setString(2, artistname);
//			pstmt.setString(3, link);
//			
//			int result = pstmt.executeUpdate();
//			
//			System.out.println("excuteUpdate 결과 : "+ result);
//			
//			pstmt.close();
//			con.close();
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	//노래 지움(to do : 메소드 수정하여 삭제 기능 만들기)
//	public void delSong(String songname) {
//		
//		try {
//			// DB 접속
//			con = dataFactory.getConnection();
//			
//			// SQL 준비
//			String query = " delete from song";
//			query += 	   " where songname = ?";
//			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, songname);
//			
//			// SQL 실행
//			int result = pstmt.executeUpdate();
//			// 실행 결과 활용
//			System.out.println("삭제 결과 : "+ result);
//			
//			pstmt.close();
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
//	//노래 업데이트(제목 수정등)
//	public void updateSong(vod vo) {
//		try {
//			String songnumber = vo.getSongnumber();
//			String songname = vo.getSongname();
//			String artistname = vo.getArtistname();
//			System.out.println("songnumber" + songnumber + "songname"+ songname +", artistname : "+ artistname);
//			
//			// db 접속
//			con = dataFactory.getConnection();
//			
//			//곡 제목 업데이트
//			String query = " UPDATE song ";
//			query += 	   " SET songname = ?";
//			query += 	   " 	,artistname = ?";
//			query += 	   " WHERE songnumber = ?";
//			
//			pstmt = con.prepareStatement(query);
//			
//			pstmt.setString(1, songnumber);
//			pstmt.setString(2, artistname);
//			pstmt.setString(3, songname);
//
//			// SQL 실행
//			int result = pstmt.executeUpdate();
//			System.out.println("excuteUpdate 결과 : "+ result);
//			
//			pstmt.close();
//			con.close();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	
	//노래 리스트
	public void songlist(song_DTO vo) {
		try {
			this.con = dataFactory.getConnection();
			
			String songnumber = vo.getSongnumber();
			String ranking = vo.getRanking();
			String famous = vo.getFamous();
			String songname = vo.getSongname();
			String artistname = vo.getArtistname();
			String bygenre = vo.getBygenre();
			String hits = vo.getHits();
			String likes = vo.getLikes();
			String playtime = vo.getPlaytime();
			
			
			
			String query = " SELECT RANK() OVER (ORDER BY FAMOUS desc) AS RANKING, a.* FROM ( SELECT (HITS *1) + (LIKES * 1.5) AS FAMOUS, s.* FROM song1 s ) a ";
			
			System.out.println("query" + query);
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, songnumber);
			pstmt.setString(2, ranking);
			pstmt.setString(3, famous);
			pstmt.setString(4, songname);
			pstmt.setString(5, artistname);
			pstmt.setString(6, bygenre);
			pstmt.setString(7, hits);
			pstmt.setString(8, likes);
			pstmt.setString(9, playtime);
			
			
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
	

