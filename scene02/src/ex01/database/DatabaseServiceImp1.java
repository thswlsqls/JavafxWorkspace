package ex01.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex01.memberdto.memberDTO;

public class DatabaseServiceImp1 implements DatabaseService {
	
	// 210.108.48.214:1521:ex	
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	String id = "java01";  //jsp
	String pwd = "1234";
	
	public DatabaseServiceImp1() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int saveMember(memberDTO dto) {
		
		String sql = "insert into member (id, pw, name, gender, age, hobby) "
				+ "values(?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3,  dto.getName());
			ps.setInt(4,  dto.getGender());
			ps.setString(5, dto.getPw());
			ps.setInt(6,  dto.getHobby());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}	
	public String loginCheck(String userId) {
		
		String sql = "select pw from member where id =' "+userId+" ' ";

		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getString("pw");	
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	};
	
}
