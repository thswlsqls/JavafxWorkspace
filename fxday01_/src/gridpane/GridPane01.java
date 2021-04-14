package gridpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPane01 extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		GridPane gp = new GridPane();
		Button button = new Button("Button");
		gp.setRowIndex(button, 0);//세로 인덱스
		gp.setColumnIndex(button, 0);//가로 인덱스
		
		gp.setHgap(50);//세로
		
		Label lbl = new Label("Label");
		Label lbl02 = new Label("Label02");
		
		GridPane.setRowIndex(lbl02, 1);//세로 인덱스
		GridPane.setColumnIndex(lbl02, 1);//가로 인덱스
		
		GridPane.setConstraints(lbl,0,2);//가로, 세로
		
		gp.setPadding(new Insets(30));
		
		gp.getChildren().add(button);
		gp.getChildren().add(lbl);
		gp.getChildren().add(lbl02);
		//gp.getChildren().addAll(button,lbl,lbl02);
		arg0.setScene(new Scene(gp,300,100));
		
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}







