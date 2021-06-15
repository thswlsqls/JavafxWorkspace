package ex01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.common.CommonService;
import ex01.loginService.LoginService;
import ex01.loginService.LoginServiceImpl;
import ex01.member.MemberMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller implements Initializable{
	@FXML TextField fxId;
	Parent root;
	LoginService ls;
	MemberMain mm;
	public static CommonService cs;
	static { cs = new CommonClass(); }
	public void cancelProc() {
		System.out.println("취소 버튼 클릭");
		Controller.cs.exit(root);
	}
	
	public void setRoot(Parent root) { this.root = root; }
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginServiceImpl();
		mm = new MemberMain();
	}
	
	public void loginProc() {
		ls.loginCheck(root);
	}
	public void memberProc()  {
		System.out.println("회원가입 클릭");
		mm.setMemberStage();
	}
}






