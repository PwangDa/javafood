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

public class dbon {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	public dbon() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env"); 
			dataFactory = (DataSource) envContext.lookup("jdbc1/oracle2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
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
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<vod> ballade () {
		List<vod> list = new ArrayList<>();
		
		
		try {
			con = dataFactory.getConnection();
			String genre = " SELECT * FROM  song";
			genre += " where bygenre = '발라드'";
			pstmt = con.prepareStatement (genre);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vod vo = new vod();
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setSongname(rs.getString("songname"));
				vo.setSongnumber(rs.getString("songnumber"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<vod> dance () {
		List<vod> list = new ArrayList<>();
		
		
		try {
			con = dataFactory.getConnection();
			String genre = " SELECT * FROM  song";
			genre += " where bygenre = '댄스'";
			pstmt = con.prepareStatement (genre);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vod vo = new vod();
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setSongname(rs.getString("songname"));
				vo.setSongnumber(rs.getString("songnumber"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<vod> pop () {
		List<vod> list = new ArrayList<>();
		
		
		try {
			con = dataFactory.getConnection();
			String genre = " SELECT * FROM  song";
			genre += " where bygenre = 'pop'";
			pstmt = con.prepareStatement (genre);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vod vo = new vod();
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setSongname(rs.getString("songname"));
				vo.setSongnumber(rs.getString("songnumber"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<vod> rnb () {
		List<vod> list = new ArrayList<>();
		
		
		try {
			con = dataFactory.getConnection();
			String genre = " SELECT * FROM  song";
			genre += " where bygenre = 'R&B'";
			pstmt = con.prepareStatement (genre);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vod vo = new vod();
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setSongname(rs.getString("songname"));
				vo.setSongnumber(rs.getString("songnumber"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<vod> indy () {
		List<vod> list = new ArrayList<>();
		
		
		try {
			con = dataFactory.getConnection();
			String genre = " SELECT * FROM  song";
			genre += " where bygenre = '인디'";
			pstmt = con.prepareStatement (genre);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vod vo = new vod();
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setSongname(rs.getString("songname"));
				vo.setSongnumber(rs.getString("songnumber"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<vod> trot () {
		List<vod> list = new ArrayList<>();
		
		
		try {
			con = dataFactory.getConnection();
			String genre = " SELECT * FROM  song";
			genre += " where bygenre = '트로트'";
			pstmt = con.prepareStatement (genre);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vod vo = new vod();
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setSongname(rs.getString("songname"));
				vo.setSongnumber(rs.getString("songnumber"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
