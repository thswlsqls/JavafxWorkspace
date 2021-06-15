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
		//System.out.println(db.getTable().get("홍길동"));
		//System.out.println(db.getTable().get("김개똥"));
		//System.out.println(db.getTable().get("김길자"));
		System.out.println(db.getPassword( fxId.getText() ));
		
		if(fxId.getText().isEmpty()) {
			fxId.requestFocus();
			myAlert("아이디를 입력하세요");
			return;
		}else if(fxPwd.getText().isEmpty()) {
			fxPwd.requestFocus();
			myAlert("비밀번호를 입력하세요");
			return;
		}
		
		String pwd = db.getPassword( fxId.getText() );
		if( pwd != null) {
			if( pwd.equals(fxPwd.getText()) ) {
				myAlert("인증 통과");
			}else {
				myAlert("비밀번호 틀림");
			}
		}else {
			myAlert("존재하지 않는 아이디 입니다");
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













