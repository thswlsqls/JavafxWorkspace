package fxday02;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ImageView01 extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		FlowPane flow = new FlowPane();
		
		ImageView iv = new ImageView("/resources/img/SmileReRe.png");
		ImageView iv02 = new ImageView();
		
//		iv02.setImage(new ImageView("/resources/img/SmileReRe.png"));
//		
//		iv02.setFileHeight(50);
//		iv02.setFileWidth(50);
		
		iv02.setRotate(45);
		
		flow.getChildren().addAll(iv, iv02);
//		arg0.setScene(new Scene(flow, 400, 200));
//		arg0.show()
	}

}
