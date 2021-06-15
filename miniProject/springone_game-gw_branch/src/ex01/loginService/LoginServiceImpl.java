package ex01.loginService;

import java.util.Optional;

import ex01.Controller;
import ex01.common.CommonClass;
import ex01.database.DataBaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.memberDTO.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import listview.ListviewMain;

public class LoginServiceImpl implements LoginService {
	public static MemberDTO dto = new MemberDTO();
	@Override
	public void loginCheck(Parent root) {
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPw");
		
		
		DataBaseService ds = new DatabaseServiceImpl();
		String dbPwd = ds.loginCheck(id.getText());
		String dbNickName = ds.nickNameCheck(id.getText());
		CommonClass.setNickName(dbNickName);
		if(dbPwd == null) {
			Controller.cs.alert("�������� �ʴ� ȸ���Դϴ�");
		} else {
			if(dbPwd.equals(pwd.getText())) {
				//Controller.cs.alert(dbNickName + "�� ������ �����մϴ�");
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText(dbNickName + "�� ������ �����մϴ�");
				Optional<ButtonType> result = alert.showAndWait();
				if(result.get() == ButtonType.OK) {
					dto.setId(id.getText());
					dto.setCount(0);
					ListviewMain lvm = new ListviewMain();
					lvm.gameStart();
				}
			} else {
				Controller.cs.alert("��й�ȣ�� �ٽ� �Է��ϼ���");
			}
		}
	}

}
