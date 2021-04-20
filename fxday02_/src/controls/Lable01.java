package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lable01 extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		HBox hbox = new HBox();
		Label lbl = new Label("lbl test");
		
		lbl.setText("setText test");
		lbl.setPrefSize(200,30);
		lbl.setStyle("-fx-background-color:yellow;");
		lbl.setAlignment(Pos.CENTER_RIGHT);
		
		hbox.setPadding(new Insets(20));
		hbox.getChildren().addAll(lbl);
		hbox.setPrefSize(300, 200);
		
		arg0.setScene(new Scene(hbox));
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
