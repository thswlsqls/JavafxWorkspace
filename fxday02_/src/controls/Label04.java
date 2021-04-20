package controls;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Label04 extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		FlowPane flow = new FlowPane();
		Label lbl = new Label("test");
		lbl.setFont(new Font("",32));
		lbl.setTranslateX(100);
		lbl.setTranslateY(70);
		
		EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				lbl.setScaleX(1.5);
				lbl.setScaleY(1.5);
			}
		};
		lbl.setOnMouseEntered(event);
		
		lbl.setOnMouseExited( new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				lbl.setScaleX(1);
				lbl.setScaleY(1);
			}
		} );
		
		lbl.setOnMousePressed( e -> {
			lbl.setRotate(48);
		});
		
		lbl.setOnMouseReleased(e ->{
			lbl.setRotate(0);
		});
		
		
		flow.getChildren().add(lbl);
		flow.setPrefSize(300, 200);
		arg0.setScene(new Scene(flow));
		
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
