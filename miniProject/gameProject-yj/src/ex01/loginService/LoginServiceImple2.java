package ex01.loginService;

import ex01.Controller;
import ex01.database.DataBaseService;
import ex01.database.DatabaseServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginServiceImple2 implements LoginService {

	@Override
	public void loginCheck(Parent root) {
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPw");
		
		
		DataBaseService ds = new DatabaseServiceImpl();
		String dbPwd = ds.loginCheck(id.getText());
		String dbNickName = ds.nickNameCheck(id.getText());
		if(dbPwd == null) {
			Controller.cs.alert("�������� �ʴ� ȸ���Դϴ�");
		} else {
			if(dbPwd.equals(pwd.getText())) {
				int result = ds.deleteMember(id.getText());
				if(result == 1) {
					Controller.cs.alert(dbNickName + "�� Ż��Ǿ����ϴ�");
					Controller.cs.exit(root);
				} 
			} else {
				Controller.cs.alert("��й�ȣ�� �ٽ� �Է��ϼ���");
			}
		}
	}

	
	


}
