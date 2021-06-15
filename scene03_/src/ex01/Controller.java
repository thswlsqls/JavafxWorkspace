package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class Controller implements Initializable{

	Parent root;
	public void setRoot(Parent root) { this.root = root; }
	
	@FXML PieChart pieChart;
	@FXML BarChart barChart;
	@FXML AreaChart areaChart;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pieChart.setData(FXCollections.observableArrayList(
						new PieChart.Data("JAVA", 30),
						new PieChart.Data("JavaFX", 30),
						new PieChart.Data("Spring", 17),
						new PieChart.Data("Swing", 23)
				));
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("����");
		series1.setData(FXCollections.observableArrayList(
						new XYChart.Data("2017", 70),
						new XYChart.Data("2018", 40),
						new XYChart.Data("2019", 90),
						new XYChart.Data("2020", 45)
				));
		barChart.getData().add(series1);
		
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("����");
		series2.setData(FXCollections.observableArrayList(
						new XYChart.Data("2017", 70),
						new XYChart.Data("2018", 40),
						new XYChart.Data("2019", 90),
						new XYChart.Data("2020", 45)
				));
		barChart.getData().add(series2);
		
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("��տµ�");
		series3.setData(FXCollections.observableArrayList(
						new XYChart.Data("2017", 13),
						new XYChart.Data("2018", 19),
						new XYChart.Data("2019", 7),
						new XYChart.Data("2020", 20)
				));
		areaChart.getData().add(series3);
		
	}
}
