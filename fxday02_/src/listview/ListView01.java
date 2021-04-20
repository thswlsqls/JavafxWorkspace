package listview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListView01 extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		FlowPane flow = new FlowPane();
		ListView<String> lv = new ListView<String>();
		lv.getItems().addAll("item1","item2","item3");
		
		lv.setPrefSize(100, 50);
		
		flow.getChildren().add(lv);
		arg0.setScene(new Scene(flow,300,200));
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
