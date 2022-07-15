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
	t_expenseDTO dto = null;

	// DB ���� �޼ҵ�
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
	}//db_conn ��
	
	// DB ���� �޼ҵ�
	public void db_close() {
		
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}//db_close ��
	
	
	// �Ϸ� ���� �������� �޼ҵ�
	public ArrayList<t_expenseDTO> bringDayPrice() {
		
		ArrayList<t_expenseDTO> list = new ArrayList<t_expenseDTO>();
		
		db_conn();
		
		try {// sqp�� ���� ����(user_id=? �� ��ü�ؾ� ��)
			String sql = "select * from t_expense where user_id='test' and exp_date=to_char(sysdate)";
			psmt = conn.prepareStatement(sql);
			//psmt.setString(0, dto.getUser_id());
			
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
		
	}// bringDayPrice ��
	
	
	// �ֺ� ���� ������ �������� �޼ҵ� - �̿ϼ�
	public ArrayList<t_expenseDTO> bringWeekPrice() {
		
		ArrayList<t_expenseDTO> WList = new ArrayList<t_expenseDTO>();
		db_conn();
		
		try {//sql�� ���� ����
			String sql = "select * from t_expense where ";
			psmt = conn.prepareStatement(sql);
			//psmt.setString(0, dto.getUser_id());
			//psmt.setString(1, dto.getExp_date());
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int price = rs.getInt("exp_price");
				String category = rs. getString("exp_category");
				String date = rs.getString("exp_date");
				String user_id = rs.getString("user_id");
				
				dto = new t_expenseDTO(price, category, date, user_id);
				
				WList.add(dto);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
		}
		return WList;
	} // bringWeekPrice ��
	

	
	
}
