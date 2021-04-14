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
		gp.setRowIndex(button, 0);//���� �ε���
		gp.setColumnIndex(button, 0);//���� �ε���
		
		gp.setHgap(50);//����
		
		Label lbl = new Label("Label");
		Label lbl02 = new Label("Label02");
		
		GridPane.setRowIndex(lbl02, 1);//���� �ε���
		GridPane.setColumnIndex(lbl02, 1);//���� �ε���
		
		GridPane.setConstraints(lbl,0,2);//����, ����
		
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







