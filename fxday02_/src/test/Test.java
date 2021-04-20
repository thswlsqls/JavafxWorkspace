package test;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Test extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		FlowPane hfl4 = new FlowPane(Orientation.HORIZONTAL);
		CheckBox chb1 = new CheckBox("게임");
		CheckBox chb2 = new CheckBox("공부");
		hfl4.getChildren().addAll(chb1, chb2);
		arg0.setScene(new Scene(hfl4));
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
