package comment;

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

public class CommentDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	//sql 불러오는 설정
	public CommentDAO(){
		Context ctx;
		try {
			ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/javafood"); 
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
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
	
	//댓글 리스트 읽기 구현
	public List<CommentVO> listComment(){
		List<CommentVO> list = new ArrayList<CommentVO>();
		
		try {
			this.con = dataFactory.getConnection();
			
			   //가져올 테이블 선택(불러오기)
			   String query = "select * from comment_c";
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
	
	
}
