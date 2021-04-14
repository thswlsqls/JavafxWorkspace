package fxday01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainClass01 extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println("호출됩닊까?");
		Label lb = new Label("Hello World!!!");
		lb.setFont(new Font(20));
		
		Scene scene = new Scene(lb);
		arg0.setScene(scene);
		
		arg0.setTitle("제목이 들어 갑니다");
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}






