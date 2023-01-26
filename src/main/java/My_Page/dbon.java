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
import javax.websocket.Session;

import org.apache.el.parser.AstFalse;
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
	public List<vod> session(String login) {
		List<vod> list = new ArrayList<vod>();
		try {
			ResultSet rs = this.dataFactory.getConnection().prepareStatement("SELECT *  FROM login WHERE ID = '"+login+"'").executeQuery();
			vod vo = new vod();
			rs.next();
			vo.setId(rs.getString("id"));
			vo.setPw(rs.getString("pwd"));
			vo.setNic(rs.getString("nic"));
			vo.setPn(rs.getString("pn"));
			vo.setPhone(rs.getString("phone"));
			vo.setEmail(rs.getString("email"));
			vo.setHome(rs.getString("home"));
			vo.setMyimg(rs.getString("img"));
			list.add(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<vod>listID(){
		List<vod> list = new ArrayList<vod>();
		try {
			con=this.dataFactory.getConnection();
			this.pstmt = con.prepareStatement("SELECT * FROM login");
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				vod vo = new vod();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pwd"));
				vo.setNic(rs.getString("nic"));
				vo.setPn(rs.getString("pn"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
				vo.setHome(rs.getString("home"));
				vo.setMyimg(rs.getString("img"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void addId(vod vo) {
		try {
			con = this.dataFactory.getConnection();
			pstmt = con.prepareStatement("insert into login values('"+vo.getId()+"','"+vo.getPw()+"','"+vo.getNic()+"','"+vo.getPn()+"','"+vo.getPhone()+"','"+vo.getEmail()+"',null)");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<vod> list () {
		List<vod> list = new ArrayList<vod>();
		try {
			con = this.dataFactory.getConnection();
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
				vo.setPlayTime(rs.getString("playtime"));

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
			con = this.dataFactory.getConnection();
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
	public void like(String i) {
		try {
			con=this.dataFactory.getConnection();
			this.pstmt = con.prepareStatement("SELECT LIKES  FROM SONG WHERE SONGNUMBER ="+i);
			ResultSet rs = this.pstmt.executeQuery();
			rs.next();
			vod vo = new vod();
			vo.setLikes(rs.getString("likes"));
			int a = Integer.parseInt(vo.getLikes())+1;
			System.out.println(a);
			this.pstmt = con.prepareStatement("UPDATE SONG SET LIKES = "+a+" WHERE SONGNUMBER = "+i);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				vo.setPlayTime(rs.getString("playtime"));
				list.add(vo);
			}
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
