//package My_Page;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import javax.websocket.Session;
//
//import org.apache.el.parser.AstFalse;
//
//import javafood_DTO.login_DTO;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public class dbon {
//	private Connection con;
//	private PreparedStatement pstmt;
//	private DataSource dataFactory;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public dbon() {
//		try {
//			Context ctx = new InitialContext();
//			Context envContext = (Context) ctx.lookup("java:/comp/env"); 
//			dataFactory = (DataSource) envContext.lookup("jdbc1/oracle2");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		//특정 아이디에 노래 조회수 증가
//	public void addhit(String id, String songnumber) {
//		int s = (Integer.parseInt(songnumber))+1;
//		try {
//			this.con = this.dataFactory.getConnection();
//			this.pstmt = this.con.prepareStatement("SELECT * FROM songhit WHERE ID = '"+id+"'");
//			ResultSet rs = this.pstmt.executeQuery();
//			List list = new ArrayList();
//			while(rs.next()) {
//				list.add(rs.getString("songnumber"));
//			}
//			rs.close();
//			int q =0;
//			for(int i=0; i<list.size(); i++) {
//				int a = Integer.parseInt((String) list.get(i));
//				if(a==s) {
//					q++;
//					break;
//				}
//			}
//			if(q==0) {
//				try {
//					this.pstmt = this.con.prepareStatement("insert into songhit values('"+id+"', 0,'"+s+"')");
//					this.pstmt.executeUpdate();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			this.pstmt = this.con.prepareStatement("SELECT * FROM songhit WHERE ID = '"+id+"' AND SONGNUMBER  = '"+s+"'");
//			ResultSet rs1 = this.pstmt.executeQuery();
//			rs1.next();
//			int a = rs1.getInt("hit")+1;
//			rs1.close();
//			this.pstmt.close();
//			this.pstmt = this.con.prepareStatement("UPDATE songhit SET HIT = '"+a+"' WHERE ID = '"+id+"' AND SONGNUMBER = '"+s+"'");
//			this.pstmt.executeUpdate();
//			this.pstmt.close();
//			this.con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	//특정 아이디에 조회수, 노래번호 가져오기
//	public List<login_DTO> uresong(String id){
//		List<login_DTO> list = new ArrayList<login_DTO>();
//		try {
//			this.con=this.dataFactory.getConnection();
//			this.pstmt = this.con.prepareStatement("SELECT * FROM songhit s JOIN song s2 \n"
//					+ "ON s.SONGNUMBER =s2.SONGNUMBER \n"
//					+ "WHERE s.ID = '"+id+"' ORDER BY s.HIT DESC");
//			ResultSet rs = this.pstmt.executeQuery();
//			while(rs.next()) {
//				login_DTO vo = new login_DTO();
//				vo.setHits(rs.getString("hit"));
//				vo.setSongnumber(rs.getString("songnumber"));
//				vo.setArtistname(rs.getString("artistname"));
//				vo.setLikes(rs.getString("likes"));
//				vo.setSongname(rs.getString("songname"));
//				vo.setLink(rs.getString("link"));
//				list.add(vo);
//			}
//			this.con.close();
//			this.pstmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public List<login_DTO> session(String login) {
//		List<login_DTO> list = new ArrayList<login_DTO>();
//		try {
//			ResultSet rs = this.dataFactory.getConnection().prepareStatement("SELECT *  FROM login WHERE ID = '"+login+"'").executeQuery();
//			login_DTO vo = new login_DTO();
//			rs.next();
//			vo.setId(rs.getString("id"));
//			vo.setPw(rs.getString("pwd"));
//			vo.setNic(rs.getString("nic"));
//			vo.setPn(rs.getString("pn"));
//			vo.setPhone(rs.getString("phone"));
//			vo.setEmail(rs.getString("email"));
//			vo.setHome(rs.getString("home"));
//			vo.setMyimg(rs.getString("img"));
//			list.add(vo);
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public List<login_DTO>listID(){
//		List<login_DTO> list = new ArrayList<login_DTO>();
//		try {
//			con=this.dataFactory.getConnection();
//			this.pstmt = con.prepareStatement("SELECT * FROM login");
//			ResultSet rs=this.pstmt.executeQuery();
//			while(rs.next()) {
//				login_DTO vo = new login_DTO();
//				vo.setId(rs.getString("id"));
//				vo.setPw(rs.getString("pwd"));
//				vo.setNic(rs.getString("nic"));
//				vo.setPn(rs.getString("pn"));
//				vo.setPhone(rs.getString("phone"));
//				vo.setEmail(rs.getString("email"));
//				vo.setHome(rs.getString("home"));
//				vo.setMyimg(rs.getString("img"));
//				list.add(vo);
//			}
//			this.con.close();
//			this.pstmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public void addId(login_DTO vo) {
//		try {
//			this.con = this.dataFactory.getConnection();
//			this.pstmt = this.con.prepareStatement("insert into login values('"+vo.getId()+"','"+vo.getPw()+"','"+vo.getNic()+"','"+vo.getPn()+"','"+vo.getPhone()+"','"+vo.getEmail()+"',null,null)");
//			this.pstmt.executeUpdate();
//			this.con.close();
//			this.pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public List<login_DTO> list () {
//		List<login_DTO> list = new ArrayList<login_DTO>();
//		try {
//			this.con = this.dataFactory.getConnection();
//			this.pstmt = this.con.prepareStatement("SELECT * FROM  song");
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				login_DTO vo = new login_DTO();
//				vo.setArtistname(rs.getString("artistname"));
//				vo.setBygenre(rs.getString("bygenre"));
//				vo.setHits(rs.getString("hits"));
//				vo.setLikes(rs.getString("likes"));
//				vo.setSongname(rs.getString("songname"));
//				vo.setSongnumber(rs.getString("songnumber"));
//				vo.setLink(rs.getString("link"));
//				vo.setPlayTime(rs.getString("playtime"));
//				list.add(vo);
//			}
//			this.con.close();
//			this.pstmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public String link1(login_DTO list) {
//		String st= (String)list.getLink().split("=")[1];
//		return st ;
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public List<login_DTO> Search(String option, String text) {
//		List<login_DTO> list = new ArrayList<>();
//		try {
//			this.con = this.dataFactory.getConnection();
//			if("man".equals(option)) this.pstmt = this.con.prepareStatement("SELECT * FROM SONG WHERE ARTISTNAME  LIKE '%"+text+"%'");
//			else if("sing".equals(option)) this.pstmt = this.con.prepareStatement("SELECT * FROM SONG WHERE SONGNAME  LIKE '%"+text+"%'");
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				login_DTO vo = new login_DTO();
//				vo.setArtistname(rs.getString("artistname"));
//				vo.setBygenre(rs.getString("bygenre"));
//				vo.setHits(rs.getString("hits"));
//				vo.setLikes(rs.getString("likes"));
//				vo.setSongname(rs.getString("songname"));
//				vo.setSongnumber(rs.getString("songnumber"));
//				vo.setLink(rs.getString("link"));
//				list.add(vo);
//			}
//			this.con.close();
//			this.pstmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public void like(String i) {
//		try {
//			this.con=this.dataFactory.getConnection();
//			this.pstmt = this.con.prepareStatement("SELECT LIKES  FROM SONG WHERE SONGNUMBER ="+i);
//			ResultSet rs = this.pstmt.executeQuery();
//			rs.next();
//			login_DTO vo = new login_DTO();
//			vo.setLikes(rs.getString("likes"));
//			int a = Integer.parseInt(vo.getLikes())+1;
//			System.out.println(a);
//			this.pstmt = con.prepareStatement("UPDATE SONG SET LIKES = "+a+" WHERE SONGNUMBER = "+i);
//			this.pstmt.executeUpdate();
//			this.con.close();
//			this.pstmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public List<login_DTO> getGenre (String a) {
//		List<login_DTO> list = new ArrayList<>();
//		
//		
//		try {
//			this.con = this.dataFactory.getConnection();
//			String genre = " SELECT * FROM  song";
//			genre += " where bygenre = ?";
//			this.pstmt = con.prepareStatement (genre);
//			this.pstmt.setString(1, a);
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				login_DTO vo = new login_DTO();
//				vo.setArtistname(rs.getString("artistname"));
//				vo.setBygenre(rs.getString("bygenre"));
//				vo.setHits(rs.getString("hits"));
//				vo.setLikes(rs.getString("likes"));
//				vo.setSongname(rs.getString("songname"));
//				vo.setSongnumber(rs.getString("songnumber"));
//				vo.setLink(rs.getString("link"));
//				vo.setPlayTime(rs.getString("playtime"));
//				list.add(vo);
//			}
//			this.con.close();
//			this.pstmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	
//}
