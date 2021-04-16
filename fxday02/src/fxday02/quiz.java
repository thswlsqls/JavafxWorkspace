package fxday02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class quiz extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		BorderPane bp = new BorderPane();

		Button[] btn = new Button[6];
		String[] strBtn = {"메뉴 나열","내용 들어가는 곳", "아이디 입력", "비밀번호 입력", "로그인", "바닥글 들어가는 곳"};
		for(int i=0; i<btn.length; i++) {
			btn[i] = new Button(strBtn[i]);
			btn[i].setPrefHeight(40);
		}
		
		Label[] lb = new Label[3];
		String[] strLb = {"메뉴", "홈", "로그인"};
		for(int j=0; j<lb.length; j++) {
			lb[j] = new Label(strLb[j]);
		}
		
//		Text[] txt = new Text[3];
//		String[] strTxt = {"메뉴", "홈", "로그인"};
		Text txte = new Text("메뉴 홈 로그인");
		
//		String[] strBtn = {"Left", "CENTER", "BOTTOM", "LEFT", "RIGHT"};
//		VBox v = new VBox[5];
//		lb[0], lb[1], lb[2]
		
		VBox vTop = new VBox();
		vTop.getChildren().addAll(txte);
		bp.setTop(vTop);
		vTop.setStyle("-fx-background-color:pink;");
		vTop.setPrefSize(600, 60);
		
		VBox vLeft = new VBox();
		vLeft.getChildren().addAll(btn[0]);
		bp.setLeft(vLeft);
		vLeft.setStyle("-fx-background-color:blue;");
		vLeft.setPrefSize(150, 200);
		
		VBox vRight = new VBox();
		vRight.getChildren().addAll(btn[2], btn[3], btn[4]);
		bp.setRight(vRight);
		vRight.setStyle("-fx-background-color:yellow;");
		vRight.setPrefSize(300, 200);
		
		VBox vCenter = new VBox();
		vCenter.getChildren().addAll(btn[1]);
		bp.setCenter(vCenter);
		vCenter.setStyle("-fx-background-color:green;");
		vCenter.setPrefSize(150, 100);
		
		VBox vBottom = new VBox();
		vBottom.getChildren().addAll(btn[5]);
		bp.setBottom(vBottom);
		vBottom.setStyle("-fx-background-color:brown;");
		vBottom.setPrefSize(600, 40);
		
		arg0.setScene(new Scene(bp, 600, 300));
		arg0.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
