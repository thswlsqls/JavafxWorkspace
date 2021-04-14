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
		Button btn01 = new Button("��ư01");
		Button btn02 = new Button("��ư02");
		Button btn03 = new Button("��ư03");
		
		flow.getChildren().add(btn01);
		flow.getChildren().add(btn02);
		flow.getChildren().add(btn03);
		*/
		//flow.setVgap(50);//������
		//flow.setHgap(10);//������
		flow.setColumnHalignment(HPos.LEFT);
		//padding : ���ذ��� ���� ������ ��,����,�Ʒ�,�������� ��������
		//���ڰ� �ϳ��� ������ 4������ ���� ���� ����
		flow.setPadding( new Insets(50,0,10,50) );
		for(int i=1;i<15;i++) {
			flow.getChildren().add(new Button("��ư0"+( i *i *i *i *i *10)));
		}
		Scene scene = new Scene(flow,300,250);
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}


