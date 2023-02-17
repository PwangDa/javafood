package album.info;

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

public class AlbumDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	//sql 불러오는 설정
	public AlbumDAO(){
//		Context ctx;
//		try {
//			ctx = new InitialContext();
//			Context envContext = (Context) ctx.lookup("java:/comp/env");
//			dataFactory = (DataSource)envContext.lookup("jdbc/javafood"); 
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
	}
	
	//앨범 넣는 메소드
	public void addAlbum(AlbumVO albumVO) {
		try {
			this.con = dataFactory.getConnection();
			
			String num = albumVO.getAlbum_num();
			String cover = albumVO.getAlbum_cover();
			String alname = albumVO.getAlbum_name();
			String into = albumVO.getAlbum_into();
			String artist_info = albumVO.getArtist_info();
			String artist_img = albumVO.getArtist_img();
			
			String query = "insert into NewJeans";
			query += "(album_num, album_cover, album_name, album_into, artist_info, artistname, artist_img)";
			query += " values(jeans.nextval, ?, ?, ?, 'NewJeans는 2022년 7월 22일에 데뷔한 대한민국의 5인조 걸 그룹으로, 소속사는 HYBE 산하의 레이블인 ADOR이다. SM 엔터테인먼트 디렉터 출신으로 HYBE에 영입된 민희진이 프로듀서로 나서서 발굴한 걸그룹이다. 2022년 8월 18일 《엠카운트다운》에서 데뷔 3주만에 첫 1위를 차지하였다.', 'NewJeans', 'https://img.gqkorea.co.kr/gq/2022/10/style_634e7c680d723.jpg')";
			
			System.out.println("query check" + query);
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, cover);
			pstmt.setString(2, alname);
			pstmt.setString(3, into);
//			pstmt.setString(4, artist_info);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//그 앨범의 수록곡 넣는 메소드
	public void addMusic(AlbumVO albumVO) {
		try {
			this.con = dataFactory.getConnection();
			
			String key = albumVO.getAlbum_key();
			String mnum = albumVO.getMusic_num();
			String mname = albumVO.getMusic_name();
			String alname= albumVO.getAlbum_name();
			String link = albumVO.getMusic_link();
			String time = albumVO.getMusic_time();
			
			String query = "insert into newjeansAlbum";
			query += "(album_num, album_name, music_num, music_name, music_link, music_time)";
			query += " values(3, NewJeans 1st EP 'New Jeans', 1, ?, ?, ?)";
			
			System.out.println("query check \n" + query);
			
			pstmt = con.prepareStatement(query);
			
//			pstmt.setString(1, albumname);
			System.out.println(mname);
			pstmt.setString(1, mname);
			pstmt.setString(2, link);
			pstmt.setString(3, time);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//앨범수록곡 리스트 출력하는 메소드
	public List<AlbumVO> listAlbum(String num){
		List<AlbumVO> listAlbum = new ArrayList<AlbumVO>();
		
		try {
			this.con = dataFactory.getConnection();
			
			String query = "SELECT * FROM ALBUM a";
			query += " LEFT JOIN INTOALBUM i ON (a.ALBUM_NUM = i.ALBUM_NUM)";
//			query += " WHERE a.ALBUM_NUM = 1";
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
	//앨범수록곡 리스트 출력하는 메소드
	public List<AlbumVO> listAlbum(){
		List<AlbumVO> listAlbum = new ArrayList<AlbumVO>();
		
		try {
			this.con = dataFactory.getConnection();
			
			String query = "SELECT * FROM ALBUM a";
			query += " LEFT JOIN INTOALBUM i ON (a.ALBUM_NUM = i.ALBUM_NUM)";
//			query += " WHERE a.ALBUM_NUM = 1";
			query += " WHERE i.MUSIC_NUM = 1";
			
//			System.out.println("num : "+num);
			pstmt = this.con.prepareStatement(query);
//			pstmt.setString(1, num);
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
	
}
