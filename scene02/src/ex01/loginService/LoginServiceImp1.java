package ex01.loginService;

import ex01.Controller;
import ex01.common.CommonClass;
import ex01.common.CommonService;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImp1;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginServiceImp1  implements LoginService{

	@FXML  TextField fxId;
	@FXML  TextField fxPw;
	
	static CommonService cs;
	static {
		cs = new CommonClass();
	}
	
	@Override
	public void loginCheck(Parent root) {
		
		if(fxId.getText().isEmpty()) {
			Controller.cs.alert(null);
		}
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPw");
		System.out.println("�α��� ü�� �մϴ�.");
		System.out.println("Id : " + id.getText());
		System.out.println("pwd : "+pwd.getText());		
	}
	
	DatabaseService ds = new DatabaseServiceImp1();
//	String dbPwd = ds.loginCheck(id.getText());
//	if(dbPwd == null) {
//		Controller.cs.alert("�������� �ʴ� ���̵��Դϴ�.");
//	}else {
//		if(dbPwd.equals(pwd.getText())) {
//			Controller.cs.alert("���� ���");
//		}else {
//			Controller.cs.alert("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
//		}
//	}
	

}



