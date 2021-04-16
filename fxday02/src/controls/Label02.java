package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Label02 extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
//		Label lbl = new Label("", new ImageView("/resource/img/search.png"))
				
		Label lbl02 = new Label("search");
		lbl02.setGraphic(new ImageView("/resouces/img/smile.png"));
//		hbox.getChildren().addAll(lbl, lbl02);
		
		Label lbl03 = new Label("hello world");
		lbl03.setFont(new Font("", 32));
		lbl03.setRotate(48);
		lbl03.setTranslateY(50);
		
//		hbox.getChildren().addAll(lbl, lbl02, lbl03);
		
		arg0.setScene(new Scene(hbox, 600, 200));
		arg0.show();
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
