package ex01.survey;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.catalog.CatalogManager;

import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class SurveyController implements Initializable{
	
	Parent root;

	public void setRoot(Parent root) { this.root = root; };
	
	@FXML PieChart pieChart; @FXML BarChart barChart; @FXML AreaChart areaChart;
	@FXML Label lbl10; @FXML Label lbl20; @FXML Label lbl30; @FXML Label lbl40;
	@FXML Label lblMan; @FXML Label lblWoman; @FXML Label lblSum;  
	@FXML Label lblForeign; @FXML Label lblDomestic; @FXML Label lblNone;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		FXMLLoader loader =
			new FXMLLoader(getClass().getResource("survey.fxml"));
					try {
						root = loader.load();
					} catch (IOException e) {
						e.printStackTrace();
					}
					AreaChart areaChart0 = (AreaChart)root.lookup("#areaChart");
		
		Integer Cman = getCountOfGender("남성"); System.out.print("남성="+Cman+" "); 
		Integer CWoman = getCountOfGender("여성"); System.out.print("여성="+CWoman+" "); 
		Integer CSum = Cman + CWoman;
		
		 Integer CTeen = getCountOfAge("10대"); System.out.print("10대="+CTeen+" ");
		 Integer CTwenties = getCountOfAge("20대"); System.out.print("20대="+CTwenties+" "); 
		 Integer CThirties = getCountOfAge("30대"); System.out.print("30대="+CThirties+" "); 
		 Integer CForties = getCountOfAge("40대"); System.out.print("40대="+CForties+" "); 

		 Integer CForeign = getCountOfSight("해외여행"); System.out.print("해외여행="+ CForeign+" ");  
		 Integer CDomestic = getCountOfSight("국내여행"); System.out.print("국내여행="+ CDomestic+" "); 
		 Integer CNone = getCountOfSight("없음"); System.out.println("없음="+ CNone); 

		 pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("10대", getCountOfAge("10대")),
				new PieChart.Data("20대", getCountOfAge("20대")),
				new PieChart.Data("30대", getCountOfAge("30대")),
				new PieChart.Data("40대", getCountOfAge("40대"))
		));
		 
		lbl10.setText(CTeen.toString()+" 명"); lbl20.setText(CTwenties.toString()+" 명"); 
		lbl30.setText(CThirties.toString()+" 명"); lbl40.setText(CForties.toString()+" 명");
		lblMan.setText(Cman.toString()+" 명"); lblWoman.setText(CWoman.toString()+" 명"); lblSum.setText(CSum.toString()+" 명");
		lblForeign.setText(CForeign.toString()+" 명"); lblDomestic.setText(CDomestic.toString()+" 명"); lblNone.setText(CNone.toString()+" 명");
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("남성");
		series1.setData(FXCollections.observableArrayList(
						new XYChart.Data("남성", getCountOfGender("남성"))
				));
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("여성");
		series2.setData(FXCollections.observableArrayList(
						new XYChart.Data("여성", getCountOfGender("여성"))
				));
		barChart.getData().addAll(series1, series2);

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("가고싶은 여행지");
		series3.setData(FXCollections.observableArrayList(
						new XYChart.Data("해외여행", getCountOfSight("해외여행")),
						new XYChart.Data("국내여행", getCountOfSight("국내여행")),
						new XYChart.Data("없음", getCountOfSight("없음"))
				));
		areaChart0.getData().add(series3);
	}	
	
	public int getCountOfGender(String gender) {
		DatabaseService ds = new DatabaseServiceImpl();
		int countOfGender = ds.getdbCountOfGender(gender);
		return countOfGender;
	}

	public int getCountOfAge(String age) {
		DatabaseService ds = new DatabaseServiceImpl();
		int countOfAge = ds.getdbCountOfAge(age);
		return countOfAge;
	}

	public int getCountOfSight(String sight) {
		DatabaseService ds = new DatabaseServiceImpl();
		int countOfSight = ds.getdbCountOfSight(sight);
		return countOfSight;
	}

}
