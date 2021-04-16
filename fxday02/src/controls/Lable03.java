package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lable03  extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
	
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		
		Label lbl = new Label("아무 내용이나 들어갑니다.");
		lbl.setWrapText(true);
		
		hbox.getChildren().add(lbl);
		hbox.setPrefSize(100, 100);
		
		arg0.setScene(new Scene(hbox));
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
