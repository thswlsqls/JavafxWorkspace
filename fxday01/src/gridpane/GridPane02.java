package gridpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPane02 extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		
		//pane1
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(20));
		gridpane.setHgap(50);
		gridpane.setVgap(10);
		
		gridpane.add(new Button("Button"), 0, 0);
		gridpane.add(new Button("1 , 0"), 1, 0);
		gridpane.add(new Label("0 , 1"), 0, 1);
		gridpane.add(new Button("Label"), 1	, 1);
		
		//pane2
		FlowPane flow = new FlowPane();
		flow.getChildren().add(new Button("연습"));
		flow.getChildren().add(new Button("연습1"));
		flow.getChildren().add(new Button("연습2"));
		flow.getChildren().add(new Button("merge col(0), row(2)"));
		flow.setAlignment(Pos.CENTER);
		flow.setStyle("-fx-background-color:black;");
		gridpane.add(flow, 0, 2, 2, 1); //가로, 세로, 가로병합개수, 세로병합개수
		
		arg0.setScene(new Scene(gridpane, 300, 300));
		arg0.show();
		
	}  
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
