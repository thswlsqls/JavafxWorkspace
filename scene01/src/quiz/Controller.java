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
		System.out.println("quiz controller ����");
		btnLogin.setOnAction(e ->{
			System.out.println("Login ��ư Ŭ��");
			onBtnLoginClick();
		});
	}
	
	public boolean checkInput() {
		if(txtID.getText().isEmpty()) {
			Alert alertId = new Alert(AlertType.WARNING);
			alertId.setTitle("���� �߻�");
		    alertId.setContentText("idTextField�� �Է��ؾ� �մϴ�.");
		    alertId.show();
			txtID.requestFocus();
			return false;
		} else if(txtPW.getText().isEmpty()) {
			Alert alertPw = new Alert(AlertType.WARNING);
			alertPw.setTitle("���� �߻�");
		    alertPw.setContentText("pwTextField�� �Է��ؾ� �մϴ�.");
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
		alertID.setTitle("���� �߻�");
	    alertID.setContentText("��ȿ���� ���� ID�Դϴ�.");
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
		alertPW.setTitle("���� �߻�");
	    alertPW.setContentText("��ȿ���� ���� PW�Դϴ�.");
	    alertPW.show();
	    txtPW.clear(); txtPW.requestFocus();
	}
	
	public void alertLoginSuccess(){
		Alert alertLogin = new Alert(AlertType.WARNING);
		alertLogin.setTitle("�α��� ����");
	    alertLogin.setContentText("�α��ο� �����߽��ϴ�.");
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

