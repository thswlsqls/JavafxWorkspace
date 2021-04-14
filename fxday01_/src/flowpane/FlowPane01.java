package flowpane;

//import java.awt.Button;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPane01 extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		FlowPane flow = new FlowPane(Orientation.VERTICAL);
		/*
		Button btn01 = new Button("버튼01");
		Button btn02 = new Button("버튼02");
		Button btn03 = new Button("버튼03");
		
		flow.getChildren().add(btn01);
		flow.getChildren().add(btn02);
		flow.getChildren().add(btn03);
		*/
		//flow.setVgap(50);//가로줄
		//flow.setHgap(10);//세로줄
		flow.setColumnHalignment(HPos.LEFT);
		//padding : 기준값의 안쪽 여백의 위,오른,아래,왼쪽으로 공간형성
		//숫자가 하나가 들어오면 4군데의 여백 동일 숫자
		flow.setPadding( new Insets(50,0,10,50) );
		for(int i=1;i<15;i++) {
			flow.getChildren().add(new Button("버튼0"+( i *i *i *i *i *10)));
		}
		Scene scene = new Scene(flow,300,250);
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}


