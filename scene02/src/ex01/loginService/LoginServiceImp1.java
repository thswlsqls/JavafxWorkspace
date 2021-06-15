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
		System.out.println("로그인 체그 합니다.");
		System.out.println("Id : " + id.getText());
		System.out.println("pwd : "+pwd.getText());		
	}
	
	DatabaseService ds = new DatabaseServiceImp1();
//	String dbPwd = ds.loginCheck(id.getText());
//	if(dbPwd == null) {
//		Controller.cs.alert("존재하지 않는 아이디입니다.");
//	}else {
//		if(dbPwd.equals(pwd.getText())) {
//			Controller.cs.alert("인증 통과");
//		}else {
//			Controller.cs.alert("비밀번호가 틀렸습니다.");
//		}
//	}
	

}



