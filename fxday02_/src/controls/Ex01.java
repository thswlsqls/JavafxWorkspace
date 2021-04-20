package controls;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex01 extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(20));
		
		TextField tf = new TextField();
		tf.setText("아무내용이나");
		
		PasswordField pf = new PasswordField();
		pf.setText("아무내용이나");
		
		DatePicker dp = new DatePicker();
		
		TextArea ta = new TextArea();
		ta.setText("아무내용이나");
		
		ComboBox<String> cb = new ComboBox<String>();
		cb.getItems().addAll("달리기","멍","술");
		cb.setValue("선택하세요");
		
		vbox.getChildren().addAll(tf,pf, dp, ta, cb);
		
		arg0.setScene(new Scene(vbox,300,400));
		arg0.show();//2021. 3. 25.
	}
	public static void main(String[] args) {
		launch(args);
	}
}









