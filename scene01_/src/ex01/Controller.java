package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller implements Initializable{
	@FXML Button btn;
	@FXML TextField txtField;
	@FXML TextField txtField02;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("controller 실행");
		
		btn.setOnAction(e ->{
			System.out.println("버튼 클릭");
			testAction();
		});
	}
	public void testAction() {
		System.out.println( txtField.getText() );
		txtField02.setText( txtField.getText() );
		
		txtField.setText("");
		//txtField.clear();
		
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("문제 발생");
		alert.setContentText("반갑습니다 : "+txtField02.getText());
		alert.show();
	}
}



