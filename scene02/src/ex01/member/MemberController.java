package ex01.member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MemberController implements  Initializable{

	Parent root;
	MemberService ms;
	public void setRoot() {
		this.root = root;
//		ms.setRoot(root);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		ms = new MemberServiceImp1();
	}
	public void memverProc() {
//		ms.memberShip();
	}
	public void cancelProc() {
//		ms.memberClose();
	}
	
}
