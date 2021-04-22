package quiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuizMainClass01 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.out.println("quiz main start");
		Parent root = FXMLLoader.load(getClass().getResource("eventQuiz.fxml"));
		System.out.println("quiz main end");
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
