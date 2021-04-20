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
		tf.setText("�ƹ������̳�");
		
		PasswordField pf = new PasswordField();
		pf.setText("�ƹ������̳�");
		
		DatePicker dp = new DatePicker();
		
		TextArea ta = new TextArea();
		ta.setText("�ƹ������̳�");
		
		ComboBox<String> cb = new ComboBox<String>();
		cb.getItems().addAll("�޸���","��","��");
		cb.setValue("�����ϼ���");
		
		vbox.getChildren().addAll(tf,pf, dp, ta, cb);
		
		arg0.setScene(new Scene(vbox,300,400));
		arg0.show();//2021. 3. 25.
	}
	public static void main(String[] args) {
		launch(args);
	}
}









