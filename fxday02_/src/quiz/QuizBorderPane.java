package quiz;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class QuizBorderPane extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		BorderPane bp = new BorderPane();
		FlowPane flowTop = new FlowPane();
		FlowPane flowRight = new FlowPane();
		FlowPane flowBottom = new FlowPane();
		FlowPane flowLeft = new FlowPane();
		FlowPane flowCenter = new FlowPane();
		
		flowTop.setStyle("-fx-background-color:pink;");
		flowRight.setStyle("-fx-background-color:#FAED7D;");
		flowBottom.setStyle("-fx-background-color:#CCA63D;");
		flowLeft.setStyle("-fx-background-color:#B2EBF4;");
		flowCenter.setStyle("-fx-background-color:#CEF279;");
		
		flowTop.setPrefSize(500, 50);
		flowBottom.setPrefSize(500, 50);
		flowLeft.setPrefSize(100, 200);
		flowCenter.setPrefSize(150, 200);
		flowRight.setPrefSize(250, 200);
		
		Label lblTop = new Label("메뉴     홈     로그인");
		flowTop.getChildren().add(lblTop);
		
		Button btnId = new Button("아이디 입력");
		Button btnPwd = new Button("비밀번호 입력");
		Button btnLog = new Button("로그인");
		FlowPane flow = new FlowPane();
		FlowPane vFlow = new FlowPane(Orientation.VERTICAL);
		vFlow.getChildren().addAll(btnId,btnPwd);
		vFlow.setPrefSize(100, 100);
		btnId.setPrefSize(100, 50);
		btnPwd.setPrefSize(100, 50);
		btnLog.setPrefSize(100, 100);
		flow.getChildren().addAll(vFlow,btnLog);
		flowRight.getChildren().add(flow);
		
		
		Button btnBottom = new Button("바닥글 들어가는 곳"); flowBottom.getChildren().add(btnBottom);
		Button btnLeft = new Button("메뉴 나열");        flowLeft.getChildren().add(btnLeft);
		Button btnCenter = new Button("내용 들어가는 곳"); flowCenter.getChildren().add(btnCenter);
		
		
		bp.setTop(flowTop); bp.setRight(flowRight); bp.setBottom(flowBottom);
		bp.setLeft(flowLeft); bp.setCenter(flowCenter);
		
		arg0.setScene(new Scene(bp,500,300));
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}












