package My_Page;

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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class dbon {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public dbon() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env"); 
			dataFactory = (DataSource) envContext.lookup("jdbc1/oracle2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<vod> list () {
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
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String link1(vod list) {
		String st= (String)list.getLink().split("=")[1];
		return st ;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<vod> Search(String option, String text) {
		List<vod> list = new ArrayList<>();
		try {
			con = dataFactory.getConnection();
			if("man".equals(option)) pstmt = con.prepareStatement("SELECT * FROM SONG WHERE ARTISTNAME  LIKE '%"+text+"%'");
			else if("sing".equals(option)) pstmt = con.prepareStatement("SELECT * FROM SONG WHERE SONGNAME  LIKE '%"+text+"%'");
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
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<vod> getGenre (String a) {
		List<vod> list = new ArrayList<>();
		
		
		try {
			con = dataFactory.getConnection();
			String genre = " SELECT * FROM  song";
			genre += " where bygenre = ?";
			pstmt = con.prepareStatement (genre);
			pstmt.setString(1, a);
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
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
