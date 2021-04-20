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
		
		Label lblTop = new Label("�޴�     Ȩ     �α���");
		flowTop.getChildren().add(lblTop);
		
		Button btnId = new Button("���̵� �Է�");
		Button btnPwd = new Button("��й�ȣ �Է�");
		Button btnLog = new Button("�α���");
		FlowPane flow = new FlowPane();
		FlowPane vFlow = new FlowPane(Orientation.VERTICAL);
		vFlow.getChildren().addAll(btnId,btnPwd);
		vFlow.setPrefSize(100, 100);
		btnId.setPrefSize(100, 50);
		btnPwd.setPrefSize(100, 50);
		btnLog.setPrefSize(100, 100);
		flow.getChildren().addAll(vFlow,btnLog);
		flowRight.getChildren().add(flow);
		
		
		Button btnBottom = new Button("�ٴڱ� ���� ��"); flowBottom.getChildren().add(btnBottom);
		Button btnLeft = new Button("�޴� ����");        flowLeft.getChildren().add(btnLeft);
		Button btnCenter = new Button("���� ���� ��"); flowCenter.getChildren().add(btnCenter);
		
		
		bp.setTop(flowTop); bp.setRight(flowRight); bp.setBottom(flowBottom);
		bp.setLeft(flowLeft); bp.setCenter(flowCenter);
		
		arg0.setScene(new Scene(bp,500,300));
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}












