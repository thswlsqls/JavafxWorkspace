package quiz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class EventTest{
	public void setOnEnteded(Label lbl) {
		lbl.setOnMouseEntered(e->{
			lbl.setScaleX(1.5);
			lbl.setScaleY(1.5);
		});
	}
	public void setOnExited(Label lbl) {
		lbl.setOnMouseExited(e->{
			lbl.setScaleX(1);
			lbl.setScaleY(1);
		});
	}
}
public class QuizLambda extends Application{
	public static void main(String [] args){
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox(10);
		Label imgLable = new Label("Search", new ImageView("/resources/img/search.png"));
		Label rotateLabel = new Label("values");
		Label wrappedLabel = new Label("A label that needs to be wrapped");
		HBox wrappedHbox = new HBox();
		imgLable.setFont(new Font("Arial", 25));
		imgLable.setTextFill(Color.web("#0076a3"));
		rotateLabel.setFont(new Font("Arial", 35));
		rotateLabel.setRotate(270);
		rotateLabel.setTranslateY(60);
		wrappedLabel.setWrapText(true);
		wrappedHbox.setPadding(new Insets(40, 0, 0, 0));
		wrappedHbox.setPrefSize(100, 100);
		wrappedHbox.getChildren().add(wrappedLabel);
		
		EventTest et = new EventTest();
		et.setOnEnteded(imgLable);
		et.setOnExited(imgLable);
		
		et.setOnEnteded(rotateLabel);
		et.setOnExited(rotateLabel);
	
		et.setOnEnteded(wrappedLabel);
		et.setOnExited(wrappedLabel);
	
		hbox.getChildren().addAll(imgLable, rotateLabel, wrappedHbox);
		primaryStage.setScene(new Scene(hbox, 400, 170));
		primaryStage.show();
	}
}
