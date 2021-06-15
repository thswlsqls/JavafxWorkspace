package ex01.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ex01.surveydto.SurveyDTO;

public class DatabaseServiceImpl implements DatabaseService{

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
	
	@Override
	public int saveSurvey(SurveyDTO dto) {
		String sql = 
			"insert into survey(sight,age,gender) values(?,?,?)";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getSight()); ps.setString(2, dto.getAge()); ps.setString(3, dto.getGender());
			
			result = ps.executeUpdate();
			
		}	catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int getdbCountOfGender(String gender) {
		
		String sql = "select COUNT(*) from survey where  gender='"+gender+"'";
		int countOfGender = 0;

		ResultSet genderRows = null;

		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			Statement stmt = con.createStatement();	
			genderRows = stmt.executeQuery(sql);
			
			while(genderRows.next()) {
				countOfGender = genderRows.getInt("count(*)");
				String countOfGender0 = genderRows.getString("count(*)");
			}
		}	catch(Exception e){
			e.printStackTrace();
		}

		return countOfGender;
	}
	
	public int getdbCountOfAge(String age) {

		String sql = "select COUNT(*) from survey where age='" +age+"'";
		
		int countOfAge = 0;
		ResultSet ageRows = null;
		
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			Statement stmt = con.createStatement();	
			ageRows = stmt.executeQuery(sql);
			
			while(ageRows.next()) {
				countOfAge = ageRows.getInt("count(*)");
			}
		}	catch(Exception e){
			e.printStackTrace();
		}

		return countOfAge;
	}
	
	public int getdbCountOfSight(String sight) {

		String sql = "select COUNT(*) from survey where  sight='"+sight+"'";

		int countOfSight = 0;
		ResultSet sightRows = null;
		
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			Statement stmt = con.createStatement();	
			sightRows = stmt.executeQuery(sql);

			while(sightRows.next()) {
				countOfSight = sightRows.getInt("count(*)");
			}
		}	catch(Exception e){
			e.printStackTrace();
		}

		return countOfSight;
	}
	
}
