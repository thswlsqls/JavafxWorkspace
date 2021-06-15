package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.common.CommonService;
import ex01.loginService.LoginServiceImp1;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	@FXML TextField fxId;
	Parent root;
	LoginServiceImp1 ls;
	
	public static CommonService cs;
	static {
		cs = new CommonClass();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginServiceImp1();
	}
	
	public void cancelProc() {
		System.out.println("취소 버튼 클릭");
		Controller.cs.exit(root);
	}
	
	public void loginProc() {
		ls.loginCheck(root);	
		}
	}


