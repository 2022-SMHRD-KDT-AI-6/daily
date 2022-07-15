package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class t_expenseDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// DB 연결 메소드
	public void db_conn() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_user = "cgi_8_0704_4";
			String db_pw = "smhrd4";
			
			conn = DriverManager.getConnection(url, db_user, db_pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//db_conn 끝
	
	// DB 종료 메소드
	public void db_close() {
		
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}//db_close 끝
	
	// 하루 가격 가져오는 메소드
	public ArrayList<t_expenseDTO> bringDayPrice() {
		
		ArrayList<t_expenseDTO> list = new ArrayList<t_expenseDTO>();
		t_expenseDTO dto = null;
		db_conn();
		
		try {
			String sql = "select * from t_expense where user_id = ? and exp_date = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getExp_date());
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int price = rs.getInt("exp_price");
				String category = rs.getString("exp_category");
				String user_id = rs.getString("user_id");
				
				dto = new t_expenseDTO(price, category, user_id);
				
				list.add(dto);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return list;
		
	}// bringDayPrice 끝
}
