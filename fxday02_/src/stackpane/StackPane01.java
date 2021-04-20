package stackpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StackPane01 extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		StackPane stack = new StackPane();
		Rectangle ret = new Rectangle(100,100,Color.BURLYWOOD);
		Label label = new Label("Go!");
		
		StackPane.setMargin(label, new Insets(0,8,100,8));
		StackPane.setMargin(ret, new Insets(100,8,8,8));
		
		stack.getChildren().addAll(ret, label);
		arg0.setScene(new Scene(stack,300,250));
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
