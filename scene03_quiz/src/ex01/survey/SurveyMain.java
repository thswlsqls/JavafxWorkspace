package ex01.survey;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SurveyMain extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("survey.fxml"));
		Parent root = loader.load();
		
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
}
