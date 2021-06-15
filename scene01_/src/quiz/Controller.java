package quiz;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	@FXML TextField fxId;
	@FXML PasswordField fxPwd;
	@FXML Button fxBtn;
	MyDB db;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new MyDB();
		fxBtn.setOnAction(e->{
			userCheck();
		});
	}
	public void userCheck() {
		//System.out.println(db.getTable().get("ȫ�浿"));
		//System.out.println(db.getTable().get("�谳��"));
		//System.out.println(db.getTable().get("�����"));
		System.out.println(db.getPassword( fxId.getText() ));
		
		if(fxId.getText().isEmpty()) {
			fxId.requestFocus();
			myAlert("���̵� �Է��ϼ���");
			return;
		}else if(fxPwd.getText().isEmpty()) {
			fxPwd.requestFocus();
			myAlert("��й�ȣ�� �Է��ϼ���");
			return;
		}
		
		String pwd = db.getPassword( fxId.getText() );
		if( pwd != null) {
			if( pwd.equals(fxPwd.getText()) ) {
				myAlert("���� ���");
			}else {
				myAlert("��й�ȣ Ʋ��");
			}
		}else {
			myAlert("�������� �ʴ� ���̵� �Դϴ�");
		}
		fxId.clear();
		fxPwd.clear();
	}
	private void myAlert(String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(content);
		alert.show();
	}

}













