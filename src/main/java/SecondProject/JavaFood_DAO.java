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

import javafood_DTO.AlbumDTO;
import javafood_DTO.CommentDTO;
import javafood_DTO.PlayListDTO;
import javafood_DTO.login_DTO;
import javafood_DTO.song_DTO;

	//필드
public class JavaFood_DAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
///////////////////////////////////////////////////////////////////////////////////
	/**
	 * DB접속시도
	 */
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
////		노래추가 제목 엘범 이미지
//	/**
//	 * @param i : song1 의 추가할 노래번호
//	 * @param b : song1 의 노래 제목
//	 * @param c : song1 의 앨범 이름
//	 * @param d : song1 의 노래의 이미지 주소
//	 */
//	public void addsong1(String b,String c,String d) {
//		try {
//			this.con = this.dataFactory.getConnection();
//			this.con.prepareStatement("INSERT INTO Genre VALUES (genre_s.nextval, 'a', '"+b+"', 'https://www.youtube.com/results?search_query="+b+"', '"+c+"', 0, 0, NULL, NULL, '"+d+"')").executeUpdate();
//			this.con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	public void addsong1(int i ,String b,String c,String d) {
//		try {
//			this.con = this.dataFactory.getConnection();
//			this.con.prepareStatement("INSERT INTO song1 VALUES ('"+i+"', 'a', '"+b+"', 'https://www.youtube.com/results?search_query="+b+"', '"+c+"', 0, 0, 'top100',null , '"+d+"',null,null)").executeUpdate();
//			this.con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////		노래추가 가수
//	/**
//	 * @param a : song1 에 추가할 가수이름
//	 * @param i : song1 의 불러올 노래번호
//	 */
//	public void addsong2(String a,int i) {
//		try {
//			this.con = this.dataFactory.getConnection();
//			this.con.prepareStatement("UPDATE GENRE SET ARTISTNAME ='"+a+"' WHERE SONGNUMBER ="+i).executeUpdate();
//			this.con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 특정 아이디에 노래 조회수 증가
	 * @param id : id값에 String 세션 아이디값을 넣어주세요
	 * @param songnumber : 조회수를 증가시킬 노래의 번호를 입력해주세요.
	 */
	public void addhit(String id, String songnumber) {
		int s = (Integer.parseInt(songnumber));
		try {
			this.con = this.dataFactory.getConnection();
			try {
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
			} catch (Exception e) {
				System.out.println("빈아이디");
				this.con.prepareStatement("insert into songhit values('"+id+"','0','"+songnumber+"');").executeUpdate();
				System.out.println("아이디값 생성");
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
	/**
	 * genre목록에 조회수 증가
	 * @param songnumber : GENRE 목록의 조회수를 증가시킬 노래의 번호를 입력해주세요.
	 */
	public void song1addhit(String songnumber) {
		int s = (Integer.parseInt(songnumber));
		try {
			this.con = this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("SELECT * FROM GENRE WHERE songnumber="+songnumber+"");
			ResultSet rs = this.pstmt.executeQuery();
			rs.next();
			int a = (Integer.parseInt(rs.getString("HITS"))+1);
			rs.close();
			this.pstmt.close();
			this.con.close();
			this.con = this.dataFactory.getConnection();
			this.con.prepareStatement("UPDATE GENRE SET HITS = '"+a+"' WHERE SONGNUMBER = '"+songnumber+"'").executeUpdate();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 특정 아이디에 조회수, 노래번호 가져오기
	 * @param id : 세션값의 String 아이디 값을 넣어주세요.
	 * @return list : 아이디 값으로 조회한 song1목록을 리턴해줍니다.
	 */
	public List<song_DTO> uresong(String id){
		List<song_DTO> list = new ArrayList<song_DTO>();
		try {
			this.con=this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("SELECT * FROM songhit s \r\n"
					+ "JOIN GENRE g ON s.SONGNUMBER =g.SONGNUMBER \r\n"
					+ "WHERE s.ID = '"+id+"' ORDER BY s.HIT DESC");
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()) {
				song_DTO vo = new song_DTO();
				vo.setSongnumber(rs.getString("songnumber"));
				vo.setLink(rs.getString("link"));
				vo.setImglink(rs.getString("imagelink"));
				vo.setSongname(rs.getString("songname"));
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setPlaytime(rs.getString("playtime"));
				vo.setAlbum(rs.getString("album_add"));
				vo.setAlbum_name(rs.getString("album_name"));
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
	/**
	 * 세션에 저장된 아이디의 정보를 불러옵니다.
	 * @param login : 세션에 저장된 아이디 값을 넣어주세요.
	 * @return list : 아이디 값으로 조회한 아이디 정보를 리턴해줍니다.
	 */
	public List<login_DTO> session(String login) {
		List<login_DTO> list = new ArrayList<login_DTO>();
		try {
			this.con=this.dataFactory.getConnection();
			ResultSet rs = con.prepareStatement("SELECT *  FROM login WHERE ID = '"+login+"'").executeQuery();
			login_DTO vo = new login_DTO();
			rs.next();
			vo.setId(rs.getString("id"));
			vo.setPw(rs.getString("pwd"));
			vo.setNic(rs.getString("nic"));

			vo.setPn1(rs.getString("pn").split("-")[0]);
			vo.setPn(rs.getString("pn"));
			
			vo.setPhone(rs.getString("phone"));
			vo.setEmail(rs.getString("email"));
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
	/**
	 * 아이디 리스트
	 * @return list : 회원정보를 리턴해줍니다.
	 */
	public List<login_DTO>listID(){
		List<login_DTO> list = new ArrayList<login_DTO>();
		try {
			con=this.dataFactory.getConnection();
			this.pstmt = con.prepareStatement("SELECT * FROM login");
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				login_DTO vo = new login_DTO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pwd"));
				vo.setNic(rs.getString("nic"));
				vo.setPn(rs.getString("pn"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
				vo.setMyimg(rs.getString("img"));
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
	/**
	 * 회원가입
	 * @param vo : 가입할 회원정보 DTO를 넣어줍니다.
	 */
	public void addId(login_DTO vo) {
		try {
			this.con = this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("insert into login values('"+vo.getId()+"','"+vo.getPw()+"','"+vo.getNic()+"','"+vo.getPn()+"','"+vo.getPhone()+"','"+vo.getEmail()+"',null)");
			this.pstmt.executeUpdate();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 회원정보 수정
	 * @param vo : 수정할 회원정보 DTO를 넣어줍니다.
	 */
	public void removeId(login_DTO vo) {
		try {
			this.con = this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("UPDATE login SET pwd = '"+vo.getPw()+"', nic = '"+vo.getNic()+"', phone='"+vo.getPhone()+"', email='"+vo.getEmail()+"', img='"+vo.getMyimg()+"' WHERE id = '"+vo.getId()+"'");
			this.pstmt.executeUpdate();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 회원탈퇴
	 * @param vo : 수정할 회원정보 DTO를 넣어줍니다.
	 */
	public String outId(String id) {
		String ab="1";
		try {
			this.con = this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("DELETE FROM LOGIN  WHERE id = '"+id+"'");
			this.pstmt.executeUpdate();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			ab="0";
		}return ab;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * song리스트
	 * @return list : song1의 목록을 list로 가져옵니다.
	 */
	public List<song_DTO> list () {
		List<song_DTO> list = new ArrayList<song_DTO>();
		try {
			this.con = this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("SELECT * FROM  Genre");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				song_DTO vo = new song_DTO();
				vo.setSongnumber(rs.getString("songnumber"));
				vo.setLink(rs.getString("link"));
				vo.setImglink(rs.getString("imagelink"));
				vo.setSongname(rs.getString("songname"));
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setPlaytime(rs.getString("playtime"));
				vo.setAlbum(rs.getString("album_add"));
				list.add(vo);
			}
			rs.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 검색해서 특정값 넣어주면 특정값관련된 것만 불러오기
	 * @param option : 검색기록의 옵션값을 넣어줍니다.
	 * @param text : 검색 내용을 넣어줍니다.
	 * @return list : 검색된 내용의 song1의 목록을 list로 가져옵니다.
	 */
	public List<song_DTO> Search(String option, String text) {
		List<song_DTO> list = new ArrayList<>();
		try {
			this.con = this.dataFactory.getConnection();
			if("man".equals(option)) this.pstmt = this.con.prepareStatement("SELECT * FROM Genre WHERE ARTISTNAME  LIKE '%"+text+"%'");
			else if("sing".equals(option)) this.pstmt = this.con.prepareStatement("SELECT * FROM Genre WHERE SONGNAME  LIKE '%"+text+"%'");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				song_DTO vo = new song_DTO();
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setImglink(rs.getString("imglink"));
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
			list=null;
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 특정한 번호의 음악의 좋아요 증가
	 * @param i : song1의 음악 번호를 넣어줍니다.
	 */
	public void like(String i) {
		try {
			this.con=this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("SELECT LIKES  FROM Genre WHERE SONGNUMBER ="+i);
			ResultSet rs = this.pstmt.executeQuery();
			rs.next();
			song_DTO vo = new song_DTO();
			vo.setLikes(rs.getString("likes"));
			int a = Integer.parseInt(vo.getLikes())+1;
			System.out.println(a);
			this.pstmt = con.prepareStatement("UPDATE Genre SET LIKES = "+a+" WHERE SONGNUMBER = "+i);
			this.pstmt.executeUpdate();
			rs.close();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 장르별로 노래 가져오기
	 * @param a : song1음악의 장르를 입력해 주세요.
	 * @return list : song1의 장르별로 음악list를 가져옵니다.
	 */
//	public List<song_DTO> getGenre (String a) {
//		List<song_DTO> list = new ArrayList<>();
//		try {
//			this.con = this.dataFactory.getConnection();
//			String genre = " SELECT * FROM  Genre";
//			genre += " where bygenre = ?";
//			genre += " ORDER BY songnumber";
//			this.pstmt = con.prepareStatement (genre);
//			this.pstmt.setString(1, a);
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				song_DTO vo = new song_DTO();
//				vo.setArtistname(rs.getString("artistname"));
//				vo.setBygenre(rs.getString("bygenre"));
//				vo.setHits(rs.getString("hits"));
//				vo.setLikes(rs.getString("likes"));
//				vo.setSongname(rs.getString("songname"));
//				vo.setSongnumber(rs.getString("songnumber"));
//				vo.setLink(rs.getString("link"));
//				vo.setPlaytime(rs.getString("playtime"));
//				vo.setAlbum(rs.getString("album_name"));
//				vo.setImglink(rs.getString("imagelink"));
//				list.add(vo);
//			}
//			rs.close();
//			this.pstmt.close();
//			this.con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 장르별로 노래 가져오기 -페이징
	 * @param a : Genre음악의 장르를 입력해 주세요.
	 * @return list : Genre의 장르별로 음악list를 가져옵니다.
	 */
	public List<song_DTO> getGenre (String a, int start, int end) {
		List<song_DTO> list = new ArrayList<>();
		try {
			this.con = this.dataFactory.getConnection();
			String genre = " SELECT * FROM (";
			genre += " SELECT rownum AS rnum, genre.* FROM (";
			genre += " SELECT * FROM genre ";
			genre += " WHERE BYGENRE = ?";
			genre += " ORDER BY SONGNUMBER";
			genre += " ) genre";
			genre += " )";
			genre += " WHERE rnum >= ? AND rnum<= ?";
			this.pstmt = con.prepareStatement (genre);
			this.pstmt.setString(1, a); 
			this.pstmt.setInt(2, start);
			this.pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				song_DTO vo = new song_DTO();
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setSongname(rs.getString("songname"));
				vo.setSongnumber(rs.getString("songnumber"));
				vo.setLink(rs.getString("link"));
				vo.setPlaytime(rs.getString("playtime"));
				vo.setAlbum(rs.getString("album_name"));
				vo.setImglink(rs.getString("imagelink"));
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
/**
* 장르별로 노래 가져오기 -페이징
* @param a : db에 가지고있는 노래 수량 확인.
* @return list : db에 가지고있는 노래 수량을 가져옴.
*/
	public int pagetotal () {
		List<song_DTO> list = new ArrayList<>();
		int totalcnt = 0;
		try {
			this.con = this.dataFactory.getConnection();
			String genre = " SELECT count(*) cnt FROM  Genre";
			this.pstmt = con.prepareStatement (genre);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				totalcnt = rs.getInt("cnt");
			}
			rs.close();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return totalcnt;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 최신음악 노래 가져오기
	 * @param a : song1음악의 가져오기
	 * @return list : song1의 음악list를 가져옵니다.최신음악.
	 */
	public List<song_DTO> popular_music () {
		List<song_DTO> list = new ArrayList<>();
		try {
			this.con = this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement (" SELECT * FROM  song1");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				song_DTO vo = new song_DTO();
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setSongname(rs.getString("songname"));
				vo.setSongnumber(rs.getString("songnumber"));
				vo.setLink(rs.getString("link"));
				vo.setPlaytime(rs.getString("playtime"));
				vo.setAlbum(rs.getString("album_name"));
				vo.setImglink(rs.getString("imagelink"));
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
/**
* 특정한 번호의 음악의 좋아요 증가
* @param i : song1의 음악 번호를 넣어줍니다.
*/
	public void like_music(String i) {
		try {
			this.con=this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("SELECT LIKES  FROM song1 WHERE SONGNUMBER ="+i);
			ResultSet rs = this.pstmt.executeQuery();
			rs.next();
			song_DTO vo = new song_DTO();
			vo.setLikes(rs.getString("likes"));
			int a = Integer.parseInt(vo.getLikes())+1;
			System.out.println(a);
			this.pstmt = con.prepareStatement("UPDATE song1 SET LIKES = "+a+" WHERE SONGNUMBER = "+i);
			this.pstmt.executeUpdate();
			rs.close();
			this.pstmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//앨범수록곡 리스트 출력하는 메소드
	//앨범명 클릭 후 그 앨범의 수록곡을 출력하는 메소드용
	/**
	 * 다영:앨범 클릭 후 그 앨범의 수록곡을 출려하는 메소드
	 * @param num : 앨범이름 클릭하면 해당하는 숫자 넘어옴 
	 * @return list :  해당 앨범의 음악list를 가져옵니다.
	 */
	public List<AlbumDTO> listAlbum(String num){
		List<AlbumDTO> listAlbum = new ArrayList<AlbumDTO>();
		
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
				String alNum = rs.getString("album_num");
				String cover = rs.getString("album_cover");
				String alname = rs.getString("album_name");
				String into = rs.getString("album_into");
//				String artist = rs.getString("artist");
				String artistname = rs.getString("artistname");
				String artistimg = rs.getString("artist_img");
				String info = rs.getString("artist_info");
				
				String music_num = rs.getString("music_num");
				String music_name = rs.getString("music_name");
				String music_link = rs.getString("music_link");
				String music_time = rs.getString("music_time");
				
				AlbumDTO albumDTO = new AlbumDTO();
				
				albumDTO.setAlbum_num(alNum);
				albumDTO.setAlbum_cover(cover);
				albumDTO.setAlbum_name(alname);
				albumDTO.setAlbum_into(into);
				albumDTO.setArtist_info(info);
				albumDTO.setArtist_img(artistimg);
				albumDTO.setArtistname(artistname);
				
				albumDTO.setMusic_num(music_num);
				albumDTO.setMusic_name(music_name);
				albumDTO.setMusic_link(music_link);
				albumDTO.setMusic_time(music_time);
				
				listAlbum.add(albumDTO);
				
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listAlbum;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//앨범수록곡 리스트 출력하는 메소드
// 아티스트 페이지에서
//앨범수록곡 리스트 출력하는 메소드 >artistinfo.jsp에서 쓰이는 메소드
	/**
	 * 다영:아티스트페이지 들어가면 각 앨범의 대표곡만 나오게 하는 메소드
	 * @return list :  각 앨범의 1번음악만 list를 가져옵니다.
	 */
	public List<AlbumDTO> listAlbum(){
		List<AlbumDTO> listAlbum = new ArrayList<AlbumDTO>();
		
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
//				String artist = rs.getString("artist");
				String artistname = rs.getString("artistname");
				String artistimg = rs.getString("artist_img");
				String info = rs.getString("artist_info");
				
				String music_num = rs.getString("music_num");
				String music_name = rs.getString("music_name");
				String music_link = rs.getString("music_link");
				String music_time = rs.getString("music_time");
				
				AlbumDTO albumDTO = new AlbumDTO();
				
				albumDTO.setAlbum_num(alNum);
				albumDTO.setAlbum_cover(cover);
				albumDTO.setAlbum_name(alname);
				albumDTO.setAlbum_into(into);
				albumDTO.setArtist_info(info);
				albumDTO.setArtist_img(artistimg);
				albumDTO.setArtistname(artistname);
				
				albumDTO.setMusic_num(music_num);
				albumDTO.setMusic_name(music_name);
				albumDTO.setMusic_link(music_link);
				albumDTO.setMusic_time(music_time);
				
				listAlbum.add(albumDTO);
				
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listAlbum;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//댓글 등록 구현
	/**
	 * 다영: 댓글 등록 메소드 insert into
	 * @param commentDTO : commentDTO를 전달인자로 받음
	 */
	public void addcomment(CommentDTO commentDTO) {
		try {
			this.con = dataFactory.getConnection();
			System.out.println("댓글등록DAO 접속");
			String id = commentDTO.getComment_id();
			String cont = commentDTO.getComment_cont();
			
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
	
	//답글 달 용으로 만든 메소드
	/**
	 * 다영:(이걸로 쓸 것!)댓글 등록 메소드 insert into~
	 * @param commentDTO : commentDTO를 전달인자로 받음
	 */
	public void insertComment(CommentDTO commentDTO) {
		try {
			this.con = dataFactory.getConnection();
			System.out.println("댓글등록DAO 접속");
			int parentNO = commentDTO.getParentNO();
			String id = commentDTO.getComment_id();
			String cont = commentDTO.getComment_cont();
			int artist_num = commentDTO.getArtistlist_num();
			String artist_name = commentDTO.getArtistname();
			
			String query = "insert into comment_com";
			query += "(articleno, parentno, comment_num, comment_id, comment_cont, artistlist_num, artistname)";
			query += " values(comment_com_seq.nextval, ?, comment_com_seq1.nextval, ?, ?, ?, ?)"; //띄어쓰기 필수!
			
			System.out.println("query check" + query);
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, parentNO);
			pstmt.setString(2, id);
			pstmt.setString(3, cont);
			pstmt.setInt(4, artist_num);
			pstmt.setString(5, artist_name);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//댓글 리스트 읽기 구현
	public List<CommentDTO> listComment(){
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		System.out.println("댓글리스트DAO 접속");
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
				   
				   CommentDTO vo = new CommentDTO();
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
	//댓글의 대댓글까지 모든 리스트 읽기 구현
	/**
	 * 다영:(이걸로 쓸 것!)부모댓글과 자식대댓글 달리면 이것도 리스트에 넣어 읽는 메소드
	 * @param commentDTO : commentDTO를 전달인자로 받음
	 * @return list :  댓글과 그 대댓글이 있으면 그것도 리스트에서 가져옴
	 */

		public List<CommentDTO> allComment(String name){
			List<CommentDTO> list = new ArrayList<CommentDTO>();
			System.out.println("모든댓글리스트DAO 접속");
			System.out.println(name+" 아티스트의 댓글을 조회합니다.");
			try {
				this.con = dataFactory.getConnection();
				
				   //가져올 테이블 선택(불러오기)
				String query = "SELECT LEVEL, articleNO, parentNO, comment_num, comment_id, comment_cont, comment_date \n";
				query += " from comment_com \n";    
				query += " WHERE artistname= ? \n"; //전달인자로 num받아서 그것만 보이게?
				query += " START WITH parentNO=0 \n";    
				query += " CONNECT BY PRIOR articleNO=parentNO \n";    
				query += " ORDER SIBLINGS BY articleNO DESC"; 
				   
				   pstmt = this.con.prepareStatement(query);
				   pstmt.setString(1, name);
				   ResultSet rs = pstmt.executeQuery();
				   
				   System.out.println("query :>>> \n"+query);
				   
				   while(rs.next()) {
						int level = rs.getInt("level");
						int articleNO = rs.getInt("articleno");
						int parentNO = rs.getInt("parentno");
					   String id = rs.getString("comment_id");
					   String cont = rs.getString("comment_cont");
					   Date date = rs.getDate("comment_date");
					   
					   CommentDTO vo = new CommentDTO();
					   vo.setLevel(level);
					   vo.setArticleNO(articleNO);
					   vo.setParentNO(parentNO);
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
			System.out.println("댓글삭제DAO 접속");
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
	
	//댓글삭제 할 articleNO 조회
	/**
	 * 다영:(이걸로 쓸 것!)삭제할 댓글의 articleNO값을 알아내는 메소드[대댓글이 있으면 그것도 같이 불러옴]
	 * @param articleNO : 댓글의 articleNO를 값을 가져옴
	 */
	public List<Integer> selectRemoveComment(int articleNO) {
		List<Integer> articleNOList = new ArrayList<Integer>();
		try {
			this.con = dataFactory.getConnection();
			System.out.println("댓글삭제 할 no조회 접속");
			String query = "SELECT articleno FROM comment_com \n";
			query += " START WITH articleno = ? \n";
			query += " CONNECT BY PRIOR articleno = parentno";
			
			System.out.println("query : \n"+query);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			System.out.println("댓글번호 확인"+articleNO);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				articleNO = rs.getInt("articleNO");
				articleNOList.add(articleNO);		
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return articleNOList;
	}
	
	//삭제 댓글과 그 밑에 달린 댓글도 모두 삭제하게
	/**
	 * 다영 : (이걸로 쓸 것!)댓글 삭제 메소드(부모댓글을 삭제하면 그 아래 대댓글도 같이 삭제되게)
	 * @param articleNO : 댓글의 articleNO를 값을 가져옴
	 */
	public void deleteComment(int articleNO) {
		try {
			this.con= dataFactory.getConnection();
			System.out.println("댓글삭제 밑의 댓글도 삭제하게");
			String query = "DELETE FROM comment_com \n";
			query += " WHERE articleno IN (";
			query += " SELECT articleno FROM comment_com \n";
			query += " START WITH articleno = ? \n";
			query += " CONNECT BY PRIOR articleno = parentno )";
			
			System.out.println("query : \n"+query);
			pstmt = this.con.prepareStatement(query);
			pstmt.setInt(1, articleNO);	 
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 다영 : (삭제금지!)album_add와 artist_add 컬럼에 주소값 데이터 넣는 메소드
	 * @param articleNO : 댓글의 articleNO를 값을 가져옴
	 */
	public void url_add(String artist_add, String album_add, int songnumber) {
//		List li = new ArrayList();
		System.out.println("artist_add컬럼에 넣었습니다.");
		try {
			this.con = this.dataFactory.getConnection();
			this.con.prepareStatement("UPDATE GENRE SET album_add='"+album_add+"' WHERE SONGNUMBER ='"+songnumber+"'").executeUpdate();
			con.close();
			
			this.con = this.dataFactory.getConnection();
			this.con.prepareStatement("UPDATE GENRE SET artist_add='"+artist_add+"' WHERE SONGNUMBER ='"+songnumber+"'").executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 다영 : (삭제금지!)jsoup용: album_add와 artist_add 컬럼의 값을 가져오는 메소드
	 * @return list :  album_add와 artist_add 데이터가 들어있음
	 */
	public List<AlbumDTO> album_add(String num) {
		List<AlbumDTO> li = new ArrayList<AlbumDTO>();
		try {
			this.con = dataFactory.getConnection();
			
			String query = "SELECT * FROM GENRE";
			query += " WHERE SONGNUMBER = ?";
			
			System.out.println("query : "+query);
			pstmt = this.con.prepareStatement(query);
			pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();		
			
			while(rs.next()) {				
				String artistname = rs.getString("artistname");
				String album_cover = rs.getString("imagelink");
				String album_name = rs.getString("album_name");
				String album_url = rs.getString("album_add");
				String artist_url = rs.getString("artist_add");
				AlbumDTO dto = new AlbumDTO();
				dto.setArtistname(artistname);
				dto.setAlbum_cover(album_cover);
				dto.setAlbum_name(album_name);
				dto.setAlbum_add(album_url);
				dto.setArtist_add(artist_url);
				li.add(dto);
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//listsong값이 null인 메소드 생성(기본값)
	/*
	 * public List<login_DTO> listsong(){ List<login_DTO> list = null; return list;
	 * }
	 */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//listsong 초기화 후 query문으로 값들 불러와서 출력
	public List<song_DTO> listSong(){
		List<song_DTO> list = new ArrayList<song_DTO>();
		
		try {
			this.con = dataFactory.getConnection();
			
			   //기존 Genre table과 좋아요+조회수 합산 나타내주는 table 합쳐서 출력(famous 변수)
			String query = "SELECT * FROM (SELECT RANK() OVER (ORDER BY FAMOUS desc) AS RANKING, a.* FROM (SELECT (HITS *1) + (LIKES * 1.5) AS FAMOUS, s.* FROM Genre s) a) ORDER BY famous desc";
			   		 
			   		  
			   		
			   //query문 확인용	 
//			   System.out.println(query);
			   
			   pstmt = this.con.prepareStatement(query);
			   ResultSet rs = pstmt.executeQuery();
			   
			   while(rs.next()) {
				   String ranking = rs.getString("ranking");
				   String famous = rs.getString("famous");
				   String imglink = rs.getString("imagelink");
				   String songname = rs.getString("songname");
				   String artistname = rs.getString("artistname");
				   String bygenre = rs.getString("bygenre");
				   String hits = rs.getString("hits");
				   String likes = rs.getString("likes");
				   String playtime = rs.getString("playtime");
				   String songnumber = rs.getString("songnumber");
				   
//				   System.out.println("songnumber : "+songnumber);
				   // 재생 버튼 클릭 시 유튜브 검색
				   String link = rs.getString("link");
				   // 담기 변수는 아직 설정 x
				   String country = rs.getString("country");
				   String album_name = rs.getString("album_name");
				   
				   
				   
				   song_DTO vo = new song_DTO();
				   vo.setRanking(ranking);
				   vo.setFamous(famous);
				   vo.setImglink(imglink);
				   vo.setSongname(songname);
				   vo.setArtistname(artistname);
				   vo.setBygenre(bygenre);
				   vo.setHits(hits);
				   vo.setLikes(likes);
				   vo.setPlaytime(playtime);
				   vo.setLink(link);
				   vo.setCountry(country);
				   vo.setSongnumber(songnumber);
				   vo.setAlbum_name(album_name);
				   list.add(vo);
				   
//				   System.out.println("vo songnumber : "+vo.getSongnumber());
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
	//좋아요 + 조회수 합산하여 출력하는 메소드(setString 값들을 받아서 출력하는 메소드)
//	public void songlist(login_DTO vo) {
//		try {
//			this.con = dataFactory.getConnection();
//			
//			String songnumber = vo.getSongnumber();
//			String rank2 = vo.getRank2();
//			String ranking = vo.getRanking();
//			String songname = vo.getSongname();
//			String artistname = vo.getArtistname();
//			String bygenre = vo.getBygenre();
//			String hits = vo.getHits();
//			String likes = vo.getLikes();
//			String playtime = vo.getPlaytime();
//			
//			
//			
//			String query = " SELECT RANK() OVER (ORDER BY RANK2 desc) AS RANKING, a.* FROM ( SELECT (HITS *1) + (LIKES * 1.5) AS RANK2, s.* FROM song s ) a ";
//			
//			System.out.println("query" + query);
//			
//			pstmt = con.prepareStatement(query);
//			
//			pstmt.setString(1, songnumber);
//			pstmt.setString(2, ranking);
//			pstmt.setString(3, rank2);
//			pstmt.setString(4, songname);
//			pstmt.setString(5, artistname);
//			pstmt.setString(6, bygenre);
//			pstmt.setString(7, hits);
//			pstmt.setString(8, likes);
//			pstmt.setString(9, playtime);
//			
//			
//			
//			pstmt.executeUpdate();
//			
//			pstmt.close();
//			con.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 플레이 리스트를 추가하는 메서드 입니다.
	 * @param title : 플레이 리스트의 제목을 입력하세요.
	 * @param explain : 플레이 리스트의 설명을 입력하세요.
	 * @param id : 플레이 리스트 주인의 id를 입력하세요.
	 */
	public void addList(String title, String explain, String id)
	{
		//DTO에 접속하여 플레이 리스트 제목과 설명을 세팅하기
		PlayListDTO plDTO = new PlayListDTO();
		plDTO.setListTitle(title);
		plDTO.setListExplain(explain);
		plDTO.setId(id);
		
		String temp_title = plDTO.getListTitle();
		String temp_explain = plDTO.getListExplain();
		String temp_id = plDTO.getId();
		System.out.println("temp_title : " + temp_title); //확인용
		System.out.println("temp_explain : " + temp_explain); //확인용
		System.out.println("temp_id : " + temp_id); //확인용
		
		//플레이 리스트 추가 쿼리문 작성
		String add_query =
				"INSERT INTO playList(PL_ID, ID2, PL_Title, PL_Explain)"
				+ "VALUES(seq_PL_ID.nextval, ?, ?, ?)";
		
		//플레이 리스트 추가 쿼리 실행
		try
		{
			this.con = dataFactory.getConnection();
			
			pstmt = con.prepareStatement(add_query);
			pstmt.setString(1, temp_id);
			pstmt.setString(2, temp_title);
			pstmt.setString(3, temp_explain);
			pstmt.executeQuery();
			
			pstmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 플레이 리스트를 삭제하는 메서드 입니다.
	 * @param PL_ID : 플레이 리스트의 id를 입력하세요.
	 * @param id : 플레이 리스트 주인의 id를 입력하세요.
	 */
	public void deleteList(int pl_id, String id)
	{
		//플레이 리스트 내용 삭제 쿼리문 작성
		String del_query = 
				"DELETE FROM playList_content"
				+ " WHERE PL_ID = ?";
		
		//플레이 리스트 내용 삭제 쿼리 실행
		try
		{
			this.con = dataFactory.getConnection();
			
			pstmt = con.prepareStatement(del_query);
			pstmt.setInt(1, pl_id);
			pstmt.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		//플레이 리스트 삭제 쿼리문 작성
		del_query = 
				"DELETE FROM PLAYLIST"
				+ " WHERE PL_ID = ?"
				+ " AND ID2 = ?";
		
		//플레이 리스트 삭제 쿼리 실행
		try
		{
			this.con = dataFactory.getConnection();
			
			pstmt = con.prepareStatement(del_query);
			pstmt.setInt(1, pl_id);
			pstmt.setString(2, id);
			pstmt.executeQuery();
			
			pstmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 플레이 리스트를 불러옵니다.
	 * @param id : 플레이 리스트의 주인 id를 입력하세요.
	 * @param return : ArrayList가 return 됩니다.
	 */
	public List<PlayListDTO> loadPL(String id)
	{
		System.out.println("JavaFood_DAO의 loadPL 메서드 실행됨."); //확인용
		System.out.println("받은 id값 : " + id); //확인용
		
		
		List<PlayListDTO> playList = new ArrayList<PlayListDTO>();
		
		//쿼리문 작성
		String load_query = "SELECT * FROM playList"
				+ " WHERE ID2 = ?"
				+ " ORDER BY PL_ID DESC";
		
		//플레이 리스트 불러오기 쿼리 실행
		try
		{
			this.con = dataFactory.getConnection();
			
			pstmt = con.prepareStatement(load_query);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next() )
			{
				String temp_title = rs.getString("PL_TITLE");
				String temp_id = rs.getString("ID2");
				int temp_pl_id = rs.getInt("PL_ID");
				
				PlayListDTO plDTO = new PlayListDTO(temp_title, temp_id, temp_pl_id);
				
				playList.add(plDTO);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return playList;
	}


	public List<PlayListDTO> loadPL(String id, int start, int end)
	{
		System.out.println("JavaFood_DAO의 loadPL 메서드 실행됨."); //확인용
		System.out.println("받은 id값 : " + id); //확인용
		
		
		List<PlayListDTO> playList = new ArrayList<PlayListDTO>();
		
		//쿼리문 작성
		String load_query = "SELECT rownum as rnum, * FROM playList"
				+ " WHERE ID2 = ?"
				+ "	AND rnum >= ? AND rnum <= ?"
				+ " ORDER BY PL_ID DESC";
		
		//플레이 리스트 불러오기 쿼리 실행
		try
		{
			this.con = dataFactory.getConnection();
			
			pstmt = con.prepareStatement(load_query);
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next() )
			{
				String temp_title = rs.getString("PL_TITLE");
				String temp_id = rs.getString("ID2");
				int temp_pl_id = rs.getInt("PL_ID");
				
				PlayListDTO plDTO = new PlayListDTO(temp_title, temp_id, temp_pl_id);
				
				playList.add(plDTO);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return playList;
	}
	
	/**
	 * 플레이 리스트 페이지의 페이징 시스템을 만들기 위해 퀄럼 갯수를 세는 메서드 입니다.
	 * @param id : 플레이 리스트 주인의 id를 입력하세요.
	 * @return : playList의 퀄럼 갯수를 int로 return 합니다.
	 */
	public int pl_totalCount(String id)
	{
		int totalCount = 0;
		
		String countQuery = 
				"SELECT count(*) cnt FROM playList"
				+ "WHERE id = ?";
		
		try
		{
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(countQuery);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next() )
			{
				totalCount = rs.getInt("cnt");
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return totalCount;
	}
	
	/**
	 * 플레이 리스트 내의 곡을 삭제하는 메서드 입니다.
	 * @param PL_ID : 플레이 리스트의 아이디를 입력하세요.
	 * @param listNumber : 삭제할 곡의 플레이 리스트 번호를 입력하세요.
	 */
	public void doDeleteSong(int PL_ID, int listNumber)
	{
		//DTO에 접속하여 값 세팅하기
		PlayListDTO dto = new PlayListDTO();
		dto.setPl_id(PL_ID);
		dto.setListNumber(listNumber);
		
		int temp_PL_ID = dto.getPl_id();
		int temp_listNumber = dto.getListNumber();
		
		//쿼리문 작성
		String delSong_query = "DELETE FROM playList_Content"
				+ " WHERE ListNumber = ?"
				+ "	AND PL_ID = ?";
		
		//쿼리 실행
		try 
		{
			this.con = dataFactory.getConnection();
			pstmt = con.prepareStatement(delSong_query);
			pstmt.setInt(1, temp_listNumber);
			pstmt.setInt(2, temp_PL_ID);
			pstmt.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<PlayListDTO> loadPLC(int PL_ID, String id)
	{
		List<PlayListDTO> playListContent = new ArrayList<PlayListDTO>();
		
		//쿼리문 작성
		String loadList_query =
				"SELECT * FROM playList_Content plc"
				+ " JOIN playList pl ON (plc.PL_ID = pl.PL_ID)"
				+ " JOIN Song1 s ON (plc.songNumber = s.songNumber)"
				+ "	WHERE plc.PL_ID = ?"
				+ " ORDER BY listNumber";
		
		//쿼리 실행
		try
		{
			this.con = dataFactory.getConnection();
			pstmt = con.prepareStatement(loadList_query);
			pstmt.setInt(1, PL_ID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next() )
			{
				int temp_pl_id = rs.getInt("PL_ID");
				int temp_listNumber = rs.getInt("listNumber");
				String temp_songName = rs.getString("songName");
				String temp_plTitle = rs.getString("pl_title");
				String temp_plExplain = rs.getString("pl_explain");
				String temp_artistName = rs.getString("artistName");
				String temp_imgLink = rs.getString("imgLink");
				String temp_album = rs.getString("album");
				
				PlayListDTO playListDTO = 
						new PlayListDTO
						(
							temp_pl_id, 
							temp_listNumber, 
							temp_songName, 
							temp_plTitle, 
							temp_plExplain, 
							temp_artistName,
							temp_imgLink,
							temp_album
						);
				
				playListContent.add(playListDTO);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return playListContent;
	}
	
	/**
	 * 메인 페이지에서 쓰일 인기곡 리스트를 불러옵니다.
	 * @return : song1 테이블의 songNumber가 40이하인 곡인 곡들 40곡을 리스트로 리턴합니다.
	 */
	public List<song_DTO> mainList1 () {
		List<song_DTO> list = new ArrayList<song_DTO>();
		try {
			this.con = this.dataFactory.getConnection();
			this.pstmt = this.con.prepareStatement("SELECT * FROM  Song1 WHERE songNumber <= 40");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				song_DTO vo = new song_DTO();
				vo.setSongnumber(rs.getString("songnumber"));
				vo.setLink(rs.getString("link"));
				vo.setImglink(rs.getString("imageLink"));
				vo.setSongname(rs.getString("songname"));
				vo.setArtistname(rs.getString("artistname"));
				vo.setBygenre(rs.getString("bygenre"));
				vo.setHits(rs.getString("hits"));
				vo.setLikes(rs.getString("likes"));
				vo.setPlaytime(rs.getString("playtime"));
				vo.setAlbum(rs.getString("album_name"));
				list.add(vo);
			}
			rs.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}


