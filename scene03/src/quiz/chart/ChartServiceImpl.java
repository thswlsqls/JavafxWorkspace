package quiz.chart;

import java.io.IOException;
import java.util.ArrayList;

import quiz.Inquiry;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ChartServiceImpl implements ChartService{
	private Parent root;
	private PieChart pieChart;
	private BarChart barChart;
	private AreaChart areaChart;
	private Label labelMan;
	private ArrayList<Label> labelAgeList;
	private ArrayList<Label> labelGenderList;
	private ArrayList<Label> labelTravelList;
	private Label labelSum;
	private int count;
	
	public ChartServiceImpl() {
		
		FXMLLoader loader =
new FXMLLoader(getClass().getResource("../viewChart.fxml"));
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pieChart = (PieChart)root.lookup("#pieChart");
		barChart = (BarChart)root.lookup("#barChart");
		areaChart = (AreaChart)root.lookup("#areaChart");
		
		labelGenderList = new ArrayList<>();
		for(int i=0;i<2;i++) {
			labelGenderList.add((Label)root.lookup("#labelGender"+i));
		}
		labelAgeList=new ArrayList<>();
		for(int i=0;i<4;i++) {
			labelAgeList.add((Label)root.lookup("#labelAge"+i));
		}
		labelTravelList=new ArrayList<>();
		for(int i=0;i<4;i++) {
			labelTravelList.add((Label)root.lookup("#labelTravel"+i));
		}
	}
	@Override
	public void viewChart(ArrayList<Inquiry> lists) {
		int ageList[] = new int[] {0,0,0,0};
		int genderList[] = new int[] {0,0};
		int travelList[] = new int[] {0,0,0};
		
		for(int i=0;i<lists.size();i++) {
			count++;
			ageList[lists.get(i).getAge()]++;//{1,0,0,0}
			genderList[lists.get(i).getGender()]++;
			travelList[lists.get(i).getTravel()]++;
		}
		
		for(int i=0;i < labelGenderList.size();i++) {
			labelGenderList.get(i).setText(genderList[i]+" ��");
		}
		
		for(int i=0;i<labelAgeList.size();i++) {
			labelAgeList.get(i).setText(ageList[i]+" ��");
		}
		
		for(int i=0;i<3;i++) {
			labelTravelList.get(i).setText(travelList[i]+" ��");
		}
		
		labelSum = (Label)root.lookup("#labelSum");
		labelSum.setText(count+"");
		
		pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("10��", ageList[0]),		
				new PieChart.Data("20��", ageList[1]),
				new PieChart.Data("30��", ageList[2]),
				new PieChart.Data("40��", ageList[3])
				));

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("����");       
		series1.setData(FXCollections.observableArrayList(new XYChart.Data("���� �������� ����", genderList[1])));  
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("����");       
		series2.setData(FXCollections.observableArrayList(new XYChart.Data("���� �������� ����", genderList[0])));
		barChart.getData().addAll(series1,series2);

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("������� ������");       
		series3.setData(FXCollections.observableArrayList(
				new XYChart.Data("�ؿ� ����", travelList[0]),
				new XYChart.Data("���� ����", travelList[1]),
				new XYChart.Data("������� �� ����", travelList[2])
				));
		areaChart.getData().add(series3);

		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("�������� ���");
		stage.setScene(scene);
		stage.show();
	}
}
