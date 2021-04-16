package scene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Quiz extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane root = 
				FXMLLoader.load(getClass().getResource("Quiz.fxml"));
		
		Scene scene = new Scene(root);
		arg0.setTitle("Quiz");
		arg0.setScene(scene);
		arg0.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
}
