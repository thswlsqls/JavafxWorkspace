package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPane01 extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		BorderPane bp = new BorderPane();
		Button[] btn = new Button[5];
		String[] strBtn = {"TOP111111","CENTER","BOTTOM","LEFT","RIGHT"};
		for(int i=0; i<btn.length ;i++) {
			btn[i] = new Button(strBtn[i]);
		}
		Button btn001 = new Button("service");
		bp.setTop(btn[0]);
		bp.setCenter(btn[1]);
		bp.setBottom(btn[2]);
		bp.setRight(btn[4]);
		
		VBox v = new VBox();
		v.getChildren().addAll(btn001,btn[3]);
		//bp.setLeft(btn001);
		bp.setLeft(v);
		v.setStyle("-fx-background-color:yellow;");
		v.setPrefSize(100, 150);
		bp.setStyle("-fx-background-color:red;");
		
		btn[0].setPrefSize(300, 50);
	
		arg0.setScene(new Scene(bp,300,100));
		arg0.setResizable(false);//스테이지 고정크기
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}






