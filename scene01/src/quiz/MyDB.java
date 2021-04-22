package quiz;

import java.util.HashMap;

public class MyDB {

	/*
	 현재 데이터베이스 연동된 것이 없으므로, 저장되어 있는 데이터를 만들어서 실습한다.
	 */
	
	private HashMap<String, String> table;
	
	public HashMap<String, String> getTable() {
		return table;
	}
	
	public MyDB() {
		table = new HashMap<>();
		table.put("if", "if1234");
		table.put("else", "else1234");
		table.put("while", "while1234");
		table.put("for", "for1234");
		table.put("admin", "admin1234");
	}
	
	public String getPassword(String userId) {
		return table.get(userId);
	}
}
