package controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RadioButton01 extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		HBox hbox = new HBox(10);
		RadioButton rdb01 = new RadioButton();
		RadioButton rdb02 = new RadioButton();
		rdb01.setText("라디오01");
		rdb02.setText("라디오02");
		
		ToggleGroup tg = new ToggleGroup();
		rdb01.setToggleGroup(tg);
		rdb02.setToggleGroup(tg);
		rdb01.setSelected(true);
		
		hbox.getChildren().addAll(rdb01, rdb02);
		
		arg0.setScene(new Scene(hbox, 300, 200));
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
