package SecondProject;

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
import album.info.AlbumVO;
import comment.CommentVO;

public class JavaFood_DAO {
///////////////////////////////////////////////////////////////////////////////////
	//필드
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
///////////////////////////////////////////////////////////////////////////////////
	//DB접속
	public JavaFood_DAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env"); 
			dataFactory = (DataSource) envContext.lookup("jdbc1/oracle2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//특정 아이디에 노래 조회수 증가
	public void addhit(String id, String songnumber) {
		int s = (Integer.parseInt(songnumber))+1;
		try {
			this.con = this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("SELECT * FROM songhit WHERE ID = '"+id+"'");
			ResultSet rs = this.pstmt.executeQuery();
			List list = new ArrayList();
			while(rs.next()) {
				list.add(rs.getString("songnumber"));
}
			rs.close();
			int q =0;
			for(int i=0; i<list.size(); i++) {
				int a = Integer.parseInt((String) list.get(i));
				if(a==s) {
					q++;
					break;
				}
			}
			if(q==0) {
				try {
					this.pstmt = this.con.prepareStatement("insert into songhit values('"+id+"', 0,'"+s+"')");
					this.pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.pstmt = this.con.prepareStatement("SELECT * FROM songhit WHERE ID = '"+id+"' AND SONGNUMBER  = '"+s+"'");
			ResultSet rs1 = this.pstmt.executeQuery();
			rs1.next();
			int a = rs1.getInt("hit")+1;
			rs1.close();
			this.pstmt.close();
			this.pstmt = this.con.prepareStatement("UPDATE songhit SET HIT = '"+a+"' WHERE ID = '"+id+"' AND SONGNUMBER = '"+s+"'");
			this.pstmt.executeUpdate();
			rs1.close();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//특정 아이디에 조회수, 노래번호 가져오기
	public List<vod> uresong(String id){
		List<vod> list = new ArrayList<vod>();
		try {
			this.con=this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("SELECT * FROM songhit s JOIN song s2 \n"
					+ "ON s.SONGNUMBER =s2.SONGNUMBER \n"
					+ "WHERE s.ID = '"+id+"' ORDER BY s.HIT DESC");
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()) {
				vod vo = new vod();
				vo.setHits(rs.getString("hit"));
				vo.setSongnumber(rs.getString("songnumber"));
				vo.setArtistname(rs.getString("artistname"));
				vo.setLikes(rs.getString("likes"));
				vo.setSongname(rs.getString("songname"));
				vo.setLink(rs.getString("link"));
				list.add(vo);
			}
			rs.close();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//세션
	public List<vod> session(String login) {
		List<vod> list = new ArrayList<vod>();
		try {
			this.con=this.dataFactory.getConnection();
			ResultSet rs = con.prepareStatement("SELECT *  FROM login WHERE ID = '"+login+"'").executeQuery();
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
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//아이디 리스트
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
			rs.close();
			this.pstmt.close();
			this.con.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//회원가입
	public void addId(vod vo) {
		try {
			this.con = this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("insert into login values('"+vo.getId()+"','"+vo.getPw()+"','"+vo.getNic()+"','"+vo.getPn()+"','"+vo.getPhone()+"','"+vo.getEmail()+"',null,null)");
			this.pstmt.executeUpdate();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//	song리스트
	public List<vod> list () {
		List<vod> list = new ArrayList<vod>();
		try {
			this.con = this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("SELECT * FROM  song");
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
			rs.close();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//리스트 나누기
	public String link1(vod list) {
		String st= (String)list.getLink().split("=")[1];
		return st ;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//서치
	public List<vod> Search(String option, String text) {
		List<vod> list = new ArrayList<>();
		try {
			this.con = this.dataFactory.getConnection();
			if("man".equals(option)) this.pstmt = this.con.prepareStatement("SELECT * FROM SONG WHERE ARTISTNAME  LIKE '%"+text+"%'");
			else if("sing".equals(option)) this.pstmt = this.con.prepareStatement("SELECT * FROM SONG WHERE SONGNAME  LIKE '%"+text+"%'");
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
			rs.close();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//좋아요
	public void like(String i) {
		try {
			this.con=this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("SELECT LIKES  FROM SONG WHERE SONGNUMBER ="+i);
			ResultSet rs = this.pstmt.executeQuery();
			rs.next();
			vod vo = new vod();
			vo.setLikes(rs.getString("likes"));
			int a = Integer.parseInt(vo.getLikes())+1;
			System.out.println(a);
			this.pstmt = con.prepareStatement("UPDATE SONG SET LIKES = "+a+" WHERE SONGNUMBER = "+i);
			this.pstmt.executeUpdate();
			this.con.close();
			this.pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//genre 가져오기
	public List<vod> getGenre (String a) {
		List<vod> list = new ArrayList<>();
		
		
		try {
			this.con = this.dataFactory.getConnection();
			String genre = " SELECT * FROM  song";
			genre += " where bygenre = ?";
			this.pstmt = con.prepareStatement (genre);
			this.pstmt.setString(1, a);
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
			this.pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//앨범수록곡 리스트 출력하는 메소드
	//앨범명 클릭 후 그 앨범의 수록곡을 출력하는 메소드용
	public List<AlbumVO> listAlbum(String num){
		List<AlbumVO> listAlbum = new ArrayList<AlbumVO>();
		
		try {
			this.con = dataFactory.getConnection();
			
			String query = "SELECT * FROM ALBUM a";
			query += " LEFT JOIN INTOALBUM i ON (a.ALBUM_NUM = i.ALBUM_NUM)";
			//		query += " WHERE a.ALBUM_NUM = 1";
			query += " WHERE a.ALBUM_NUM = ?";
			
			System.out.println("num : "+num);
			pstmt = this.con.prepareStatement(query);
			pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String cover = rs.getString("album_cover");
				String alname = rs.getString("album_name");
				String into = rs.getString("album_into");
				String artist = rs.getString("artist");
				
				String music_num = rs.getString("music_num");
				String music_name = rs.getString("music_name");
				String music_link = rs.getString("music_link");
				String music_time = rs.getString("music_time");
				
				AlbumVO albumVO = new AlbumVO();
				
				albumVO.setAlbum_cover(cover);
				albumVO.setAlbum_name(alname);
				albumVO.setAlbum_into(into);
				albumVO.setArtist(artist);
				
				albumVO.setMusic_num(music_num);
				albumVO.setMusic_name(music_name);
				albumVO.setMusic_link(music_link);
				albumVO.setMusic_time(music_time);
				
				listAlbum.add(albumVO);
				
			}
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listAlbum;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 아티스트 페이지에서
//앨범수록곡 리스트 출력하는 메소드 >artistinfo.jsp에서 쓰이는 메소드
	public List<AlbumVO> listAlbum(){
		List<AlbumVO> listAlbum = new ArrayList<AlbumVO>();
		
		try {
			this.con = dataFactory.getConnection();
			
			String query = "SELECT * FROM ALBUM a";
			query += " LEFT JOIN INTOALBUM i ON (a.ALBUM_NUM = i.ALBUM_NUM)";
//		query += " WHERE a.ALBUM_NUM = 1";
			query += " WHERE i.MUSIC_NUM = 1";
			
//		System.out.println("num : "+num);
			pstmt = this.con.prepareStatement(query);
//		pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String alNum = rs.getString("album_num");
				String cover = rs.getString("album_cover");
				String alname = rs.getString("album_name");
				String into = rs.getString("album_into");
				String artist = rs.getString("artist");
				
				String music_num = rs.getString("music_num");
				String music_name = rs.getString("music_name");
				String music_link = rs.getString("music_link");
				String music_time = rs.getString("music_time");
				
				AlbumVO albumVO = new AlbumVO();
				
				albumVO.setAlbum_num(alNum);
				albumVO.setAlbum_cover(cover);
				albumVO.setAlbum_name(alname);
				albumVO.setAlbum_into(into);
				albumVO.setArtist(artist);
				
				albumVO.setMusic_num(music_num);
				albumVO.setMusic_name(music_name);
				albumVO.setMusic_link(music_link);
				albumVO.setMusic_time(music_time);
				
				listAlbum.add(albumVO);
				
			}
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listAlbum;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//댓글 등록 구현
	public void addcomment(CommentVO commentVO) {
		try {
			this.con = dataFactory.getConnection();
			
			String id = commentVO.getComment_id();
			String cont = commentVO.getComment_cont();
			
			String query = "insert into comment_c";
			query += "(comment_num, comment_id, comment_cont)";
			query += " values(comm_c.nextval, ?, ?)"; //띄어쓰기 필수!
			
			System.out.println("query check" + query);
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, cont);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//댓글 리스트 읽기 구현
	public List<CommentVO> listComment(){
		List<CommentVO> list = new ArrayList<CommentVO>();
		
		try {
			this.con = dataFactory.getConnection();
			
			   //가져올 테이블 선택(불러오기)
			   String query = "select * from comment_c";
			   query += " ORDER BY COMMENT_DATE DESC";
			   System.out.println(query);
			   
			   pstmt = this.con.prepareStatement(query);
			   ResultSet rs = pstmt.executeQuery();
			   
			   while(rs.next()) {
				   String id = rs.getString("comment_id");
				   String cont = rs.getString("comment_cont");
				   Date date = rs.getDate("comment_date");
				   
				   CommentVO vo = new CommentVO();
				   vo.setComment_id(id);
				   vo.setComment_cont(cont);
				   vo.setComment_Date(date);
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//댓글삭제버튼 구현
	public void delcomment(String id) {
		try {
			this.con = dataFactory.getConnection();
			
			String query = " delete from comment_c";
			query +=       " where comment_id = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			System.out.println("삭제결과 확인"+id);
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//listsong값이 null인 메소드 생성
	public List<vod> listsong(){
		List<vod> list = listsong(null);
		return list;
	}
	//listsong 초기화 후 query문으로 값들 불러와서 출력
	public List<vod> listsong(String _songname){
		List<vod> list = new ArrayList<vod>();
		
		try {
			this.con = dataFactory.getConnection();
			
			   //기존 song table과 좋아요+조회수 합산 나타내주는 table 합쳐서 출력(rank2 변수)
			String query = " SELECT s.*,songname, (HITS *1) + (LIKES * 1.5) AS RANK2 FROM song s  ORDER BY RANK2 DESC";
			   		 
			   		  
			   		
			   //query문 확인용	 
			   System.out.println(query);
			   
			   pstmt = this.con.prepareStatement(query);
			   ResultSet rs = pstmt.executeQuery();
			   
			   while(rs.next()) {
				   String songnumber = rs.getString("songnumber");
				   String rank2 = rs.getString("rank2");
				   String ranking = rs.getString("ranking");
				   String songname = rs.getString("songname");
				   String artistname = rs.getString("artistname");
				   String bygenre = rs.getString("bygenre");
				   String hits = rs.getString("hits");
				   String likes = rs.getString("likes");
				   String playtime = rs.getString("playtime");
				   
				   
				   
				   vod vo = new vod();
				   vo.setSongnumber(songnumber);
				   vo.setRank2(rank2);
				   vo.setRanking(ranking);
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void songlist(vod vo) {
		try {
			this.con = dataFactory.getConnection();
			
			String songnumber = vo.getSongnumber();
			String rank2 = vo.getRank2();
			String ranking = vo.getRanking();
			String songname = vo.getSongname();
			String artistname = vo.getArtistname();
			String bygenre = vo.getBygenre();
			String hits = vo.getHits();
			String likes = vo.getLikes();
			String playtime = vo.getPlaytime();
			
			
			
			String query = " SELECT s.*,songname, (HITS *1) + (LIKES * 1.5) AS RANK2 FROM song s  ORDER BY RANK2 DESC";
			
			System.out.println("query" + query);
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, songnumber);
			pstmt.setString(2, rank2);
			pstmt.setString(3, ranking);
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

