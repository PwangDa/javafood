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

public class SongDAO {
	
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	public SongDAO() {
		
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc1/oracle2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
		
public List<vod> chart(String songnumber){
		
		List<vod> list = new ArrayList<vod>();
		
		try {
			this.con = dataFactory.getConnection();
			
			String query = "select * from song";
				   query += " order by likes";
				   
			System.out.println(query);
			
			pstmt = this.con.prepareStatement(query);
			pstmt.setString(1, songnumber);
				
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				String number = rs.getString("songnumber");
				String artistname = rs.getString("artistname");
				String songname = rs.getString("songname");
				String bygenre = rs.getString("bygenre");
				String hits = rs.getString("hits");
				String likes = rs.getString("likes");
				String link = rs.getString("link");
				String ranking = rs.getString("ranking");
				
				vod song = new vod();
				song.setSongnumber(number);
				song.setArtistname(artistname);
				song.setSongname(songname);
				song.setBygenre(bygenre);
				song.setHits(hits);
				song.setLikes(likes);
				song.setLink(link);
				song.setRanking(ranking);
				
				list.add(song);
			}
			rs.close();
			this.pstmt.close();
			this.con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
public void addMember(vod vo) {
	try {
		String number = vo.getSongnumber();
		String artistname = vo.getArtistname();
		String songname = vo.getSongname();
		String bygenre = vo.getBygenre();
		String hits = vo.getHits();
		String likes = vo.getLikes();
		String link = vo.getLink();
		String ranking = vo.getRanking();
		
		// DB 접속
		con = dataFactory.getConnection();
		
		// SQL 준비
		String query = " insert into song";
		query 		+= " (songnumber, artistname, songname, bygenre, hits, likes, link, ranking)"; 
		query 		+= " values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, number);
		pstmt.setString(2, artistname);
		pstmt.setString(3, songname);
		pstmt.setString(4, bygenre);
		pstmt.setString(5, hits);
		pstmt.setString(6, likes);
		pstmt.setString(7, link);
		pstmt.setString(8, ranking);
		
		// SQL 실행
		int result = pstmt.executeUpdate();
		
		// SQL 실행 결과 활용
		System.out.println("excuteUpdate 결과 : "+ result);
		
		pstmt.close();
		con.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public void delMember(String artistname) {
	
	try {
		// DB 접속
		con = dataFactory.getConnection();
		
		// SQL 준비
		String query = " delete from song";
		query += 	   " where artistname = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, artistname);
		
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

public void updateMember(vod vo) {
	try {
		String number = vo.getSongnumber();
		String artistname = vo.getArtistname();
		String songname = vo.getSongname();
		String bygenre = vo.getBygenre();
		String hits = vo.getHits();
		String likes = vo.getLikes();
		String link = vo.getLink();
		String ranking = vo.getRanking();
		System.out.println("songnumber : "+ number +", artistname : "+ artistname + "songname : " + songname + "bygenre : " + bygenre + "hits : " + hits + "likes : " + likes + "link : " + link + "ranking : " + ranking );
		
		// db 접속
		con = dataFactory.getConnection();
		
		// SQL 준비
		
		String query = " UPDATE song ";
		query += 	   " SET songnumber = ?";
		query += 	   " 	,artistname = ?";
		query += 	   " 	,songname = ?";
		query += 	   " 	,bygenre = ?";
		query += 	   " 	,hits = ?";
		query += 	   " 	,likes = ?";
		query += 	   " 	,link = ?";
		query += 	   " 	,ranking = ?";
		query += 	   " WHERE songname = ?";
		
		pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, number);
		pstmt.setString(2, artistname);
		pstmt.setString(3, songname);
		pstmt.setString(4, bygenre);
		pstmt.setString(5, hits);
		pstmt.setString(6, likes);
		pstmt.setString(7, link);
		pstmt.setString(8, ranking);

		// SQL 실행
		int result = pstmt.executeUpdate();
		System.out.println("excuteUpdate 결과 : "+ result);
		
		pstmt.close();
		con.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public vod getMember(String songnumber){
	vod vo = new vod();
	
	try {
		this.con = dataFactory.getConnection();
		
		String query = "select * from song ";
		query 		+= " where songnumber = ?";
		System.out.println(query);
		
		pstmt = this.con.prepareStatement(query);
		pstmt.setString(1, songnumber);
		
		ResultSet rs = pstmt.executeQuery();
//		System.out.println("rs : "+ rs);
//		System.out.println("rs.next() : "+ rs.next());
//		System.out.println("rs.getString(id) : "+ rs.getString("id"));
//		if(rs.next()) {
//			
//		}
		// 어차피 한줄만 있거나 한줄도 없더라도 while로 해결할 수 있다
		while(rs.next()) {
			String id = rs.getString("id");
			System.out.println("id : "+ id);
			
			String number = rs.getString("songnumber");
			String artistname = rs.getString("artistname");
			String songname = rs.getString("songname");
			String bygenre = rs.getString("bygenre");
			String hits = rs.getString("hits");
			String likes = rs.getString("likes");
			String link = rs.getString("link");
			String ranking = rs.getString("ranking");
			
			vo.setSongnumber(number);
			vo.setArtistname(artistname);
			vo.setSongname(songname);
			vo.setBygenre(bygenre);
			vo.setHits(hits);
			vo.setLikes(likes);
			vo.setLink(link);
			vo.setRanking(ranking);
			
		}
		
		rs.close();
		this.pstmt.close();
		this.con.close();
		
	}catch (Exception e) {
		e.printStackTrace();
	}

	return vo;
	
}

}
	

