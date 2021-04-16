package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Button01 extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		FlowPane flow = new FlowPane();
		Button btn = new Button();
		
		btn.setGraphic(new ImageView("/resources/img/SmileReRe.png"));
		
		btn.setStyle("-fx-background-color:transparent; -fx-padding: 10 10 10 10;");
		btn.setOnMousePressed(e -> {
			btn.setStyle("-fx-background-color:transparent; -fx-padding: 15 10 10 10;");
		});
		btn.setOnMousePressed(e -> {
			btn.setStyle("-fx-background-color:transparent; -fx-padding: 10 10 10 10;");
		});
		btn.setOnMousePressed(e -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("버튼 이벤트");
			alert.setTitle("안내");
			alert.setContentText("버튼이 클릭");
			alert.show();
		});
		
		
		flow.setPadding(new Insets(20));
		flow.getChildren().add(btn);
		arg0.show();
		
		arg0.setScene(new Scene(flow, 300, 300));
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
