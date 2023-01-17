package My_Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class aas {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public aas() {
		
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env"); // JNDI 사용을 위한 설정
			dataFactory = (DataSource) envContext.lookup("jdbc1/oracle2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	public void ass(){
		
		String id;
		String pw;
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM  LLL");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getString("id"));
			System.out.println(rs.getString("pwd"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
