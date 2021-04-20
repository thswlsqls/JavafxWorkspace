package controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RadioButton01 extends Application	{

	@Override
	public void start(Stage arg0) throws Exception {
		HBox hbox = new HBox(10);
		RadioButton rdo01 = new RadioButton();
		RadioButton rdo02 = new RadioButton();
		rdo01.setText("라디오01");
		rdo02.setText("라디오02");
		
		ToggleGroup tg = new ToggleGroup();
		rdo01.setToggleGroup(tg);
		rdo02.setToggleGroup(tg);
		rdo01.setSelected(true);
		
		hbox.getChildren().addAll(rdo01, rdo02);
		
		arg0.setScene(new Scene(hbox,300,200));
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}






