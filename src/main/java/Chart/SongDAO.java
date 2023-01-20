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
	
	
	public void songlist(vod vo) {
		try {
			this.con = dataFactory.getConnection();
			
			String songname = vo.getSongname();
			String artistname = vo.getArtistname();
			
			String query = "SELECT * FROM SONG";
			
			System.out.println("query" + query);
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, songname);
			pstmt.setString(2, artistname);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<vod> listsong(){
		List<vod> list = new ArrayList<vod>();
		
		try {
			this.con = dataFactory.getConnection();
			
			   
			   String query = "SELECT * FROM SONG";
			   System.out.println(query);
			   
			   pstmt = this.con.prepareStatement(query);
			   ResultSet rs = pstmt.executeQuery();
			   
			   while(rs.next()) {
				   String songname = rs.getString("songname");
				   String artistname = rs.getString("artistname");
				   
				   
				   vod vo = new vod();
				   vo.setSongname(songname);
				   vo.setArtistname(artistname);
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
	
}
	

