package ex01.loginService;

import java.util.HashMap;

import ex01.Controller;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginServiceImpl implements LoginService{
	@Override
	public void loginCheck(Parent root) {
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPw");
		
		if(id.getText().isEmpty()) {
			Controller.cs.alert("���̵� �Է��ϼ���");
		}
		
		System.out.println("�α��� üũ �մϴ�");
		System.out.println("id : "+id.getText());
		System.out.println("pwd : "+pwd.getText());
		
		DatabaseService ds = new DatabaseServiceImpl();
		
		String dbPwd = ds.loginCheck(id.getText());
		HashMap<String, String> userInfo = ds.printUserInfo(id.getText());
		for (String info : userInfo.keySet()) {
			System.out.println(info + " : " + userInfo.get(info));
		}
		
		System.out.println(userInfo);
		
		if(dbPwd == null) {
			Controller.cs.alert("�������� �ʴ� ���̵� �Դϴ�");
		}else {
			if( dbPwd.equals(pwd.getText()) ) {
				
				Controller.cs.alert("���� ���");
			}else {
				Controller.cs.alert("��й�ȣ�� Ʋ�Ƚ��ϴ�");
			}
		}
	}
}







