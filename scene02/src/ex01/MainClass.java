package ex01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("eventTest.fxml"));
		FXMLLoader loader0 = new FXMLLoader(getClass().getResource("member.fxml"));
		
		
		Parent root = loader.load();
		Parent root0 = loader0.load();
		
		Scene scene = new Scene(root);
		Scene scene0 = new Scene(root0);
		
		Controller controller = loader.getController();
		controller.setRoot(root);
		Controller controller0 = loader.getController();
		controller.setRoot(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setScene(scene0);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}

