package quiz;

import java.util.HashMap;

public class MyDB {

	/*
	 ���� �����ͺ��̽� ������ ���� �����Ƿ�, ����Ǿ� �ִ� �����͸� ���� �ǽ��Ѵ�.
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
