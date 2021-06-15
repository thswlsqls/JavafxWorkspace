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
		
		Integer Cman = getCountOfGender("����"); System.out.print("����="+Cman+" "); 
		Integer CWoman = getCountOfGender("����"); System.out.print("����="+CWoman+" "); 
		Integer CSum = Cman + CWoman;
		
		 Integer CTeen = getCountOfAge("10��"); System.out.print("10��="+CTeen+" ");
		 Integer CTwenties = getCountOfAge("20��"); System.out.print("20��="+CTwenties+" "); 
		 Integer CThirties = getCountOfAge("30��"); System.out.print("30��="+CThirties+" "); 
		 Integer CForties = getCountOfAge("40��"); System.out.print("40��="+CForties+" "); 

		 Integer CForeign = getCountOfSight("�ؿܿ���"); System.out.print("�ؿܿ���="+ CForeign+" ");  
		 Integer CDomestic = getCountOfSight("��������"); System.out.print("��������="+ CDomestic+" "); 
		 Integer CNone = getCountOfSight("����"); System.out.println("����="+ CNone); 

		 pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("10��", getCountOfAge("10��")),
				new PieChart.Data("20��", getCountOfAge("20��")),
				new PieChart.Data("30��", getCountOfAge("30��")),
				new PieChart.Data("40��", getCountOfAge("40��"))
		));
		 
		lbl10.setText(CTeen.toString()+" ��"); lbl20.setText(CTwenties.toString()+" ��"); 
		lbl30.setText(CThirties.toString()+" ��"); lbl40.setText(CForties.toString()+" ��");
		lblMan.setText(Cman.toString()+" ��"); lblWoman.setText(CWoman.toString()+" ��"); lblSum.setText(CSum.toString()+" ��");
		lblForeign.setText(CForeign.toString()+" ��"); lblDomestic.setText(CDomestic.toString()+" ��"); lblNone.setText(CNone.toString()+" ��");
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("����");
		series1.setData(FXCollections.observableArrayList(
						new XYChart.Data("����", getCountOfGender("����"))
				));
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("����");
		series2.setData(FXCollections.observableArrayList(
						new XYChart.Data("����", getCountOfGender("����"))
				));
		barChart.getData().addAll(series1, series2);

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("������� ������");
		series3.setData(FXCollections.observableArrayList(
						new XYChart.Data("�ؿܿ���", getCountOfSight("�ؿܿ���")),
						new XYChart.Data("��������", getCountOfSight("��������")),
						new XYChart.Data("����", getCountOfSight("����"))
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
