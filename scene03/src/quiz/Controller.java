package quiz;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import quiz.chart.ChartService;
import quiz.chart.ChartServiceImpl;
import quiz.databaseService.DatabaseService;
import quiz.databaseService.DatabaseServiceImpl;
import quiz.inquiryResult.ResultService;
import quiz.inquiryResult.ResultServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Controller implements Initializable{
	private Parent root;
	private ResultServiceImpl rs;
	private Inquiry into;
	private DatabaseService db;
	private ChartService cs;
	public void setRoot(Parent root) {
		this.root = root; 
	}
	public void resultBtn() {
		System.out.println("결과 보기");
		ArrayList<Inquiry> lists = db.selectSQL();
		cs = new ChartServiceImpl();
		cs.viewChart(lists);
		for(Inquiry i : lists) {
			System.out.println(i.getAge()+":"+i.getGender()+":"+i.getTravel());
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rs = new ResultServiceImpl() ;
		db = new DatabaseServiceImpl();
	}
	public void saveBtn() {//확인 버튼
		System.out.println("저장");
		into = rs.result(root);//선택값 얻어오기
		db.insertSQL(into);//디비 저장
	}
	public void cancelBtn() {
		System.out.println("취소");	
	}
}

