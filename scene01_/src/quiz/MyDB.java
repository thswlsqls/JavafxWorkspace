package quiz;

import java.util.HashMap;

public class MyDB {
	/* ���� �����ͺ��̽� �����Ȱ� �����Ƿ�, ����Ǿ� �ִ� �����͸� ���� �ǽ��Ѵ�. */
	private HashMap<String, String> table;
	public HashMap getTable() {return table;}
	public MyDB() {
		table = new HashMap<String, String>();
		table.put("ȫ�浿", "1111");
		table.put("�谳��", "2222");
		table.put("�̼���", "3333");
	}
	/* �ʿ��� ��ɵ��� ������ �߰��� �ּ���~ */
	public String getPassword(String userId) {
		return table.get(userId);
	}
}
