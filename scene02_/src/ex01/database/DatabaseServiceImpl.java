package ex01.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import ex01.memberdto.MemberDTO;

public class DatabaseServiceImpl implements DatabaseService{
	//String url = "jdbc:oracle:thin:@210.108.48.214:1521:xe";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "java01"; //jsp
	String pwd = "1234";  //1234
	
	public DatabaseServiceImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int saveMember( MemberDTO dto ) {
		String sql = 
			"insert into member(id,pw,name,gender,age,hobby) values(?,?,?,?,?,?)";
		int result = 0;
		try {
			
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setInt(4, dto.getGender());
			ps.setString(5, dto.getAge());
			ps.setInt(6, dto.getHobby());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String loginCheck(String userId) {
		String sql = "select pw from member where id='"+userId+"'";
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				System.out.println(rs.getString("pw"));
				return rs.getString("pw");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HashMap<String, String> printUserInfo(String userId) {
		String sql = "select id, name, gender, age, hobby from member where id='"+userId+"'";
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				HashMap<String, String> userInfo = new HashMap<String, String>();
				
				String gender = rs.getInt("gender")==0?"¿©":"³²";
				String hobby = rs.getInt("hobby")==1 ? "À½¾Ç" : rs.getInt("hobby")==2 ? "½ºÆ÷Ã÷" : "¿µÈ­"; 
	 			
				userInfo.put("id", rs.getString("id"));
				userInfo.put("name", rs.getString("name"));
				userInfo.put("gender", gender);
				userInfo.put("age", rs.getString("age"));
				userInfo.put("hobby", hobby);
				
				return userInfo;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}









