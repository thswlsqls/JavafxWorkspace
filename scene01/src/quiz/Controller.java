package quiz;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller implements Initializable{

	@FXML  Button btnLogin;
	@FXML TextField txtID;
	@FXML TextField txtPW;
	@FXML CheckBox cbRemember;
	
	MyDB db = new MyDB();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		System.out.println("quiz controller 실행");
		btnLogin.setOnAction(e ->{
			System.out.println("Login 버튼 클릭");
			onBtnLoginClick();
		});
	}
	
	public boolean checkInput() {
		if(txtID.getText().isEmpty()) {
			Alert alertId = new Alert(AlertType.WARNING);
			alertId.setTitle("문제 발생");
		    alertId.setContentText("idTextField를 입력해야 합니다.");
		    alertId.show();
			txtID.requestFocus();
			return false;
		} else if(txtPW.getText().isEmpty()) {
			Alert alertPw = new Alert(AlertType.WARNING);
			alertPw.setTitle("문제 발생");
		    alertPw.setContentText("pwTextField를 입력해야 합니다.");
		    alertPw.show();
			txtPW.requestFocus();
			return false;
			}  else {
				return true;	
			}
	}
	
	public boolean checkID() {
		String ID = txtID.getText();
		String PW = txtPW.getText();
		return db.getTable().containsKey(ID)? true : false; 
	}
	
	public void alertUnvalidID() {
		Alert alertID = new Alert(AlertType.WARNING);
		alertID.setTitle("문제 발생");
	    alertID.setContentText("유효하지 않은 ID입니다.");
	    alertID.show();
	    txtID.clear(); txtID.requestFocus();
	}
	
	public boolean checkPW() {
		String ID = txtID.getText();
		String PW = txtPW.getText();
		return db.getTable().get(ID).equals(PW) ? true : false;
	}
	
	public void alertUnvalidPW() {
		Alert alertPW = new Alert(AlertType.WARNING);
		alertPW.setTitle("문제 발생");
	    alertPW.setContentText("유효하지 않은 PW입니다.");
	    alertPW.show();
	    txtPW.clear(); txtPW.requestFocus();
	}
	
	public void alertLoginSuccess(){
		Alert alertLogin = new Alert(AlertType.WARNING);
		alertLogin.setTitle("로그인 성공");
	    alertLogin.setContentText("로그인에 성공했습니다.");
	    alertLogin.show();
	}
	
	public void checkRemember() {
		if(cbRemember.isSelected()) {
	    	txtPW.clear(); txtPW.requestFocus();
	    }else {
	    	txtID.clear(); txtPW.clear(); txtID.requestFocus();
	    }
	}
	
	public void onBtnLoginClick() {
		
		if(checkInput()) {
			String ID = txtID.getText();
			String PW = txtPW.getText();
			if(!checkID()){
				alertUnvalidID();
			    checkRemember();
				}else if(!checkPW()) {
					alertUnvalidPW();
				    checkRemember();
				}else {
					alertLoginSuccess();
				} 
			}
		}
	
	}

